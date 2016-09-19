<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<body>

<form action="main.jsp" method="POST">
Metrics: <input type="text" name="Metrics">
<br />
Dimension: <input type="text" name="Dimension" />
<br />
Dimensionfilter: <input type="text" name="Dimensionfilter">
<input type="submit" value="Submit" />

</form>
</body>
</html>