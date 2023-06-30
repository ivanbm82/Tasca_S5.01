package cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n02;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@OpenAPIDefinition
public class S05T01N02BuenoMartinIvanApplication {

	public static void main(String[] args) {
		SpringApplication.run(S05T01N02BuenoMartinIvanApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Floristeria API")
						.description("API para controlar una lista de Flores con SpringBoot")
						.contact(new Contact()
								.name("Iván Bueno")
								.email("iv13an15@gmail.com")));
	}
}
