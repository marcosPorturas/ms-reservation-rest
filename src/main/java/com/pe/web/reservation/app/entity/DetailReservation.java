package com.pe.web.reservation.app.entity;

import java.time.LocalDateTime;

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
@Table(name="tbl_detail_reservation")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetailReservation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codDetailReservation;
	
	private LocalDateTime creationDate;
	
	private Integer codSeat;
	
	private Integer codReservation;
	
	@ManyToOne
	@JoinColumn(name="cod_type_ticket",referencedColumnName="cod_type_ticket")
	private TypeTicket typeTicket; 
	
}
