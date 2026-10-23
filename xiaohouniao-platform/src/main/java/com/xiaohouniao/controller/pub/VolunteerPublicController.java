package com.xiaohouniao.controller.pub;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaohouniao.common.PageResult;
import com.xiaohouniao.common.Result;
import com.xiaohouniao.model.dto.PageQuery;
import com.xiaohouniao.model.entity.Volunteer;
import com.xiaohouniao.service.VolunteerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public/volunteer")
@RequiredArgsConstructor
public class VolunteerPublicController {

    private final VolunteerService volunteerService;

    @GetMapping
    public Result<PageResult<Volunteer>> list(PageQuery query) {
        Page<Volunteer> page = volunteerService.pagePublic(query);
        return Result.ok(PageResult.of(page));
    }

    @GetMapping("/{id}")
    public Result<Volunteer> get(@PathVariable Long id) {
        return Result.ok(volunteerService.getById(id));
    }
}
