package com.pe.web.function.app.proxy;

import com.pe.web.function.app.dto.response.employee.EmployeeResponse;

import io.reactivex.Single;

public interface EmployeeProxy {

	Single<EmployeeResponse> getEmployeeResponse(Integer codEmployee);	
}
