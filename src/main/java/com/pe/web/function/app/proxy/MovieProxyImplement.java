package com.pe.web.function.app.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pe.web.function.app.dto.response.MovieResponse;
import com.pe.web.function.app.proxy.feign.MovieFeign;

import io.reactivex.Single;

@Component
public class MovieProxyImplement implements MovieProxy{

	@Autowired
	MovieFeign movieFeign;
	
	@Override
	public Single<MovieResponse> getMovieResponse(Integer codMovie) {
		// TODO Auto-generated method stub
		return Single.just(movieFeign.getMovieResponse(codMovie));
	}

	
}
