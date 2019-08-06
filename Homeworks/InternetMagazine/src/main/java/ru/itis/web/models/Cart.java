package ru.itis.web.models;

import lombok.*;

import java.util.List;

@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private Long Id;
    private List<Article> articles;
    private User user;
}
