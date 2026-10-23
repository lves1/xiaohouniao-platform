package com.xiaohouniao.controller.admin;

import com.xiaohouniao.common.Result;
import com.xiaohouniao.model.dto.CommunityDTO;
import com.xiaohouniao.model.entity.Community;
import com.xiaohouniao.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/community")
@RequiredArgsConstructor
public class CommunityController {

    private final CommunityService communityService;

    @GetMapping
    public Result<List<Community>> list() {
        return Result.ok(communityService.listAll());
    }

    @PostMapping
    public Result<Community> create(@RequestBody CommunityDTO dto) {
        return Result.ok(communityService.create(dto));
    }

    @PutMapping("/{id}")
    public Result<Community> update(@PathVariable Long id, @RequestBody CommunityDTO dto) {
        return Result.ok(communityService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        communityService.removeById(id);
        return Result.ok();
    }
}
