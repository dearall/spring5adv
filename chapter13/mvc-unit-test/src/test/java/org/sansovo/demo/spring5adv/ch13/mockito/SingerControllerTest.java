package org.sansovo.demo.spring5adv.ch13.mockito;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.sansovo.demo.spring5adv.ch13.SingerController;
import org.sansovo.demo.spring5adv.ch13.entities.Singer;
import org.sansovo.demo.spring5adv.ch13.entities.Singers;
import org.sansovo.demo.spring5adv.ch13.services.SingerService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SingerControllerTest {
    private final List<Singer> singers = new ArrayList<>();

    @Before
    public void initSingers() {
        Singer singer = new Singer();
        singer.setId(1l);
        singer.setFirstName("John");
        singer.setLastName("Mayer");
        singers.add(singer);
    }

    @Test
    public void testList() throws Exception {
        SingerService singerService = mock(SingerService.class);
        when(singerService.findAll()).thenReturn(singers);

        SingerController singerController = new SingerController();

        ReflectionTestUtils.setField(singerController, "singerService", singerService);

        ExtendedModelMap uiModel = new ExtendedModelMap();
        uiModel.addAttribute("singers", singerController.listData());

        Singers modelSingers = (Singers) uiModel.get("singers");

        assertEquals(1, modelSingers.getSingers().size());
    }

    @Test
    public void testCreate() {
        final Singer newSinger = new Singer();
        newSinger.setId(999l);
        newSinger.setFirstName("Stevie");
        newSinger.setLastName("Vaughan");

        SingerService singerService = mock(SingerService.class);
        when(singerService.save(newSinger)).thenAnswer(invocation -> {
			singers.add(newSinger);
			return newSinger;
		});

        SingerController singerController = new SingerController();
        ReflectionTestUtils.setField(singerController, "singerService",
                singerService);

        Singer singer = singerController.create(newSinger);
        assertEquals(Long.valueOf(999l), singer.getId());
        assertEquals("Stevie", singer.getFirstName());
        assertEquals("Vaughan", singer.getLastName());

        assertEquals(2, singers.size());
    }

    @Test
    public void testFindSingerById(){

        SingerService singerService = mock(SingerService.class);
        when(singerService.findById(1L)).thenAnswer(invocation -> {
            for (Singer s: singers) {
                if(s.getId() == 1L) {
                    return s;
                }
            }
            return null;
        });

        SingerController singerController = new SingerController();
        ReflectionTestUtils.setField(singerController, "singerService",
                singerService);
        Singer singer = singerController.findSingerById(1L);
        assertEquals(Long.valueOf(1L), singer.getId());
        assertEquals("John", singer.getFirstName());
        assertEquals("Mayer", singer.getLastName());
    }
    @Test
    public void testUpdate(){
        Singer singer = new Singer();
        singer.setId(1l);
        singer.setFirstName("John");
        singer.setLastName("Luojie");

        SingerService singerService = mock(SingerService.class);
        when(singerService.save(singer)).thenAnswer(invocation -> {
            for (Singer s: singers) {
                if(s.getId() == singer.getId()){
                    s.setFirstName(singer.getFirstName());
                    s.setLastName(singer.getLastName());
                    s.setBirthDate(singer.getBirthDate());
                    return s;
                }
            }
            return null;
        });

        SingerController singerController = new SingerController();
        ReflectionTestUtils.setField(singerController, "singerService",
                singerService);

        singerController.update(singer,1L);

        assertEquals(Long.valueOf(1L), singer.getId());
        assertEquals("John", singer.getFirstName());
        assertEquals("Luojie", singer.getLastName());
    }

    @Test
    public void testDelete(){
        SingerService singerService = mock(SingerService.class);
        when(singerService.findById(1L)).thenAnswer(invocation -> {
            for (Singer s: singers) {
                if(s.getId() == 1L) {
                    singers.remove(s);
                    return s;
                }
            }
            return new Singer();
        });

        SingerController singerController = new SingerController();
        ReflectionTestUtils.setField(singerController, "singerService",
                singerService);

        Singer singer = singerService.findById(1L);

        assertEquals(0, singers.size());
    }
}
