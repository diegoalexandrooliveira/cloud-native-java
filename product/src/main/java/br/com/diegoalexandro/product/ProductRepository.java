package br.com.diegoalexandro.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p join fetch p.category where p.id = ?1")
    Optional<Product> getById(Long id);

    @Query("select p from Product p join fetch p.category where p.category.id = ?1")
    List<Product> getByCategory(Long id);


}
