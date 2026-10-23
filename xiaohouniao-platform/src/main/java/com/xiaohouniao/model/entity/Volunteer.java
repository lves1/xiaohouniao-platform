package com.xiaohouniao.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("volunteer")
public class Volunteer {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String type;
    private String name;
    private String school;
    private Integer memberCount;
    private String description;
    private String storyTitle;
    private String storyContent;
    private String coverUrl;
    private BigDecimal serviceHours;
    private String serviceCommunity;
    private Integer sortOrder;
    private Integer isPublished;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
    @TableLogic
    private Integer deleted;
}
