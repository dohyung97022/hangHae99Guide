package com.sparta.week4.controller;

import com.sparta.week4.models.Product;
import com.sparta.week4.models.ProductMypriceRequestDto;
import com.sparta.week4.models.ProductRepository;
import com.sparta.week4.models.ProductRequestDto;
import com.sparta.week4.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class ProductRestController {

    private final ProductService productService;
    private final ProductRepository productRepository;

    // 등록된 전체 상품 목록 조회
    @GetMapping("/api/products")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    // 신규 상품 등록
    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto requestDto) {
        Product product = new Product(requestDto);
        return productRepository.save(product);
    }

    @PutMapping("api/products/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto productMypriceRequestDto) {
        Product product = productRepository.getById(id);
        product.updateByProductMypriceRequestDto(productMypriceRequestDto);
        productRepository.save(product);
        return product;
    }
}