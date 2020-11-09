package com.pe.web.reservation.app.dto.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequest {

	private Integer codClient;
	
	private Integer codEmployee;
	
	private Integer codFunction;
	
	private List<SeatRequest> listSeat;
	
}
