package by.natashkinsasha.config;


import by.natashkinsasha.api.ApiOriginFilter;
import by.natashkinsasha.api.BookingRequestApi;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig{
    public JerseyConfig(){
        register(BookingRequestApi.class);
        register(ApiOriginFilter.class);
    }
}
