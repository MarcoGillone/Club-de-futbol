package com.example.demo.modelo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "Partidos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Partidos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_Partido", nullable = false)
	private int id;
	
	@Column(name = "NroFecha")
	private int nroFecha;
	
	@Column(name = "NroZona")
	private int nroZona;
	
	@Column(name = "Categoria")
	private int categoria;
	
	@ManyToOne
	@JoinColumn(name = "Id_ClubL")
	private Clubes clubL;
	
	@ManyToOne
	@JoinColumn(name = "Id_ClubV")
	private Clubes clubV;
	
	@Column(name = "GolesL")
	private int golesL;
	
	@Column(name = "GolesV")
	private int golesV;
	
	@Column(name = "FechaPartido", nullable = true)
	private LocalDate  fechaPartido;

	
	
	
	
	
}
