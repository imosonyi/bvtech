package hu.imosonyi.bvtech.analyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Spring Boot main class.
 *
 * @author István Mosonyi
 */
@SpringBootApplication
@EnableAsync
public class BVTechAnalyzerApplication {

    public static void main (String[] args) {
        SpringApplication.run(BVTechAnalyzerApplication.class, args);
    }

}
