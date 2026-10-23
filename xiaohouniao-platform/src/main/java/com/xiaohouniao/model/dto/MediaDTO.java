package com.xiaohouniao.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MediaDTO {
    private String type;
    private String title;
    private String url;
    private String source;
    private String category;
    private LocalDate publishDate;
    private String summary;
    private Integer sortOrder;
    private Integer isPublished;
}
