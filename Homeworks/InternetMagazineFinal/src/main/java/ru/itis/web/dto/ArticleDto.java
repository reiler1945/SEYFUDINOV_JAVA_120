package ru.itis.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.web.models.Article;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {
    private Long id;
    private String name;
    private Double price;

    public static ArticleDto from(Article model) {
        return ArticleDto.builder()
                .id(model.getId())
                .name(model.getName())
                .price(model.getPrice())
                .build();
    }

    public static List<ArticleDto> from(List<Article> models) {
        return models.stream()
                .map(ArticleDto::from)
                .collect(Collectors.toList());
    }
}
