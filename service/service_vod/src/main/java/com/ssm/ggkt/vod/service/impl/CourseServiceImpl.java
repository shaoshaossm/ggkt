package com.ssm.ggkt.vod.service.impl;

import com.alibaba.excel.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssm.ggkt.model.vod.Course;
import com.ssm.ggkt.model.vod.CourseDescription;
import com.ssm.ggkt.model.vod.Subject;
import com.ssm.ggkt.model.vod.Teacher;
import com.ssm.ggkt.vo.vod.CourseFormVo;
import com.ssm.ggkt.vo.vod.CourseQueryVo;
import com.ssm.ggkt.vod.mapper.CourseMapper;
import com.ssm.ggkt.vod.service.CourseDescriptionService;
import com.ssm.ggkt.vod.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssm.ggkt.vod.service.SubjectService;
import com.ssm.ggkt.vod.service.TeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author ssm
 * @since 2022-10-16
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private SubjectService subjectService;

    @Autowired
    private CourseDescriptionService courseDescriptionService;

    @Override
    public Map<String, Object> findPageCourse(Page<Course> pageParam, CourseQueryVo courseQueryVo) {

        String title = courseQueryVo.getTitle();
        Long subjectId = courseQueryVo.getSubjectId();
        Long teacherId = courseQueryVo.getTeacherId();
        Long subjectParentId = courseQueryVo.getSubjectParentId();

        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(title)) {
            wrapper.like("title", title);
        }
        if (!StringUtils.isEmpty(subjectId)) {
            wrapper.eq("subject_id", subjectId);
        }
        if (!StringUtils.isEmpty(subjectParentId)) {
            wrapper.eq("subject_parent_id", subjectParentId);
        }
        if (!StringUtils.isEmpty(teacherId)) {
            wrapper.eq("teacher_id", teacherId);
        }

        Page<Course> pages = baseMapper.selectPage(pageParam, wrapper);
        long totalCount = pages.getTotal();//总记录数
        long totalPage = pages.getPages();//总页数
        long currentPage = pages.getCurrent();//当前页
        long size = pages.getSize();//每页记录数
        List<Course> records = pages.getRecords(); //每页数据合集
        records.stream().forEach(item -> {
            this.getTeacherOrSubjectName(item);
        });

        //封装返回数据
        Map<String, Object> map = new HashMap<>();
        map.put("totalCount", totalCount);
        map.put("totalPage", totalPage);
        map.put("records", records);
        return map;
    }

    @Override
    public Long saveCourseInfo(CourseFormVo courseFormVo) {
        Course course = new Course();
        BeanUtils.copyProperties(courseFormVo, course);
        baseMapper.insert(course);

        CourseDescription description = new CourseDescription();
        description.setDescription(courseFormVo.getDescription());
        description.setId(course.getId());

        return course.getId();
    }

    @Override
    public CourseFormVo getCourseInfoById(Long id) {
        Course course = baseMapper.selectById(id);
        if (course == null) {
            return null;
        }

        CourseDescription descriptionServiceById = courseDescriptionService.getById(id);

        CourseFormVo courseFormVo = new CourseFormVo();
        BeanUtils.copyProperties(course, courseFormVo);
        if (descriptionServiceById != null) {
            courseFormVo.setDescription(descriptionServiceById.getDescription());
        }

        return courseFormVo;
    }

    @Override
    public void updateCourseId(CourseFormVo courseFormVo) {
        Course course = new Course();
        BeanUtils.copyProperties(courseFormVo, course);
        baseMapper.updateById(course);

        CourseDescription description = new CourseDescription();
        description.setDescription(courseFormVo.getDescription());
        courseDescriptionService.updateById(description);
    }

    // 获取讲师和分类名称
    private Course getTeacherOrSubjectName(Course course) {

        Teacher teacher = teacherService.getById(course.getTeacherId());
        if (teacher != null) {
            course.getParam().put("teacherName", teacher.getName());
        }
        Subject subjectOne = subjectService.getById(course.getSubjectParentId());
        if (subjectOne != null) {
            course.getParam().put("subjectParentTitle", subjectOne.getTitle());
        }
        Subject subjectTwo = subjectService.getById(course.getSubjectId());
        if (subjectTwo != null) {
            course.getParam().put("subjectTitle", subjectTwo.getTitle());
        }
        return course;
    }
}
