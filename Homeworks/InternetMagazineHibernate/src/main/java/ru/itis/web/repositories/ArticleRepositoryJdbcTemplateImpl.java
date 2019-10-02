package ru.itis.web.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.itis.web.models.Article;

import java.util.List;
import java.util.Optional;

@Component(value = "article.repository.jdbc.template.impl")
public class ArticleRepositoryJdbcTemplateImpl implements ArticleRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //language=SQL
    private static String SQL_SELECT_ALL = "select * from articles";

    static RowMapper<Article> articleRowMapper = (row, rowNumber) ->
            Article.builder()
                    .Id(row.getLong("article_id"))
                    .name(row.getString("name"))
                    .price((Double) row.getObject("price"))
                    .build()
            ;

    @Override
    public Optional<Article> findOneById(Long id) {
        return Optional.empty();
    }

    @Override
    public Article save(Article model) {
        return null;
    }

    @Override
    public void update(Article model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Article> findAll() {
            return jdbcTemplate.query(SQL_SELECT_ALL, articleRowMapper);
    }
}
