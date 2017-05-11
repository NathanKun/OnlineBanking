<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty client}">
	<c:redirect url="./login.jsp" />
</c:if>