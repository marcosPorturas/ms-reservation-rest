package com.pe.web.function.app.service;

import com.pe.web.function.app.dto.request.FunctionRequest;
import com.pe.web.function.app.dto.response.FunctionResponse;
import com.pe.web.function.app.dto.response.ReservationResponse;

import io.reactivex.Single;

public interface FunctionService {

	Single<FunctionResponse> getFunctionResponse(Integer codFunction);
	
	Single<FunctionResponse> addFunction(FunctionRequest functionRequest);
	
	Single<ReservationResponse> getReservationResponse(Integer codReservation);
}
