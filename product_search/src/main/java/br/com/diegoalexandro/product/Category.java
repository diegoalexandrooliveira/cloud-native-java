package br.com.diegoalexandro.product;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Category implements Serializable {
    private String id;

    private String name;
}
