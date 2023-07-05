package br.edu.ifgoias.academico.resources;

import br.edu.ifgoias.academico.entities.Aluno;
import br.edu.ifgoias.academico.entities.Curso;
import br.edu.ifgoias.academico.service.AlunoService;
import br.edu.ifgoias.academico.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {

    @Autowired
    private AlunoService service;


    @GetMapping
    public ResponseEntity<List<Aluno>> findAll(){
        List<Aluno> lista = service.findAll();

        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable Integer id) {
        Aluno aluno = service.findById(id);
        return ResponseEntity.ok().body(aluno);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Aluno> insert(@RequestBody Aluno aluno) {
        aluno = service.insert(aluno);
        return ResponseEntity.ok().body(aluno);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Aluno aluno) {
        service.update(id, aluno);
    }
}
