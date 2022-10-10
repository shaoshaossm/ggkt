package com.ssm.ggkt.vod.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssm.ggkt.exception.GgktException;
import com.ssm.ggkt.model.vod.Teacher;
import com.ssm.ggkt.result.Result;
import com.ssm.ggkt.vo.vod.TeacherQueryVo;
import com.ssm.ggkt.vod.service.TeacherService;
import com.sun.org.apache.regexp.internal.RE;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.awt.geom.PathIterator;
import java.security.PublicKey;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author ssm
 * @since 2022-10-09
 */
@Api(tags = "讲师管理接口")
@RestController
@RequestMapping(value = "/admin/vod/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @ApiOperation("查询所有讲师")
    @GetMapping("findAll")
    public Result findAllTeacher() {
        List<Teacher> list = teacherService.list();
        try {
            int a = 10 / 0;
        }catch (Exception e){
            throw new GgktException(201,"执行自定义异常处理");
        }

        return Result.ok(list).message("查询成功").code(200);
    }

    @ApiOperation("删除讲师")
    @DeleteMapping("remove/{id}")
    public Result removeTeacher(
            @ApiParam(name = "id", value = "要删除的id", required = true)
            @PathVariable long id) {
        boolean isSuccess = teacherService.removeById(id);
        if (isSuccess) {
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }
    }

    @ApiOperation("条件查询分页")
    @PostMapping("findQueryPage/{current}/{limit}")
    public Result findQueryPage(@ApiParam(name = "page", value = "当前页码", required = true)
                                @PathVariable long current,
                                @ApiParam(name = "limit", value = "每页记录数", required = true)
                                @PathVariable long limit,
                                @ApiParam(name = "teacherVo", value = "查询对象", required = false)
                                @RequestBody(required = false) TeacherQueryVo teacherQueryVo) {
        Page<Teacher> pageParam = new Page<>(current, limit);
        if (teacherQueryVo == null) {
            Page<Teacher> pageModel = teacherService.page(pageParam, null);
            return Result.ok(pageModel);
        } else {
            String name = teacherQueryVo.getName();
            Integer level = teacherQueryVo.getLevel();
            String joinDateBegin = teacherQueryVo.getJoinDateBegin();
            String joinDateEnd = teacherQueryVo.getJoinDateEnd();
            QueryWrapper<Teacher> wrapper = new QueryWrapper();
            if (!StringUtils.isEmpty(name)) {
                wrapper.like("name", name);
            }
            if (!StringUtils.isEmpty(level)) {
                wrapper.like("level", level);
            }
            if (!StringUtils.isEmpty(joinDateBegin)) {
                wrapper.ge("join_date", joinDateBegin);
            }
            if (!StringUtils.isEmpty(joinDateEnd)) {
                wrapper.le("join_date", joinDateEnd);
            }
            //调用方法分页查询
            Page<Teacher> pageModel = teacherService.page(pageParam, null);
            //返回
            return Result.ok(pageModel);

        }
    }

    @ApiOperation("添加讲师")
    @PostMapping("save")
    public Result save(@ApiParam(name = "teacher", value = "添加的对象", required = true)
                       @RequestBody Teacher teacher) {
        boolean isSuccess = teacherService.save(teacher);
        if (isSuccess) {
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }
    }

    @ApiOperation("根据ID查询讲师")
    @GetMapping("getTeacher/{id}")
    public Result getTeacher(@ApiParam(name = "id", value = "讲师ID", required = true)
                             @PathVariable long id) {
        Teacher teacher = teacherService.getById(id);
        return Result.ok(teacher);
    }

    @ApiOperation("修改讲师")
    @PutMapping("update")
    public Result updateById(@ApiParam(name = "teacher", value = "修改的对象", required = true)
                             @RequestBody Teacher teacher) {
        boolean isSuccess = teacherService.updateById(teacher);

        if (isSuccess) {
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }

    }

    @ApiOperation("批量删除讲师")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@ApiParam(name = "List", value = "IDList集合", required = true)
                              @RequestBody List<Long> idList) {
        boolean isSuccess = teacherService.removeByIds(idList);

        if (isSuccess) {
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }

    }


}

