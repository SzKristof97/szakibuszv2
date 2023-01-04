package me.szaki.szakibuszv2.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAPI configuration class
 */
@Configuration
public class OpenAPIConfig {

    /**
     * Creates the description of the API
     * @return the OpenAPI object
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SZAKIBUSZ - API")
                        .version("1.0.0")
                        .description(
                                "This API is used to manage the users, tickets and the transactions.</br>"
                        )
                        .license(new License().name("GNU General Public License V3.0").url("https://github.com/SzKristof97/szakibuszv2/blob/main/LICENSE"))
                        .contact(new Contact().name("Szabó Kristóf Gyula").email("szkristof97.gyula@gmail.com"))
                        .contact(new Contact().name("Jankovics Szilárd").email("jankovicsszilard@gmail.com"))
                );
    }
}
