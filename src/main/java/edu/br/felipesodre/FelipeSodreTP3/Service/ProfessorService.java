package edu.br.felipesodre.FelipeSodreTP3.Service;

import edu.br.felipesodre.FelipeSodreTP3.model.domain.Professor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProfessorService {

    private Map<Integer, Map<Integer, Professor>> professoresPorEscola = new HashMap<>();
    private Map<Integer, Integer> proximoIdPorEscola = new HashMap<>();

    public List<Professor> listarProfessoresPorEscola(int escolaId) {
        Map<Integer, Professor> professoresMap = professoresPorEscola.getOrDefault(escolaId, new HashMap<>());
        return new ArrayList<>(professoresMap.values());
    }

    public void criarProfessor(int escolaId, Professor professor) {
        Map<Integer, Professor> professoresMap = professoresPorEscola.getOrDefault(escolaId, new HashMap<>());

        int proximoId = proximoIdPorEscola.getOrDefault(escolaId, 1);
        professor.setId(proximoId);
        professoresMap.put(proximoId, professor);
        professoresPorEscola.put(escolaId, professoresMap);
        proximoIdPorEscola.put(escolaId, proximoId + 1);
    }

    public void deletarProfessor(int escolaId, int id) {
        Map<Integer, Professor> professoresMap = professoresPorEscola.getOrDefault(escolaId, new HashMap<>());
        professoresMap.remove(id);
        professoresPorEscola.put(escolaId, professoresMap);

        // Não é necessário atualizar os IDs dos professores restantes, pois eles já são únicos para cada escola
    }
}