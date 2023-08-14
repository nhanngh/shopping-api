package com.demo.openfeign.controller.endpoint;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AppEndpoint {

  public static final String VERSION = "/v1";

  public static final String SHOP = VERSION + "/shop";
  public static final String PRODUCT = "/product";
  public static final String PRODUCT_BY_ID = "/product/{productId}";
  public static final String USERS = "/users";
  public static final String USER_BY_ID =  "/user/{userId}";
}
