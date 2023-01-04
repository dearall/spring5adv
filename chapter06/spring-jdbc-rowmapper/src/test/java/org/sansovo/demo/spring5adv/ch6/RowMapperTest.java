package org.sansovo.demo.spring5adv.ch6;


import org.junit.Test;
import org.sansovo.demo.spring5adv.ch6.config.NamedJdbcCfg;
import org.sansovo.demo.spring5adv.ch6.dao.SingerDao;
import org.sansovo.demo.spring5adv.ch6.entities.Album;
import org.sansovo.demo.spring5adv.ch6.entities.Singer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by iuliana.cosmina on 4/16/17.
 */
public class RowMapperTest {

	@Test
	public void testRowMapper() {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(NamedJdbcCfg.class);
		SingerDao singerDao = ctx.getBean(SingerDao.class);
		assertNotNull(singerDao);
		List<Singer> singers = singerDao.findAll();
		assertTrue(singers.size() == 3);

		singers.forEach(singer -> {
			System.out.println(singer);
			if (singer.getAlbums() != null) {
				for (Album album : singer.getAlbums()) {
					System.out.println("---" + album);
				}
			}
		});

		ctx.close();
	}
}
