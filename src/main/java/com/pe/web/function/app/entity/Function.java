package com.pe.web.function.app.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbl_function")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Function {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_function")
	private Integer codFunction;
	
	private LocalDateTime creationDate;
	
	private LocalDateTime updateDate;
	
	private Boolean enabled;
	
	private Integer codRoom;
	
	private Integer codMovie;
	
	private LocalDateTime functionDate;
	
	
}
