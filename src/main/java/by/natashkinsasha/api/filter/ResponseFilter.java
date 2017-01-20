package by.natashkinsasha.api.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class ResponseFilter implements ContainerResponseFilter {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Context
    private HttpServletResponse response;
    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        HttpServletResponse res = (HttpServletResponse) response;
        res.addHeader("Access-Control-Allow-Origin", "*");
        res.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        res.addHeader("Access-Control-Allow-Headers", "Content-Type");
        StringBuilder sb = new StringBuilder();
        sb.append("Header: ").append(containerResponseContext.getHeaders());
        sb.append(" - Body ").append(containerResponseContext.getEntity());
        logger.info("HTTP RESPONSE : " + sb.toString());
    }
}
