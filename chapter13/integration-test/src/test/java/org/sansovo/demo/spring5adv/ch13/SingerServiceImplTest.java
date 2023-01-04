package org.sansovo.demo.spring5adv.ch13;


import org.sansovo.demo.spring5adv.ch13.entities.Singer;
import org.sansovo.demo.spring5adv.ch13.services.SingerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sansovo.demo.spring5adv.ch13.config.DataConfig;
import org.sansovo.demo.spring5adv.ch13.config.ServiceConfig;
import org.sansovo.demo.spring5adv.ch13.config.ServiceTestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ServiceTestConfig.class, ServiceConfig.class, DataConfig.class})
@TestExecutionListeners({ServiceTestExecutionListener.class})
@ActiveProfiles("test")
public class SingerServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    SingerService singerService;

    @PersistenceContext
    private EntityManager em;

    @DataSets(setUpDataSet= "/org/sansovo/demo/spring5adv/ch13/SingerServiceImplTest.xls")
    @Test
    public void testFindAll() throws Exception {
        List<Singer> result = singerService.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @DataSets(setUpDataSet= "/org/sansovo/demo/spring5adv/ch13/SingerServiceImplTest.xls")
    @Test
    public void testFindByFirstNameAndLastNameOne() throws Exception {
        Singer result = singerService.findByFirstNameAndLastName("John", "Mayer");
        assertNotNull(result);
    }

    @DataSets(setUpDataSet= "/org/sansovo/demo/spring5adv/ch13/SingerServiceImplTest.xls")
    @Test
    public void testFindByFirstNameAndLastNameTwo() throws Exception {
        Singer result = singerService.findByFirstNameAndLastName("BB", "King");
        assertNull(result);
    }

    @Test
    public void testAddSinger() throws Exception {
        deleteFromTables("SINGER");

        Singer singer = new Singer();
        singer.setFirstName("Stevie");
        singer.setLastName("Vaughan ");

        singerService.save(singer);
        em.flush();

        List<Singer> singers = singerService.findAll();
        assertEquals(1, singers.size());
    }

    @Test(expected=AssertionError.class)
    public void testAddSingerWithJSR349Error() throws Exception {
        deleteFromTables("SINGER");

        Singer singer = new Singer();

        singerService.save(singer);
        em.flush();

        List<Singer> singers = singerService.findAll();
        assertEquals(0, singers.size());
    }
}
