package com.fdr;

import com.fdr.config.SDSConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SDSConfig.class)
public class StockDataServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockDataServiceApplication.class, args);
    }

}
