package com.pe.web.function.app.dto.response;

import java.io.Serializable;

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
public class MovieResponse implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer codMovie;
	
	private String distributionTitle;
	
	private String originTitle;
	
	private String originCountry;
	
	private MovieInfo movieInfo;
	
	private MovieDetail movieDetail;
	
	private String sinopsis;
	
	private Integer collectionMoney;
	
}
