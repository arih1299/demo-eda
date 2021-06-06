package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import java.util.Base64;

@SpringBootApplication
@RestController
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	@Value("${BACKEND_URL}")
	private String backendurl;

	@Value("${BACKEND_USER}")
	private String username;

	@Value("${BACKEND_PASS}")
	private String password;

	@RequestMapping("/")
	public String home(@RequestBody String body) {
		log.info("Received request");
		ResponseEntity<String> response = new RestTemplate().exchange( backendurl, HttpMethod.POST, 
				new HttpEntity(body, createHeaders(username, password)), String.class);
		String backendres = response.getBody() == null ? response.getStatusCode().toString() : response.getBody();
		log.info("Received answer: " + backendres);
		return backendres;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	HttpHeaders createHeaders(String username, String password) {
             return new HttpHeaders() {{
                 String auth = username + ":" + password;
                 String authHeader = "Basic " + Base64.getEncoder().encodeToString(auth.getBytes());
                 set( "Authorization", authHeader );
             }};
        }
}

