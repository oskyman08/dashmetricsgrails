<!doctype html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><g:layoutTitle default="Grails"/></title>
		<g:layoutHead/>
        <r:layoutResources />
	</head>
	<body>
		<sec:ifLoggedIn> 
			Welcome: <sec:username /> - <g:link controller='logout'>Log Out</g:link>
		</sec:ifLoggedIn>
		<sec:ifNotLoggedIn> 
			<g:link controller='login'>Login</g:link>
		</sec:ifNotLoggedIn>		
		<h1>Demo</h1>
		<g:layoutBody/>
        <r:layoutResources />
	</body>
</html>