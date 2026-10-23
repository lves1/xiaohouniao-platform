package com.xiaohouniao.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaohouniao.model.dto.MediaDTO;
import com.xiaohouniao.model.dto.PageQuery;
import com.xiaohouniao.model.entity.Media;

public interface MediaService extends IService<Media> {
    Page<Media> pageList(PageQuery query);
    Media create(MediaDTO dto);
    Media update(Long id, MediaDTO dto);
}
