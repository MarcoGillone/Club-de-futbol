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

import com.example.demo.modelo.Clubes;
import com.example.demo.servicio.ServicioClubes;
@RestController
@RequestMapping("/app/clubes")
public class ClubesController {
	private final ServicioClubes servicioclubes;
	
	public ClubesController(ServicioClubes servicioclubes) {
		this.servicioclubes = servicioclubes;
	} 
	
	@GetMapping
	public ResponseEntity<List<Clubes>> findAll(){
		return ResponseEntity.ok(servicioclubes.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Clubes> findById(@PathVariable int id){
		return ResponseEntity.ok(servicioclubes.findById(id));
	}
	@PostMapping
	public ResponseEntity<Clubes> save(@RequestBody Clubes club){
		return ResponseEntity.ok(servicioclubes.save(club));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id){
		servicioclubes.deleteById(id);
		return ResponseEntity.noContent().build();
		
	}
}
