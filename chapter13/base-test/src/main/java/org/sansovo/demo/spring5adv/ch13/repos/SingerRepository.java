package org.sansovo.demo.spring5adv.ch13.repos;

import org.sansovo.demo.spring5adv.ch13.entities.Singer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SingerRepository extends CrudRepository<Singer, Long> {

	List<Singer> findByFirstName(String firstName);

	Singer findByFirstNameAndLastName(String firstName, String lastName);
}
