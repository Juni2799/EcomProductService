package com.example.EcomProductService.service;

import com.example.EcomProductService.dto.CreateProductRequestDTO;
import com.example.EcomProductService.dto.ProductResponseDTO;
import com.example.EcomProductService.entity.Category;
import com.example.EcomProductService.entity.Product;
import com.example.EcomProductService.mapper.ProductEntityDTOMapper;
import com.example.EcomProductService.repository.CategoryRepository;
import com.example.EcomProductService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("productService")
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();

        List<ProductResponseDTO> productsList = new ArrayList<>();
        for(Product product: products){
            productsList.add(ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product));
        }
        return productsList;
    }

    @Override
    public ProductResponseDTO getProductById(UUID productId) {
        Product product = productRepository.findById(productId).get();
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product);
    }

    @Override
    public ProductResponseDTO createProduct(CreateProductRequestDTO createProductRequestDTO) {
        Product product = ProductEntityDTOMapper.convertProductRequestDTOToProductEntity(createProductRequestDTO);

        Category savedCategory = categoryRepository.findById(createProductRequestDTO.getCategoryId()).get();
        product.setCategory(savedCategory);
        Product savedProduct = productRepository.save(product);

        List<Product> categoryProducts = savedCategory.getProducts();
        categoryProducts.add(product);
        savedCategory.setProducts(categoryProducts);
        categoryRepository.save(savedCategory);

        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(savedProduct);
    }

    @Override
    public ProductResponseDTO updateProduct(UUID productId, CreateProductRequestDTO createProductRequestDTO) {
        Product savedProduct = productRepository.findById(productId).get();
        savedProduct.setTitle(createProductRequestDTO.getTitle());
        savedProduct.setImageURL(createProductRequestDTO.getImageURL());
        savedProduct.setDescription(createProductRequestDTO.getDescription());
        savedProduct.setPrice(createProductRequestDTO.getPrice());
        productRepository.save(savedProduct);
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(savedProduct);
    }

    @Override
    public boolean deleteProduct(UUID productId) {
        productRepository.deleteById(productId);
        return true;
    }

    @Override
    public ProductResponseDTO getProductByName(String productName) {
        Product product = productRepository.findProductByTitle(productName);
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product);
    }

    @Override
    public List<ProductResponseDTO> getProducts(double minPrice, double maxPrice) {
        List<Product> productsBetweenRange = productRepository.findProductBetween(minPrice, maxPrice);
        return ProductEntityDTOMapper.convertProductListEntityToProductResponseDTOList(productsBetweenRange);
    }
}
