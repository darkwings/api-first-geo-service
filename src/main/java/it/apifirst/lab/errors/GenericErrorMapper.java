package it.apifirst.lab.errors;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericErrorMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable t) {
        return Response.status(500).header("Content-Type", "application/problem+json")
                .entity(new ErrorResponse("Unexpected error", "Detected an unexpected error :" + t.getMessage(),
                        "ERR500", 500, null, null)).build();
    }
}
