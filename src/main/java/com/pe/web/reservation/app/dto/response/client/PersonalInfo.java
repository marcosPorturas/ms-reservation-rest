package com.pe.web.reservation.app.dto.response.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonalInfo {
	
	private String telephone;
	
	private String direction;
	
	private String  birthDate;
	
	private String relathionship;
	
	private String typeDocument;
	
	private String numberDocument;

}
