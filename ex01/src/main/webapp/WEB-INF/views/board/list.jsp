<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
    <%@include file="../include/header.jsp" %>
    
  <div class="row">
<div class="col-lg-12">
<div class="page-header"> tables</div>
</div>
</div>
<div class="row">
<div class="col-lg-12">
<div class="panel panel-default">
<div class="panel">
<div class="panel-heading">Boardlist page......</div>
<div class="panel-body">
<table class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th>#번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>수정일</th>
		</tr>
	</thead>
	<c:forEach items="${list}" var="board">
		<tr>
			<%-- <td><c:out value="${board.bno}" /></td>
			<td><c:out value="${board.title}" /></td>
			<td><a href='/board/get?bno=<c:out value="${board.bno}"/>'><c:out value="${board.title}"/></a></td>
			<td><c:out value="${board.writer}" /></td>
			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regDate}"/></td>
			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}"/></td> --%>
			<tr>
  <td><c:out value="${board.bno}"/></td>
 <%--  <td><a href='/board/get?bno=<c:out value="${board.bno}"/>'><c:out value="${board.title}"/></a></td> --%>

 <!-- list 명령시 원래 페이지로 이동 move클래스로 변경하여 스크립트코드 작성 -->
 <td><a class='move' href='<c:out value="${board.bno}"/>'>
 	<c:out value="${board.title}" />
 </a> </td>
  <td><c:out value="${board.writer}"/></td>
  <td><fmt:formatDate pattern = "yyyy-MM-dd" value = "${board.regDate}" /></td>
  <td><fmt:formatDate pattern = "yyyy-MM-dd" value = "${board.updateDate}" /></td>  
</tr>
			
	</c:forEach>
</table>

<div class='row'>
<div class="col-lg-12">
	<form id='searchForm' action="/board/list" method='get'>
		<select name='type'>
		<option value="">--</option>
				<option value="T">제목</option>
				<option value="C">내용</option>
				<option value="W">작성자</option>
				<option value="TC">제목 or 내용</option>
				<option value="TW">제목 or 작성자</option>
				<option value="TWC">제목 or 내용 or작성자</option>
				</select>
				<input type="text" name="keyword" />
				<input type="hidden" name="pageNum" value='${pageMaker.cri.pageNum}' />
				<input type="hidden" name="amount" value='${pageMaker.cri.amount}' />
		<button class="btn btn-default">search</button>		
	</form>
</div>
</div>

<!--paging  -->
<div class="pull-right">
<div class="pagination">
<c:if test="${pageMaker.prev}">
<li class="paginate_button previous" ><a href="${pageMaker.startPage-1}">Previous</a></li>
</c:if>
<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
<li class="paginate_button ${pageMaker.cri.pageNum == num ? "active":""}">
<a href="${num}">${num}</a></li>
</c:forEach>
<c:if test="${pageMaker.next}">
<li class="paginate_button next" ><a href="${pageMaker.endPage+1}">Next</a></li>
</c:if>
</div> <!--  end pagination -->
<form id='actionForm' action="/board/list" method='get'>
  <input type='hidden' name='pageNum' value = '${pageMaker.cri.pageNum}'>
  <input type='hidden' name='amount' value = '${pageMaker.cri.amount}'>
</form>
</div>
<!-- Modal  추가 -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">Modal title</h4>
						</div>
						<div class="modal-body">처리가 완료되었습니다.</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
							<button type="button" class="btn btn-primary" data-dismiss="modal">Save
								changes</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
  $(document).ready(function() {
 
    var result = '<c:out value="${result}"/>';
 	checkModal(result);
	history.replaceState({},null,null);    
    function checkModal(result){
 
      if (result === '' || history.state) {
      
    	  return;
      }
 
      if (parseInt(result) > 0) {
        $(".modal-body").html(
            "게시글 " + parseInt(result) + " 번이 등록되었습니다.");
      }
       $("#myModal").modal("show");
    }    
 	$("#regBtn").on("click",function(){
	self.location = "/board/register";
});
//a 이벤트처리

	var actionForm=$("#actionForm");
	$(".paginate_button a").on("click",function(e){
		e.preventDefault();
		//<form>태그의 내용 변경후 submit
	      actionForm.find("input[name='pageNum']").val($(this).attr("href"));
	      actionForm.submit();

	})
	
	$(".move").on("click",function(e){
			e.preventDefault();
	      actionForm.append("<input type='hidden' name='bno' value='"+ $(this).attr("href")+"'>");
	      actionForm.attr("action","/board/get");
	      actionForm.submit();

	})
	
	var searchForm=$("#searchForm");
	$("#searchForm").on("click",function(e) {
		if(!searchForm.find("option:selected").val()) {
			alert("검색종류를 선택하세요");
			return false;
		}
		
		if(!searchForm.find("input[name='keyword']").val()) {
			alert("키워드를 입력하세요");
			return false;
		}
		
		searchForm.find("input[name='pageNum']").val("1");
		e.preventDefault();
		
		searchForm.submit();
	})

  });
</script>

<%@include file="../include/footer.jsp"%>