package com.restassured.tests;

import org.testng.annotations.Test;

import com.restassured.pojos.GetPlaylist;
import com.restassured.api.PlaylistAPI;
import com.restassured.pojos.Error;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@Epic("Spotify OAuth")
@Feature("Playlist API")
public class PlayList {

	String playlist_id = "6oZ5PAoGroB3l4sjr76h9s";

	@Description("This method is used to create a playlist")
	@Test(description = "Create a playlist")
	public void createPlaylist() {
		GetPlaylist payload = new GetPlaylist();
		payload.setName("This is the name from the pojo name");
		payload.setDescription("This is description from the pojo description");
		payload.set_public(false);

		Response responsePayLoad = PlaylistAPI.post(payload);
		GetPlaylist repsonse = responsePayLoad.as(GetPlaylist.class);

		assertThat(payload.getName(), equalTo(repsonse.getName()));
		assertThat(payload.getDescription(), equalTo(repsonse.getDescription()));
		assertThat(payload.get_public(), equalTo(repsonse.get_public()));
	}

	@Description("This method is used to get a playlist")
	@Test(description = "Get a playlist")
	public void getPlaylist()

	{
		Response responsePayload = PlaylistAPI.get(playlist_id);
		assertThat(responsePayload.getStatusCode(), equalTo(200));

	}

	@Description("This method is used to update a playlist")
	@Test(description = "Update a playlist")
	public void updatePlaylist() {

		GetPlaylist payload = new GetPlaylist();
		payload.setName("This is the updated name from the pojo name");
		payload.setDescription("This is updated description from the pojo description");
		payload.set_public(false);
		Response responsePayload = PlaylistAPI.update(payload, playlist_id);
		assertThat(responsePayload.getStatusCode(), equalTo(200));
	}

	@Description("This method is used to create a playlist without name, and expected to return 400 error")
	@Test(description = "Create a playlist without Name")
	public void notAbleToCreatePlaylistWithoutName() {

		GetPlaylist payload = new GetPlaylist();
		payload.setName("");
		payload.setDescription("This is updated description from the pojo description");
		payload.set_public(false);
		Response responsePayLoad = PlaylistAPI.post(payload);
		Error repsonse = responsePayLoad.as(Error.class);
		assertThat(responsePayLoad.getStatusCode(), equalTo(400));
		assertThat(repsonse.getError().getMessage(), equalTo("Missing required field: name"));

	}

	@Description("This method is used to create a playlist withou proper token and expected to throw 401 error")
	@Test(description = "Create a playlist without proper token")
	public void notAbleToCreatePlaylistWithoutToken() {

		GetPlaylist payload = new GetPlaylist();
		payload.setName("This is not going to work due to token issue");
		payload.setDescription("This is updated description from the pojo description");
		payload.set_public(false);

		Response responsePayLoad = PlaylistAPI.post(payload, "12143234");
		Error repsonse = responsePayLoad.as(Error.class);

		assertThat(repsonse.getError().getMessage(), equalTo("Invalid access token"));
	}

}
