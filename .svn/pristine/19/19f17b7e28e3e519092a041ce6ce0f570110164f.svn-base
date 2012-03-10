<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>
		<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 1em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}

			#page-body {
				margin: 2em 1em 1.25em 18em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>
	</head>
	<body>
		<div id="status" role="complementary" style="display:none">
			<h1>Application Status</h1>
			<ul>
				<li>App version: <g:meta name="app.version"/></li>
				<li>Grails version: <g:meta name="app.grails.version"/></li>
				<li>Groovy version: ${org.codehaus.groovy.runtime.InvokerHelper.getVersion()}</li>
				<li>JVM version: ${System.getProperty('java.version')}</li>
				<li>Controllers: ${grailsApplication.controllerClasses.size()}</li>
				<li>Domains: ${grailsApplication.domainClasses.size()}</li>
				<li>Services: ${grailsApplication.serviceClasses.size()}</li>
				<li>Tag Libraries: ${grailsApplication.tagLibClasses.size()}</li>
			</ul>
			<h1>Installed Plugins</h1>
			<ul>
				<g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">
					<li>${plugin.name} - ${plugin.version}</li>
				</g:each>
			</ul>
		</div>
		<div id="page-body" role="main">
            <h1>Welcome to the Utility For Organic Chemists web site</h1>
            <p>As of late it started compiling some of my favorite utilities and fronting them with a
            web interface, in the hope of providing chemists with some of the computer-based tools
            that can help make life easier. The list is currently short,  but expected to grow. Please
            feel free to use these utilities for your own purposes, and drop me a  <a href="mailto:benjamin.alexander96@yahoo.com">note</a> if you find
            anything on this site to be of particular value.
                </p>
            <div id="controller-list" role="navigation">
                <h2>Current list of  surfaced capabilities as of:
                    <script type="text/javascript">
                        <!--

                        var d_names = new Array("Sunday", "Monday", "Tuesday",
                                "Wednesday", "Thursday", "Friday", "Saturday");

                        var m_names = new Array("January", "February", "March",
                                "April", "May", "June", "July", "August", "September",
                                "October", "November", "December");

                        var d = new Date();
                        var curr_day = d.getDay();
                        var curr_date = d.getDate();
                        var sup = "";
                        if (curr_date == 1 || curr_date == 21 || curr_date ==31)
                        {
                            sup = "st";
                        }
                        else if (curr_date == 2 || curr_date == 22)
                        {
                            sup = "nd";
                        }
                        else if (curr_date == 3 || curr_date == 23)
                        {
                            sup = "rd";
                        }
                        else
                        {
                            sup = "th";
                        }
                        var curr_month = d.getMonth();
                        var curr_year = d.getFullYear();

                        document.write(d_names[curr_day] + " " + curr_date + "<SUP>"
                                + sup + "</SUP> " + m_names[curr_month] + " " + curr_year);

                        //-->
                    </script></h2>
				<ul>
					<g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
						<li class="controller"><g:link controller="${c.logicalPropertyName}">${c.name}</g:link></li>
					</g:each>
				</ul>
			</div>
		</div>
	</body>
</html>
