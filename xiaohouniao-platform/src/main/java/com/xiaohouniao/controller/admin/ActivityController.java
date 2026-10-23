package com.xiaohouniao.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaohouniao.common.FileUtil;
import com.xiaohouniao.common.PageResult;
import com.xiaohouniao.common.Result;
import com.xiaohouniao.model.dto.ActivityDTO;
import com.xiaohouniao.model.dto.PageQuery;
import com.xiaohouniao.model.entity.Activity;
import com.xiaohouniao.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/admin/activity")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @Value("${app.upload-path}")
    private String uploadPath;

    @GetMapping
    public Result<PageResult<Activity>> list(PageQuery query) {
        Page<Activity> page = activityService.pageList(query);
        return Result.ok(PageResult.of(page));
    }

    @GetMapping("/{id}")
    public Result<Activity> get(@PathVariable Long id) {
        return Result.ok(activityService.getById(id));
    }

    @PostMapping
    public Result<Activity> create(@RequestBody ActivityDTO dto) {
        return Result.ok(activityService.create(dto));
    }

    @PutMapping("/{id}")
    public Result<Activity> update(@PathVariable Long id, @RequestBody ActivityDTO dto) {
        return Result.ok(activityService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        activityService.removeById(id);
        return Result.ok();
    }

    @PostMapping("/upload")
    public Result<String> upload(@RequestParam("file") MultipartFile file) {
        String url = FileUtil.upload(file, uploadPath);
        return Result.ok(url);
    }

    @GetMapping("/statistics")
    public Result<Map<String, Object>> statistics() {
        return Result.ok(activityService.statistics());
    }
}
