package ru.web.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products", schema = "testbase")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int value;
    private int price;
}