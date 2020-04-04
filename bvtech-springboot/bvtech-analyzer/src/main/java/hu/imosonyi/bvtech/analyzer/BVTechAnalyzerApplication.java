package hu.imosonyi.bvtech.analyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class BVTechAnalyzerApplication {

    public static void main (String[] args) {
        SpringApplication.run(BVTechAnalyzerApplication.class, args);
    }

}
