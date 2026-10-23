package com.xiaohouniao.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaohouniao.common.PageResult;
import com.xiaohouniao.common.Result;
import com.xiaohouniao.model.dto.MediaDTO;
import com.xiaohouniao.model.dto.PageQuery;
import com.xiaohouniao.model.entity.Media;
import com.xiaohouniao.service.MediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/media")
@RequiredArgsConstructor
public class MediaController {

    private final MediaService mediaService;

    @GetMapping
    public Result<PageResult<Media>> list(PageQuery query) {
        Page<Media> page = mediaService.pageList(query);
        return Result.ok(PageResult.of(page));
    }

    @GetMapping("/{id}")
    public Result<Media> get(@PathVariable Long id) {
        return Result.ok(mediaService.getById(id));
    }

    @PostMapping
    public Result<Media> create(@RequestBody MediaDTO dto) {
        return Result.ok(mediaService.create(dto));
    }

    @PutMapping("/{id}")
    public Result<Media> update(@PathVariable Long id, @RequestBody MediaDTO dto) {
        return Result.ok(mediaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        mediaService.removeById(id);
        return Result.ok();
    }
}
