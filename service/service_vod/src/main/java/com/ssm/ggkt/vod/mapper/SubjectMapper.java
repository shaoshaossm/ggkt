package com.ssm.ggkt.vod.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ssm.ggkt.model.vod.Subject;
import org.mapstruct.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 课程科目 Mapper 接口
 * </p>
 *
 * @author ssm
 * @since 2022-10-15
 */
@Repository
public interface SubjectMapper extends BaseMapper<Subject> {

}
