package com.eds.cakefactory.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Profile("dev")
class ItemJpaRepositoryTest {

    @Autowired
    private ItemJpaRepository itemJpaRepository;




}