package edu.br.felipesodre.FelipeSodreTP3.Service;

import edu.br.felipesodre.FelipeSodreTP3.model.domain.Professor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;

public class ProfessorServiceTest {

    private ProfessorService professorService;

    @BeforeEach
    public void setUp() {
        professorService = new ProfessorService();
    }

    @Test
    public void testListarProfessoresPorEscola() {
        // Adding sample professors for testing
        Professor professor1 = new Professor();
        professor1.setNome("Professor 1");
        professorService.criarProfessor(1, professor1);

        Professor professor2 = new Professor();
        professor2.setNome("Professor 2");
        professorService.criarProfessor(1, professor2);

        List<Professor> professores = professorService.listarProfessoresPorEscola(1);
        assertEquals(2, professores.size());
    }

    @Test
    public void testCriarProfessor() {
        Professor professor = new Professor();
        professor.setNome("Novo Professor");
        professorService.criarProfessor(1, professor);

        List<Professor> professores = professorService.listarProfessoresPorEscola(1);
        assertEquals(1, professores.size());
        assertTrue(professores.contains(professor));
    }

    @Test
    public void testDeletarProfessor() {
        Professor professor = new Professor();
        professor.setNome("Professor para deletar");
        professorService.criarProfessor(1, professor);

        int id = professor.getId();
        professorService.deletarProfessor(1, id);

        List<Professor> professores = professorService.listarProfessoresPorEscola(1);
        assertEquals(0, professores.size());
    }
}
