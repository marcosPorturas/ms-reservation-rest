package com.pe.web.function.app.proxy;

import com.pe.web.function.app.dto.response.cinema.RoomResponse;

import io.reactivex.Single;

public interface CinemaProxy {

	Single<RoomResponse> getRoomResponse(Integer codRoom);
	
	
}
