package lf.com.customerservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:application.properties")
public class CustomerServiceApplicationTests {

    @Test
    public void contextLoads() {
        CustomerServiceApplication.main(new String[] {"--config-server.uri=http://localhost:8888",
                                                      "--service.registry.host=localhost"});
    }

}
