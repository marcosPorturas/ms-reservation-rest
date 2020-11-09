package com.pe.web.reservation.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pe.web.reservation.app.entity.Reservation;


@Repository
@Transactional
public interface ReservationRepository extends JpaRepository<Reservation,Integer>{

}
