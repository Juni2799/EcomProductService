package com.example.EcomProductService.client;

import com.example.EcomProductService.dto.fakestoreDtos.FakeStoreProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreClient {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Value("${fakestore.api.base.url}")
    private String fakeStoreApiBaseUrl;
    @Value("${fakestore.api.product.path}")
    private String fakeStoreApiProductPath;

    public List<FakeStoreProductResponseDTO> getAllProducts(){
        String fakeStoreApiGetProductUrl = fakeStoreApiBaseUrl.concat(fakeStoreApiProductPath);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> productResponseList =
                restTemplate.getForEntity(fakeStoreApiGetProductUrl, FakeStoreProductResponseDTO[].class);
        return List.of(productResponseList.getBody());
    }

    public FakeStoreProductResponseDTO getProductById(int id){
        String fakeStoreApiGetProductByIdUrl = fakeStoreApiBaseUrl.concat(fakeStoreApiProductPath).concat("/" + id);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse =
                restTemplate.getForEntity(fakeStoreApiGetProductByIdUrl, FakeStoreProductResponseDTO.class);
        return productResponse.getBody();
    }
}
