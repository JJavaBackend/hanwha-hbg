package com.hanwha.hbg.api.common.model.req;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ApiRequest<T> {

  @Valid @NotNull private ReqHeader header;

  @Valid @NotNull private T payload;
}
