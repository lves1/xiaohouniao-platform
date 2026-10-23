package com.xiaohouniao.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class VolunteerDTO {
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
}
