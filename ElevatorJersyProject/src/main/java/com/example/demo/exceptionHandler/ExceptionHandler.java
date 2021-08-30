package com.example.demo.exceptionHandler;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import com.example.demo.model.InvalidOperationException;

public class ExceptionHandler implements ExceptionMapper<InvalidOperationException> {

	@Override
	public Response toResponse(InvalidOperationException exception) {
		// TODO Auto-generated method stub
		return Response.status(Status.NOT_FOUND)
				.entity( exception.getMessage())
				.build();
	}

}
