package org.sansovo.demo.spring5adv.ch8;

import org.sansovo.demo.spring5adv.ch8.config.EnversConfig;
import org.sansovo.demo.spring5adv.ch8.entities.SingerAudit;
import org.sansovo.demo.spring5adv.ch8.services.SingerAuditService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class SpringEnversJPADemo {
    private static Logger logger = LoggerFactory.getLogger(SpringEnversJPADemo.class);

    public static void main(String... args) {
//        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:spring/app-context-annotation.xml");
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(EnversConfig.class);

        SingerAuditService singerAuditService = ctx.getBean(SingerAuditService.class);

        System.out.println("Add new singer");
        SingerAudit singer = new SingerAudit();
        singer.setFirstName("BB");
        singer.setLastName("King");
        singer.setBirthDate(new Date(
                (new GregorianCalendar(1940, 8, 16)).getTime().getTime()));
        singerAuditService.save(singer);
        listSingers(singerAuditService.findAll());

        System.out.println("Update singer");
        singer.setFirstName("Riley B.");
        singerAuditService.save(singer);
        listSingers(singerAuditService.findAll());

        SingerAudit oldSinger = singerAuditService.findAuditByRevision(4l, 1);
        System.out.println("");
        System.out.println("Old Singer with id 4 and rev 1:" + oldSinger);
        System.out.println("");
        oldSinger = singerAuditService.findAuditByRevision(4l, 2);
        System.out.println("");
        System.out.println("Old Singer with id 4 and rev 2:" + oldSinger);
        System.out.println("");

        ctx.close();
    }

    private static void listSingers(List<SingerAudit> singers) {
        logger.info(" ---- Listing singers:");
        singers.forEach(s -> logger.info(s.toString()));
    }
}
