<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ include file="../layout/taglib.jsp" %>


<form:form commandName="project" cssClass="form-horizontal">
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
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${projects}" var="project">
			<tr>
				<td>
					<c:out value="${project.name}" />
				</td>
		    </tr>
		</c:forEach>
	</tbody>
</table>
  
