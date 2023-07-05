package br.edu.ifgoias.academico.repositories;

import br.edu.ifgoias.academico.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifgoias.academico.entities.Aluno;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{

}
