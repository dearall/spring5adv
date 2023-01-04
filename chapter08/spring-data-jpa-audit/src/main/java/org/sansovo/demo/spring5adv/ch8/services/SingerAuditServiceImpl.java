package org.sansovo.demo.spring5adv.ch8.services;

import org.sansovo.demo.spring5adv.ch8.entities.SingerAudit;
import org.sansovo.demo.spring5adv.ch8.repos.SingerAuditRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("singerAuditService")
@Transactional
public class SingerAuditServiceImpl implements SingerAuditService {

    @Autowired
    private SingerAuditRepository singerAuditRepository;

    @Transactional(readOnly=true)
    public List<SingerAudit> findAll() {
        return Lists.newArrayList(singerAuditRepository.findAll());
    }

    /**
     * API  changed in  2.0.0.M3 findOne became findById
     * @param id
     * @return
     */
    public SingerAudit findById(Long id) {
        return singerAuditRepository.findById(id).get();
    }

    public SingerAudit save(SingerAudit singer) {
        return singerAuditRepository.save(singer);
    }
}
