package com.learning.rest.webservices.restfulwebservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

	private static final Info DEFAULT_API_INFO = new Info().title("Awesome API Title")
			.description("Awesome API Documentation")
			.version("1.0")
			.license(new License().name("Apache 2.0").url("http://www.apache.org/licenses/LICENSE-2.0"))
			.contact(new Contact().name("Ashish Nayak").email("ashish04021989@gmail.com"));
	
	@Bean
	public OpenAPI api() {
		return new OpenAPI().info(DEFAULT_API_INFO);
		
	}
	
	@Bean
	public LinkDiscoverers discovers() {
		List<LinkDiscoverer> plugins = new ArrayList<>();
		plugins.add(new CollectionJsonLinkDiscoverer());
		return new LinkDiscoverers(SimplePluginRegistry.create(plugins));
		
	}
}
