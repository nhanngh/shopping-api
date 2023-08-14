package com.demo.openfeign.module.user;

import com.demo.openfeign.model.dto.UserDTO;
import com.demo.openfeign.module.user.config.UserClientConfiguration;
import com.demo.openfeign.module.user.config.UserClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "userClient",
    url = "${jsonplaceholder.url:https://jsonplaceholder.typicode.com}",
    configuration = UserClientConfiguration.class,
    fallback = UserClientFallback.class)
public interface UserClient {
  @GetMapping(value = "/users")
  List<UserDTO> getUsers();

  @GetMapping(value = "/users/{userId}")
  UserDTO getUserById(@PathVariable Integer userId);
}
