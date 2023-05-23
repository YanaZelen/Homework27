package ru.web.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "testbase")
@Data
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

    @Column
    private String name;

    @Column
    private String password;
}