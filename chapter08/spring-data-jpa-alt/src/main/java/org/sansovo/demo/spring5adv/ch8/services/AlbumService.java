package org.sansovo.demo.spring5adv.ch8.services;

import org.sansovo.demo.spring5adv.ch8.entities.Album;
import org.sansovo.demo.spring5adv.ch8.entities.Singer;

import java.util.List;

/**
 * Created by iuliana.cosmina on 5/7/17.
 */
public interface AlbumService {
	List<Album> findBySinger(Singer singer);

	List<Album> findByTitle(String title);
}
