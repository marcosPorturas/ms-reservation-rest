package com.pe.web.reservation.app.proxy;

import com.pe.web.reservation.app.dto.response.client.ClientResponse;

import io.reactivex.Single;

public interface ClientProxy {

	Single<ClientResponse> getClientResponse(Integer codClient);
	
}
