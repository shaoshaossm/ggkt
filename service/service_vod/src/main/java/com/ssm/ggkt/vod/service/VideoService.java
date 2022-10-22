package com.ssm.ggkt.vod.service;

import com.ssm.ggkt.model.vod.Video;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author ssm
 * @since 2022-10-16
 */
public interface VideoService extends IService<Video> {

    void removeVideoByCourseId(Long id);


    void removeVideoById(Long id);
}
