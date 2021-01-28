package br.com.diegoalexandro.product;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class NewProductRequest {

    @NotEmpty
    private String name;


    @NotEmpty
    private String idCategory;

    @NotEmpty
    private String categoryName;


    public Product toModel() {
        Category category = new Category(idCategory, categoryName);
        return new Product(name, category);
    }


}
