package trainproject.healthtogether;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HealthtogetherApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthtogetherApplication.class, args);
	}

}
