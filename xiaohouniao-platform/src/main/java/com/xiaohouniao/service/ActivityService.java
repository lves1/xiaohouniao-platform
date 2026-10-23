package com.xiaohouniao.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaohouniao.model.dto.ActivityDTO;
import com.xiaohouniao.model.dto.PageQuery;
import com.xiaohouniao.model.entity.Activity;

import java.util.Map;

public interface ActivityService extends IService<Activity> {
    Page<Activity> pageList(PageQuery query);
    Page<Activity> pagePublic(PageQuery query);
    Activity create(ActivityDTO dto);
    Activity update(Long id, ActivityDTO dto);
    Map<String, Object> statistics();
}
