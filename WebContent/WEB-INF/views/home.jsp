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
	width: 400px;
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
					<li><a href="info" target="iframe">컨트롤러 생성</a></li>
					<li><a href="ch02/content" target="iframe">요청 매핑</a></li>
					<li><a href="ch03/content" target="iframe">요청 파라메터</a></li>
					<li><a href="ch04/content" target="iframe">요청 헤더값과쿠키값 설정 및 읽기</a></li>
					<li><a href="ch05/content" target="iframe">컨트롤러에서 뷰로 데이터 전달</a></li>
					<li><a href="ch06/content" target="iframe">매개변수 타입과 리턴타입</a></li>
					<li><a href="ch08/content" target="iframe">파일 업로드</a></li>
					<li><a href="ch09/content" target="iframe">의존성 주입(DI)</a></li>
					<li><a href="ch10/content" target="iframe">데이터베이스 연동</a></li>
					<li><a href="ch11/content" target="iframe">JavaScript -> MQTT연동 (WAS, MQTT Broker 동일 PC)</a></li>
					<li><a href="ch12/content" target="iframe">HTTP 요청 -> MQTT Pub(WAS, MQTT Broker 동일/다른 PC)</a></li>
					<li><a href="ch13/content" target="iframe">MQTT Sub -> WebSocket Push(WAS, MQTT Broker 동일/다른 PC)</a></li>
					<li><a href="ch30/content" target="iframe">테스트 게시판</a></li>
					
					
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