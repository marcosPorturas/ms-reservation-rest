package com.pe.web.reservation.app.dto.response.function;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InfoRoom {
	
	private Integer codRoom;
	
	private Integer numRoom;

}
