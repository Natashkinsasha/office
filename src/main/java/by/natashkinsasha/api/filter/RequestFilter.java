package by.natashkinsasha.api.filter;



import org.glassfish.jersey.message.internal.ReaderWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Provider
@PreMatching
public class RequestFilter implements ContainerRequestFilter {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Context
    private HttpServletRequest request;
    @Override
    public void filter(ContainerRequestContext requestContext)  throws IOException
    {
        StringBuilder sb = new StringBuilder();
        sb.append(" Method: ").append(requestContext.getMethod());
        sb.append(" - Path: ").append(requestContext.getUriInfo().getPath());
        sb.append(" - Header: ").append(requestContext.getHeaders());
        sb.append(" - QueryParameters: ").append(requestContext.getUriInfo().getQueryParameters());
        sb.append(" - Body: ").append(getEntityBody(requestContext));
        logger.info("HTTP REQUEST : " + sb.toString());
    }



    private String getEntityBody(ContainerRequestContext requestContext)
    {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        InputStream in = requestContext.getEntityStream();

        final StringBuilder b = new StringBuilder();
        try
        {
            ReaderWriter.writeTo(in, out);

            byte[] requestEntity = out.toByteArray();
            if (requestEntity.length == 0) {
                b.append("");
            }
            else {
                b.append(new String(requestEntity));
            }
            requestContext.setEntityStream( new ByteArrayInputStream(requestEntity) );

        } catch (IOException ex) {
            logger.error("",ex);
        }
        return b.toString();
    }


}
