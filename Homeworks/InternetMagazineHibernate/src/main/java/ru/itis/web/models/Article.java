package ru.itis.web.models;

import lombok.*;
import org.postgresql.util.PGmoney;

import javax.persistence.*;

@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(length = 20)
    private String name;
    private Double price;
}
