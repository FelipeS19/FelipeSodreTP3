package edu.br.felipesodre.FelipeSodreTP3.Controllers;

import edu.br.felipesodre.FelipeSodreTP3.Service.EscolaService;
import edu.br.felipesodre.FelipeSodreTP3.model.domain.Escola;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escolas")
public class EscolaController {

    @Autowired
    private EscolaService escolaService;

    @GetMapping
    public List<Escola> listarEscolas() {
        return escolaService.listarEscolas();
    }

    @PostMapping
    public void criarEscola(@RequestBody Escola escola) {
        escolaService.criarEscola(escola);
    }

    @DeleteMapping("/{id}")
    public void deletarEscola(@PathVariable int id) {
        escolaService.deletarEscola(id);
    }
}
