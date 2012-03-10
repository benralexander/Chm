<%@ page import="fam.OpticalStructureRecognition" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
    <g:javascript src="js2java.js" />
    <g:javascript src="marvin.js" />
    <g:set var="entityName" value="${message(code: 'chmHolder.label', default: 'OpticalStructureRecognition')}" />
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
    </ul>
</div>

<h2>Optical Structure Recognition</h2>
<table id="greetingstablewrapper2">
    <tr>
        <td width="100%">
            <g:if test="${werenew==0}">
                   Hello, anonymous user.  You are welcome to view this page,  but if you would like to actually convert molecules
                   then you'll need to  login. This is a fairly painless process: any username and password will be accepted -- if
                   that username has been used in the past then you will be referencing an existing account,  otherwise a new one
                   will be created for you.  As a courtesy we request that you use your e-mail address as your username ( if only
                   so that we might track who is using the system ), but this convention is not required.
                   <g:form  method="post" action="createNewLogin">
                        <table id="greetingstablewrapper">
                               <tr>
                                  <td>username</td>
                                  <td><g:textField name="user" field="username" /></td>
                                  <td></td>
                               </tr>
                               <tr>
                                  <td>password</td>
                                  <td><g:textField name="password" field="password" /></td>
                                  <td></td>
                               </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td><input type="submit"/></td>
                            </tr>
                       </table>
                   </g:form>
            </g:if>
            <g:else>
                Welcome back, "${username}"
            </g:else>

        </td>
    </tr>
</table>
<table id="tablewrapper">

    <tr>
        <td width="100%">

            <h5>While molecules are often presented in the literature using  some variation on the standard Kekule structure diagrams, those pictures  usually
            include no precise specification of  the atoms and bonds ( or at least none  that a computer can understand).  There have been several attempts, however,
            to  take these pictures and turn them into connection tables (see J Chem. Inf. Computer Science, 1992, 32, 373-378).  When these programs  do
            arise, moreover, they require a fair bit of work before they can actually be utilized by the chemist. On this page we implement  one of these algorithms
            (specifically <a
                    href="http://cactus.nci.nih.gov/osra/">OSRA</a>) and make it available  to anyone who can upload a PNG.
            </h5>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <table>
                <thead>
                <tr>
                    <th></th><th>Image must be in  PNG format</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>Image of molecules:</td>
                    <td>
                        <g:form  method="post" action="saveOsra" enctype="multipart/form-data">
                            <input type="file" name="payload"/>
                            <input type="submit"/>
                        </g:form>
                    </td>
                </tr>
                </tbody>
            </table>
        </td>
    </tr>
    <g:if test="${werenew!=0}">
    <tr>
        <td>
            <table>
                <thead>
                </thead>
                <tbody>
                <tr>
                    <td>SMILES  representation :</td>
                    <td>
                        ${foo}
                    </td>
                    <td>
                        <g:form name="create" action="show">
                            <g:hiddenField name="osraStructure"
                                           value="${foo}"/>
                            <g:actionSubmit value="Download molecule" action="show"/>
                        </g:form>
                    </td>
                </tr>
                <tr>
                    <td>Structure:</td>
                    <td colspan=2>
                        %{--msketch_begin("http://localhost:8080/ChemPortal/marvinbase/.", 440, 380);--}%
                        <script type="text/javascript">
                            <!--
                            msketch_name = "MSketch";
                            msketch_begin("/ChemPortal/js/marvinbase/.", 440, 380);
                            msketch_param("autoscale", "true");
                            msketch_param("bondDraggedAlong", "false");
                            msketch_param("isMyTemplatesEnabled", "false");
                            msketch_param("dispQuality", "1");
                            msketch_param("moreEnabled", "true");
                            msketch_param("template.2d", "false");
                            msketch_param("viewonly", "true");
                            msketch_param("undetachByX", "false");
                            msketch_param("menubar", "false");
                            msketch_param("mol", "${foo}");
                            msketch_end();
                            //-->
                        </script>
                        </td>
                    </tr>
                    </tbody>
                </table>

            </td>
        </tr>
    </g:if>
</table>

</body>
</html>
