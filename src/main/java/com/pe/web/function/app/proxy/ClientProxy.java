package com.pe.web.function.app.proxy;

import com.pe.web.function.app.dto.response.client.ClientResponse;

import io.reactivex.Single;

public interface ClientProxy {

	Single<ClientResponse> getClientResponse(Integer codClient);
	
}
