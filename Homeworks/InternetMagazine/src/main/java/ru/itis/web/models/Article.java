package ru.itis.web.models;

import lombok.*;
import org.postgresql.util.PGmoney;

@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    Long Id;
    String name;
    Double price;
}
