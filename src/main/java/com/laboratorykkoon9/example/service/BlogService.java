package com.laboratorykkoon9.example.service;

import com.laboratorykkoon9.example.domain.Article;
import com.laboratorykkoon9.example.dto.AddArticleRequest;
import com.laboratorykkoon9.example.dto.UpdateArticleRequest;
import com.laboratorykkoon9.example.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final ArticleRepository articleRepository;

    public Article save(final AddArticleRequest request) {
        return articleRepository.save(request.toEntity());
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public void delete(final long id) {
        articleRepository.deleteById(id);
    }

    @Transactional
    public Article update(final long id, final UpdateArticleRequest request) {
        Article article = articleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("not found: " + id)
        );

        article.update(request.getTitle(), request.getContent());

        return article;
    }

}
