package br.edu.ifba.demo.backend.api.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.edu.ifba.demo.backend.api.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    Optional<UsuarioModel> findByNome(String nome);
    Optional<UsuarioModel> findByCpf(String cpf);
    Optional<UsuarioModel> findByEmail(String email);
    Optional<UsuarioModel> findByLogin(String login);

    // Métodos para verificar se e-mail ou CPF já existem
    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);

    @Query(value = "SELECT u.idusuario, u.nome, u.cpf, u.email, u.login, u.senha, " +
                   "e.estado, e.cidade, e.bairro, e.rua, e.numero, e.cep, " +
                   "t.numero AS telefone, t.tipo_numero " +
                   "FROM usuario u " +
                   "JOIN endereco e ON u.idendereco = e.idendereco " +
                   "JOIN telefone t ON u.idusuario = t.id_usuario;", nativeQuery = true)
    List<Object[]> getUsuarioDados();
}
