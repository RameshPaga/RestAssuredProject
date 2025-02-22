
package com.restassured.pojos;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class Owner {

	@JsonProperty("display_name")
	private String displayName;
	@JsonProperty("external_urls")
	private ExternalUrls__1 externalUrls;
	@JsonProperty("href")
	private String href;
	@JsonProperty("id")
	private String id;
	@JsonProperty("type")
	private String type;
	@JsonProperty("uri")
	private String uri;

}
