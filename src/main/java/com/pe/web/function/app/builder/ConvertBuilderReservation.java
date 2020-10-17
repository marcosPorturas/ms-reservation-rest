package com.pe.web.function.app.builder;

import com.pe.web.function.app.dto.response.InfoClient;
import com.pe.web.function.app.dto.response.InfoEmployee;
import com.pe.web.function.app.dto.response.InfoFunction;
import com.pe.web.function.app.dto.response.ReservationResponse;
import com.pe.web.function.app.dto.response.client.ClientResponse;
import com.pe.web.function.app.dto.response.employee.EmployeeResponse;
import com.pe.web.function.app.entity.Function;
import com.pe.web.function.app.entity.Reservation;
import com.pe.web.function.app.util.Utilitario;

public class ConvertBuilderReservation {

	
	public ReservationResponse convertToReservationResponse(Reservation reservation,ClientResponse clientResponse,
			EmployeeResponse employeeResponse) {
		return ReservationResponse.builder()
				.codReservation(reservation.getCodReservation())
				.reservationDate(Utilitario.convertToStringDate(reservation.getReservationDate()))
				.statusReservation(reservation.getStatusReservation().getDescription())
				.infoClient(convertToInfoClient(clientResponse))
				.infoEmployee(convertToInfoEmployee(employeeResponse))
				.infoFunction(convertToInfoFunction(reservation.getFunction()))
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
	
	public InfoFunction convertToInfoFunction(Function function) {
		return InfoFunction.builder()
				.codFunction(function.getCodFunction())
				.functionDate(Utilitario.
						convertToStringDate(function.getFunctionDate()))
				.build();
	}
}
