package org.sansovo.demo.spring5adv.ch8.repos;

import org.sansovo.demo.spring5adv.ch8.entities.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by iuliana.cosmina on 5/7/17.
 */
public interface InstrumentRepository extends JpaRepository<Instrument, Long> {

}
