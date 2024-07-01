package com.hanwha.hbg.api.auth.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/** 로그인 인증 */
public class AuthDto {

  @Getter
  @Setter
  @ToString
  @Schema(name = "요청 로그인")
  public static class ReqAuthLoginDto {

    @Schema(description = "로그인 아이디")
    @NotBlank(message = "아이디는 필수값 입니다.")
    private String username;

    @Schema(description = "로그인 비밀번호")
    @NotBlank(message = "비밀번호는 필수값 입니다.")
    private String password;

    @Schema(description = "생년월일")
    @NotBlank(message = "생년월일은 필수값 입니다.")
    @Size(min = 0, max = 9, message = "최소 1, 최대 9 입력 가능합니다.")
    private String userBirth;
  }

  @Getter
  @Setter
  @ToString
  @Schema(name = "응답 로그인")
  public static class ResAuthLoginDto {
    @Schema(description = "로그인 아이디")
    private String username;

    @Schema(description = "로그인 비밀번호")
    private String password;
  }
}
