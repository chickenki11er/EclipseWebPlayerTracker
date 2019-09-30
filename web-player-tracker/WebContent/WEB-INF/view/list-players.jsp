<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
	<title>List Players</title>
	<link type="text/css" 
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Player list</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
			
			<!-- put new button "Add player" -->
			
			<input type="button" value="Add player"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button"	
			/>
			
			<!-- add search option -->
			
			<form:form action="search" method="GET">
				Search player:<input type="text" name="theSearchName"/>
				
			<input type="submit" value="Search" class="add-button"/>
			
			</form:form>
			
			<!--  add our html table here -->
			
			<table>
				<tr>
					<th>id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Club</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our players -->
				<c:forEach var="tempPlayer" items="${players}">
				
					<!-- construct the "update" link with player id -->
					<c:url var="updateLink" value="/Player/showFormForUpdate">
						<c:param name="playerId" value="${tempPlayer.id }"/>
					</c:url>
					
					<!-- construct the "delete" link with player id -->
					<c:url var="deleteLink" value="/Player/delete">
						<c:param name="playerId" value="${tempPlayer.id }"/>
					</c:url>
					
					<tr>
						<td> ${tempPlayer.id }</td>
						<td> ${tempPlayer.firstName}</td>
						<td> ${tempPlayer.lastName}</td>
						<td> ${tempPlayer.club}</td>
						
						<!-- display update link -->
						<td>
							<a href="${updateLink }">Update</a> 
							|
							<a href="${deleteLink }"
								onclick="if(!(confirm('Are you sure you want to delete this player?'))) return false">Delete</a>
							
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>

</body>

</html>