<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/publications_configuration/init.jsp" %>

<clay:container-fluid
	cssClass="container-form-lg"
>
	<aui:form action="<%= publicationsConfigurationDisplayContext.getActionURL() %>" method="post" name="fm">
		<aui:input name="navigation" type="hidden" value="<%= publicationsConfigurationDisplayContext.getNavigation() %>" />
		<aui:input name="redirectToOverview" type="hidden" value="<%= false %>" />

		<clay:sheet>
			<%@ include file="/publications_configuration/global_settings.jspf" %>
		</clay:sheet>
	</aui:form>
</clay:container-fluid>