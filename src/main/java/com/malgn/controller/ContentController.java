package com.malgn.controller;

import com.malgn.dto.request.ContentCreateRequest;
import com.malgn.dto.response.ContentResponse;
import com.malgn.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/contents")
public class ContentController {

    private final ContentService contentService;

    @PostMapping
    public ResponseEntity<ContentResponse> createContent(@RequestBody ContentCreateRequest request) {
        ContentResponse response = contentService.createContent(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
