package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTest {

    @Setter(onMethod_ = @Autowired)
    private BoardService service;

    @Test
    public void testExist() {
        log.info(service);
        assert service != null : "BoardService가 null입니다.";
    }

    @Test
    public void testRegister() {
        BoardVO board = new BoardVO();
        board.setTitle("서비스 테스트 제목");
        board.setContent("서비스 테스트 내용");
        board.setWriter("test");

        service.register(board);
        log.info("생성된 게시물 번호: " + board.getBno());
    }
    
    @Test
    public void testGet() {
        BoardVO board = service.get(1L); //존재하는 번호
        log.info(board);
    }
    
    @Test
    public void testGetList1() {
        service.getList().forEach(board -> log.info(board));
    }

    @Test
    public void testDelete() {
        log.info("삭제 결과: " + service.remove(1L));
    }

    @Test
    public void testUpdate() {
        BoardVO board = service.get(1L); 
        if (board == null) {
            log.warn("게시물이 존재하지 않음");
            return;
        }

        board.setBno(1L);
        board.setTitle("(서비스) 제목 변경.....");
        board.setContent("(서비스) 내용 변경.....");
        board.setWriter("user100");
        log.info("결과:"+service.modify(board));
        
       /* boolean result = service.modify(board);
        log.info("수정 결과: " + result);*/
    }
    
    @Test
    public void testGetList() {
    	service.getList(new Criteria(2,10)).forEach(board ->log.info(board));;
    }
    
    
}
