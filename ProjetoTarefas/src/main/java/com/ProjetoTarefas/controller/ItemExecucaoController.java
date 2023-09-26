package com.ProjetoTarefas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetoTarefas.entities.ItemExecucao;
import com.ProjetoTarefas.services.ItemExecucaoService;

@RestController
@RequestMapping("/ItemExecucao")

public class ItemExecucaoController {
    private final ItemExecucaoService ItemExecucaoService;

    @Autowired
    public ItemExecucaoController(ItemExecucaoService itemExecucaoService) {
        this.ItemExecucaoService = itemExecucaoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemExecucao> buscaItemExecucaoControlId(@PathVariable Long id){
    	ItemExecucao itemExecucao = ItemExecucaoService.buscaItemExecucaoId(id);
    	if (itemExecucao != null) {
    		return ResponseEntity.ok(itemExecucao);
    	}
    	else {
    		return ResponseEntity.notFound().build();
    	}
    }
    @GetMapping("/")
    public ResponseEntity<List<ItemExecucao>> buscaTodosItemExecucaosControl(){
    	List<ItemExecucao> ItemExecucaos = ItemExecucaoService.buscaTodositemExecucaos();
    	
    	return ResponseEntity.ok(ItemExecucaos);
    }
    @PostMapping("/")
    public ResponseEntity<ItemExecucao> salvaItemExecucaosControl(@RequestBody ItemExecucao itemExecucao){
    	ItemExecucao salvaItemExecucao = ItemExecucaoService.SalvaItemExecucao(itemExecucao);
    	return ResponseEntity.status(HttpStatus.CREATED).body(salvaItemExecucao);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ItemExecucao> alteraItemExecucaoControl(@PathVariable Long id, @RequestBody ItemExecucao itemExecucao){
    	ItemExecucao alteraItemExecucao = ItemExecucaoService.alteraritemExecucao(id, itemExecucao);
    	if(itemExecucao != null) {
    		return ResponseEntity.ok(itemExecucao);
    	}
    	else {
    		return ResponseEntity.notFound().build();   	
    		}
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> apagaItemExecucaoControl(@PathVariable Long id){
    	boolean apagar = ItemExecucaoService.apagarItemExecucao(id);
    	if (apagar) {
    		return ResponseEntity.ok().body("O ItemExecucao foi excluido com sucesso");
    	}
    	else {
    		return ResponseEntity.notFound().build();
    	}
    }
    
    
}

