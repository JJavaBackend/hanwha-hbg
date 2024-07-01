package com.hanwha.hbg.api.common.model.res;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ApiResponse<T> {
  private ResHeader header;
  private T payload;

  public ApiResponse(final ResHeader resHeader, final T payload) {
    this.payload = payload;
    this.header = resHeader;
  }

  public ApiResponse(final ResHeader resHeader) {
    this.header = resHeader;
  }

  public ApiResponse<T> error(final ResHeader resHeader) {
    return new ApiResponse<>(this.header.failed());
  }
}
