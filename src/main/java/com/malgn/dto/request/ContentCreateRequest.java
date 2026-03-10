package com.malgn.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ContentCreateRequest {
    private String title;
    private String description;
}
