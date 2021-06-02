package com.LojadeGame.paratodos.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.LojadeGame.paratodos.Model.Categoria;


@Repository     //o long vem do tipo do id do model, se la fosse int aqui tem que ser int
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	
	public List<Categoria> findAllByDescricaoContainingIgnoreCase (String descricao);
	//O containing vai trazer tudo que tem dentro da variavel nesse caso 'descricao'
	
}
