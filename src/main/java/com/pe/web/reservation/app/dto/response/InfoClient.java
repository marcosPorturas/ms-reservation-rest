package com.pe.web.reservation.app.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class InfoClient {
	
	private Integer codClient;
	private String names;
	private String lastNameFather;
	private String lastNameMother;
	private String membershipDate;

}
