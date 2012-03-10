
<%@ page import="fam.OpticalStructureRecognition" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'chmHolder.label', default: 'OpticalStructureRecognition')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-chmHolder" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-chmHolder" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list chmHolder">
			
				<g:if test="${chmHolderInstance?.multipartFile}">
				<li class="fieldcontain">
					<span id="multipartFile-label" class="property-label"><g:message code="chmHolder.multipartFile.label" default="Multipart File" /></span>
					
						<span class="property-value" aria-labelledby="multipartFile-label"><g:fieldValue bean="${chmHolderInstance}" field="multipartFile"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${chmHolderInstance?.molHolderList}">
				<li class="fieldcontain">
					<span id="molHolderList-label" class="property-label"><g:message code="chmHolder.molHolderList.label" default="Mol Holder List" /></span>
					
						<g:each in="${chmHolderInstance.molHolderList}" var="m">
						<span class="property-value" aria-labelledby="molHolderList-label"><g:link controller="molHolder" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${chmHolderInstance?.id}" />
					<g:link class="edit" action="edit" id="${chmHolderInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
