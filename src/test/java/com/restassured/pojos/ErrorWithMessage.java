
package com.restassured.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorWithMessage {

    @JsonProperty("status")
    private Integer status;
    @JsonProperty("message")
    private String message;
}
