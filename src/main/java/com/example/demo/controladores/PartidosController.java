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

import com.example.demo.modelo.Partidos;
import com.example.demo.servicio.ServicioPartidos;
@RestController
@RequestMapping("app/partidos")
public class PartidosController {
	private final ServicioPartidos serviciopartidos;
	
	public PartidosController(ServicioPartidos serviciopartidos){
		this.serviciopartidos = serviciopartidos;
	}
	@GetMapping
	public ResponseEntity<List<Partidos>> findAll(){
		return ResponseEntity.ok(serviciopartidos.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Partidos> findById(@PathVariable int id){
		return ResponseEntity.ok(serviciopartidos.findById(id));
	}
	@PostMapping
	public ResponseEntity<Partidos> save (@RequestBody Partidos partido){
		return ResponseEntity.ok(serviciopartidos.save(partido));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete (@PathVariable int id){
		serviciopartidos.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
