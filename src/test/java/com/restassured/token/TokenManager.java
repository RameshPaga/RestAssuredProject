package com.restassured.token;

import java.util.HashMap;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import com.restassured.specBuilder.SpecBuilder;

public class TokenManager {

	public static String renew_token() {

		HashMap<String, String> formParam = new HashMap<String, String>();
		formParam.put("grant_type", "refresh_token");
		formParam.put("refresh_token",
				"AQA5X6dbNjyxb-gXuyaC90P-U1QUTdGV4mTJ1OH6GCIUfxCwTFo463PNYQAwHi_i4RoyLCgU0bH5lOnH7ThFoKW68I4gq61a69LQRKynNHX2FxV9KZl60_OfIbkfP0tPefs");
		formParam.put("client_id", "931ab8dcea974007a27f86382accf8f0");
		formParam.put("client_secret", "7b415f6ab31a4edb8d083816fbb93954");

		Response response = given().baseUri("https://accounts.spotify.com").formParams(formParam)
				.contentType(ContentType.URLENC).log().all().when().post("/api/token").then()
				.spec(SpecBuilder.getRespSpec()).extract().response();
		if (response.statusCode() != 200) {
			throw new RuntimeException("Error while renewing the token");
		}
		return response.path("access_token");

	}

}
