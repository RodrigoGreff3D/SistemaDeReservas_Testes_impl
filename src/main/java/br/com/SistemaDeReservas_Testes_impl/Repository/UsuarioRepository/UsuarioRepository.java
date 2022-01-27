package br.com.SistemaDeReservas_Testes_impl.Repository.UsuarioRepository;

import br.com.SistemaDeReservas_Testes_impl.Domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByEmail(String email);

    boolean existsByCpf(String cpf);
}
