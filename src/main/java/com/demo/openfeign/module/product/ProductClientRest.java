package com.demo.openfeign.module.product;

import com.demo.openfeign.model.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class ProductClientRest {
  private final RestTemplate productRestTemplate;

  public ProductDTO getProduct(String id) {
    try {
      String endpoint = UriComponentsBuilder.fromUriString("/product/{id}").build().toString();
      ProductDTO product = productRestTemplate.getForObject(endpoint, ProductDTO.class, id);

      if (product == null) {
        throw new IllegalArgumentException("Product not found.");
      }

      return product;
    } catch (HttpClientErrorException | HttpServerErrorException ex) {
      // handle: log error, send notification
      throw ex;
    }
  }
}
