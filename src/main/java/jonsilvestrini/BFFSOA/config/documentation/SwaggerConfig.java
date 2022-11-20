package jonsilvestrini.BFFSOA.config.documentation;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI api() {
		return new OpenAPI()
				.info(new Info().title("BFF SOA")
				.description("API BFF para integração de serviços. Matéria de Arquitetura Orientada a Serviços - Fatec Araras")
				.version("1.0")
				)
				.components(new Components().addSecuritySchemes("bearer-jwt",
		                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")
		                    .in(SecurityScheme.In.HEADER).name("Authorization")))
				.addSecurityItem(
	                    new SecurityRequirement().addList("bearer-jwt", Arrays.asList("read", "write")));
	}



}
