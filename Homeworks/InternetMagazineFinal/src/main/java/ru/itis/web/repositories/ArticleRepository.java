package ru.itis.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.web.models.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
