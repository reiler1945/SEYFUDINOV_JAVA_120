package ru.itis.web.services;

import ru.itis.web.dto.ArticleDto;
import ru.itis.web.models.Article;

import java.util.List;

public interface ArticleService {
    Article addArticle(ArticleDto articleForm);
    List<ArticleDto> getAllArticles();
    void delete(Long article_id);
}
