package br.com.diegoalexandro.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/client/products")
@RequiredArgsConstructor
public class ProductClient {


    private final RestTemplate restTemplate;


    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> get(@PathVariable("id") String id) {

        Product product = restTemplate.getForObject(
                "http://PRODUCT/api/products/" + id, Product.class);

        return ResponseEntity.ok(product);
    }
}
