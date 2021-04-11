package com.eds.cakefactory.controller;

import com.eds.cakefactory.model.Cake;
import com.eds.cakefactory.service.ICakeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CatalogControllerMockMVCTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ICakeService cakeService;

    @Test
    public void getCakesShouldReturnCakesFromService() throws Exception {
        List<Cake> cakes =new ArrayList<Cake>();
        cakes.add(new Cake("111", "Cake1", 44.5));
        cakes.add(new Cake("222", "Cake2", 20));
        cakes.add(new Cake("333", "Cake3", 33));

        Mockito.when(cakeService.getCakes()).thenReturn(cakes);

        this.mockMvc.perform(get("/getCakes")).andDo(print())
                .andExpect((status().isOk()));
    }
}
