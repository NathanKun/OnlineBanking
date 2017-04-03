<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${not empty client}">
	<c:redirect url="./AccueilClient.jsp" />
</c:if>