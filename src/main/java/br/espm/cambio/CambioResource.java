package br.espm.cambio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CambioResource {

    @Autowired
    private MoedaService moedaService;
    
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello ESPM";
    }

    @GetMapping("/moeda")
    public List<Moeda> listMoeda() {

       // moedas.add(new Moeda("Real", "BRL"));
       // moedas.add(new Moeda("Rubro", "RUB"));
       // moedas.add(new Moeda("Dólar", "USD"));
       // moedas.add(new Moeda("Euro", "EUR"));

        return moedaService.listaAll();
    }

    @GetMapping("/moeda/{simbolo}")
    public Moeda findMoedaBySimbolo (@PathVariable String simbolo) {
        return null;
    }

    @PostMapping("/moeda")
    public void save(@RequestBody Moeda moeda) {
        moedaService.create(moeda);
        //moedas.add(moeda);
    }

}
