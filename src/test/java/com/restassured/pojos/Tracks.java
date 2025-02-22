
package com.restassured.pojos;

import java.util.List;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class Tracks {

	@JsonProperty("href")
	private String href;
	@JsonProperty("items")
	private List<Object> items;
	@JsonProperty("limit")
	private Integer limit;
	@JsonProperty("next")
	private Object next;
	@JsonProperty("offset")
	private Integer offset;
	@JsonProperty("previous")
	private Object previous;
	@JsonProperty("total")
	private Integer total;

}
