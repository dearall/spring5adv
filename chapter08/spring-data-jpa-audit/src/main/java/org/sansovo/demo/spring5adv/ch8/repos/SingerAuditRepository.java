package org.sansovo.demo.spring5adv.ch8.repos;

import org.sansovo.demo.spring5adv.ch8.entities.SingerAudit;
import org.springframework.data.repository.CrudRepository;

public interface SingerAuditRepository extends CrudRepository<SingerAudit, Long> {
}
