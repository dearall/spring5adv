package org.sansovo.demo.spring5adv.ch8.services;

import org.sansovo.demo.spring5adv.ch8.entities.Singer;

import java.util.List;

public interface SingerService {
    List<Singer> findAll();
    List<Singer> findByFirstName(String firstName);
    List<Singer> findByFirstNameAndLastName(String firstName, String lastName);
}
