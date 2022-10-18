package com.ssm.ggkt.vod.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssm.ggkt.model.vod.Course;
import com.ssm.ggkt.result.Result;
import com.ssm.ggkt.vo.vod.CourseFormVo;
import com.ssm.ggkt.vo.vod.CourseQueryVo;
import com.ssm.ggkt.vo.vod.CourseVo;
import com.ssm.ggkt.vod.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author ssm
 * @since 2022-10-16
 */
@Api(tags = "课程管理接口")
@RestController
@RequestMapping(value = "/admin/vod/course")
@CrossOrigin
public class CourseController {

    @Autowired
    private CourseService courseService;

    @ApiOperation("点播课程列表")
    @GetMapping("{page}/{limit}")
    public Result courseList(@PathVariable Long page,
                             @PathVariable Long limit,
                             CourseQueryVo courseQueryVo) {
        Page<Course> pageParam = new Page<>(page, limit);
        Map<String, Object> map = courseService.findPageCourse(pageParam, courseQueryVo);
        return Result.ok(map);
    }

    @ApiOperation("添加课程基本信息")
    @PostMapping("save")
    public Result save(@RequestBody CourseFormVo courseFormVo) {
        Long courseId = courseService.saveCourseInfo(courseFormVo);
        return Result.ok(courseId);
    }

    @ApiOperation("根据id获取课程信息")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        CourseFormVo courseFormVo = courseService.getCourseInfoById(id);
        return Result.ok(courseFormVo);
    }
    @ApiOperation("修改课程信息")
    @PostMapping("update")
    public Result update(@RequestBody CourseFormVo courseFormVo){
        courseService.updateCourseId(courseFormVo);
        return Result.ok(null);
    }



}

