<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="<%=application.getContextPath()%>/resources/js/jquery-3.4.1.min.js">
	
</script>
<link rel="stylesheet" type="text/css"
	href="<%=application.getContextPath()%>/resources/bootstrap-4.3.1-dist/css/bootstrap.min.css">
<script type="text/javascript"
	src="<%=application.getContextPath()%>/resources/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<p>
		<a href="join?mid=fall&mname=홍길동&mpassword=12345&mage=32&mbirth=1988-11-13"
			class="btn btn-primary">get 방식으로 테스트</a>
		<a href="join2?mid=fall&mname=홍길동&mpassword=12345&mbirth=1988-11-13"
			class="btn btn-primary">get 방식으로 테스트(객체로 받기)</a>
	</p>

	<p>
	<!-- <form method="post" action="join"> -->
	<form id="joinForm" name="joinForm" method="post" action="join2">
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text" id="basic-addon1">id</span>
			</div>
			<input id="mid" name="mid" value="ejgusdl" type="text" class="form-control" placeholder="Username"
				aria-label="Username" aria-describedby="basic-addon1" />
		</div>

		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text" id="basic-addon1">name</span>
			</div>
			<input id="mname" name="mname" value="박도현" type="text" class="form-control" placeholder="Username"
				aria-label="Username" aria-describedby="basic-addon1" />
		</div>

		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text" id="basic-addon1">password</span>
			</div>
			<input id="mpassword" name="mpassword" value="12345" type="password" class="form-control" placeholder="Username"
				aria-label="Username" aria-describedby="basic-addon1" />
		</div>
		
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text" id="basic-addon1">age</span>
			</div>
			<input id="mage" name="mage" value="32" type="number" class="form-control" placeholder="Username"
				aria-label="Username" aria-describedby="basic-addon1" />
		</div>
		
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text" id="basic-addon1">birth</span>
			</div>
			<input id="mbirth" name="mbirth" value="1988-11-13" type="date" class="form-control" placeholder="Username"
				aria-label="Username" aria-describedby="basic-addon1" />
		</div>
		<input type="submit" class="btn btn-warning" value="회원가입" />
	</form>
	</p>
	
	<p>
		<script type="text/javascript">
			function join(){
				//how1
				/*var mid = $("#mid").val();				
				var mname = $("#mname").val();
				var mpassword = $("#mpassword").val();
				var mage = $("#mage").val();
				var mbirth = $("#mbirth").val();
				var params = "";
				params += "mid=" + mid + "&";
				params += "mname=" + mname + "&";
				params += "mpassword=" + mpassword + "&";
				params += "mage=" + mage + "&";
				params += "mbirth=" + mbirth;
				
				location.href = "join2?" + params;*/
				
				//how2
				//var joinForm = documnet.quetySelector("#joinForm");
				//joinForm.submit();	
				
				//how3  form의 name이 필요
				document.joinForm.sumbit();
			}
		</script>
		<button onclick="join()" class="btn btn-danger">자바스크립트를 이용해서 데이터 전달</button>
	</p>

	<p>
		<script type="text/javascript">
			function joinAjax() {
				$.ajax({
					url: "join3",
					//data: "mid=fall&mname=박도현",
					data: {mid:"fall", mname:"박도현"},
					method: "post",
					success: function(data){
						var html = "<span>mid: " + data.mid + "</span> <br/>";
						html += "<span>mname: " + data.mname + "</span>";
						$("#resultDiv").html(html);
					}
				});
			}
		
		</script>
		
		<button onclick="joinAjax()" class="btn btn-info">Ajax를 통한 데이터 전달</button>
		<div id="resultDiv">
			
		</div>
	
	</p>

</body>
</html>