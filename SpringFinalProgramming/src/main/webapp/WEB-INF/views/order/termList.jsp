<%@ page contentType="application/json;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

{
	"termList": [
		<c:forEach var="term" items="${termList}" varStatus="status">
		{
			"ogid":"${term.ogid}",
			"user_id":"${term.user_id}",
			"ogtime":"${term.ogtime}",
			"ogtotalprice":"${term.ogtotalprice}",
			"oghowpay":"${term.oghowpay}"
		}
		<c:if test="${!status.last}">,</c:if>
		</c:forEach>
	],
	
	"pageNo":${pageNo},
	"rowsPerPage": ${rowsPerPage},
	"pagesPerGroup": ${pagesPerGroup},
	"totalBoardNo": ${totalBoardNo},
	"totalPageNo": ${totalPageNo},
	"totalGroupNo": ${totalGroupNo},
	"groupNo": ${groupNo},
	"startPageNo": ${startPageNo},
	"endPageNo": ${endPageNo}
}