package com.laboratorykkoon9.example.dto;

import lombok.Getter;

@Getter
public class ArticleResponse {
    private String title;
    private String content;

    public ArticleResponse(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
