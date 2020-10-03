package dist.ai.backend;

import dist.ai.backend.database.VoteContext;
import dist.ai.backend.model.Vote;
import dist.ai.backend.services.TimerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Timer;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    public TimerService TimerService() {
        return new TimerService();
    }

    @Bean
    public VoteContext VoteContext() {
        return new VoteContext();
    }
}
