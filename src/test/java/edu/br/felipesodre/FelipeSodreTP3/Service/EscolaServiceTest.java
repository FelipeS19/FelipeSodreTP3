package edu.br.felipesodre.FelipeSodreTP3.Service;

import edu.br.felipesodre.FelipeSodreTP3.model.domain.Escola;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;

public class EscolaServiceTest {

    private EscolaService escolaService;

    @BeforeEach
    public void setUp() {
        escolaService = new EscolaService();
    }

    @Test
    public void testListarEscolas() {
        // Adding sample schools for testing
        Escola escola1 = new Escola();
        escola1.setNome("Escola 1");
        escolaService.criarEscola(escola1);

        Escola escola2 = new Escola();
        escola2.setNome("Escola 2");
        escolaService.criarEscola(escola2);

        List<Escola> escolas = escolaService.listarEscolas();
        assertEquals(2, escolas.size());
    }

    @Test
    public void testCriarEscola() {
        Escola escola = new Escola();
        escola.setNome("Nova Escola");
        escolaService.criarEscola(escola);

        List<Escola> escolas = escolaService.listarEscolas();
        assertEquals(1, escolas.size());
        assertTrue(escolas.contains(escola));
    }

    @Test
    public void testDeletarEscola() {
        Escola escola = new Escola();
        escola.setNome("Escola para deletar");
        escolaService.criarEscola(escola);

        int id = escola.getId();
        escolaService.deletarEscola(id);

        List<Escola> escolas = escolaService.listarEscolas();
        assertEquals(0, escolas.size());
    }
}
