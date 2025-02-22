package com.restassured.resuables;

import static io.restassured.RestAssured.given;

import com.restassured.pojos.GetPlaylist;
import com.restassured.specBuilder.SpecBuilder;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;

public class ReusableMethods {

	public static Response post(Object obj, String accessToken, String path) {
		return given().spec(SpecBuilder.getReqSpec()).filter(new AllureRestAssured()).auth().oauth2(accessToken)
				.body(obj).when().post(path).then().spec(SpecBuilder.getRespSpec()).extract().response();
	}

	public static Response get(String accessToken, String path) {
		return given().spec(SpecBuilder.getReqSpec()).filter(new AllureRestAssured()).auth().oauth2(accessToken).when()
				.get(path).then().spec(SpecBuilder.getRespSpec()).extract().response();

	}

	public static Response update(GetPlaylist playlist, String accessToken, String path) {
		return given().spec(SpecBuilder.getReqSpec()).filter(new AllureRestAssured()).auth().oauth2(accessToken)
				.body(playlist).when().put(path).then().spec(SpecBuilder.getRespSpec()).extract().response();

	}

}
