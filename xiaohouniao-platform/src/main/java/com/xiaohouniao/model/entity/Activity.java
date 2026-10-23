package com.xiaohouniao.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@TableName("activity")
public class Activity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String title;
    private String summary;
    private String content;
    private String coverUrl;
    private String category;
    private Long communityId;
    private String communityName;
    private String location;
    private LocalDate activityDate;
    private Integer participantCount;
    private Integer volunteerCount;
    private String tags;
    private Integer isFeatured;
    private Integer isPublished;
    private Integer viewCount;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
    @TableLogic
    private Integer deleted;
}
