package com.pe.web.function.app.proxy.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pe.web.function.app.dto.response.employee.EmployeeResponse;

@FeignClient(name="employee", url="${url.employee.host}")
public interface EmployeeFeign {

	@GetMapping("/{codEmployee}")
	EmployeeResponse getEmployeeResponse(@PathVariable("codEmployee")Integer codEmployee);
	
}
