<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ include file="../layout/taglib.jsp" %>
 
<script type="text/javascript">
$(document).ready(function() {
	$(".triggerRemove").click(function(e) {
		e.preventDefault();
		$("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
		$("#modalRemove").modal();
	});
});
</script>


<form:form commandName="project" cssClass="form-horizontal">
<c:if test="${param.success eq true}">
		<div class="alert alert-success">Project created successfully!</div>
</c:if>
<c:if test="${param.delete eq true}">
		<div class="alert alert-success">Project deleted successfully!</div>
</c:if>

	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Name:</label>
		<div class="col-sm-10">
			<form:input path="name" class="form-control" />
			<form:errors path="name" />
		</div>
	</div>
	<div class="form-group">
		<label for="url" class="col-sm-2 control-label">URL:</label>
		<div class="col-sm-10">
			<form:input path="url" class="form-control" />
			<form:errors path="url" />
		</div>
	</div>

	<div class="form-group">
	    <label for="ux" class="col-sm-2 control-label"></label>
		<div class="col-sm-10">
			<input type="submit" value="Save" class="btn btn-lg btn-primary" />
			
		</div>
	</div>
</form:form>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Name</th>
			<th>URL</th>
			<th> Remove </th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${projects}" var="project">
			<tr>
				<td>
					<c:out value="${project.name}" />
				</td>
				<td>
					<c:out value="${project.url}" />
				</td>
				<td>
				   <a href="<spring:url value="/project/remove/${project.id}.html" />" class="btn btn-danger triggerRemove">
						remove
					</a>
				</td>
		    </tr>
		</c:forEach>
	</tbody>
</table>
  
<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Delete Project</h4>
      </div>
      <div class="modal-body">
        Do you want to delete this project?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <a href="" class="btn btn-danger removeBtn">Remove</a>
      </div>
    </div>
  </div>
</div>