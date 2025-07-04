package org.zerock.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SampleTests {
	@Setter(onMethod_=@Autowired)
	private Restaurant restaurant;
	
	@Test
	public void testExist() {
		log.info(restaurant);
		log.info("-----------------------");
		log.info(restaurant.getChef());
	}
}
