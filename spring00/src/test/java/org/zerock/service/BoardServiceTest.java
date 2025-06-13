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
        assert service != null : "BoardService�� null�Դϴ�.";
    }

    @Test
    public void testRegister() {
        BoardVO board = new BoardVO();
        board.setTitle("���� �׽�Ʈ ����");
        board.setContent("���� �׽�Ʈ ����");
        board.setWriter("test");

        service.register(board);
        log.info("������ �Խù� ��ȣ: " + board.getBno());
    }
    
    @Test
    public void testGet() {
        BoardVO board = service.get(1L); //�����ϴ� ��ȣ
        log.info(board);
    }
    
    @Test
    public void testGetList1() {
        service.getList().forEach(board -> log.info(board));
    }

    @Test
    public void testDelete() {
        log.info("���� ���: " + service.remove(1L));
    }

    @Test
    public void testUpdate() {
        BoardVO board = service.get(1L); 
        if (board == null) {
            log.warn("�Խù��� �������� ����");
            return;
        }

        board.setBno(1L);
        board.setTitle("(����) ���� ����.....");
        board.setContent("(����) ���� ����.....");
        board.setWriter("user100");
        log.info("���:"+service.modify(board));
        
       /* boolean result = service.modify(board);
        log.info("���� ���: " + result);*/
    }
    
    @Test
    public void testGetList() {
    	service.getList(new Criteria(2,10)).forEach(board ->log.info(board));;
    }
    
    
}
