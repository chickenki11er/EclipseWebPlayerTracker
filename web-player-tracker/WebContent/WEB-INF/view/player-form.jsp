<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Player</title>
	
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath }/resources/css/style.css"/>
		
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath }/resources/css/addplayerstyle.css"/>
		
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>PRM- Player Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Player</h3>
		
		<form:form action="savePlayer" modelAttribute="player" method="POST">
			
			<!-- need to associate this data with player id -->
			<form:hidden path="id"/>
			
			<table>
				<tbody>
					
					<tr>
						<td><label>First Name:</label></td>
						<td><form:input path="firstName"/></td> 
					</tr>
					
					<tr>
						<td><label>Last Name:</label></td>
						<td><form:input path="lastName"/></td> 
					</tr>
					
					<tr>
						<td><label>Club:</label></td>
						<td><form:input path="club"/></td> 
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td> 
					</tr>
				</tbody>
			</table>
			
		</form:form>
		
		<div style="clear; both;"></div>
		
		<p>
			<a href="${PageContext.request.contextPath }/web-player-tracker/Player/list">Back to list</a>
		</p>
		
	</div>


</body>

</html>