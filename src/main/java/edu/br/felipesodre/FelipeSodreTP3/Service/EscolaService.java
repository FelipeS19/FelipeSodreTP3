package edu.br.felipesodre.FelipeSodreTP3.Service;

import edu.br.felipesodre.FelipeSodreTP3.model.domain.Escola;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EscolaService {

    private Map<Integer, Escola> escolas = new HashMap<>();
    private int proximoId = 1;

    public List<Escola> listarEscolas() {
        return new ArrayList<>(escolas.values());
    }

    public void criarEscola(Escola escola) {
        if (escolas.isEmpty()) {
            escola.setId(1);
            escolas.put(1, escola);
            proximoId = 2;
        } else {
            int novoId = escolas.keySet().stream().max(Integer::compareTo).orElse(0) + 1;
            escola.setId(novoId);
            escolas.put(novoId, escola);
            proximoId = novoId + 1;
        }
    }
    public void deletarEscola(int id) {
        escolas.remove(id);
        reatribuirIDs();
    }
    private void reatribuirIDs() {
        List<Escola> escolasAtualizadas = new ArrayList<>();
        int novoId = 1;
        for (Escola escola : escolas.values()) {
            escola.setId(novoId++);
            escolasAtualizadas.add(escola);
        }
        escolas.clear();

        for (Escola escola : escolasAtualizadas) {
            escolas.put(escola.getId(), escola);
        }
        proximoId = novoId;
    }
}