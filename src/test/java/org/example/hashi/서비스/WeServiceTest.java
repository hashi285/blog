package org.example.hashi.서비스;

import pcroomtracker.서비스.WeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WeServiceTest {
    @Autowired private WeService service;

    @Test
    void getIp() {
         service.getip(1L);
        System.out.println(service.getip(1L) + "---------------------------");
    }

    @Test
    void addName() {
        service.addName("이명박 피시방");
    }


    @Test
    void findAll() {
        service.findAll();
        System.out.println(service.findAll());
    }

    @Test
    void getAdmin() {
        service.getAdmin(1L);
        System.out.println(service.getAdmin(1L) + "---------------------------");
    }
}