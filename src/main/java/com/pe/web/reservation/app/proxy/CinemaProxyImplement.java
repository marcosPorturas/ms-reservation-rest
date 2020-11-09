package com.pe.web.reservation.app.proxy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pe.web.reservation.app.dto.request.SeatRequest;
import com.pe.web.reservation.app.dto.response.cinema.RoomResponse;
import com.pe.web.reservation.app.dto.response.cinema.SeatResponse;
import com.pe.web.reservation.app.proxy.feign.CinemaFeign;

import io.reactivex.Single;

@Component
public class CinemaProxyImplement implements CinemaProxy{

	@Autowired
	CinemaFeign cinemaFeign;
	
	@Override
	public Single<RoomResponse> getRoomResponse(Integer codRoom) {
		// TODO Auto-generated method stub
		return Single.just(cinemaFeign.getRoomResponse(codRoom));
	}

	@Override
	public Single<List<SeatResponse>> updateSeat(List<SeatRequest> listSeatRequest) {
		// TODO Auto-generated method stub
		return Single.just(cinemaFeign.updateSeat(listSeatRequest));
	}

}
