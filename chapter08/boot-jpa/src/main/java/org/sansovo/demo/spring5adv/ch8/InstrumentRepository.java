package org.sansovo.demo.spring5adv.ch8;

import org.sansovo.demo.spring5adv.ch8.entities.Instrument;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by iuliana.cosmina on 5/12/17.
 */
public interface InstrumentRepository extends CrudRepository<Instrument, Long> {

}
