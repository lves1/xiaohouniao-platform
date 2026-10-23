package com.xiaohouniao.model.dto;

import lombok.Data;

@Data
public class TopicDTO {
    private String title;
    private String subtitle;
    private String coverColor;
    private String icon;
    private String description;
    private Integer sortOrder;
    private Integer isPublished;
}
