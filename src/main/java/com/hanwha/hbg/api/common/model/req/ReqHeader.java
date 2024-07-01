package com.hanwha.hbg.api.common.model.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Schema(name = "요청 헤더")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReqHeader {
  @Schema(description = "access_token")
  @NotBlank(message = "엑세스 토큰을 입력해주세요.")
  private String accessToken;

  @Schema(description = "refresh_token")
  @NotBlank(message = "리프레쉬 토큰을 입력해주세요.")
  private String refreshToken;
}
