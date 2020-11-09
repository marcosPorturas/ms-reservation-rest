package com.pe.web.reservation.app.dto.response.cinema;

import java.io.Serializable;
import java.util.List;

import com.pe.web.reservation.app.dto.response.InfoCinema;

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
public class RoomResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer codRoom;
	
	private InfoCinema infoCinema;
	
	private String creationDate;
	
	private Integer numRoom;
	
	private Integer numRow;
	
	private Integer numSeat;
	
	private List<SeatResponse> listSeat;
	
	
}
