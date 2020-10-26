package com.pe.web.function.app.proxy.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pe.web.function.app.dto.request.SeatRequest;
import com.pe.web.function.app.dto.response.cinema.RoomResponse;
import com.pe.web.function.app.dto.response.cinema.SeatResponse;


@FeignClient(name="cinema", url="${url.cinema.host}")
public interface CinemaFeign {
	
	@GetMapping("/room/{codRoom}")
	RoomResponse getRoomResponse(@PathVariable("codRoom")Integer codRoom);
	
	@PostMapping("/room/seat")
	List<SeatResponse> updateSeat(@RequestBody List<SeatRequest> listSeatRequest);

}
