package com.pe.web.reservation.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.web.reservation.app.dto.request.ReservationRequest;
import com.pe.web.reservation.app.dto.response.ReservationResponse;
import com.pe.web.reservation.app.service.ReservationService;

import io.reactivex.Single;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	ReservationService reservationService;
	
	
	@GetMapping("/{codReservation}")
	public Single<ReservationResponse> getReservationResponse(@PathVariable("codReservation")
	Integer codReservation) {
		return reservationService.getReservationResponse(codReservation);
	}
	
	@PostMapping("/add")
	public Single<ReservationResponse> addReservation(@RequestBody ReservationRequest reservationRequest) {
		return reservationService.addReservation(reservationRequest);
	}
}
