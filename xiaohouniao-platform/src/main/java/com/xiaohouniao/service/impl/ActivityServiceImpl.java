package com.xiaohouniao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohouniao.mapper.ActivityMapper;
import com.xiaohouniao.model.dto.ActivityDTO;
import com.xiaohouniao.model.dto.PageQuery;
import com.xiaohouniao.model.entity.Activity;
import com.xiaohouniao.service.ActivityService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements ActivityService {

    @Override
    public Page<Activity> pageList(PageQuery query) {
        LambdaQueryWrapper<Activity> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.hasText(query.getKeyword())) {
            wrapper.like(Activity::getTitle, query.getKeyword());
        }
        if (StringUtils.hasText(query.getCategory())) {
            wrapper.eq(Activity::getCategory, query.getCategory());
        }
        wrapper.orderByDesc(Activity::getCreateTime);
        return page(Page.of(query.getPage(), query.getSize()), wrapper);
    }

    @Override
    public Page<Activity> pagePublic(PageQuery query) {
        LambdaQueryWrapper<Activity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Activity::getIsPublished, 1);
        if (StringUtils.hasText(query.getKeyword())) {
            wrapper.and(w -> w.like(Activity::getTitle, query.getKeyword())
                    .or().like(Activity::getTags, query.getKeyword()));
        }
        if (StringUtils.hasText(query.getCategory())) {
            if (!"全部".equals(query.getCategory())) {
                wrapper.eq(Activity::getCategory, query.getCategory());
            }
        }
        wrapper.orderByDesc(Activity::getCreateTime);
        return page(Page.of(query.getPage(), query.getSize()), wrapper);
    }

    @Override
    public Activity create(ActivityDTO dto) {
        Activity entity = new Activity();
        BeanUtils.copyProperties(dto, entity);
        if (entity.getViewCount() == null) entity.setViewCount(0);
        save(entity);
        return entity;
    }

    @Override
    public Activity update(Long id, ActivityDTO dto) {
        Activity entity = getById(id);
        if (entity == null) throw new RuntimeException("活动不存在");
        BeanUtils.copyProperties(dto, entity);
        entity.setId(id);
        updateById(entity);
        return entity;
    }

    @Override
    public Map<String, Object> statistics() {
        Map<String, Object> stats = new HashMap<>();

        LambdaQueryWrapper<Activity> pubWrapper = new LambdaQueryWrapper<>();
        pubWrapper.eq(Activity::getIsPublished, 1);

        long totalActivities = count(pubWrapper);
        long totalParticipants = 0;
        long totalVolunteers = 0;

        List<Activity> activities = list(pubWrapper);
        for (Activity a : activities) {
            totalParticipants += a.getParticipantCount() != null ? a.getParticipantCount() : 0;
            totalVolunteers += a.getVolunteerCount() != null ? a.getVolunteerCount() : 0;
        }

        stats.put("totalActivities", totalActivities);
        stats.put("totalParticipants", totalParticipants);
        stats.put("totalVolunteers", totalVolunteers);

        List<Map<String, Object>> byCategory = baseMapper.countByCategory();
        stats.put("byCategory", byCategory);

        List<Map<String, Object>> monthlyTrend = baseMapper.monthlyTrend();
        stats.put("monthlyTrend", monthlyTrend);

        return stats;
    }
}
