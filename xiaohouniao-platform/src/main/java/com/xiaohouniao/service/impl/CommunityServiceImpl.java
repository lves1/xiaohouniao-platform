package com.xiaohouniao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohouniao.mapper.CommunityMapper;
import com.xiaohouniao.model.dto.CommunityDTO;
import com.xiaohouniao.model.entity.Community;
import com.xiaohouniao.service.CommunityService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityServiceImpl extends ServiceImpl<CommunityMapper, Community> implements CommunityService {

    @Override
    public List<Community> listAll() {
        LambdaQueryWrapper<Community> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByAsc(Community::getSortOrder);
        return list(wrapper);
    }

    @Override
    public Community create(CommunityDTO dto) {
        Community entity = new Community();
        BeanUtils.copyProperties(dto, entity);
        save(entity);
        return entity;
    }

    @Override
    public Community update(Long id, CommunityDTO dto) {
        Community entity = getById(id);
        if (entity == null) throw new RuntimeException("社区不存在");
        BeanUtils.copyProperties(dto, entity);
        entity.setId(id);
        updateById(entity);
        return entity;
    }
}
