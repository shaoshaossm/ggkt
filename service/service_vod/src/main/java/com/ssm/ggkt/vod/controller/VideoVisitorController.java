package com.ssm.ggkt.vod.controller;


import com.ssm.ggkt.result.Result;
import com.ssm.ggkt.vod.service.VideoService;
import com.ssm.ggkt.vod.service.VideoVisitorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * 视频来访者记录表 前端控制器
 * </p>
 *
 * @author ssm
 * @since 2022-10-20
 */
@RestController
@RequestMapping("/admin/vod/videoVisitor")
//@CrossOrigin
public class VideoVisitorController {

    @Autowired
    private VideoVisitorService videoVisitorService;

    @ApiOperation("显示统计数据")
    @GetMapping("findCount/{courseId}/{startDate}/{endDate}")
    public Result showChart(@ApiParam("开始时间") @PathVariable Long courseId,
                            @ApiParam("开始时间") @PathVariable String startDate,
                            @ApiParam("结束时间") @PathVariable String endDate) {
        Map<String, Object> map = videoVisitorService.findCount(courseId, startDate, endDate);
        return Result.ok(map);
    }
}

