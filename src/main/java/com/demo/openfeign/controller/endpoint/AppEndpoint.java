package com.demo.openfeign.controller.endpoint;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AppEndpoint {

  public static final String VERSION = "/v1";

  public static final String HELLO_ENDPOINT = VERSION + "/hello";
}
