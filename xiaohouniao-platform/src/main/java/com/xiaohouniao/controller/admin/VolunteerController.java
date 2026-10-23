package com.xiaohouniao.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaohouniao.common.PageResult;
import com.xiaohouniao.common.Result;
import com.xiaohouniao.model.dto.PageQuery;
import com.xiaohouniao.model.dto.VolunteerDTO;
import com.xiaohouniao.model.entity.Volunteer;
import com.xiaohouniao.service.VolunteerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/volunteer")
@RequiredArgsConstructor
public class VolunteerController {

    private final VolunteerService volunteerService;

    @GetMapping
    public Result<PageResult<Volunteer>> list(PageQuery query) {
        Page<Volunteer> page = volunteerService.pageList(query);
        return Result.ok(PageResult.of(page));
    }

    @GetMapping("/{id}")
    public Result<Volunteer> get(@PathVariable Long id) {
        return Result.ok(volunteerService.getById(id));
    }

    @PostMapping
    public Result<Volunteer> create(@RequestBody VolunteerDTO dto) {
        return Result.ok(volunteerService.create(dto));
    }

    @PutMapping("/{id}")
    public Result<Volunteer> update(@PathVariable Long id, @RequestBody VolunteerDTO dto) {
        return Result.ok(volunteerService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        volunteerService.removeById(id);
        return Result.ok();
    }
}
