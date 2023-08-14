package com.demo.openfeign.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

  NOT_FOUND("E404"),
  BAD_REQUEST("E400"),
  UNKNOWN_ERROR("E000"),
  ;

  private final String code;
}
