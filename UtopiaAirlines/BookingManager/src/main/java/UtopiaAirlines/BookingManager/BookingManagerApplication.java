package UtopiaAirlines.BookingManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BookingManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingManagerApplication.class, args);
	}

}
