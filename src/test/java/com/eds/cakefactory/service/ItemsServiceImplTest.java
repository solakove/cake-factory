package com.eds.cakefactory.service;

import com.eds.cakefactory.configuration.FlywayTestConfiguration;
import com.eds.cakefactory.model.Items;
import com.eds.cakefactory.repository.ItemJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

@SpringBootTest
@Import(FlywayTestConfiguration.class)
class ItemsServiceImplTest {

    @Autowired
    private IItemService itemService;

    @MockBean
    private ItemJpaRepository itemJpaRepository;

    @Test
    public void getCakesShouldReturnAllThreeCakes() {
        List<Items> items = new ArrayList<Items>();
        items.add(new Items(111, "Cake1", 44.5));
        items.add(new Items(222, "Cake2", 20));
        items.add(new Items(333, "Cake3", 33));

        doReturn(items).when(itemJpaRepository).findAll();

        List<Items> returnedItems = itemService.getItems();

        assertEquals(returnedItems.size(), 3);
        assertThat(returnedItems, containsInAnyOrder(
                items.get(0),
                items.get(1),
                items.get(2)
        ));
    }

    @Test
    public void getCakesShouldReturnEmptyList() {
        doReturn(new ArrayList<Items>()).when(itemJpaRepository).findAll();

        List<Items> returnedItems = itemService.getItems();
        assertEquals(returnedItems.size(), 0);

    }

    @Test
    public void getCakesShouldThrowSqlException() {
        String exceptionMessage = "sql script error";
        doThrow(new RuntimeException(exceptionMessage)).when(itemJpaRepository).findAll();
        Exception exception = assertThrows(RuntimeException.class, () -> itemService.getItems());

        assertEquals(exception.getMessage(), exceptionMessage);
    }


}