package org.sansovo.demo.spring5adv.ch16.repos;

import org.sansovo.demo.spring5adv.ch16.entities.Singer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SingerRepository extends PagingAndSortingRepository<Singer, Long> {
}
