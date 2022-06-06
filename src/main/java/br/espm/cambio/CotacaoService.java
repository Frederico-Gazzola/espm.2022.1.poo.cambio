package br.espm.cambio;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CotacaoService {

    @Autowired 
    private CotacaoRepository cotacaoRepository;

    public List<Cotacao> listAll(){
        return StreamSupport
            // transforma de iteravel para lista
            .stream(cotacaoRepository.findAll().spliterator(), false)
            .collect(Collectors.toList())
            // transforma de Model para Objeto
            .stream().map(CotacaoModel::to)
            .collect(Collectors.toList());
    }

    public Cotacao create(Cotacao vo){
        vo.setId(UUID.randomUUID());
        return cotacaoRepository.save(new CotacaoModel(vo)).to();
    }

    public List<Cotacao> findBySimbolo(String simbolo){
        return StreamSupport
        .stream(cotacaoRepository.findBySimbolo(simbolo).spliterator(), false)
        .collect(Collectors.toList())
        .stream().map(CotacaoModel::to)
        .collect(Collectors.toList());

    }


}
