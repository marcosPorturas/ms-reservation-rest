package com.pe.web.function.app.proxy;

import java.util.List;

import com.pe.web.function.app.dto.request.SeatRequest;
import com.pe.web.function.app.dto.response.cinema.RoomResponse;
import com.pe.web.function.app.dto.response.cinema.SeatResponse;

import io.reactivex.Single;

public interface CinemaProxy {

	Single<RoomResponse> getRoomResponse(Integer codRoom);
	
	Single<List<SeatResponse>> updateSeat(List<SeatRequest> listSeatRequest);
	
	
}
