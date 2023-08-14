package com.demo.openfeign.module.product.config;

import com.demo.openfeign.exception.BadRequestException;
import com.demo.openfeign.exception.ErrorCode;
import com.demo.openfeign.exception.NotFoundException;
import com.demo.openfeign.model.dto.FeignExceptionMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class RetreiveFeignMessageErrorDecoder implements ErrorDecoder {
  @Override
  public Exception decode(String key, Response response) {
    FeignExceptionMessage message;

    try (InputStream bodyIs = response.body().asInputStream()) {
      ObjectMapper mapper = new ObjectMapper();
      message = mapper.readValue(bodyIs, FeignExceptionMessage.class);
    } catch (IOException e) {
      return new Exception(e.getMessage());
    }

    log.error("Service %s causes an error. Status code: %s. Error message: %s".formatted(key, message.getCode(), message.getMessage()));

    return switch (response.status()) {
      case 400 ->
          new BadRequestException(ErrorCode.BAD_REQUEST, message.getMessage() != null ? message.getMessage() : "Bad Request");
      case 404 ->
          new NotFoundException(ErrorCode.NOT_FOUND, message.getMessage() != null ? message.getMessage() : "Not found");
      default -> new Exception("Exception when call other service.");
    };
  }
}
