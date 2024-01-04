package me.fontas.demo.model;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

public class PagedContentResponse {
    private final Page<Content> contentPage;

    public PagedContentResponse(Page<Content> contentPage) {
        this.contentPage = contentPage;
    }

    public List<Content> getContents() {
        return contentPage.getContent();
    }

    public int getCurrentPage() {
        return contentPage.getNumber();
    }

    public int getPageSize() {
        return contentPage.getSize();
    }

    public long getTotalElements() {
        return contentPage.getTotalElements();
    }

    public int getTotalPages() {
        return contentPage.getTotalPages();
    }
}
