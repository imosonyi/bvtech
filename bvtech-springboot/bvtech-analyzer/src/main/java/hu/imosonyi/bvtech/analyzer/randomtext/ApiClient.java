package hu.imosonyi.bvtech.analyzer.randomtext;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.client.RestTemplate;

import hu.imosonyi.bvtech.analyzer.dto.ApiResponse;

/**
 * Creates the asynchronous call to the RandomText API.
 *
 * @author István Mosonyi
 */
public class ApiClient {

    private final RestTemplate restTemplate;

    public ApiClient (RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    /**
     * Make request to RandomText API with the given path.
     *
     * @param path RandomText API URL path.
     * @return Asynchronous response from the API.
     */
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
