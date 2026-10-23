package com.xiaohouniao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaohouniao.model.dto.TopicDTO;
import com.xiaohouniao.model.entity.Topic;

import java.util.List;

public interface TopicService extends IService<Topic> {
    List<Topic> listPublic();
    List<Topic> listAll();
    Topic create(TopicDTO dto);
    Topic update(Long id, TopicDTO dto);
}
