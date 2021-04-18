package com.eds.cakefactory.controller;

import com.eds.cakefactory.configuration.FlywayTestConfiguration;
import com.eds.cakefactory.model.Items;
import com.eds.cakefactory.service.IItemService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


// https://stackoverflow.com/questions/50915868/spring-boot-and-flyway-clear-database-data-before-integration-tests


@SpringBootTest
@AutoConfigureMockMvc
@Import(FlywayTestConfiguration.class)
public class CatalogControllerMockMVCTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IItemService cakeService;

    @Test
    public void getCakesShouldReturnCakesFromService() throws Exception {
        List<Items> items =new ArrayList<Items>();
        items.add(new Items(111, "Cake1", 44.5));
        items.add(new Items(222, "Cake2", 20));
        items.add(new Items(333, "Cake3", 33));

        Mockito.when(cakeService.getItems()).thenReturn(items);

        this.mockMvc.perform(get("/getCakes")).andDo(print())
                .andExpect((status().isOk()));
    }
}
