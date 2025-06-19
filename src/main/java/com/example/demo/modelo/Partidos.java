package com.example.demo.modelo;

import java.sql.Date;

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
	private int NroFecha;
	
	@Column(name = "NroZona")
	private int NroZona;
	
	@Column(name = "Categoria")
	private int categoria;
	
	@ManyToOne
	@JoinColumn(name = "Id_ClubL")
	private Clubes clubL;
	
	@ManyToOne
	@JoinColumn(name = "Id_ClubV")
	private Clubes clubV;
	
	@Column(name = "GolesL", nullable = false)
	private int golesL;
	
	@Column(name = "GolesV", nullable = false)
	private int golesV;
	
	@Column(name = "FechaPartido", nullable = false)
	private Date fechaPartido;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNroFecha() {
		return NroFecha;
	}

	public void setNroFecha(int nroFecha) {
		NroFecha = nroFecha;
	}

	public int getNroZona() {
		return NroZona;
	}

	public void setNroZona(int nroZona) {
		NroZona = nroZona;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public Clubes getClubL() {
		return clubL;
	}

	public void setClubL(Clubes clubL) {
		this.clubL = clubL;
	}

	public Clubes getClubV() {
		return clubV;
	}

	public void setClubV(Clubes clubV) {
		this.clubV = clubV;
	}

	public int getGolesL() {
		return golesL;
	}

	public void setGolesL(int golesL) {
		this.golesL = golesL;
	}

	public int getGolesV() {
		return golesV;
	}

	public void setGolesV(int golesV) {
		this.golesV = golesV;
	}

	public Date getFechaPartido() {
		return fechaPartido;
	}

	public void setFechaPartido(Date fechaPartido) {
		this.fechaPartido = fechaPartido;
	}
	
	
	
	
	
	
	
}
