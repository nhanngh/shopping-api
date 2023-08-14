package com.demo.openfeign.module.product.config;

import feign.Feign;
import feign.Logger;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class ProductClientConfiguration {
  @Bean
  Logger.Level feignLoggerLevel() {
    return Logger.Level.FULL;
  }

  @Bean
  public ErrorDecoder errorDecoder() {
    return new RetreiveFeignMessageErrorDecoder();
  }

  @Bean
  @Scope("prototype")
  public Feign.Builder feignBuilder() {
    return Feign.builder();
  }
}
