package com.Green.demo;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests extends ConsumptionData{

	@Test
	public void contextLoads() {
	}

//	@Test
//	public void fileLoaded() throws IOException {
//		final XSSFWorkbook expected = new XSSFWorkbook(new FileInputStream("..//data.xlsx"));
//		final XSSFWorkbook actual = getWorkbookFromExcelFile();
//		Assert.assertEquals(actual,expected);
//	}

	@Test
	public void month() {
		final int expected = 2; // 2 == February
		final int actual = getLastMonth();
		Assert.assertEquals(actual,expected);
	}

	@Test
	public void year() {
		final String expected = "2017";
		final String actual = getTwoYearsAgo();
		Assert.assertEquals(actual,expected);
	}

//	@Test
//	public void comment() throws IOException {
//		final String expected = "2017";
//		final String actual = (String) ConsumptionData.comment("waste");
//		Assert.assertEquals(actual,expected);
//	}

}
