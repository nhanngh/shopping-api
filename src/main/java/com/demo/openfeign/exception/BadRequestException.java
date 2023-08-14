package com.demo.openfeign.exception;

import jakarta.annotation.Nullable;

public class BadRequestException extends CustomException {

  public BadRequestException(ErrorCode errorCode, String message) {
    super(errorCode, message);
  }

  public BadRequestException(ErrorCode errorCode, String message, Throwable cause) {
    super(errorCode, message, cause);
  }
}
