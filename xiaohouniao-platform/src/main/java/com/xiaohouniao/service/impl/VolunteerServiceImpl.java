package com.xiaohouniao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohouniao.mapper.VolunteerMapper;
import com.xiaohouniao.model.dto.PageQuery;
import com.xiaohouniao.model.dto.VolunteerDTO;
import com.xiaohouniao.model.entity.Volunteer;
import com.xiaohouniao.service.VolunteerService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class VolunteerServiceImpl extends ServiceImpl<VolunteerMapper, Volunteer> implements VolunteerService {

    @Override
    public Page<Volunteer> pageList(PageQuery query) {
        LambdaQueryWrapper<Volunteer> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.hasText(query.getKeyword())) {
            wrapper.like(Volunteer::getName, query.getKeyword());
        }
        wrapper.orderByDesc(Volunteer::getCreateTime);
        return page(Page.of(query.getPage(), query.getSize()), wrapper);
    }

    @Override
    public Page<Volunteer> pagePublic(PageQuery query) {
        LambdaQueryWrapper<Volunteer> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Volunteer::getIsPublished, 1);
        if (StringUtils.hasText(query.getKeyword())) {
            wrapper.like(Volunteer::getName, query.getKeyword());
        }
        wrapper.orderByDesc(Volunteer::getCreateTime);
        return page(Page.of(query.getPage(), query.getSize()), wrapper);
    }

    @Override
    public Volunteer create(VolunteerDTO dto) {
        Volunteer entity = new Volunteer();
        BeanUtils.copyProperties(dto, entity);
        save(entity);
        return entity;
    }

    @Override
    public Volunteer update(Long id, VolunteerDTO dto) {
        Volunteer entity = getById(id);
        if (entity == null) throw new RuntimeException("志愿者/团队不存在");
        BeanUtils.copyProperties(dto, entity);
        entity.setId(id);
        updateById(entity);
        return entity;
    }
}
