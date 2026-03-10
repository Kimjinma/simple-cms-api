package com.malgn.dto.response;

import com.malgn.domain.content.Content;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ContentResponse {
    private Long id;
    private String title;
    private String description;
    private Long viewCount;
    private String createdBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;

    public ContentResponse(Content content) {
        this.id = content.getId();
        this.title = content.getTitle();
        this.description = content.getDescription();
        this.viewCount = content.getViewCount();
        this.createdBy = content.getCreatedBy();
        this.createdDate = content.getCreatedDate();
        this.lastModifiedBy = content.getLastModifiedBy();
        this.lastModifiedDate = content.getLastModifiedDate();
    }
}
