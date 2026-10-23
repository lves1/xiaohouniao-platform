package com.xiaohouniao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohouniao.mapper.TopicMapper;
import com.xiaohouniao.model.dto.TopicDTO;
import com.xiaohouniao.model.entity.Topic;
import com.xiaohouniao.service.TopicService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic> implements TopicService {

    @Override
    public List<Topic> listPublic() {
        LambdaQueryWrapper<Topic> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Topic::getIsPublished, 1);
        wrapper.orderByAsc(Topic::getSortOrder);
        return list(wrapper);
    }

    @Override
    public List<Topic> listAll() {
        LambdaQueryWrapper<Topic> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByAsc(Topic::getSortOrder);
        return list(wrapper);
    }

    @Override
    public Topic create(TopicDTO dto) {
        Topic entity = new Topic();
        BeanUtils.copyProperties(dto, entity);
        save(entity);
        return entity;
    }

    @Override
    public Topic update(Long id, TopicDTO dto) {
        Topic entity = getById(id);
        if (entity == null) throw new RuntimeException("专题不存在");
        BeanUtils.copyProperties(dto, entity);
        entity.setId(id);
        updateById(entity);
        return entity;
    }
}
