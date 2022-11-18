package jonsilvestrini.BFFSOA.config.documentation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI api() {
		return new OpenAPI()
				.info(new Info().title("BFF SOA")
				.description("API BFF para integração de serviços. Matéria de Arquitetura Orientada a Serviços - Fatec Araras")
				.version("1.0")
				);
	}



}
