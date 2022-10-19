package com.ssm.ggkt.vod.controller;


import com.ssm.ggkt.model.vod.Video;
import com.ssm.ggkt.result.Result;
import com.ssm.ggkt.vod.service.VideoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author ssm
 * @since 2022-10-16
 */
@RestController
@RequestMapping("/admin/vod/video")
@CrossOrigin
public class VideoController {

    @Autowired
    private VideoService videoService;

    @ApiOperation(value = "根据ID查询")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        Video video = videoService.getById(id);
        return Result.ok(video);
    }

    @ApiOperation(value = "增加小节")
    @PostMapping("save")
    public Result save(@RequestBody Video video) {
        videoService.save(video);
        return Result.ok(null);
    }

    @ApiOperation(value = "修改小节")
    @PutMapping("update")
    public Result updateById(@RequestBody Video video) {
        videoService.updateById(video);
        return Result.ok(null);
    }

    @ApiOperation(value = "删除小节")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        videoService.removeById(id);
        return Result.ok(null);
    }

}

