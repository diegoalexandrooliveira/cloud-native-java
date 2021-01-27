package br.com.diegoalexandro.product;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Document(indexName = "product", type = "external")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Product implements Serializable {

    @Id
    private String id;

    private String name;

    private Category category;

    public Product(@NonNull String name, @NonNull Category category) {
        this.name = name;
        this.category = category;
    }
}
