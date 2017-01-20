package by.natashkinsasha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class OfficeApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new OfficeApplication()
				.configure(new SpringApplicationBuilder(OfficeApplication.class))
				.run(args);
	}
}
