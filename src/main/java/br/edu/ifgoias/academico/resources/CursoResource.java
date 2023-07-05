package br.edu.ifgoias.academico.resources;

import br.edu.ifgoias.academico.entities.Curso;
import br.edu.ifgoias.academico.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cursos")
public class CursoResource {

    @Autowired
    private CursoService service;


    @GetMapping
    public ResponseEntity <List<Curso>> findAll(){
        List<Curso> lista = service.findAll();

        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Curso> findById(@PathVariable Integer id) {
        Curso curso = service.findById(id);
        return ResponseEntity.ok().body(curso);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Curso> insert(@RequestBody Curso curso) {
        curso = service.insert(curso);
        return ResponseEntity.ok().body(curso);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Curso curso) {
        service.update(id, curso);
    }
}