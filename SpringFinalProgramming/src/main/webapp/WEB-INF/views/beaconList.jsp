<%@ page contentType="application/json;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

[
<c:forEach var="store" items="${store}" varStatus="status"><%-- list로 된 객체를 찾음 --%> 
<%-- varStatus="status" 루프정보를 담는 객체를 저장할 변수명을 값으로 갖는다. --%>
	{
		"sname":"${store.sname}",
		"slocal":"${store.slocal}",
		"saddr":"${store.saddr}",
		"stel":"${store.stel}",
		"sopen":"${store.sopen}",
		"sclosed":"${store.sclosed}",
		"sbeacon":"${store.sbeacon}"
	}
	<c:if test="${!status.last}">,</c:if><%-- 마지막 행 전까지 ','를 넣어라 --%>
</c:forEach>
]