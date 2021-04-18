package com.eds.cakefactory;

import com.eds.cakefactory.configuration.FlywayTestConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(FlywayTestConfiguration.class)
class CakeFactoryApplicationTests {

    @Test
    void contextLoads() {
    }

}
