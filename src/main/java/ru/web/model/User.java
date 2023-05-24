package ru.web.model;

import lombok.*;

import javax.persistence.*;

/**
 * Изменять параметры Table нужно если они не совпадают с стандартными.
 * @Data тоже не надо делать, если ты вставляешь остальные аннотации
 */
@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String password;
}