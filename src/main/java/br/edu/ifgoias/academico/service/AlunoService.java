package br.edu.ifgoias.academico.service;

import br.edu.ifgoias.academico.entities.Aluno;
import br.edu.ifgoias.academico.entities.Curso;
import br.edu.ifgoias.academico.repositories.AlunoRepository;
import br.edu.ifgoias.academico.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository repository;

    public List<Aluno> findAll() {
        return repository.findAll();
    }

    public Aluno findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Aluno insert(Aluno obj) {
        return repository.save(obj);
    }

    public void delete(Integer id) {
        repository.findById(id).map(aluno -> {
            repository.delete(aluno);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void update(Integer id, Aluno obj) {
        repository.findById(id).map(aluno -> {
            aluno.setNome(obj.getNome());
            aluno.setSexo(obj.getSexo());
            aluno.setDt_nasc(obj.getDt_nasc());
            aluno.setCursos(obj.getCursos());
            return repository.save(aluno);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}