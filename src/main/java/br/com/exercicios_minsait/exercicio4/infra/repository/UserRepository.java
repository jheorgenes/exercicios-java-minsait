package br.com.exercicios_minsait.exercicio4.infra.repository;

import br.com.exercicios_minsait.exercicio4.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
