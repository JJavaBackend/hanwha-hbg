package com.hanwha.hbg.api.common.token;

import com.hanwha.hbg.api.common.model.res.ResCodeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AuthToken {
  private String accessToken;
  private String refreshToken;

  private ResCodeType resCodeType;

  public AuthToken(final ResCodeType resCodeType) {
    this.resCodeType = resCodeType;
  }
}
