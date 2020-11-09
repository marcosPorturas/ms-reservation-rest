package com.pe.web.reservation.app.proxy.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pe.web.reservation.app.dto.response.function.FunctionResponse;

@FeignClient(name="function", url="${url.function.host}")
public interface FunctionFeign {

	@GetMapping("/{codFunction}")
	FunctionResponse getFunctionResponse(@PathVariable("codFunction")Integer codFunction);
	
}
