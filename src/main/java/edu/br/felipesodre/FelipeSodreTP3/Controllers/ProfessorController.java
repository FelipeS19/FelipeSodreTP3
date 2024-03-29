package edu.br.felipesodre.FelipeSodreTP3.Controllers;

import edu.br.felipesodre.FelipeSodreTP3.Service.ProfessorService;
import edu.br.felipesodre.FelipeSodreTP3.model.domain.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escolas/{escolaId}/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public List<Professor> listarProfessoresPorEscola(@PathVariable int escolaId) {
        return professorService.listarProfessoresPorEscola(escolaId);
    }

    @PostMapping
    public void criarProfessor(@PathVariable int escolaId, @RequestBody Professor professor) {
        professorService.criarProfessor(escolaId, professor);
    }

    @DeleteMapping("/{id}")
    public void deletarProfessor(@PathVariable int escolaId, @PathVariable int id) {
        professorService.deletarProfessor(escolaId, id);
    }
}