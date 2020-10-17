package com.pe.web.function.app.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pe.web.function.app.dto.response.employee.EmployeeResponse;
import com.pe.web.function.app.proxy.feign.EmployeeFeign;

import io.reactivex.Single;

@Component
public class EmployeeProxyImplement implements EmployeeProxy{

	@Autowired
	EmployeeFeign employeeFeign;
	
	@Override
	public Single<EmployeeResponse> getEmployeeResponse(Integer codEmployee) {
		// TODO Auto-generated method stub
		return Single.just(employeeFeign.getEmployeeResponse(codEmployee));
	}

	
}
