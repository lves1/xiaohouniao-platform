package com.xiaohouniao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohouniao.mapper.MediaMapper;
import com.xiaohouniao.model.dto.MediaDTO;
import com.xiaohouniao.model.dto.PageQuery;
import com.xiaohouniao.model.entity.Media;
import com.xiaohouniao.service.MediaService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class MediaServiceImpl extends ServiceImpl<MediaMapper, Media> implements MediaService {

    @Override
    public Page<Media> pageList(PageQuery query) {
        LambdaQueryWrapper<Media> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.hasText(query.getKeyword())) {
            wrapper.like(Media::getTitle, query.getKeyword());
        }
        if (StringUtils.hasText(query.getCategory())) {
            wrapper.eq(Media::getType, query.getCategory());
        }
        wrapper.orderByDesc(Media::getCreateTime);
        return page(Page.of(query.getPage(), query.getSize()), wrapper);
    }

    @Override
    public Media create(MediaDTO dto) {
        Media entity = new Media();
        BeanUtils.copyProperties(dto, entity);
        save(entity);
        return entity;
    }

    @Override
    public Media update(Long id, MediaDTO dto) {
        Media entity = getById(id);
        if (entity == null) throw new RuntimeException("媒体素材不存在");
        BeanUtils.copyProperties(dto, entity);
        entity.setId(id);
        updateById(entity);
        return entity;
    }
}
