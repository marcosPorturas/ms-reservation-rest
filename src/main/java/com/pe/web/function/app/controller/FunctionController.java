package com.pe.web.function.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.web.function.app.dto.request.FunctionRequest;
import com.pe.web.function.app.dto.request.ReservationRequest;
import com.pe.web.function.app.dto.response.FunctionResponse;
import com.pe.web.function.app.dto.response.ReservationResponse;
import com.pe.web.function.app.service.FunctionService;

import io.reactivex.Single;

@RestController
@RequestMapping("/function")
public class FunctionController {

	@Autowired
	FunctionService functionService;
	
	
	@GetMapping("/{codFunction}")
	public Single<FunctionResponse> getFunctionResponse(@PathVariable("codFunction")
	Integer codFunction) {
		return functionService.getFunctionResponse(codFunction);
	}
	
	@GetMapping("/reservation/{codReservation}")
	public Single<ReservationResponse> getReservationResponse(@PathVariable("codReservation")
	Integer codReservation) {
		return functionService.getReservationResponse(codReservation);
	}
	
	@PostMapping("/add")
	public Single<FunctionResponse> addFunction(@RequestBody FunctionRequest functionRequest) {
		return functionService.addFunction(functionRequest);
	}
	
	@PostMapping("/reservation/add")
	public Single<ReservationResponse> addReservation(@RequestBody ReservationRequest reservationRequest) {
		return functionService.addReservation(reservationRequest);
	}
}
