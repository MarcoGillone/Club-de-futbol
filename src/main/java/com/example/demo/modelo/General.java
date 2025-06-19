package com.example.demo.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class General {
	private Clubes club;
	private String nombre;
	private int cantidad;
	private int ganados;
	private int empatados;
	private int perdidos;
	private int golesF;
	private int golesC;
	private int diferencia;
	private int puntos;
	private float promedio;
	

	
	
	
}
