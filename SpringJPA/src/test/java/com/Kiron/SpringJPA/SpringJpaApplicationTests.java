package com.Kiron.SpringJPA;

import com.Kiron.SpringJPA.Entity.ProductEntity;
import com.Kiron.SpringJPA.Repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class SpringJpaApplicationTests {

    @Autowired
    ProductRepository productRepository;



    @Test
	void contextLoads() {
	}

//    @Test
//    void insert(){
//        ProductEntity product = ProductEntity.builder()
//                .title("Physics Book")
//                .genre("Education")
//                .price(159)
//                .available(true)
//                .build();
//
//        ProductEntity savedProduct = productRepository.save(product);
//        System.out.println(savedProduct);
//    }

//    @Test
//    void getProducts(){
//        Optional<ProductEntity> product = productRepository.findByTitle("Product-1");
//        System.out.println(product);
//    }

//    @Test
//    void multiInsert() {
//        List<ProductEntity> products = new ArrayList<>();
//                    for (int i = 1; i <= 20; i++) {
//                ProductEntity product = ProductEntity.builder()
//                        .title("Product-" + i)          // must be unique
//                        .genre("Category-" + (i % 5))
//                        .price(100 + i * 10)
//                        .available(i % 2 == 0)
//                        .build();
//
//                products.add(product);
//            }
//
//            List<ProductEntity> savedProducts = productRepository.saveAll(products);
//            savedProducts
//                    .forEach(System.out::println);
//
//        }


}
