package com.demo.openfeign.exception;

import jakarta.annotation.Nullable;
import lombok.Getter;

import java.util.List;

@Getter
public class CustomException extends RuntimeException {

  private final ErrorCode errorCode;

  public CustomException(ErrorCode errorCode, String message) {
    super(message);
    this.errorCode = errorCode;
  }

  public CustomException(ErrorCode errorCode, String message, Throwable cause) {
    super(message, cause);
    this.errorCode = errorCode;
  }
}