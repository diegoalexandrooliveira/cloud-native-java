package br.com.diegoalexandro.product;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
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
        this.id = new ObjectId().toString();
    }

    public void update(String name, Category category){
        this.name = name;
        this.category = category;
    }
}
