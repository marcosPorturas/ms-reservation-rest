package com.pe.web.reservation.app.builder;

import java.time.LocalDateTime;

import com.pe.web.reservation.app.dto.request.ReservationRequest;
import com.pe.web.reservation.app.dto.response.InfoClient;
import com.pe.web.reservation.app.dto.response.InfoEmployee;
import com.pe.web.reservation.app.dto.response.InfoFunction;
import com.pe.web.reservation.app.dto.response.ReservationResponse;
import com.pe.web.reservation.app.dto.response.client.ClientResponse;
import com.pe.web.reservation.app.dto.response.employee.EmployeeResponse;
import com.pe.web.reservation.app.dto.response.function.FunctionResponse;
import com.pe.web.reservation.app.entity.Reservation;
import com.pe.web.reservation.app.entity.StatusReservation;
import com.pe.web.reservation.app.util.Constants;
import com.pe.web.reservation.app.util.Utilitario;


public class ConvertBuilderReservation {

	
	public ReservationResponse convertToReservationResponse(Reservation reservation,ClientResponse clientResponse,
			EmployeeResponse employeeResponse,FunctionResponse functionResponse) {
		return ReservationResponse.builder()
				.codReservation(reservation.getCodReservation())
				.reservationDate(Utilitario.convertToStringDate(reservation.getReservationDate()))
				.statusReservation(reservation.getStatusReservation().getDescription())
				.infoClient(convertToInfoClient(clientResponse))
				.infoEmployee(convertToInfoEmployee(employeeResponse))
				.infoFunction(convertToInfoFunction(functionResponse))
				.build();
	}
	
	public Reservation convertToReservationEntity(ReservationRequest reservationRequest) {
		return Reservation.builder()
				.codClient(reservationRequest.getCodClient())
				.codEmployee(reservationRequest.getCodEmployee())
				.enabled(Constants.ENABLED)
				.creationDate(LocalDateTime.now())
				.reservationDate(LocalDateTime.now())
				.codFunction(reservationRequest.getCodFunction())
				.statusReservation(StatusReservation.builder()
						.codStatusReservation(Constants.COD_STATUS_RESERVATION_RESERVADO)
						.build())
				.build();
	}
	
	public InfoClient convertToInfoClient(ClientResponse clientResponse) {
		return InfoClient.builder()
				.codClient(clientResponse.getCodClient())
				.names(clientResponse.getNames())
				.lastNameFather(clientResponse.getLastNameFather())
				.lastNameMother(clientResponse.getLastNameMother())
				.membershipDate(clientResponse.getMemeberInfo().getMembershipDate())
				.build();
	}
	
	public InfoEmployee convertToInfoEmployee(EmployeeResponse employeeResponse) {
		return InfoEmployee.builder()
				.codEmployee(employeeResponse.getCodEmployee())
				.names(employeeResponse.getNames())
				.lastNameFather(employeeResponse.getLastNameFather())
				.lastNameMother(employeeResponse.getLastNameMother())
				.typeEmployee(employeeResponse.getEmployeeInfo().getTypeEmployee())
				.build();
	}
	
	public InfoFunction convertToInfoFunction(FunctionResponse functionResponse) {
		return InfoFunction.builder()
				.codFunction(functionResponse.getCodFunction())
				.functionDate(functionResponse.getFunctionDate())
				.build();
	}
}
