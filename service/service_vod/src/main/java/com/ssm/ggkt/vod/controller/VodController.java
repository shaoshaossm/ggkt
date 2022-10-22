package com.ssm.ggkt.vod.controller;

import com.ssm.ggkt.result.Result;
import com.ssm.ggkt.vod.service.VodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2022/10/21 11:52
 */
@Api(tags = "腾讯云点播")
@RestController
@RequestMapping("/admin/vod")
//@CrossOrigin
public class VodController {

    @Autowired
    private VodService vodService;

    @ApiOperation("上传视频")
    @PostMapping("upload")
    public Result upload() {
        String fieldId = vodService.uploadVideo();
        return Result.ok(fieldId);
    }

    @ApiOperation("删除视频")
    @DeleteMapping("remove/{fieldId}")
    public Result remove(@PathVariable String fieldId){
        vodService.removeVideoById(fieldId);
        return Result.ok(null);
    }

}
