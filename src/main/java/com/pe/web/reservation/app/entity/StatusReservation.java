package com.pe.web.reservation.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbl_status_reservation")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatusReservation {

	@Id
	@Column(name="cod_status_reservation")
	private Integer codStatusReservation;
	
	private String description;
	
}
