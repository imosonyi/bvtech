package hu.imosonyi.bvtech.analyzer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hu.imosonyi.bvtech.analyzer.randomtext.ParagraphAnalyzer;

@Configuration
public class ParagraphAnalyzerConfig {
    
    @Bean
    public ParagraphAnalyzer paragraphAnalyzer () {
        return new ParagraphAnalyzer();
    }

}
