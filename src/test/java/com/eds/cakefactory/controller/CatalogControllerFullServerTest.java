package com.eds.cakefactory.controller;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;


//@WebMvcTest(CatalogController.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class CatalogControllerFullServerTest {

    private static final WebClient webClient = new WebClient();

    @LocalServerPort
    int serverPort;

    @AfterAll
    public static void close() {
        webClient.close();
    }

    @Test
    public void givenClient_whenAccessingStartupPage_thenPageTitleIsOK() throws Exception {
        HtmlPage page = webClient.getPage("http://localhost:" + serverPort + "/getCakes");

        Assertions.assertEquals("Cake Factory", page.getTitleText());
    }

}