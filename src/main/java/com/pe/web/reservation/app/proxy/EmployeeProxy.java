package com.pe.web.reservation.app.proxy;


import com.pe.web.reservation.app.dto.response.employee.EmployeeResponse;

import io.reactivex.Single;

public interface EmployeeProxy {

	Single<EmployeeResponse> getEmployeeResponse(Integer codEmployee);	
}
