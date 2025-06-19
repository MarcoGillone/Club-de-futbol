package com.example.demo.modelo;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "Jugadores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jugadores {
	@Column(name = "Tipodoc", length = 3)
	private String tipoDoc;
	@Id
	@Column(name = "Nrodoc")
	private int nroDoc;
	@Column(name = "Nombre",  length = 30)
	private String nombre;
	@Column(name = "Fecha_Nac")
	private Date fechaNacimiento;
	@Column(name = "Categoria")
	private int categoria;
	@ManyToOne
	@JoinColumn(name = "Id_Club", nullable = false)
	private Clubes club;

	
	
	
	

	
	
	
}
