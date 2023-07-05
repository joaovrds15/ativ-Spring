package br.edu.ifgoias.academico.repositories;

import br.edu.ifgoias.academico.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}
