package com.ProjetoTarefas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoTarefas.entities.Tarefa;
import com.ProjetoTarefas.repository.TarefaRepository;

@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;

    //construtor que recebe a dependencia
    @Autowired
    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }
    
    public List<Tarefa> buscaTodosTarefas(){
    	return tarefaRepository.findAll();
    }
    
    public Tarefa buscaTarefaId(Long id) {
        Optional <Tarefa> tarefa = tarefaRepository.findById(id);
        return tarefa.orElse(null);
    }
    //metodo salvar os produtos
    public Tarefa SalvaTarefa(Tarefa tarefa) {
    	return tarefaRepository.save(tarefa);
    }
    public Tarefa alterarTarefa(Long id, Tarefa alterarTaref) {
    	Optional <Tarefa> existeTarefa = tarefaRepository.findById(id);
    	
    	if (existeTarefa.isPresent()) {
    		alterarTaref.setId(id);
    		return tarefaRepository.save(alterarTaref);
    	}
    	return null;
    }
    public boolean apagarTarefa(Long id) {
    	Optional <Tarefa> existeTarefa = tarefaRepository.findById(id);
    	if (existeTarefa.isPresent()) {
    		tarefaRepository.deleteById(id);
    		return true;
    	}
    	return false;
    }
}
