<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1>Board Read</h1>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Read Page</div>
			<div class="panel-body">

				<div class="form-group">
					<label>Bno</label><input class="form-control" type="text"
						name="bno" value="${board.bno}" readonly="readonly">
				</div>
				<div class="form-group">
					<label>Title</label><input class="form-control" type="text"
						name="title" value="${board.title }" readonly="readonly">
				</div>
				<div class="form-group">
					<label>Text Area</label>
					<textarea class="form-control" rows="3" name="content"
						readonly="readonly"><c:out value="${board.content}" /></textarea>
				</div>
				<div class="form-group">
					<label>Writer</label><input class="form-control" type="text"
						name="writer" value="${board.writer }" readonly="readonly">
				</div>

				<button data-oper='modify' class="btn btn-default">
					<a>Modify</a>  <%-- href="/board/modify?bno=<c:out value="${board.bno}"/>" --%>
				</button>
				<button data-oper='list' class="btn btn-info">
					<a>List</a>  <!-- href="/board/list" a태그 안에 있었는데 modift.jsp에 작성하면서 지움-->
				</button>

				<form id='operForm' action="/boad/modify" method="get">
					<input type='hidden' id='bno' name='bno'
						value='<c:out value="${board.bno}"/>'>
				</form>
			</div>
		</div>
	</div>
	<!--  -->
</div>
<!-- row -->
<script type="text/javascript">
$(document).ready(function() {
  
  var operForm = $("#operForm"); 
  
  $("button[data-oper='modify']").on("click", function(e){
    
    operForm.attr("action","/board/modify").submit();
    
  });
  $("button[data-oper='list']").on("click", function(e){
	    
	    operForm.find("#bno").remove();
	    operForm.attr("action","/board/list")
	    operForm.submit();
	    
	  });  
	});
	</script>

<%@ include file="../includes/footer.jsp"%>
