package br.com.diegoalexandro.product;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UpdateProductRequest {

    @NotEmpty
    private String name;

    @NotEmpty
    private String idCategory;

    @NotEmpty
    private String categoryName;

    public Product toModel(Product product) {
        Category category = new Category(idCategory, categoryName);
        product.update(name, category);
        return product;
    }
}
