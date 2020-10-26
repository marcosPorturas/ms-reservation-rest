package com.pe.web.function.app.dto.response;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ReservationResponse {

	private Integer codReservation;
	
	private String reservationDate;
	
	private String statusReservation;
	
	private InfoClient infoClient;
	
	private InfoEmployee infoEmployee;
	
	private InfoFunction infoFunction;
	
	private List<DetailReservationResponse> listDetailReservaion;
	
	
}
