package br.com.diegoalexandro.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/products")
//@RequestMapping(path = "/${env}/products")
@RequiredArgsConstructor
@Validated
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") String id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @GetMapping(path = "/category/{id}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("id") String id) {
        return ResponseEntity.ok(productRepository.findByCategoryId(id));
    }


    @GetMapping(path = "/name/{name}")
    public ResponseEntity<List<Product>> getByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(productRepository.findByName(name));
    }

    @PostMapping
    public ResponseEntity<Product> insertProduct(@RequestBody @Valid NewProductRequest newProductRequest) {
        Product product = productRepository.save(newProductRequest.toModel());
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") String id, @RequestBody @Valid UpdateProductRequest updateProductRequest) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
        product = updateProductRequest.toModel(product);
        productRepository.save(product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") String id) {
        productRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
