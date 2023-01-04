package org.sansovo.demo.spring5adv.ch8.service;

import org.sansovo.demo.spring5adv.ch8.view.SingerSummary;

import java.util.List;

public interface SingerSummaryService {
    List<SingerSummary> findAll();
}
