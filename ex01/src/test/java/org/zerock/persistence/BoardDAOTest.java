package org.zerock.persistence;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardDAOTest {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;

	
	  @Test public void testInsertMassive() { log.info("대량 데이터 등록 테스트 시작");
	  
	  for (int i = 1; i <= 3000; i++) { BoardVO vo = new BoardVO(); vo.setTitle(i +
	  "번째 테스트 게시물!!"); vo.setContent(i + "번째 게시물 내용입니다~~"); vo.setWriter("user" +
	  (i % 100));
	  
	  boardMapper.insert(vo); }
	  
	  log.info("대량 데이터 등록 테스트 완료"); }
	 
	/*
	 * @Test public void testGet() {
	 * 
	 * long targetBno = 100L; // 조회할 게시물 번호 (L을 붙여 Long 타입으로 지정)
	 * 
	 * log.info("조회 테스트 시작: " + targetBno + "번 게시물을 조회합니다.");
	 * 
	 * 
	 * BoardVO vo = boardMapper.read(targetBno);
	 * 
	 * 
	 * assertNotNull(vo);
	 * 
	 * 
	 * log.info("======= 조회 결과 ======="); log.info(vo);
	 * log.info("======================="); } //
	 */

	/*
	 * @Test public void testUpdate() {
	 * 
	 * long targetBno = 1L; // 수정할 게시물 번호
	 * 
	 * // 1. 먼저 수정할 게시물이 있는지 확인하고 가져옵니다. BoardVO vo = boardMapper.read(targetBno);
	 * 
	 * // 게시물이 없을 경우를 대비한 방어 코드 if (vo == null) { log.warn(targetBno +
	 * "번 게시물이 존재하지 않아 수정을 중단합니다."); return; }
	 * 
	 * log.info("수정 전 데이터: " + vo);
	 * 
	 * 
	 * vo.setTitle("1번 게시물 제목 수정!!!"); vo.setContent("1번 게시물 내용도 수정합니다.");
	 * 
	 * int updateCount = boardMapper.update(vo);
	 * 
	 * 
	 * assertEquals(1, updateCount);
	 * 
	 * log.info("UPDATE COUNT: " + updateCount);
	 * 
	 * BoardVO updatedVo = boardMapper.read(targetBno); log.info("수정 후 데이터: " +
	 * updatedVo);
	 * 
	 * assertEquals("1번 게시물 제목 수정!!!", updatedVo.getTitle()); }
	 */

}