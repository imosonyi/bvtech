package hu.imosonyi.bvtech.randomtext;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import hu.imosonyi.bvtech.dto.ApiResponse;

public class ApiClient {

    private static WebTarget target = ClientBuilder.newClient().target(ApiPathGenerator.BASE_URL);
    
    public CompletableFuture<ApiResponse> request (String path) {
        return CompletableFuture.supplyAsync(getRequest(path));
    }
    
    public <R> CompletableFuture<R> request (String path, Function<ApiResponse, R> callBack) {
        return CompletableFuture.supplyAsync(getRequest(path)).thenApply(callBack);
    }
    
    private Supplier<ApiResponse> getRequest (String path) {
        return () -> target.path(path).request(MediaType.APPLICATION_JSON).get(ApiResponse.class);
    }
    
}
