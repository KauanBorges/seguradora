package com.programem.seguradora;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/dependente")
public class DependenteController {

    @Autowired
    private DependenteRepository dependenteRepository;

    
    private Lista lista = new Lista();

    @GetMapping("/")
    public String dependenteForm(){
      return "dependenteForm";
    }

    @PostMapping(path="/insere") // Map ONLY POST Requests
    public @ResponseBody String addNewDependente (
         @RequestParam String nome
        ,@RequestParam Integer idade
        ,@RequestParam String endereco
        ) {

            Dependente d = new Dependente();

            d.setNome(nome);
            d.setIdade(idade);
            d.setEndereco(endereco);

            dependenteRepository.save(d);

            return nome+" "+idade+" "+endereco;
    }

    @GetMapping(path="/lista")
    public @ResponseBody String getAllDependente() {
      return lista.listaDependente(dependenteRepository.findAll());
  }
}