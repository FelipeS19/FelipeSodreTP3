package edu.br.felipesodre.FelipeSodreTP3.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    @Autowired
    private RestTemplate restTemplate;

    public Object obterDadosDaApiExterna() {
        String url = "URL_DA_API_EXTERNAMENTE";

        // Fazer uma solicitação GET para a API externa e retornar os dados
        return restTemplate.getForObject(url, Object.class);
    }
}