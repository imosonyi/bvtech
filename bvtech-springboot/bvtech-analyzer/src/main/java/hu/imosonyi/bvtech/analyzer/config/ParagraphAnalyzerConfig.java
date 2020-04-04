package hu.imosonyi.bvtech.analyzer.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import hu.imosonyi.bvtech.analyzer.randomtext.ParagraphAnalyzer;

@Configuration
public class ParagraphAnalyzerConfig {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ParagraphAnalyzer paragraphAnalyzer () {
        return new ParagraphAnalyzer();
    }

}
