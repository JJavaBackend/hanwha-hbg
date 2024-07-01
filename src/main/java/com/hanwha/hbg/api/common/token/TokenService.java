package com.hanwha.hbg.api.common.token;

import com.hanwha.hbg.api.common.model.res.ResCodeType;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TokenService {

  @Value("${token.access.secret}")
  private String accessTokenKey;

  @Value("${token.refresh.secret}")
  private String refreshTokenKey;

  @Value("${token.access.exprMin}")
  private int accessTokenExpirationMinute;

  @Value("${token.refresh.exprHour}")
  private int refreshTokenExpirationHour;

  @Value("${token.refresh.limtMin}")
  private int refreshTokenLimitMinute;

  public AuthToken createToken(final String userid, final String userBirth) {
    Date today = Date.from(Instant.now()); // 현재 시간

    // Access Token 생성
    String accessToken =
        createSignedJWT(
            "access_token", userBirth, userid, accessTokenExpirationMinute, accessTokenKey);

    // Refresh Token 생성
    String refreshToken =
        createSignedJWT(
            "refresh_token",
            userBirth,
            userid,
            refreshTokenExpirationHour * 60 + refreshTokenLimitMinute,
            refreshTokenKey);

    if (accessToken != null && refreshToken != null) {
      return new AuthToken(accessToken, refreshToken, ResCodeType.OK);
    } else {
      log.error("*** 토큰 생성 실패 ***");
      return null;
    }
  }

  private String createSignedJWT(
      String subject, String userBirth, String userid, int expirationMinutes, String key) {
    try {
      JWSSigner signer = new MACSigner(key);
      JWTClaimsSet claimsSet =
          new JWTClaimsSet.Builder()
              .subject(subject)
              .claim("user_birth", userBirth)
              .claim("user_id", userid)
              .issueTime(new Date())
              .expirationTime(Date.from(Instant.now().plus(expirationMinutes, ChronoUnit.MINUTES)))
              .build();
      SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
      signedJWT.sign(signer);
      return signedJWT.serialize();
    } catch (JOSEException ex) {
      log.error("*** 토큰 생성 관련 에러입니다 ::: {} ***", ex);
      return null;
    }
  }
}