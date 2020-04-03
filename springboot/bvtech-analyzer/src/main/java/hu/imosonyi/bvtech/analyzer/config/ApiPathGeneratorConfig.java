package hu.imosonyi.bvtech.analyzer.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import hu.imosonyi.bvtech.analyzer.randomtext.ApiPathGenerator;

@Configuration
public class ApiPathGeneratorConfig {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ApiPathGenerator apiPathGenerator () {
        return new ApiPathGenerator();
    }

}
