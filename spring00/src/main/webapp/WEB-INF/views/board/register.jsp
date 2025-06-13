<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1>등록화면</h1>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">등록화면</div>
			<div class="panel-body">
				<form action="/board/register" method="post" role="form">
					<div class="form-group">
						<label>Title</label><input class="form-control" type="text"
							name="title">
					</div>
					<div class="form-group">
						<label>Text Area</label>
						<textarea class="form-control" rows="3" name="content"></textarea>
					</div>
					<div class="form-group">
						<label>Writer</label><input class="form-control" type="text"
							name="writer">
					</div>
					<button type="submit" class="btn btn-default">Submit Button</button>
					<button type="reset"  class="btn btbn-default">Reset Button</button>

				</form>
			</div>
		</div>
	</div>
	<!--  -->
</div>
<!-- row -->
<%@ include file="../includes/footer.jsp"%>
