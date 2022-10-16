package com.ssm.ggkt.vod.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ssm.ggkt.model.vod.Subject;
import com.ssm.ggkt.vod.mapper.SubjectMapper;
import com.ssm.ggkt.vod.service.SubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.velocity.runtime.directive.Foreach;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author ssm
 * @since 2022-10-15
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    /**
     *
     * @param id 要查询的id
     * @return true or false
     *
     * 这段代码的意思是传入一个id，查询条件为id = parent_id，查询所有与parent_id有关的的数据后
     * 获取这些数据的id值，然后再次判断查询表中的数据，判断是否有数据的parent_id与这个id相同，
     * 相同的话返回的数据打小就大于0，返回true，即设置setHasChildren为true，
     * 没有的话就不大于0返回false，设置setHasChildren为false
     */
    @Override
    public List<Subject> selectSubjectList(Long id) {
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", id);
        List<Subject> subjectList = baseMapper.selectList(wrapper);

        for (Subject subject : subjectList) {
            Long subjectId = subject.getId();
            boolean isChild = this.isChildren(subjectId);
            subject.setHasChildren(isChild);
        }
        return subjectList;
    }

    private boolean isChildren(Long subjectId) {
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", subjectId);
        Integer count = baseMapper.selectCount(wrapper);
        return count > 0;
    }
}
