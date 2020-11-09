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
public class MemberInfo {
	
	private String creationDate;
	
	private String membershipDate;
	
	private String userValue;
	
	private String passwordValue;

}
