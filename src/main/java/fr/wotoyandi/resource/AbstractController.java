package fr.wotoyandi.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public abstract class AbstractController{

    private static final Logger LOG
            = LoggerFactory.getLogger(AbstractController.class);

    protected static final String APPLICATION_JSON = MediaType.APPLICATION_JSON + ";charset=utf-8";

    private void throwWebApplicationException(String errorMessage) {
        LOG.error(errorMessage);
        throw new WebApplicationException(errorMessage, Response.Status.BAD_REQUEST);
    }
}
