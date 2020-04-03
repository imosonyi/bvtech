package hu.imosonyi.bvtech.analyzer.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hu.imosonyi.bvtech.analyzer.randomtext.ApiClient;

@Configuration
public class ApiClientConfig {
    
    @Bean
    public ApiClient apiClient (RestTemplateBuilder builder) {
        return new ApiClient(builder);
    }

}
