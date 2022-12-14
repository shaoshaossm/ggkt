package com.ssm.ggkt.vod.mapper;

import com.ssm.ggkt.model.vod.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ssm.ggkt.vo.vod.CoursePublishVo;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author ssm
 * @since 2022-10-16
 */
public interface CourseMapper extends BaseMapper<Course> {

    CoursePublishVo selectCoursePublishVoById(Long id);
}
