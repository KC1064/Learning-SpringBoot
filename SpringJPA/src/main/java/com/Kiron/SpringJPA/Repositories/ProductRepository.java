package com.Kiron.SpringJPA.Repositories;

import com.Kiron.SpringJPA.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
