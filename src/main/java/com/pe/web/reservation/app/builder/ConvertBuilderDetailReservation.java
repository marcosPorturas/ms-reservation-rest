package com.pe.web.reservation.app.builder;

import java.time.LocalDateTime;

import com.pe.web.reservation.app.dto.request.SeatRequest;
import com.pe.web.reservation.app.dto.response.DetailReservationResponse;
import com.pe.web.reservation.app.dto.response.ReservationResponse;
import com.pe.web.reservation.app.entity.DetailReservation;
import com.pe.web.reservation.app.entity.TypeTicket;



public class ConvertBuilderDetailReservation {
	
	
	public DetailReservation convertToDetailReservationEntity(ReservationResponse reservationResponse,
			SeatRequest seatRequest) {
		
		return DetailReservation.builder()
				.codReservation(reservationResponse.getCodReservation())
				.creationDate(LocalDateTime.now())
				.codSeat(seatRequest.getCodSeat())
				.typeTicket(TypeTicket.builder()
						.codTypeTicket(seatRequest.getCodTypeTicket())
						.build())
				.build();
		
	}
	
	public DetailReservationResponse convertToDetailReservationResponse(DetailReservation detailReservation) {
		return DetailReservationResponse.builder()
				.codSeat(detailReservation.getCodSeat())
				.codTypeTicket(detailReservation.getTypeTicket().getCodTypeTicket())
				.description(detailReservation.getTypeTicket().getDescription())
				.price(detailReservation.getTypeTicket().getPrice())
				.build();
	}

}
