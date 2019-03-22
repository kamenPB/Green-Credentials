package com.Green.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void month() throws IOException {
		final int expected = 1;
		final int actual = (int) ConsumptionData.getLastMonth();
		Assert.assertEquals(actual,expected);
	}

}
