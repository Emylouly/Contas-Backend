package br.edu.ifba.demo.backend.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifba.demo.backend.api.model.TelefoneModel;
import br.edu.ifba.demo.backend.api.repository.TelefoneRepository;

@RestController
@RequestMapping("/telefone")
public class TelefoneController {

    @Autowired
    private TelefoneRepository telefoneRepository;

    public TelefoneController (TelefoneRepository telefoneRepository){
        this.telefoneRepository = telefoneRepository;
    }

    @GetMapping
	public String teste() {
		return "Testando Rota telefone";
	}
	
	@GetMapping("/listall")
	public List<TelefoneModel> listall() {
		var telefone = telefoneRepository.findAll();
		return telefone;
	}

    @GetMapping("buscarporid/{id}")
    public TelefoneModel findById(@PathVariable("id") Long id) {
		Optional<TelefoneModel> telefone = telefoneRepository.findById(id);
		if ( telefone.isPresent() )
			return telefone.get();
        return null;
    }

	@GetMapping("buscarpornumero/{numero}")
    public TelefoneModel findByTelefonenumero(@PathVariable("numero") String numero) {
		Optional<TelefoneModel> telefone = telefoneRepository.findByTelefonenumero(numero);
		if ( telefone.isPresent() )
			return telefone.get();
        return null;
    }

	@GetMapping("buscarportiponumero/{tiponumero}")
    public List<TelefoneModel> findByTiponumero(@PathVariable("tiponumero") String tiponumero) {
        List<TelefoneModel> telefones = telefoneRepository.findByTiponumero(tiponumero);
        if (telefones.isEmpty()) {
            return null;
        }
        return telefones;
    }

    @PostMapping("/salvar")
    public ResponseEntity<TelefoneModel> addTelefone(@RequestBody TelefoneModel telefones) {
        TelefoneModel savedTelefone = telefoneRepository.save(telefones);
        return new ResponseEntity<>(savedTelefone, HttpStatus.CREATED);
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        try {
            if (telefoneRepository.existsById(id)) {
                telefoneRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Telefone não encontrado.");
            }
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Não é possível deletar o telefone pois está vinculado a um usuário.");
        }
    }

    
}
