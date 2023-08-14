package com.demo.openfeign.module.user.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class UserClientConfiguration {
  @Bean
  Logger.Level feignLoggerLevel() {
    return Logger.Level.FULL;
  }
}
