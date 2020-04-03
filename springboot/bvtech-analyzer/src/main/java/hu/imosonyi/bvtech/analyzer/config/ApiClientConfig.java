package hu.imosonyi.bvtech.analyzer.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import hu.imosonyi.bvtech.analyzer.randomtext.ApiClient;

@Configuration
public class ApiClientConfig {
    
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ApiClient apiClient (RestTemplateBuilder builder) {
        return new ApiClient(builder);
    }

}
