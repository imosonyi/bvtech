package hu.imosonyi.bvtech.rest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import hu.imosonyi.bvtech.rest.impl.HistoryRestImpl;
import hu.imosonyi.bvtech.service.HistoryService;

@RunWith(MockitoJUnitRunner.class)
public class HistoryRestTest extends AbstractRestTest {

    @Mock
    private HistoryService historyService;

    @InjectMocks
    private HistoryRest historyRest = new HistoryRestImpl();

    @Test
    public void testGetTextShouldCallTextService () {
        when(Response.ok()).thenReturn(responseBuilder);
        when(historyService.getHistory()).thenReturn(Collections.emptyList());
        when(responseBuilder.entity(any(List.class))).thenReturn(responseBuilder);

        historyRest.getHistory();

        verify(historyService, times(1)).getHistory();
    }

}
