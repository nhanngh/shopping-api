package com.demo.openfeign.module.user.config;

import com.demo.openfeign.model.dto.ProductCreateRequest;
import com.demo.openfeign.model.dto.ProductDTO;
import com.demo.openfeign.model.dto.UserDTO;
import com.demo.openfeign.module.product.ProductClient;
import com.demo.openfeign.module.user.UserClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserClientFallback implements UserClient {
  @Override
  public List<UserDTO> getUsers() {
    return null;
  }

  @Override
  public UserDTO getUserById(Integer userId) {
    return new UserDTO(1000, "fake user name", "fake user email");
  }
}
