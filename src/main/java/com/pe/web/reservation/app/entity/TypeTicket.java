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
@Table(name="tbl_type_ticket")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TypeTicket {
	
	@Id
	@Column(name="cod_type_ticket")
	private Integer codTypeTicket;
	
	private String description;
	
	private Double price;

}
