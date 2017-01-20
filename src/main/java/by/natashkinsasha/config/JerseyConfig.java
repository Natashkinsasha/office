package by.natashkinsasha.config;


import by.natashkinsasha.api.BookingRequestApi;
import by.natashkinsasha.api.filter.RequestFilter;
import by.natashkinsasha.api.filter.ResponseFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig{
    public JerseyConfig(){
        packages("by.natashkinsasha.api.filter;by.natashkinsasha.api");
        register(RequestFilter.class);
        register(BookingRequestApi.class);
        register(ResponseFilter.class);

    }
}
