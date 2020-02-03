package ${package};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * This is the main entry point of Spring Cloud Config Server.
 * @param args
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}

	@Autowired
    @Bean
    public WebSecurityConfigurerAdapter configurationServerWebSecurity(final ServerProperties serverProperties) {
        return new WebSecurityConfigurerAdapter() {
        	
        	 @Override
        	    protected void configure(HttpSecurity http) throws Exception {
        	        http.csrf().disable().authorizeRequests()
        	        .anyRequest().authenticated().and()
        	        .httpBasic();
        	    }
        };
	}
	
}
