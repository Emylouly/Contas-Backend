package br.edu.ifba.demo.backend.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifba.demo.backend.api.model.CategoriaModel;
import br.edu.ifba.demo.backend.api.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaController (CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping
	public String teste() {
		return "Testando Rota categoria";
	}
	
	@GetMapping("/listall")
	public List<CategoriaModel> listall() {
		var categoria = categoriaRepository.findAll();
		return categoria;
	}

    @GetMapping("buscarporid/{id}")
    public CategoriaModel findById(@PathVariable("id") Long id) {
		Optional<CategoriaModel> categoria = categoriaRepository.findById(id);
		if ( categoria.isPresent() )
			return categoria.get();
        return null;
    }

    @GetMapping("buscarpordescricao/{descricao}")
    public List<CategoriaModel> findByCategoriadescricao(@PathVariable("descricao") String descricao) {
        List<CategoriaModel> categoria = categoriaRepository.findByCategoriadescricao(descricao);
        if (categoria.isEmpty()) {
            return null;
        }
        return categoria;
    }

    @GetMapping("buscarportipo/{tipo}")
    public List<CategoriaModel> findByTiponumero(@PathVariable("tipo") String tipo) {
        List<CategoriaModel> categoria = categoriaRepository.findByTipo(tipo);
        if (categoria.isEmpty()) {
            return null;
        }
        return categoria;
    }

    @PostMapping("/salvar")
	  public ResponseEntity<CategoriaModel> addCategoria(@RequestBody CategoriaModel categoria) {
        CategoriaModel savedCategoria = categoriaRepository.save(categoria);
		  return new ResponseEntity<>(savedCategoria, HttpStatus.CREATED);
    }

}
