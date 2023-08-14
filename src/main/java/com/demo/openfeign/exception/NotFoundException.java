package com.demo.openfeign.exception;

import jakarta.annotation.Nullable;

public class NotFoundException extends CustomException {

  public NotFoundException(ErrorCode errorCode, String message) {
    super(errorCode, message);
  }

  public NotFoundException(ErrorCode errorCode, String message, Throwable cause) {
    super(errorCode, message, cause);
  }
}
