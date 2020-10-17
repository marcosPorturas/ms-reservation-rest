package com.pe.web.function.app.proxy.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pe.web.function.app.dto.response.client.ClientResponse;

@FeignClient(name="client", url="${url.client.host}")
public interface ClientFeign {

	@GetMapping("/{codClient}")
	ClientResponse getClientResponse(@PathVariable("codClient")Integer codClient);
}
