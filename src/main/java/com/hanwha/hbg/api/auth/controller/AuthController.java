package com.hanwha.hbg.api.auth.controller;

import com.hanwha.hbg.api.auth.model.AuthDto.ReqAuthLoginDto;
import com.hanwha.hbg.api.common.model.req.ApiRequest;
import com.hanwha.hbg.api.common.token.AuthToken;
import com.hanwha.hbg.api.common.token.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "1.인증 동의", description = "인증동의 API")
@Slf4j
@RestController
@RequestMapping(value = "api/")
@RequiredArgsConstructor
public class AuthController {

  private final TokenService tokenService;

  // ApiResponse<ResAuthLoginDto>
  @Operation(summary = "로그인", description = "고객 로그인")
  @PostMapping("login")
  public ResponseEntity<?> login(
      final HttpServletResponse response,
      @RequestBody @Validated final ApiRequest<ReqAuthLoginDto> reqDto) {

    AuthToken token = tokenService.createToken("userId", "asd");

    return ResponseEntity.ok().body(token);
  }
}
