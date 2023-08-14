package com.demo.openfeign.controller;

import static com.demo.openfeign.controller.endpoint.AppEndpoint.PRODUCT;
import static com.demo.openfeign.controller.endpoint.AppEndpoint.PRODUCT_BY_ID;
import static com.demo.openfeign.controller.endpoint.AppEndpoint.SHOP;
import static com.demo.openfeign.controller.endpoint.AppEndpoint.USERS;
import static com.demo.openfeign.controller.endpoint.AppEndpoint.USER_BY_ID;

import com.demo.openfeign.model.dto.ProductCreateRequest;
import com.demo.openfeign.model.dto.ProductDTO;
import com.demo.openfeign.model.dto.UserDTO;
import com.demo.openfeign.service.ShoppingService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(SHOP)
@RequiredArgsConstructor
public class ShoppingController {

  private final ShoppingService shoppingService;

  @GetMapping(value = PRODUCT_BY_ID)
  public ProductDTO getProduct(@PathVariable String productId) {
    return shoppingService.getProduct(productId);
  }

  @PostMapping(value = PRODUCT)
  public ProductDTO createProduct(@RequestBody ProductCreateRequest request) {
    return shoppingService.createProduct(request);
  }

  @GetMapping(value = USERS)
  public List<UserDTO> getUsers() {
    return shoppingService.getUsers();
  }

  @GetMapping(value = USER_BY_ID)
  public UserDTO getUserById(@PathVariable Integer userId) {
    return shoppingService.getUserById(userId);
  }
}
