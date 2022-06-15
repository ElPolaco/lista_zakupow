package com.example.zadanie9;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
    User findUserByNick(String nick);
}
