package com.pe.web.reservation.app.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pe.web.reservation.app.dto.response.function.FunctionResponse;
import com.pe.web.reservation.app.proxy.feign.FunctionFeign;

import io.reactivex.Single;

@Component
public class FunctionProxyImplement implements FunctionProxy{
	
	@Autowired
	FunctionFeign functionFeign;

	@Override
	public Single<FunctionResponse> getFunctionResponse(Integer codFunction) {
		// TODO Auto-generated method stub
		return Single.just(functionFeign.getFunctionResponse(codFunction));
	}

}
