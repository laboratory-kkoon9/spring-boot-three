package com.laboratorykkoon9.example.controller;

import com.laboratorykkoon9.example.domain.Article;
import com.laboratorykkoon9.example.dto.AddArticleRequest;
import com.laboratorykkoon9.example.dto.ArticleResponse;
import com.laboratorykkoon9.example.dto.UpdateArticleRequest;
import com.laboratorykkoon9.example.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogController {
    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<?> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<?> findAllArticles() {
        List<Article> articles = blogService.findAll();

        return ResponseEntity.ok()
                .body(articles);
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable long id) {
        blogService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<?> updateArticle(@PathVariable long id, @RequestBody UpdateArticleRequest request) {
        Article updateArticle = blogService.update(id, request);
        return ResponseEntity.ok()
                .body(updateArticle);
    }
}
