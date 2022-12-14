package org.sansovo.demo.spring5adv.ch8.services;

import org.sansovo.demo.spring5adv.ch8.entities.Album;
import org.sansovo.demo.spring5adv.ch8.entities.Singer;
import org.sansovo.demo.spring5adv.ch8.repos.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by iuliana.cosmina on 5/7/17.
 */
@Service("springJpaAlbumService")
@Transactional
public class AlbumServiceImpl implements AlbumService {
	@Autowired
	private AlbumRepository albumRepository;

	@Transactional(readOnly=true)
	@Override public List<Album> findBySinger(Singer singer) {
		return albumRepository.findBySinger(singer);
	}

	@Override public List<Album> findByTitle(String title) {
		return albumRepository.findByTitle(title);
	}
}
