package org.zerock.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.TimeMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTest {
	@Setter(onMethod_ = @Autowired)
	private TimeMapper timemapper;
	
	@Test
	public void testGetTime() {
		log.info(timemapper.getClass().getName());
		log.info(timemapper.getTime());
	}
	
	@Test
	public void testGetTime2() {
		log.info("getTime2....--..getTime2...........");
		log.info(timemapper.getTime2());
	}
	
	
}
