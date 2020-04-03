package hu.imosonyi.bvtech.analyzer.randomtext;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.client.RestTemplate;

import hu.imosonyi.bvtech.analyzer.dto.ApiResponse;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ApiClient {

    private final RestTemplate restTemplate;

    public ApiClient (RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<ApiResponse> reqest (String path) {
        return CompletableFuture.supplyAsync(getRequest(path));
    }
    
    public Supplier<ApiResponse> reqestSupplier (String path) {
        return getRequest(path);
    }
    
    private Supplier<ApiResponse> getRequest (String path) {
        return () -> restTemplate.getForObject(ApiPathGenerator.BASE_URL + path, ApiResponse.class);
    }

}
