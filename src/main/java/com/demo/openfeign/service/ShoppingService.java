package com.demo.openfeign.service;

import com.demo.openfeign.model.dto.ProductCreateRequest;
import com.demo.openfeign.model.dto.ProductDTO;
import com.demo.openfeign.model.dto.UserDTO;

import java.util.List;

public interface ShoppingService {

  ProductDTO getProduct(String productId);

  ProductDTO createProduct(ProductCreateRequest request);

  List<UserDTO> getUsers();

  UserDTO getUserById(Integer userId);
}
