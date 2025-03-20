package br.edu.ifba.demo.backend.api.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifba.demo.backend.api.model.ParcelaModel;
import br.edu.ifba.demo.backend.api.repository.ParcelaRepository;

@RestController
@RequestMapping("/parcela")
public class ParcelaController {

    @Autowired
    private ParcelaRepository parcelaRepository;

    public ParcelaController (ParcelaRepository parcelaRepository){
        this.parcelaRepository = parcelaRepository;
    }

    @GetMapping
	public String teste() {
		return "Testando Rota parcela";
	}
	
	@GetMapping("/listall")
	public List<ParcelaModel> listall() {
		var parcela = parcelaRepository.findAll();
		return parcela;
	}

	@GetMapping("/buscarporvencimento/{datavencimento}")
    public ResponseEntity<List<ParcelaModel>> findByParceladatavencimento(@PathVariable LocalDate  datavencimento) {
		List<ParcelaModel> parcela = parcelaRepository.findByParceladatavencimento(datavencimento);
        return ResponseEntity.ok(parcela);
	}

	@GetMapping("/buscarporconta/{idconta}")
	public ResponseEntity<List<ParcelaModel>> findByIdcontas_Idcontas(@PathVariable Long idconta) {
		List<ParcelaModel> parcela = parcelaRepository.findByIdcontas_Idcontas(idconta);
		return ResponseEntity.ok(parcela);
	}

	@PostMapping("/salvar")
	public ResponseEntity<ParcelaModel> addParcela(@RequestBody ParcelaModel parcela){
		ParcelaModel savedParcela = parcelaRepository.save(parcela);
		return new ResponseEntity<>(savedParcela, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteParcela(@PathVariable Long id) {
		if (!parcelaRepository.existsById(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Parcela não encontrada!");
		}
		
		// Recupera o ID da conta antes de deletar a parcela
		ParcelaModel parcela = parcelaRepository.findById(id).orElseThrow();
		Long idConta = parcela.getIdcontas().getIdcontas();
		
		parcelaRepository.deleteById(id);
		
		// Retorna o ID da conta junto com a mensagem de sucesso
		return ResponseEntity.ok(idConta);
	}

}
