package hu.imosonyi.bvtech.rest.impl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import hu.imosonyi.bvtech.rest.HistoryRest;
import hu.imosonyi.bvtech.service.HistoryService;

/**
 * Implements the {@link HistoryRest} interface.
 *
 * @author István Mosonyi
 */
@RequestScoped
public class HistoryRestImpl implements HistoryRest {

    @Inject
    private HistoryService historyService;

    @Override
    public Response getHistory () {
        return Response
                .ok()
                .entity(historyService.getHistory())
                .build();
    }

}
