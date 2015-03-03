package de.gzockoll.prototype.assets;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AssetManagerApplication.class)
@WebAppConfiguration
public class AssetManagerApplicationTests {

	@Test
	public void contextLoads() {
        assertThat(true).isTrue();
	}

}
