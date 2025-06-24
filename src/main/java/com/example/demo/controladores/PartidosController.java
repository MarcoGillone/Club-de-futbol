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
	
	@GetMapping("/club/{id}/local")
	public ResponseEntity<List<Partidos>> partidosLocal(@PathVariable int id){
		return ResponseEntity.ok(serviciopartidos.buscaarPorClubLocal(id));
	}
	
	@GetMapping("/club/{id}/visitante")
	public ResponseEntity<List<Partidos>> partidosVisitante(@PathVariable int id){
		return ResponseEntity.ok(serviciopartidos.buscaarPorClubVisitante(id));
	}
	
	@GetMapping("/club/{id}/todos")
	public ResponseEntity<List<Partidos>> partidoTodos(@PathVariable int id){
		return ResponseEntity.ok(serviciopartidos.buscaarPorClubTodos(id));
	}
	@PostMapping("/validado")
	public ResponseEntity<Partidos> crearPartidoValidado(@RequestBody Partidos partido) {
	    return ResponseEntity.ok(serviciopartidos.agregarPartidoValidado(partido));
	}
}
