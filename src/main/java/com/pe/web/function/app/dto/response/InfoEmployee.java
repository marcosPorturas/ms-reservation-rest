package com.pe.web.function.app.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class InfoEmployee {

	private Integer codEmployee;
	private String names;
	private String lastNameFather;
	private String lastNameMother;
	private String typeEmployee;
	
}
