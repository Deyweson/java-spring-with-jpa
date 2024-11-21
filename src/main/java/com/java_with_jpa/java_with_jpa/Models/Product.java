package com.java_with_jpa.java_with_jpa.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Integer id;

    @Column(nullable = false)
    @Getter
    @Setter
    @NotBlank
    private String name;

    @Column(nullable = false)
    @Getter
    @Setter
    @Min(value = 10)
    private Integer price;

    @Column()
    @Getter
    @Setter
    private String description;
}
