package com.pe.web.function.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.web.function.app.builder.ConvertBuilderFunction;
import com.pe.web.function.app.builder.ConvertBuilderReservation;
import com.pe.web.function.app.dto.request.FunctionRequest;
import com.pe.web.function.app.dto.request.ReservationRequest;
import com.pe.web.function.app.dto.response.FunctionResponse;
import com.pe.web.function.app.dto.response.ReservationResponse;
import com.pe.web.function.app.dto.response.cinema.RoomResponse;
import com.pe.web.function.app.dto.response.client.ClientResponse;
import com.pe.web.function.app.dto.response.employee.EmployeeResponse;
import com.pe.web.function.app.dto.response.movie.MovieResponse;
import com.pe.web.function.app.entity.Function;
import com.pe.web.function.app.entity.Reservation;
import com.pe.web.function.app.proxy.CinemaProxy;
import com.pe.web.function.app.proxy.ClientProxy;
import com.pe.web.function.app.proxy.EmployeeProxy;
import com.pe.web.function.app.proxy.MovieProxy;
import com.pe.web.function.app.repository.FunctionRepository;
import com.pe.web.function.app.repository.ReservationRepository;

import io.reactivex.Single;

@Service
public class FunctionServiceImplement implements FunctionService{

	@Autowired
	FunctionRepository functionRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	EmployeeProxy employeeProxy;
	
	@Autowired
	ClientProxy clientProxy;
	
	@Autowired
	CinemaProxy cinemaProxy;
	
	@Autowired
	MovieProxy movieProxy;
	
	public Function invokeConvertBuilderFunctionEntity(FunctionRequest functionRequest) {
		ConvertBuilderFunction convert = new ConvertBuilderFunction();
		return convert.convertToFunctionEntity(functionRequest);
	}
	
	public FunctionResponse invokeConvertBuilderFunctionResponse(Function function,
			MovieResponse movieResponse,RoomResponse roomResponse) {
		
		ConvertBuilderFunction convert = new ConvertBuilderFunction();		
		return convert.convertToFunctionResponse(function,movieResponse,roomResponse);
	}
	
	public Reservation invokeConvertBuilderReservationEntity(ReservationRequest 
			reservationRequest) {
		ConvertBuilderReservation convert = new ConvertBuilderReservation();
		return convert.convertToReservationEntity(reservationRequest);
	}
	
	public ReservationResponse invokeConvertBuilderReservationResponse(Reservation reservation,
			ClientResponse clientResponse,EmployeeResponse employeeResponse) {
		ConvertBuilderReservation convert = new ConvertBuilderReservation();		
		return convert.convertToReservationResponse(reservation,clientResponse,employeeResponse);
	}
	
	@Override
	public Single<FunctionResponse> getFunctionResponse(Integer codFunction) {
		// TODO Auto-generated method stub	
		
		Function functionEntity = functionRepository.findById(codFunction)
				.orElse(null);
		
		Single<MovieResponse> singleMovie = movieProxy
				.getMovieResponse(functionEntity.getCodMovie());
		
		Single<RoomResponse> singleRoom = cinemaProxy
				.getRoomResponse(functionEntity.getCodRoom());
		
		Single<Function> singleFunction = Single.just(functionEntity);
		
		return Single.zip(singleFunction,singleRoom,singleMovie,(f,r,m)->
		invokeConvertBuilderFunctionResponse(f, m, r));
				
	}

	@Override
	public Single<FunctionResponse> addFunction(FunctionRequest functionRequest) {
		// TODO Auto-generated method stub
		
		Single<Function> singleFunction = Single.just(functionRequest)
				.map(this::invokeConvertBuilderFunctionEntity)
				.map(functionRepository::save);
		
		Single<MovieResponse> singleMovie = movieProxy
				.getMovieResponse(functionRequest.getCodMovie());
		
		Single<RoomResponse> singleRoom = cinemaProxy
				.getRoomResponse(functionRequest.getCodRoom());
		
		return Single.zip(singleFunction,singleRoom,singleMovie,(f,r,m)->
		invokeConvertBuilderFunctionResponse(f, m, r));
				
	}

	@Override
	public Single<ReservationResponse> getReservationResponse(Integer codReservation) {
		// TODO Auto-generated method stub
		
		Reservation reservationEntity = reservationRepository.findById(codReservation)
				.orElse(null);
		
		Single<Reservation> singleReservation = Single.just(reservationEntity);
		
		Single<ClientResponse> singleClient = clientProxy.getClientResponse(
				reservationEntity.getCodClient());
		  
		Single<EmployeeResponse> singleEmployee = employeeProxy.getEmployeeResponse(
				reservationEntity.getCodEmployee());
		
		return Single.zip(singleReservation, singleClient, singleEmployee,
				(r,c,e)->invokeConvertBuilderReservationResponse(r,c,e));
	}

	@Override
	public Single<ReservationResponse> addReservation(ReservationRequest reservationRequest) {
		// TODO Auto-generated method stub
		Single<ClientResponse> singleClientResponse = clientProxy
				.getClientResponse(reservationRequest.getCodClient());
		
		Single<EmployeeResponse> singleEmployeeResponse = employeeProxy
				.getEmployeeResponse(reservationRequest.getCodEmployee());
		
		Single<Reservation> singleReservation = Single.just(reservationRequest)
				.map(this::invokeConvertBuilderReservationEntity)
				.map(reservationRepository::save)
				.map(reservation->reservationRepository.findById(reservation.getCodReservation())
						.orElse(null));
		
		return Single.zip(singleReservation, singleEmployeeResponse,singleClientResponse,
				(r,e,c)->invokeConvertBuilderReservationResponse(r,c,e));
				
	} 

}
