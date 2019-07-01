package ru.itis.service.models;

import lombok.*;

import java.util.List;

@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String phone;
    private String email;
    private String login;
    private String password;
    private UserRole role;
    private List<Car> cars;
}
