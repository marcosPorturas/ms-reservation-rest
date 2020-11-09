package com.pe.web.reservation.app.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pe.web.reservation.app.entity.DetailReservation;

@Repository
@Transactional
public interface DetailReservationRespository extends JpaRepository<DetailReservation, Integer>{

	
	List<DetailReservation> findByCodReservation(Integer codReservation);
	
}
