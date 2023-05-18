package com.laboratorykkoon9.example.dto;

import com.laboratorykkoon9.example.domain.Article;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AddArticleRequest {
    private String title;
    private String content;

    public AddArticleRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Article toEntity() {
        return Article.builder()
                .title(this.title)
                .content(this.content)
                .build();

    }
}
