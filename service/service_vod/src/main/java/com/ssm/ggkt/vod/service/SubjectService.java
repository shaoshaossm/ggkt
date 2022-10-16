package com.ssm.ggkt.vod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ssm.ggkt.model.vod.Subject;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author ssm
 * @since 2022-10-15
 */
public interface SubjectService extends IService<Subject> {

    List<Subject> selectSubjectList(Long id);
}
