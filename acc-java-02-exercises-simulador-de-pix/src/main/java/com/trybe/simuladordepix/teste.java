package com.trybe.simuladordepix;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class teste {

    public static void main(String[] args) {

        Collection<String> nomes = List.of("Fulano", "Maria", "Fulano", "José", "José", "Joana","QUALQUER");
        List<String> pessoasDistintas = nomes.stream()
			.distinct().collect(Collectors.toList());
		
        long p = nomes.stream().distinct().count();    
        System.out.println(pessoasDistintas);
        System.out.println(p);
    }
}

