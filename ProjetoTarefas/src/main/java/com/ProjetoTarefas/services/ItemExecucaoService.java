package com.ProjetoTarefas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoTarefas.entities.ItemExecucao;
import com.ProjetoTarefas.repository.ItemExecucaoRepository;

@Service
public class ItemExecucaoService {
    private final ItemExecucaoRepository itemExecucaoRepository;

    //construtor que recebe a dependencia
    @Autowired
    public ItemExecucaoService(ItemExecucaoRepository itemExecucaoRepository) {
        this.itemExecucaoRepository = itemExecucaoRepository;
    }
    
    public List<ItemExecucao> buscaTodositemExecucaos(){
    	return itemExecucaoRepository.findAll();
    }
    
    public ItemExecucao buscaTarefaId(Long id) {
        Optional <ItemExecucao> itemExecucao = itemExecucaoRepository.findById(id);
        return itemExecucao.orElse(null);
    }
    //metodo salvar os produtos
    public ItemExecucao SalvaItemExecucao(ItemExecucao itemExecucao) {
    	return itemExecucaoRepository.save(itemExecucao);
    }
    public ItemExecucao alteraritemExecucao(Long id, ItemExecucao alteraritemExecu) {
    	Optional <ItemExecucao> existeItemExecucao = itemExecucaoRepository.findById(id);
    	
    	if (existeItemExecucao.isPresent()) {
    		alteraritemExecu.setId(id);
    		return itemExecucaoRepository.save(alteraritemExecu);
    	}
    	return null;
    }
    public boolean apagarItemExecucao(Long id) {
    	Optional <ItemExecucao> existeItemExecucao = itemExecucaoRepository.findById(id);
    	if (existeItemExecucao.isPresent()) {
    		itemExecucaoRepository.deleteById(id);
    		return true;
    	}
    	return false;
    }

	public ItemExecucao buscaItemExecucaoId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}

