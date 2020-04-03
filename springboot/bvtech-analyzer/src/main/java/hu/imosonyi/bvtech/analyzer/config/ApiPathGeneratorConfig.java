package hu.imosonyi.bvtech.analyzer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hu.imosonyi.bvtech.analyzer.randomtext.ApiPathGenerator;

@Configuration
public class ApiPathGeneratorConfig {

    @Bean
    public ApiPathGenerator apiPathGenerator () {
        return new ApiPathGenerator();
    }

}
