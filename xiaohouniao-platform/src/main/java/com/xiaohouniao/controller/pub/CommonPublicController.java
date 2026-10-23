package com.xiaohouniao.controller.pub;

import com.xiaohouniao.common.Result;
import com.xiaohouniao.model.entity.Community;
import com.xiaohouniao.model.entity.Topic;
import com.xiaohouniao.service.CommunityService;
import com.xiaohouniao.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/public")
@RequiredArgsConstructor
public class CommonPublicController {

    private final CommunityService communityService;
    private final TopicService topicService;

    @GetMapping("/community")
    public Result<List<Community>> communities() {
        return Result.ok(communityService.listAll());
    }

    @GetMapping("/topic")
    public Result<List<Topic>> topics() {
        return Result.ok(topicService.listPublic());
    }

    @GetMapping("/overview")
    public Result<Map<String, Object>> overview() {
        long communityCount = communityService.count();
        return Result.ok(Map.of(
                "communityCount", communityCount
        ));
    }
}
