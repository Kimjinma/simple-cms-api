package com.malgn.service;

import com.malgn.domain.content.Content;
import com.malgn.domain.content.ContentRepository;
import com.malgn.dto.request.ContentCreateRequest;
import com.malgn.dto.response.ContentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ContentService {

    private final ContentRepository contentRepository;

    public ContentResponse createContent(ContentCreateRequest request) {
        Content content = new Content(request.getTitle(), request.getDescription());
        
        Content savedContent = contentRepository.save(content);
        
        return new ContentResponse(savedContent);
    }
}
