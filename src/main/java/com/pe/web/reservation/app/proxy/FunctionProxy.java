package com.pe.web.reservation.app.proxy;

import com.pe.web.reservation.app.dto.response.function.FunctionResponse;

import io.reactivex.Single;

public interface FunctionProxy {
	
	Single<FunctionResponse> getFunctionResponse(Integer codFunction);

}
