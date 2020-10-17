package com.pe.web.function.app.dto.response.employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeInfo {

	private String creationDate;
	private String typeEmployee;
	private String userValue;
	private String passwordValue;
	
}
