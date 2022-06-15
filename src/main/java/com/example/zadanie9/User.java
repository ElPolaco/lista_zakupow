package com.example.zadanie9;

import javax.persistence.*;

@Entity
@Table(name = "uzytkownicy")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String nick;

    private String haslo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public ListaZakupów getLista() {
        return lista;
    }

    public void setLista(ListaZakupów lista) {
        this.lista = lista;
    }

    @JoinColumn(name="id_listy",referencedColumnName = "id")
    @OneToOne
    private ListaZakupów lista;
}