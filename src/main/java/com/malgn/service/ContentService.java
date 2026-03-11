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

import com.malgn.dto.request.ContentUpdateRequest;
import org.springframework.security.access.AccessDeniedException;

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

    @Transactional
    public ContentResponse updateContent(Long id, ContentUpdateRequest request, String username, boolean isAdmin) {
        Content content = contentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글을 찾을 수 없습니다. id: " + id));
                
        if (!isAdmin && !content.getCreatedBy().equals(username)) {
            throw new AccessDeniedException("해당 게시글을 수정할 권한이 없습니다.");
        }
        
        content.updateContent(request.getTitle(), request.getDescription());
        
        return new ContentResponse(content);
    }

    @Transactional
    public void deleteContent(Long id, String username, boolean isAdmin) {
        Content content = contentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글을 찾을 수 없습니다. id: " + id));
                
        if (!isAdmin && !content.getCreatedBy().equals(username)) {
            throw new AccessDeniedException("해당 게시글을 삭제할 권한이 없습니다.");
        }
        
        contentRepository.delete(content);
    }
}
