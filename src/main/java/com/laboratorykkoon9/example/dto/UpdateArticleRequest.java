package com.laboratorykkoon9.example.dto;

import lombok.Getter;

@Getter
public class UpdateArticleRequest {
    private String title;
    private String content;

    public UpdateArticleRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
