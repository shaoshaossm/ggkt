package com.ssm.ggkt.vod.service.impl;

import com.ssm.ggkt.model.vod.Video;
import com.ssm.ggkt.vod.mapper.VideoMapper;
import com.ssm.ggkt.vod.service.VideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author ssm
 * @since 2022-10-16
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

}
