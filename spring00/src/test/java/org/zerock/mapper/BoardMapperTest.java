package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTest {
	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;
	
	
	@Test 
	public void testGetList() {
	System.out.println("리스트출력");
	boardMapper.getList().forEach(board->log.info(board)); }
	  
	@Test 
	public void testInsert() {
	  
	  BoardVO board = new BoardVO(); 
	  board.setTitle("새로 작성하는 글");
	  board.setContent("새로 작성하는 내용"); 
	  board.setWriter("newbie");
	  
	  boardMapper.insert(board);
	  
	  log.info(board); }
	  
	@Test 
	public void testInsertSelectKey() {
	  
	  BoardVO board = new BoardVO(); 
	  board.setTitle("새로 작성하는 글 SelectKey");
	  board.setContent("새로 작성하는 내용 SelectKey"); 
	  board.setWriter("newbie");
	  
	  boardMapper.insertSelectKey(board);
	  
	  log.info(board); }
	 
	@Test
	public void testRead() {
		  BoardVO board = boardMapper.read(6L);
		
		  log.info(board);
	}
	
	@Test
	public void testDelete() {
		  int count = boardMapper.delete(6L);
		  
		  log.info("Delete Count:"+boardMapper.delete(6L));
	  }
	  
	 @Test
	 public void update() {		  
		  BoardVO board = new BoardVO();
		  board.setBno(6L); // 수정할 게시글 번호
		  board.setTitle("수정된 제목");
		  board.setContent("수정된 내용");
		  board.setWriter("editor");

		  int count = boardMapper.update(board);
		  log.info("Update Count: " + count);

	  }
	 
	 /* @Test
	 public void testPaging() {
		 Criteria cri=new Criteria();
		 List<BoardVO> list= boardMapper.getListWithPaging(cri);
		 
		 list.forEach(board->log.info(board));
	 } */
	 
	 @Test
	 public void testPaging() {
		 Criteria cri=new Criteria();
		 cri.setPageNum(3);
		 cri.setAmount(10);
		 
		 List<BoardVO> list=boardMapper.getListWithPaging(cri);
		 list.forEach(board->log.info(board));
	 }
			   
	  
} 
