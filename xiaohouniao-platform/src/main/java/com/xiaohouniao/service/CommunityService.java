package com.xiaohouniao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaohouniao.model.dto.CommunityDTO;
import com.xiaohouniao.model.entity.Community;

import java.util.List;

public interface CommunityService extends IService<Community> {
    List<Community> listAll();
    Community create(CommunityDTO dto);
    Community update(Long id, CommunityDTO dto);
}
