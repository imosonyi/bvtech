package hu.imosonyi.bvtech.analyzer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hu.imosonyi.bvtech.analyzer.randomtext.ApiResponseProcessor;

@Configuration
public class ApiResponseProcessorConfig {
    
    @Bean
    public ApiResponseProcessor apiResponseProcessor () {
        return new ApiResponseProcessor();
    }

}
