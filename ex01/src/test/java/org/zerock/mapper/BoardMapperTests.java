package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTests {
	@Setter(onMethod_=@Autowired)
	
	private BoardMapper boardMapper;
	
	/*
	 * @Test public void testGetList() {
	 * boardMapper.getList().forEach(board->log.info(board)); }
	 * 
	 * 
	 * @Test public void testInsert() { BoardVO board = new BoardVO();
	 * board.setTitle("새로작성하는 글"); board.setContent("새로 작성하는 내용");
	 * board.setWriter("newble"); boardMapper.insert(board);
	 * 
	 * log.info(board); }
	 * 
	 * @Test public void testInsertSelectKey() { BoardVO board = new BoardVO();
	 * board.setTitle("새로작성하는 글 셀렉트 키"); board.setContent("새로 작성하는 내용 셀렉트키");
	 * board.setWriter("newble"); boardMapper.insertSelectKey(board);
	 * 
	 * log.info(board); }
	 * 
	 * @Test public void testRead() { BoardVO board = boardMapper.read(6L);
	 * 
	 * log.info(board); }
	 */
	/*
	 * @Test public void testDelete() {
	 * log.info("Delete Count:"+boardMapper.delete(6L)); }
	 */
	
	/*
	 * @Test public void testPaging() { Criteria cri = new Criteria();
	 * List<BoardVO>list =boardMapper.getListWithPaging(cri);
	 * list.forEach(board->log.info(board)); }
	 */
	
	/*
	 * @Test public void testPaging() { Criteria cri = new Criteria();
	 * cri.setPageNum(3); cri.setAmount(10);
	 * 
	 * List<BoardVO>list = boardMapper.getListWithPaging(cri);
	 * list.forEach(board->log.info(board)); }
	 */
	
	@Test
	public void testSearch() {
		Criteria cri = new Criteria();
		cri.setKeyword("키워드");
		cri.setType("TCW");
		
		List<BoardVO> list = boardMapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board));
	}
}
