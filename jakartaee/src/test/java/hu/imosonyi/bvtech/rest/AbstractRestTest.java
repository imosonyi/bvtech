package hu.imosonyi.bvtech.rest;

import static org.mockito.Mockito.when;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.RuntimeDelegate;

import org.junit.Before;
import org.mockito.Mock;

public abstract class AbstractRestTest {

    @Mock
    protected Response response;

    @Mock
    protected ResponseBuilder responseBuilder;

    @Mock
    protected RuntimeDelegate runtimeDelegate;

    @Before
    public void setUp () {
        RuntimeDelegate.setInstance(runtimeDelegate);
        when((runtimeDelegate).createResponseBuilder()).thenReturn(responseBuilder);
    }

}
