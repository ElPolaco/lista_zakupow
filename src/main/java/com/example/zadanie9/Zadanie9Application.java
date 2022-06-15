package com.example.zadanie9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Zadanie9Application {

    public static void main(String[] args) {
        SpringApplication.run(Zadanie9Application.class, args);

        /*
        Tak można dodać użytkowników
        ConfigurableApplicationContext c =SpringApplication.run(Zadanie9Application.class, args);
        User u=new User();
        ListaZakupów lista=new ListaZakupów();
        ListaRepository re=c.getBean(ListaRepository.class);
        re.save(lista);
        UserRepository repo=c.getBean(UserRepository.class);
        u.setNick("user2");
        u.setHaslo("qwerty");
        u.setLista(lista);
        repo.save(u);*/
    }

}
