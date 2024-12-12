package lab_manager.com.br;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {"spring.datasource.url=jdbc:h2:mem:testdb"})
class LabManagerApiApplicationTests {

	@Test
	void contextLoads() {
	}

}
