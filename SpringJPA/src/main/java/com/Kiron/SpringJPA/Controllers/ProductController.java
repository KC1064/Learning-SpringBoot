package com.Kiron.SpringJPA.Controllers;

import com.Kiron.SpringJPA.Entity.ProductEntity;
import com.Kiron.SpringJPA.Repositories.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final int PAGE_SIZE = 5;

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    @GetMapping
//    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue = "price") String sortBy){
//        return productRepository.findByGenre("Category-1",Sort.by(Sort.Direction.DESC,sortBy));
////        return productRepository.findAll();
//    }

    @GetMapping
    public List<ProductEntity> paginatedProducts(@RequestParam(defaultValue = "id") String sortBy,
                                                 @RequestParam(defaultValue = "0") Integer pageNumber){
        Pageable pageable = PageRequest.of(pageNumber,
                PAGE_SIZE,
                Sort.by(sortBy).descending());
        return productRepository.findAll(pageable).getContent();
    }
}
