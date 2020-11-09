package com.pe.web.reservation.app.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeatRequest{

	private Integer codSeat;
	
	private String statusSeat;
	
	private Integer codTypeTicket;
	
}
