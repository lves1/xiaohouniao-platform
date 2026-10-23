package com.xiaohouniao.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ActivityDTO {
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
}
