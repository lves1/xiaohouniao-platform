package com.xiaohouniao.controller.pub;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaohouniao.common.PageResult;
import com.xiaohouniao.common.Result;
import com.xiaohouniao.model.dto.PageQuery;
import com.xiaohouniao.model.entity.Activity;
import com.xiaohouniao.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/public/activity")
@RequiredArgsConstructor
public class ActivityPublicController {

    private final ActivityService activityService;

    @GetMapping
    public Result<PageResult<Activity>> list(PageQuery query) {
        Page<Activity> page = activityService.pagePublic(query);
        return Result.ok(PageResult.of(page));
    }

    @GetMapping("/{id}")
    public Result<Activity> get(@PathVariable Long id) {
        Activity activity = activityService.getById(id);
        if (activity != null) {
            activity.setViewCount(activity.getViewCount() + 1);
            activityService.updateById(activity);
        }
        return Result.ok(activity);
    }

    @GetMapping("/statistics")
    public Result<Map<String, Object>> statistics() {
        return Result.ok(activityService.statistics());
    }

    @GetMapping("/featured")
    public Result<PageResult<Activity>> featured(PageQuery query) {
        Page<Activity> page = new Page<>(query.getPage(), query.getSize());
        Page<Activity> result = activityService.lambdaQuery()
                .eq(Activity::getIsPublished, 1)
                .eq(Activity::getIsFeatured, 1)
                .orderByDesc(Activity::getCreateTime)
                .page(page);
        return Result.ok(PageResult.of(result));
    }
}
