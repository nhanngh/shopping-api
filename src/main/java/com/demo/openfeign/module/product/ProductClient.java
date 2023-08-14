package com.demo.openfeign.module.product;

import com.demo.openfeign.model.dto.ProductCreateRequest;
import com.demo.openfeign.model.dto.ProductDTO;
import com.demo.openfeign.module.product.config.ProductClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "productClient",
    url = "${productService.url:http://localhost:8086/v1}",
    configuration = ProductClientConfiguration.class)
public interface ProductClient {
  @GetMapping(value = "/product/{productId}")
  ProductDTO getProduct(@PathVariable String productId);

  @PostMapping(value = "/product")
  ProductDTO createProduct(@RequestBody ProductCreateRequest productCreateRequest);
}
