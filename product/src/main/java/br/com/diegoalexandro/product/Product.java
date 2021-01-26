package br.com.diegoalexandro.product;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

//@Entity
@Document(collection = "product")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Product implements Serializable {

    @Id
//    @GeneratedValue
    private String id;

    private String name;

//    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    public Product(@NonNull String name, @NonNull Category category) {
        this.name = name;
        this.category = category;
    }
}
