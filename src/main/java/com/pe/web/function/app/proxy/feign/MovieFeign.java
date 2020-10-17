package com.pe.web.function.app.proxy.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pe.web.function.app.dto.response.MovieResponse;

@FeignClient(name="movie", url="${url.movie.host}")
public interface MovieFeign {

	@GetMapping("/{codMovie}")
	MovieResponse getMovieResponse(@PathVariable("codMovie")Integer codMovie);
	
}
