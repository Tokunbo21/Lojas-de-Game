package com.LojadeGame.paratodos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LojadeGame.paratodos.Model.Produto;
import com.LojadeGame.paratodos.Repository.ProdutoRepository;

@RestController
@RequestMapping ("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoControlle {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> GetById(@PathVariable long id) {
		return repository.findById(id).map(respo -> ResponseEntity.ok(respo)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/midia/{midia}")
	public ResponseEntity<List<Produto>> GetByMidia(@PathVariable String midia) {
		return ResponseEntity.ok(repository.findAllByMidiaContainingIgnoreCase(midia));
	}
	 @PostMapping 
	   public ResponseEntity<Produto>post(@RequestBody Produto produto) {
		   return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	   }
	   @PutMapping 
	   public ResponseEntity<Produto>put(@RequestBody Produto produto) {
		   return ResponseEntity.ok(repository.save(produto));
	   }
	    @DeleteMapping ("/{id}")
	    public void delete(@PathVariable long id) {
	    	repository.deleteById(id);
	    }
   
}
