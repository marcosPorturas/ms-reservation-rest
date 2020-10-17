package com.pe.web.function.app.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pe.web.function.app.dto.response.RoomResponse;
import com.pe.web.function.app.proxy.feign.CinemaFeign;

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

}
