package com.ssm.ggkt.vod.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssm.ggkt.model.vod.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ssm.ggkt.vo.vod.CourseFormVo;
import com.ssm.ggkt.vo.vod.CourseQueryVo;

import java.util.Map;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author ssm
 * @since 2022-10-16
 */
public interface CourseService extends IService<Course> {

    Map<String, Object> findPageCourse(Page<Course> pageParam, CourseQueryVo courseQueryVo);

    Long saveCourseInfo(CourseFormVo courseFormVo);

    CourseFormVo getCourseInfoById(Long id);

    void updateCourseId(CourseFormVo courseFormVo);
}
