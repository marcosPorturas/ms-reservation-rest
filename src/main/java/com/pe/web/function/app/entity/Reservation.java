package com.pe.web.function.app.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbl_reservation")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_reservation")
	private Integer codReservation;
	
	private Integer codClient;
	
	private Integer codEmployee;
	
	private Boolean enabled;
	
	private LocalDateTime creationDate;
	
	private LocalDateTime updateDate;
	
	private LocalDateTime reservationDate;
	
	@ManyToOne
	@JoinColumn(name="cod_function",referencedColumnName="cod_function")
	private Function function;
	
	@ManyToOne
	@JoinColumn(name="cod_status_reservation",referencedColumnName="cod_status_reservation")
	private StatusReservation statusReservation;
	
}
