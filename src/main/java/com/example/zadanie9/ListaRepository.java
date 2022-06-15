package com.example.zadanie9;


import org.springframework.data.repository.CrudRepository;

public interface ListaRepository extends CrudRepository<ListaZakupów,Integer> {
    ListaZakupów findListaZakupówById(Integer id);
}
