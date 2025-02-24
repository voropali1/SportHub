package cz.cvut.ear.clubevidence;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@OpenAPIDefinition(
//        info = @Info(
//                title = "Club Evidence"
//        )
//)
public class ClubEvidenceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClubEvidenceApplication.class, args);
    }
}
