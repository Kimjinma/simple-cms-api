package com.malgn.service;

import com.malgn.domain.content.Content;
import com.malgn.domain.content.ContentRepository;
import com.malgn.dto.request.ContentCreateRequest;
import com.malgn.dto.response.ContentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ContentService {

    private final ContentRepository contentRepository;

    public ContentResponse createContent(ContentCreateRequest request) {
        Content content = new Content(request.getTitle(), request.getDescription());
        
        Content savedContent = contentRepository.save(content);
        
        return new ContentResponse(savedContent);
    }

    @Transactional(readOnly = true)
    public Page<ContentResponse> getContents(Pageable pageable) {
        return contentRepository.findAll(pageable)
                .map(content -> new ContentResponse(content));
    }

    @Transactional
    public ContentResponse getContent(Long id) {
        contentRepository.incrementViewCount(id);
        
        Content content = contentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글을 찾을 수 없습니다. id: " + id));
                
        return new ContentResponse(content);
    }
}
