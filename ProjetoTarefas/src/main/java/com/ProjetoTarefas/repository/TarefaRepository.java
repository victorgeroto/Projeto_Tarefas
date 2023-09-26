package com.ProjetoTarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetoTarefas.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
	
	// Nenhuma implementação é necessária. Spring Data JPA cuidará disso.
}

