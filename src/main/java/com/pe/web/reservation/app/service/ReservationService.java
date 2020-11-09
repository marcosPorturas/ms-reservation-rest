package com.pe.web.reservation.app.service;

import com.pe.web.reservation.app.dto.request.ReservationRequest;
import com.pe.web.reservation.app.dto.response.ReservationResponse;

import io.reactivex.Single;

public interface ReservationService {
	
	Single<ReservationResponse> getReservationResponse(Integer codReservation);
	
	Single<ReservationResponse> addReservation(ReservationRequest reservationRequest);

}
