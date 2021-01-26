package br.com.diegoalexandro.product;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {


//    @Query("select p from Product p join fetch p.category where p.category.id = ?1")
    @Cacheable("productsByCategoryCache")
    @Query("{'category.id': ?0}")
    List<Product> findByCategoryId(String id);


}
