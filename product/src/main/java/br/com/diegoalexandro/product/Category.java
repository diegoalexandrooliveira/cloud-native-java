package br.com.diegoalexandro.product;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Category(@NonNull String name) {
        this.name = name;
    }
}
