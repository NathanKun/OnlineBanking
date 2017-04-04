<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${not empty client}">
	<c:redirect url="./AccueilClient.jsp" />
	<h1>233</h1>
</c:if>
<c:if test="${empty client}">
	<h1>2333</h1>
</c:if>