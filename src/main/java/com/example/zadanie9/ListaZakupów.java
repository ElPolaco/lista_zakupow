package com.example.zadanie9;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table
public class ListaZakupów {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
    }
    @ElementCollection(targetClass=Boolean.class)
    @MapKeyColumn(name="elementy")
    private Map<String,Boolean> lista=new HashMap<String,Boolean>();

    public Map<String, Boolean> getLista() {
        return lista;
    }
}
