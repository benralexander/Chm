
<%@ page import="fam.PrincipalMomentOfInertiaPlot" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'principalMomentOfInertiaPlot.label', default: 'PrincipalMomentOfInertiaPlot')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
    <div class="nav" role="navigation">
        <ul>
            <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        </ul>
    </div>

    <h2>Chemistry portal</h2>

    <table id="tablewrapper">

       <tr>
            <td width="100%">
                <h3>PMI plot generation</h3>
                <h5>An interesting method of characterizing molecules involves  representing their respective Polar Moments of Inertia against one another.
                If you'd like to see such a plot, then provide an SDF file below  which contains two or more  molecules.  Your SDF file need include nothing
                beyond an connection  map, but be aware that generating a Polar Moment of Inertia (a.k.a. a PMI) plot requires  a three-dimensional
                conformation -- if you don't supply any 3-D SDF then that relaxed conformation  of the calculated for each, but if the number of molecules is large
                then that calculation may take a while.</h5>
                <g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
                </g:if>
                <table>
                    <thead>
                    <tr>
                        <th></th><th>2d or 3-d SDFs are acceptable</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <g:form controller="ChemHolderController" method="post" action="savePmi" enctype="multipart/form-data">
                            <td>Molecular file:</td>
                            <td><input type="file" name="payload"/></td>
                            <input type="submit"/>
                        </g:form>
                    </tr>
                    </tbody>
                </table>
            </td>
        </tr>
    </table>

</html>
