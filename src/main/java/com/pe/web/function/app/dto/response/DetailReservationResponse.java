package com.pe.web.function.app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailReservationResponse {
	
	private Integer codSeat;
	
	private Integer codTypeTicket;
	
	private String description;
	
	private Double price;

}
