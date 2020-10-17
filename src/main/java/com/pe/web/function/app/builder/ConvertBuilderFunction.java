package com.pe.web.function.app.builder;

import java.time.LocalDateTime;

import com.pe.web.function.app.dto.request.FunctionRequest;
import com.pe.web.function.app.dto.response.FunctionResponse;
import com.pe.web.function.app.dto.response.InfoCinema;
import com.pe.web.function.app.dto.response.InfoMovie;
import com.pe.web.function.app.dto.response.InfoRoom;
import com.pe.web.function.app.dto.response.MovieResponse;
import com.pe.web.function.app.dto.response.RoomResponse;
import com.pe.web.function.app.entity.Function;
import com.pe.web.function.app.util.Constants;
import com.pe.web.function.app.util.Utilitario;


public class ConvertBuilderFunction {
	

	public FunctionResponse convertToFunctionResponse(Function function,MovieResponse movieResponse,
			RoomResponse roomResponse) {
		
		
		return FunctionResponse.builder()
				.codFunction(function.getCodFunction())
				.functionDate(Utilitario.convertToStringDate(function.getFunctionDate()))
				.infoMovie(convertToInfoMovie(movieResponse))
				.infoCinema(convertToInfoCinema(roomResponse))
				.infoRoom(convertToInfoRoom(roomResponse))
				.build();
	}
	
	public InfoMovie convertToInfoMovie(MovieResponse movieResponse) {
		return InfoMovie.builder()
				.codMovie(movieResponse.getCodMovie())
				.originTitle(movieResponse.getOriginTitle())
				.distributionTitle(movieResponse.getDistributionTitle())
				.releaseDate(movieResponse.getMovieInfo().getReleaseDate())
				.build();
	}
	
	public InfoCinema convertToInfoCinema(RoomResponse roomResponse) {
		return InfoCinema.builder()
				.codCinema(roomResponse.getInfoCinema().getCodCinema())
				.name(roomResponse.getInfoCinema().getName())
				.build();
	}
	
	public InfoRoom convertToInfoRoom (RoomResponse roomResponse) {
		return InfoRoom.builder()
				.codRoom(roomResponse.getCodRoom())
				.numRoom(roomResponse.getNumRoom())
				.build();
	}

	public Function convertToFunctionEntity(FunctionRequest functionRequest) {
		// TODO Auto-generated method stub
		return Function.builder()
				.codMovie(functionRequest.getCodMovie())
				.codRoom(functionRequest.getCodRoom())
				.creationDate(LocalDateTime.now())
				.functionDate(functionRequest.getFunctionDate())
				.enabled(Constants.ENABLED)
				.build();
	}
}
