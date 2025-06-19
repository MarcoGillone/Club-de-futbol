package com.example.demo.controladores;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Jugadores;
import com.example.demo.servicio.ServicioJugadores;
@RestController
@RequestMapping("app/jugadores")
public class JugadoresController {
	private final ServicioJugadores serviciojugadores;
	
	public JugadoresController(ServicioJugadores serviciojugadores) {
		this.serviciojugadores = serviciojugadores;
	}
	
	@GetMapping
	public ResponseEntity<List<Jugadores>> findAll(){
		return ResponseEntity.ok(serviciojugadores.findAll());
	}
	@GetMapping("/{nroDoc}")
	public ResponseEntity<Jugadores> findById(@PathVariable int nroDoc){
		return ResponseEntity.ok(serviciojugadores.findById(nroDoc));
	}
	@PostMapping
	public ResponseEntity<Jugadores> save(@RequestBody Jugadores jugador){
		return ResponseEntity.ok(serviciojugadores.save(jugador));
	}
	@DeleteMapping("/{nroDoc}")
	public ResponseEntity<Void> delete(@PathVariable int nroDoc){
		serviciojugadores.deleteById(nroDoc);
		return ResponseEntity.noContent().build();
	}
}
