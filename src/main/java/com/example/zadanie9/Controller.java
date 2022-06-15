package com.example.zadanie9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@RestController
public class Controller {
    @Autowired
    ListaRepository repo;
    @Autowired
    UserRepository urepo;
    @RequestMapping("/")//Wyświetla listę
    public ModelAndView lista(Model model, Principal principal){
        ModelAndView m =new ModelAndView();
        m.setViewName("index.html");
        urepo.findUserByNick(principal.getName()).getLista().getLista().entrySet();
        model.addAttribute("lista",urepo.findUserByNick(principal.getName()).getLista().getLista().entrySet());
        return m;
    }
    @PostMapping("/dodaj") //Dodaje opcję do listy
    public void dodaj(String txt,Principal principal){
        ListaZakupów l= urepo.findUserByNick(principal.getName()).getLista();
        l.getLista().put(txt,false);
        repo.save(l);
    }
    @PostMapping("/zmienstatus")
    public void zmienstatus(String txt,Principal principal){//Usuwa lub zmienia status opcji na 'wykonaną'
        ListaZakupów l= urepo.findUserByNick(principal.getName()).getLista();
        if(l.getLista().get(txt)){
           l.getLista().remove(txt);
        }else
            l.getLista().replace(txt,true);
        repo.save(l);
    }
    @PostMapping("/zmiennazwe")
    public void zmiennazwe(String stare, String nowe,Principal principal){//Zmienia nazwę
        ListaZakupów l= urepo.findUserByNick(principal.getName()).getLista();
        boolean v=l.getLista().get(stare);
        l.getLista().remove(stare);
        l.getLista().put(nowe,v);
        repo.save(l);
    }
    @PostMapping("/przywroc")
    public void przywroc(String txt,Principal principal){//Przywraca opcję wykonaną na 'do wykonania'
        ListaZakupów l= urepo.findUserByNick(principal.getName()).getLista();
        l.getLista().replace(txt,false);
        repo.save(l);
    }
}
