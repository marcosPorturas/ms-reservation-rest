package com.pe.web.function.app.dto.request;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationRequest {

	private Integer codClient;
	
	private Integer codEmployee;
	
	private Integer codFunction;
	
	private List<SeatRequest> listSeat;
	
}
