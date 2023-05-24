package com.groupe4.frontoffice.service;

import com.groupe4.frontoffice.dto.ProductDto;
import com.groupe4.frontoffice.mapper.ProductMapper;
import com.groupe4.frontoffice.model.product.Product;
import com.groupe4.frontoffice.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    public List<ProductDto> fetchAll(){
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::productToProductDto)
                .collect(Collectors.toList());
    }

    public ProductDto getById(int id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.map(productMapper::productToProductDto).orElse(null);
    }
}

