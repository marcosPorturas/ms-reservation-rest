package com.pe.web.function.app.proxy.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pe.web.function.app.dto.response.RoomResponse;


@FeignClient(name="cinema", url="${url.cinema.host}")
public interface CinemaFeign {
	
	@GetMapping("/room/{codRoom}")
	RoomResponse getRoomResponse(@PathVariable("codRoom")Integer codRoom);

}
