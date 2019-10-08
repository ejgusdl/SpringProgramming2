<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
html, body {
	height:100%;
}
#wrapper{
	width:100%;
	height:100vh;
	display:flex;
	flex-direction: column;
}

#header {
	border-bottom: 1px solid black;
	margin-bottom: 10px;
}

#content {
	display: flex;
	flex-grow: 1;
	height:80%
}

#sideBar {
	width: 300px;
	background-color: #00ffff;
	padding-right: 10px;
	border-right: 1px solid black;
	overflow-y: scroll;
}

#center {
	flex-grow :1;
	padding:10px;	
}

#center iframe{
	margin-top: 0px;
	width:100%;
	height:100%;
}

#footer {
	border-top: 1px solid black;
	margin-top: 10px;
	margin-bottom: 10px;
}
</style>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h3>SpringProgramming2</h3>
		</div>
		<div id="content">
			<div id="sideBar">
				<ul>
					<li>
						<p>요청 매핑</p>
						<a href="info" target="iframe">요청 매핑1</a>
					</li>
			
				</ul>
			</div>
			<div id="center">
				<iframe name="iframe" src="http://tomcat.apache.org" frameborder="0"></iframe>
			</div>
		</div>

		<div id="footer">2019. IoT. P.D.H</div>
	</div>

</body>
</html>