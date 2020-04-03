package hu.imosonyi.bvtech.analyzer.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableAsync;

import hu.imosonyi.bvtech.analyzer.randomtext.TextResponseCalculator;

@Configuration
@EnableAsync
public class TextResponseCalculatorConfig {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public TextResponseCalculator textResponseCalculator () {
        return new TextResponseCalculator();
    }
    
}
