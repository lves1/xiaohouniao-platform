package com.xiaohouniao.controller.admin;

import com.xiaohouniao.common.Result;
import com.xiaohouniao.model.dto.TopicDTO;
import com.xiaohouniao.model.entity.Topic;
import com.xiaohouniao.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/topic")
@RequiredArgsConstructor
public class TopicController {

    private final TopicService topicService;

    @GetMapping
    public Result<List<Topic>> list() {
        return Result.ok(topicService.listAll());
    }

    @PostMapping
    public Result<Topic> create(@RequestBody TopicDTO dto) {
        return Result.ok(topicService.create(dto));
    }

    @PutMapping("/{id}")
    public Result<Topic> update(@PathVariable Long id, @RequestBody TopicDTO dto) {
        return Result.ok(topicService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        topicService.removeById(id);
        return Result.ok();
    }
}
