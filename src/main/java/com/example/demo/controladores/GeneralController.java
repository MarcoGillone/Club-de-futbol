package com.example.demo.controladores;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.General;
import com.example.demo.servicio.ServicioGeneral;

@RestController
@RequestMapping("/app/general")
public class GeneralController {
	private final ServicioGeneral serviciogeneral;
	
	public GeneralController(ServicioGeneral serviciogeneral) {
		this.serviciogeneral = serviciogeneral;
	}
	@GetMapping
	public ResponseEntity<List<General>> tablaGeneral(){
		return ResponseEntity.ok(serviciogeneral.tablaGeneral());
	}

}
