package br.edu.ifba.demo.backend.api.controller;

import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifba.demo.backend.api.dto.ContasDTO;
import br.edu.ifba.demo.backend.api.model.CategoriaModel;
import br.edu.ifba.demo.backend.api.model.ContasModel;
import br.edu.ifba.demo.backend.api.repository.CategoriaRepository;
import br.edu.ifba.demo.backend.api.repository.ContasRepository;
import br.edu.ifba.demo.backend.api.repository.UsuarioRepository;

@RestController
@RequestMapping("/contas")
public class ContasController {
    
    @Autowired
    private ContasRepository contasRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;

    public ContasController(ContasRepository contasRepository, UsuarioRepository usuarioRepository, CategoriaRepository categoriaRepository){
        this.contasRepository = contasRepository;
		this.usuarioRepository = usuarioRepository;
		this.categoriaRepository = categoriaRepository;
    }

    @GetMapping
	public String teste() {
		return "Testando Rota contas";
	}
	
	@GetMapping("/listall")
	public List<ContasModel> listall() {
		var contas = contasRepository.findAll();
		return contas;
	}

    @GetMapping("/buscarporid/{id}")
	public ContasModel findById(@PathVariable("id") Long id) {
		Optional<ContasModel> contas = contasRepository.findById(id);
		if (contas.isPresent()){
			return contas.get();
		}

		return null;
	}

	@GetMapping("/buscarportipoconta/{tipoConta}")
	public ResponseEntity<List<ContasModel>> findByTipoconta(@PathVariable String tipoConta) {
		List<ContasModel> contas = contasRepository.findByTipoconta(tipoConta);
		return ResponseEntity.ok(contas);
	}

	@GetMapping("/buscarporstatuscontas/{statuscontas}")
	public ResponseEntity<List<ContasModel>> findByStatuscontas(@PathVariable Boolean statuscontas) {
		List<ContasModel> contas = contasRepository.findByStatuscontas(statuscontas);
		return ResponseEntity.ok(contas);
	}

	@GetMapping("/buscarporvencimento/{datavencimento}")
    public ResponseEntity<List<ContasModel>> findByDatavencimento(@PathVariable LocalDate  datavencimento) {
        List<ContasModel> contas = contasRepository.findByDatavencimento(datavencimento);
        return ResponseEntity.ok(contas);
    }

	@GetMapping("/buscarporpagamento/{datapagamento}")
    public ResponseEntity<List<ContasModel>> findByDatapagamento(@PathVariable LocalDate  datapagamento) {
        List<ContasModel> contas = contasRepository.findByDatapagamento(datapagamento);
        return ResponseEntity.ok(contas);
    }

	@GetMapping("/buscarporidusuario/{idusuario}")
    public ResponseEntity<List<ContasModel>> buscarPorUsuario(@PathVariable Long idusuario) {
        List<ContasModel> contas = contasRepository.findByIdusuario_Idusuario(idusuario);
        return ResponseEntity.ok(contas);
    }

	@GetMapping("/buscarpornomeusuario/{nome}")
	public ResponseEntity<List<ContasModel>> buscarPorNome(@PathVariable String nome) {
		List<ContasModel> contas = contasRepository.findByIdusuario_Nome(nome);
		return ResponseEntity.ok(contas);
	}


	@GetMapping("/buscarporcategoria/{idcategoria}")
    public ResponseEntity<List<ContasModel>> buscarPorCategoria(@PathVariable Long idcategoria) {
        List<ContasModel> contas = contasRepository.findByIdcategoriaIdcategoria(idcategoria);
        return ResponseEntity.ok(contas);
    }

	@PostMapping("/salvar")
    public ResponseEntity<ContasModel> addContas(@RequestBody ContasModel contas) {
        ContasModel savedContas = contasRepository.save(contas);
        return new ResponseEntity<>(savedContas, HttpStatus.CREATED);
    }

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
		System.out.println("Recebida requisição DELETE para ID: " + id);

		if (!contasRepository.existsById(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta não encontrada.");
		}

		try {
			contasRepository.deleteById(id);
			System.out.println("Conta excluída com sucesso!");
			return ResponseEntity.ok("Conta excluída com sucesso!");
		} catch (DataIntegrityViolationException e) {
			System.err.println("Erro ao excluir: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Não é possível excluir a conta, pois há parcelas vinculadas a ela.");
		}
	}

	@PostMapping("/criar")
public ResponseEntity<?> criarConta(@RequestBody ContasDTO contasDTO, 
                                    @RequestHeader("Usuario-ID") Long usuarioId) {
    try {
        var usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        CategoriaModel categoria = null;
        if (contasDTO.getIdcategoria() != null) {
            categoria = categoriaRepository.findById(contasDTO.getIdcategoria())
                    .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        }

        ContasModel contas = new ContasModel();
        contas.setDescricao(contasDTO.getDescricao());
        contas.setValor(contasDTO.getValor());
        contas.setDatavencimento(contasDTO.getDatavencimento());
        contas.setDatapagamento(contasDTO.getDatapagamento());
        contas.setTipoconta(contasDTO.getTipoconta());
        contas.setStatuscontas(contasDTO.isStatuscontas());
        contas.setIdusuario(usuario);
        contas.setIdcategoria(categoria);

        ContasModel savedContas = contasRepository.save(contas);

        return new ResponseEntity<>(savedContas, HttpStatus.CREATED);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao criar conta: " + e.getMessage());
    }
}

}
