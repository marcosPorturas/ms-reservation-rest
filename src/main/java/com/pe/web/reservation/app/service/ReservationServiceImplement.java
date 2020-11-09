package com.pe.web.reservation.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.web.reservation.app.builder.ConvertBuilderDetailReservation;
import com.pe.web.reservation.app.builder.ConvertBuilderReservation;
import com.pe.web.reservation.app.dto.request.ReservationRequest;
import com.pe.web.reservation.app.dto.request.SeatRequest;
import com.pe.web.reservation.app.dto.response.DetailReservationResponse;
import com.pe.web.reservation.app.dto.response.ReservationResponse;
import com.pe.web.reservation.app.dto.response.client.ClientResponse;
import com.pe.web.reservation.app.dto.response.employee.EmployeeResponse;
import com.pe.web.reservation.app.dto.response.function.FunctionResponse;
import com.pe.web.reservation.app.entity.DetailReservation;
import com.pe.web.reservation.app.entity.Reservation;
import com.pe.web.reservation.app.proxy.CinemaProxy;
import com.pe.web.reservation.app.proxy.ClientProxy;
import com.pe.web.reservation.app.proxy.EmployeeProxy;
import com.pe.web.reservation.app.proxy.FunctionProxy;
import com.pe.web.reservation.app.repository.DetailReservationRespository;
import com.pe.web.reservation.app.repository.ReservationRepository;

import io.reactivex.Single;

@Service
public class ReservationServiceImplement implements ReservationService{
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	DetailReservationRespository detailReservationRespository;
	
	@Autowired
	EmployeeProxy employeeProxy;
	
	@Autowired
	ClientProxy clientProxy;
	
	@Autowired
	CinemaProxy cinemaProxy;
	
	@Autowired
	FunctionProxy functionProxy;
	
	
	public Reservation invokeConvertBuilderReservationEntity(ReservationRequest 
			reservationRequest) {
		ConvertBuilderReservation convert = new ConvertBuilderReservation();
		return convert.convertToReservationEntity(reservationRequest);
	}
	
	public ReservationResponse invokeConvertBuilderReservationResponse(Reservation reservation,
		ClientResponse clientResponse,EmployeeResponse employeeResponse,FunctionResponse functionResponse) {
		ConvertBuilderReservation convert = new ConvertBuilderReservation();		
		return convert.convertToReservationResponse(reservation,clientResponse,employeeResponse,functionResponse);
	}
	
	public DetailReservation invokeConvertBuilderDetailReservationEntity(ReservationResponse reservationResponse,
			SeatRequest seatRequest) {
		ConvertBuilderDetailReservation convert = new ConvertBuilderDetailReservation();
		return convert.convertToDetailReservationEntity(reservationResponse, seatRequest);
	}
	
	public DetailReservationResponse invokeConvertBuilderDetailReservationResponse(DetailReservation detailReservation) {
		ConvertBuilderDetailReservation convert = new ConvertBuilderDetailReservation();
		return convert.convertToDetailReservationResponse(detailReservation);
	}

	@Override
	public Single<ReservationResponse> getReservationResponse(Integer codReservation) {
		// TODO Auto-generated method stub
		
		Reservation reservationEntity = reservationRepository.findById(codReservation)
				.orElse(null);
		
		Single<Reservation> singleReservation = Single.just(reservationEntity);
		
		Single<FunctionResponse> singleFunction = functionProxy.getFunctionResponse(
				reservationEntity.getCodFunction());
		
		Single<ClientResponse> singleClient = clientProxy.getClientResponse(
				reservationEntity.getCodClient());
		  
		Single<EmployeeResponse> singleEmployee = employeeProxy.getEmployeeResponse(
				reservationEntity.getCodEmployee());
		
		return Single.zip(singleReservation, singleClient, singleEmployee,singleFunction,
				(r,c,e,f)->invokeConvertBuilderReservationResponse(r,c,e,f))
				.doOnSuccess(response->response.setListDetailReservaion(getListDetailReservationResponse(response)));
	}

	@Override
	public Single<ReservationResponse> addReservation(ReservationRequest reservationRequest) {
		// TODO Auto-generated method stub
		Single<FunctionResponse> singleFunction = functionProxy.getFunctionResponse(
				reservationRequest.getCodFunction());
		
		Single<ClientResponse> singleClient = clientProxy
				.getClientResponse(reservationRequest.getCodClient());
		
		Single<EmployeeResponse> singleEmployee = employeeProxy
				.getEmployeeResponse(reservationRequest.getCodEmployee());
		
		Single<Reservation> singleReservation = Single.just(reservationRequest)
				.map(this::invokeConvertBuilderReservationEntity)
				.map(reservationRepository::save)
				.map(reservation->reservationRepository.findById(reservation.getCodReservation())
						.orElse(null));
		
		return Single.zip(singleReservation, singleEmployee,singleClient,singleFunction,
				(r,e,c,f)->invokeConvertBuilderReservationResponse(r,c,e,f))
				.doOnSuccess(response->cinemaProxy.updateSeat(reservationRequest.getListSeat()))
				.doOnSuccess(response->addDetailReservation(response,reservationRequest))
				.doAfterSuccess(response->
				response.setListDetailReservaion(getListDetailReservationResponse(response))
				);
	}
	
	private void addDetailReservation(ReservationResponse response,ReservationRequest reservationRequest) {
		reservationRequest.getListSeat()
		.forEach(seatRequest->{
			DetailReservation detailReservation = invokeConvertBuilderDetailReservationEntity
					(response, seatRequest);
			detailReservationRespository.save(detailReservation);
		});
	}
	
	private List<DetailReservationResponse> getListDetailReservationResponse(ReservationResponse response){
		List<DetailReservation> listDetailReservation = detailReservationRespository
				.findByCodReservation(response.getCodReservation());
		List<DetailReservationResponse> listDetailReservationResponse = listDetailReservation
				.stream()
				.map(detailReservation->invokeConvertBuilderDetailReservationResponse(detailReservation))
				.collect(Collectors.toList());
		return listDetailReservationResponse;
	}

}
