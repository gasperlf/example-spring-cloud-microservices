package lf.com.serverconfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:application.properties")
public class ServerConfigApplicationTests {

    @Test
    public void contextLoads() {
        ServerConfigApplication.main(new String[] {"--api.profiles.mode=native"});
    }

}
