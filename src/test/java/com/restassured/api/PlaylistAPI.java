package com.restassured.api;

import com.restassured.pojos.GetPlaylist;
import com.restassured.resuables.ReusableMethods;
import com.restassured.token.TokenManager;

import io.restassured.response.Response;

public class PlaylistAPI {
	static String access_token = TokenManager.renew_token();

	public static Response post(GetPlaylist playlist) {
		return ReusableMethods.post(playlist, access_token, "users/31wk5uxdw2rf5qsxg4pnkn7rjeze/playlists");
	}

	public static Response post(GetPlaylist playlist, String accessToken) {
		return ReusableMethods.post(playlist, "123324", "users/31wk5uxdw2rf5qsxg4pnkn7rjeze/playlists");
	}

	public static Response get(String playlistId) {
		return ReusableMethods.get(access_token, "playlists/" + playlistId);

	}

	public static Response update(GetPlaylist playlist, String playlistId) {
		return ReusableMethods.update(playlist, access_token, "playlists/" + playlistId);

	}

}
