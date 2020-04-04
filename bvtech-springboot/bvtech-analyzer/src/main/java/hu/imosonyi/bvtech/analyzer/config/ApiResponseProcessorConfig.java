package hu.imosonyi.bvtech.analyzer.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import hu.imosonyi.bvtech.analyzer.randomtext.ApiResponseProcessor;

/**
 * Configures {@link ApiResponseProcessor} bean.
 *
 * @author István Mosonyi
 */
@Configuration
public class ApiResponseProcessorConfig {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ApiResponseProcessor apiResponseProcessor () {
        return new ApiResponseProcessor();
    }

}
