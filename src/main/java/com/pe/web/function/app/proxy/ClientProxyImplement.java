package com.pe.web.function.app.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pe.web.function.app.dto.response.client.ClientResponse;
import com.pe.web.function.app.proxy.feign.ClientFeign;

import io.reactivex.Single;

@Component
public class ClientProxyImplement implements ClientProxy{

	@Autowired
	ClientFeign clientFeign;
	
	@Override
	public Single<ClientResponse> getClientResponse(Integer codClient) {
		// TODO Auto-generated method stub
		return Single.just(clientFeign.getClientResponse(codClient));
	}

}
