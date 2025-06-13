package org.zerock.service;


import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServiceTests {
	@Setter(onMethod_=@Autowired)
	private BoardService service;
	
//	@Test
//	public void testExist() {
//		assertNotNull(service);
//	}
	
	/*
	 * @Test public void testRegister() { BoardVO board = new BoardVO();
	 * board.setTitle("새로작성하는 글"); board.setContent("새로 작성하는 내용");
	 * board.setWriter("newble"); service.register(board);
	 * 
	 * log.info("생성된 게시물번호:" + board.getBno());
	 * 
	 * }
	 * 
	 * @Test public void testGet() { log.info(service.get(1l)); }
	 * 
	 * @Test public void testGetList() {
	 * service.getList().forEach(board->log.info(board)); }
	 * 
	 * @Test public void testUpdate() { BoardVO board = service.get(1L);
	 * if(board==null) return; board.setBno(1L); board.setTitle("제목을 변경합니다.");
	 * board.setContent("변경된내용"); board.setWriter("user100");
	 * 
	 * log.info("결과:" +service.modify(board)); }
	 * 
	 * @Test public void testDelete() { log.info("Delete 결과:" + service.remove(3L));
	 * }
	 */
	/*
	 * @Test public void insertTest() throws Exception { for (int i = 1; i <= 3000;
	 * i++) { BoardVO vo = new BoardVO(); vo.setTitle(i + "번째 테스트 게시물!!");
	 * vo.setContent(i + "번째 게시물 내용입니다~~"); vo.setWriter("user" + i);
	 * boardDAO.insert(vo); log.info(boardDAO); } }
	 */
	@Test
	public void testGetList() {
		service.getList(new Criteria(2,10)).forEach(board->log.info(board));
	}
}
