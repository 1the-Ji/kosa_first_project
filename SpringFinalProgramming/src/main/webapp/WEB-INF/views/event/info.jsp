<%@ page contentType="application/json;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
{
	"eventInfo":[
		<c:forEach var="eventInfo" items="${event}" varStatus="status">
		{
			"etitle":"${eventInfo.etitle}",
			"econtents":"${eventInfo.econtents}",
			"estartperiod":"${eventInfo.estartperiod}",
			"elastperiod":"${eventInfo.elastperiod}",
			"esavedfile":"${eventInfo.esavedfile}"
		}
		<c:if test="${!status.last}">,</c:if>
		</c:forEach>	
	]
}	