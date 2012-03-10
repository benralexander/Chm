<%@ page import="fam.OpticalStructureRecognition" %>



<div class="fieldcontain ${hasErrors(bean: chmHolderInstance, field: 'multipartFile', 'error')} ">
	<label for="multipartFile">
		<g:message code="chmHolder.multipartFile.label" default="Multipart File" />
		
	</label>
	
</div>

<div class="fieldcontain ${hasErrors(bean: chmHolderInstance, field: 'molHolderList', 'error')} ">
	<label for="molHolderList">
		<g:message code="chmHolder.molHolderList.label" default="Mol Holder List" />
		
	</label>
	<g:select name="molHolderList" from="${fam.MolHolder.list()}" multiple="multiple" optionKey="id" size="5" value="${chmHolderInstance?.molHolderList*.id}" class="many-to-many"/>
</div>

