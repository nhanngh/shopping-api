package com.demo.openfeign.service.impl;

import com.demo.openfeign.model.dto.ProductCreateRequest;
import com.demo.openfeign.model.dto.ProductDTO;
import com.demo.openfeign.model.dto.UserDTO;
import com.demo.openfeign.module.user.UserClient;
import com.demo.openfeign.module.product.ProductClient;
import com.demo.openfeign.service.ShoppingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingServiceImpl implements ShoppingService {

  private final ProductClient productClient;
  private final UserClient userClient;

  @Override
  public ProductDTO getProduct(String productId) {
    return productClient.getProduct(productId);
  }

  @Override
  public ProductDTO createProduct(ProductCreateRequest request) {
    return productClient.createProduct(request);
  }

  @Override
  public List<UserDTO> getUsers() {
    return userClient.getUsers();
  }

  @Override
  public UserDTO getUserById(Integer userId) {
    return userClient.getUserById(userId);
  }
}
