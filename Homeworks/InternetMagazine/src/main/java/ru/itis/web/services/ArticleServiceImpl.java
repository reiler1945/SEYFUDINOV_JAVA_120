package ru.itis.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.web.dto.ArticleDto;
import ru.itis.web.models.Article;
import ru.itis.web.repositories.ArticleRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public List<ArticleDto> getAllArticles() {
        List<Article> articles = articleRepository.findAll();
        List<ArticleDto> result = new ArrayList<>();

        for (Article article : articles) {
            ArticleDto articleDto = ArticleDto.builder()
                    .id(article.getId())
                    .name(article.getName())
                    .price(article.getPrice())
                    .build();

            result.add(articleDto);
        }
        return result;
    }

    @Override
    public Article addArticle(ArticleDto articleForm) {
        return null;
    }

    @Override
    public void delete(Long article_id) {

    }
}
