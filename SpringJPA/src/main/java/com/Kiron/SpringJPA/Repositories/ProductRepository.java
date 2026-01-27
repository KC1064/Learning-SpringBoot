package com.Kiron.SpringJPA.Repositories;

import com.Kiron.SpringJPA.Entity.ProductEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    Optional<ProductEntity> findByTitle(String s);

    List<ProductEntity> findByOrderByPrice();


    List<ProductEntity> findByGenre(String s, Sort sort);

}
