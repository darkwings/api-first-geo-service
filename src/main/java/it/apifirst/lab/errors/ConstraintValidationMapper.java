package it.apifirst.lab.errors;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.stream.Collectors;


@Provider
public class ConstraintValidationMapper implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException e) {
        var invalidParams = e.getConstraintViolations().stream()
                .map(constraintViolation -> new InvalidParam(constraintViolation.getPropertyPath().toString(),
                        constraintViolation.getMessage()))
                .collect(Collectors.toList());
        return Response.status(Response.Status.BAD_REQUEST).header("Content-Type", "application/problem+json")
                .entity(new ErrorResponse("Bad request", "Malformed request",
                        "ERR400", Response.Status.BAD_REQUEST.getStatusCode(),
                        invalidParams, null)).build();
    }
}
