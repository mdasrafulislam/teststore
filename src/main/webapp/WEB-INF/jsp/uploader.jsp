<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>

<form:form commandName="uploader" cssClass="form-horizontal">

<table class="table table-bordered table-hover table-striped">
		<thead>
			<tr>
				<th></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<tr>
			   <td>
			       Project
			   </td>
			   <td>
			   :
			   </td>
			   <td>
			       <select id="ddpProject" name="ddlProject">
					    <option value="-1">----Select Project----</option>
					    <option value="1">archiva-all-maven-3.x</option>
					    <option value="2">ZooKeeper</option>
				   </select>            
			   </td>
			</tr>
			
			<tr>
			   <td>
			       Build Number
			   </td>
			   <td>:</td>
			   <td>
			     <input type="text" name="txtBuildNumber" />         
			   </td>
			</tr>
			<tr>
			    <td>
			    </td>
			    <td>
			    </td>
			    <td>
			        <input type="submit" value="Upload" class="btn btn-lg btn-primary" />   
			    </td>
			   
			    
			</tr>
			
		</tbody>
	</table>

</form:form>
