package com.hanwha.hbg.api.common.model.res;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Schema(name = "결과 코드값 정의")
@NoArgsConstructor
@Getter
public enum ResCodeType {
  OK("0000", "성공"),
  FAILED_9999("9999", "실패");

  @Schema(description = "코드값")
  private String code;

  @Schema(description = "결과 메시지")
  private String msg;

  ResCodeType(final String code, final String msg) {
    this.code = code;
    this.msg = msg;
  }

  public static ResCodeType findByCode(String code) {
    for (final ResCodeType resCodeType : ResCodeType.values()) {
      if (resCodeType.getCode().equals(code)) {
        return resCodeType;
      }
    }
    return null;
  }
}
