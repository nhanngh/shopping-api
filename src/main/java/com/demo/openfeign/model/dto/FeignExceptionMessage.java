package com.demo.openfeign.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeignExceptionMessage {
  private String code;
  private String message;
  private String error;
}
