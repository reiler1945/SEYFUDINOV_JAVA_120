package ru.itis.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.itis.web.dto.ArticleDto;
import ru.itis.web.models.Article;
import ru.itis.web.repositories.ArticleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    @Qualifier(value = "article.repository.jpa.impl")
    ArticleRepository articleRepository;

    @Override
    public List<ArticleDto> getAllArticles() {
        List<Article> articles = articleRepository.findAll();
        //List<ArticleDto> result = new ArrayList<>();
        Stream<Article> articleStream = articles.stream();
        // TODO: on stream -> in ArticleDto from(List<Article> articles)
        Stream<ArticleDto> articleDtoStream = articleStream
                .map(article -> ArticleDto.builder()
                    .id(article.getId())
                    .name(article.getName())
                    .price(article.getPrice())
                    .build());
        List<ArticleDto> result = articleDtoStream.collect(Collectors.toList());
//
//        for (Article article : articles) {
//
//            ArticleDto articleDto = ArticleDto.builder()
//                    .id(article.getId())
//                    .name(article.getName())
//                    .price(article.getPrice())
//                    .build();
//
//            result.add(articleDto);
//        }
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
