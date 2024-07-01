package com.hanwha.hbg.api.common.model.res;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Schema(name = "응답 헤더")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResHeader {
  @Schema(description = "결과코드")
  private String code;

  @Schema(description = "결과 메시지")
  private String message;

  /** 실패 시 실패 헤더 리턴 (X파라미터 전달X) */
  public ResHeader failed() {
    ResHeader resHeader = new ResHeader();
    resHeader.setCode(ResCodeType.FAILED_9999.getCode());
    resHeader.setMessage(ResCodeType.FAILED_9999.getMsg());
    return resHeader;
  }

  /** 실패 시 실패 헤더 리턴 (O파라미터 전달O) */
  public ResHeader failed(final ResCodeType resCodeType) {
    this.code = resCodeType.getCode();
    this.message = resCodeType.getMsg();
    return this;
  }

  /** 성공 시 성공 헤더 리턴 (X파라미터 전달X) */
  public ResHeader success() {
    ResHeader resHeader = new ResHeader();
    resHeader.setCode(ResCodeType.OK.getCode());
    resHeader.setMessage(ResCodeType.OK.getMsg());
    return resHeader;
  }

  /** 성공 시 성공 헤더 리턴 (O파라미터 전달O) */
  public ResHeader success(final ResCodeType resCodeType) {
    this.code = resCodeType.getCode();
    this.message = resCodeType.getMsg();
    return this;
  }
}
