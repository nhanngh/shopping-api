package com.demo.openfeign.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriTemplateHandler;

@Configuration
@RequiredArgsConstructor
public class ProductModuleConfig {
  @Bean
  public RestTemplate productRestTemplate(UriTemplateHandler productUriTemplateHandler) {
    RestTemplate demoRestTemplate = new RestTemplate();
    demoRestTemplate.setUriTemplateHandler(productUriTemplateHandler);

    return demoRestTemplate;
  }

  @Bean
  public UriTemplateHandler productUriTemplateHandler() {
    return new DefaultUriBuilderFactory("http://localhost:8086/v1");
  }
}
