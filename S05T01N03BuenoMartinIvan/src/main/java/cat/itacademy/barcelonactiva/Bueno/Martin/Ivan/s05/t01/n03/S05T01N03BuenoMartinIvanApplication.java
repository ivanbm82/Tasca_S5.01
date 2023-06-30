package cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n03;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class S05T01N03BuenoMartinIvanApplication {

	public static void main(String[] args) {
		SpringApplication.run(S05T01N03BuenoMartinIvanApplication.class, args);
	}

	@Bean
	public WebClient.Builder webClientBuilder() {
		return WebClient.builder().baseUrl("http://localhost:9001");
	}
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Floristeria APIClient")
						.description("API para controlar una lista de Flores con SpringBoot desde otra API haciendo uso de WebClient")
						.contact(new Contact()
								.name("Iván Bueno")
								.email("iv13an15@gmail.com")));
	}
}

