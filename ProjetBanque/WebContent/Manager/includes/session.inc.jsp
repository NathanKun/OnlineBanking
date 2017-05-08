<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty manager}">
	<c:redirect url="./login.jsp" />
</c:if>