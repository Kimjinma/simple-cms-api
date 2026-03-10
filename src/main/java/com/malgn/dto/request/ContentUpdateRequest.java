package com.malgn.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ContentUpdateRequest {
    private String title;
    private String description;
}
