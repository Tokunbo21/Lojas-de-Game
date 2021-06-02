package com.LojadeGame.paratodos.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LojadeGame.paratodos.Model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	public List<Produto>findAllByMidiaContainingIgnoreCase(String midia);
}
