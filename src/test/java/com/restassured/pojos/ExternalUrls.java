
package com.restassured.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;


import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.processing.Generated;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class ExternalUrls {

    @JsonProperty("spotify")
    private String spotify;

}
