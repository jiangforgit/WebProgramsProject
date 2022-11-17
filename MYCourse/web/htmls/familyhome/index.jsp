<%@ page import="java.util.ArrayList" %>
<%@ page import="com.db.enums.EnumSchoolType" %>
<%@ page import="java.util.Collection" %>
<%@ page import="com.db.entitys.*" %>
<%@ page import="com.utils.LoadedUserUtil" %>
<%@ page import="com.db.interfaces.IQueryFamilyStudentShip" %>
<%@ page import="com.db.enums.EnumUserSex" %>
<%@ page import="com.db.enums.EnumSchoolCreatorType" %>
<%@ page import="com.interfaces.*" %>
<%@ page import="javax.management.Query" %>
<%@ page import="com.factorys.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>课程家长端</title>
<!-- custom-theme -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="课程表" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //custom-theme -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script src="js/jquery.vide.min.js"></script>
<!-- //js -->
<link rel="stylesheet" href="css/easy-responsive-tabs.css">
<link rel="stylesheet" href="css/jquery.gallery.css">
<link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all" />
<!-- font-awesome-icons -->
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome-icons -->
<link href="http://fonts.googleapis.com/css?family=Handlee" rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="../public_resource/public_js/datalistcheck.js"></script>
<script type="text/javascript" src="../public_resource/fullcalendar/js/plugins/others/jquery.fullcalendar.js"></script>
<script type="text/javascript" src="js/scheduletask_slide_V1.01.js"></script>
</head>
	
<body>
<!-- header -->
	<div class="w3_agile_header">
		<div class="container">
			<div class="w3_agile_header_left">
				<p>家庭宝贝课程管理</p>
			</div>
			<div class="w3_agile_header_right">
				<ul>
					<li><a href="#small-dialog" class="play-icon popup-with-zoom-anim">登录</a></li>
					<li><i class="fa fa-phone" aria-hidden="true"></i> +(0592) 233 668</li>
				</ul>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>

	<div class="w3_navigation">
		<div class="container">
			<nav class="navbar navbar-default">
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
					<nav class="menu menu--miranda">
						<ul class="nav navbar-nav menu__list">
							<li class="menu__item menu__item--current"><a href="index.jsp" class="menu__link">主页</a></li>
							<li class="menu__item"><a href="#course_manage" class="scroll menu__link">课程管理</a></li>
							<li class="menu__item"><a href="#timetable" class="scroll menu__link">课程表</a></li>
							<li class="menu__item"><a href="#programs" class="scroll menu__link">宝贝课堂</a></li>
							<li class="menu__item"><a href="#scheduletask" class="scroll menu__link">计划提醒</a></li>
							<li class="menu__item"><a href="#work" class="scroll menu__link">家长统计</a></li>
						</ul>
					</nav>
				</div>
			</nav>	
		</div>
	</div>
<!-- //header -->

<!-- pop-up-box -->
	<div id="small-dialog" class="mfp-hide w3ls_small_dialog wthree_pop">
		<h3>登录</h3>
		<div class="agileits_modal_body">
			<form action="#" method="post">
				<div class="agileits_w3layouts_user">
					<i class="fa fa-user" aria-hidden="true"></i>
					<input type="text" name="Name" placeholder="User Name" required="">
				</div>
				<div class="agileits_w3layouts_user">
					<i class="fa fa-key" aria-hidden="true"></i>
					<input type="password" name="Password" placeholder="Password" required="">
				</div>
				<div class="agile_remember">
					<div class="agile_remember_left">
						<div class="check">
							<label class="checkbox"><input type="checkbox" name="checkbox"><i> </i>remember me</label>
						</div>
					</div>
					<div class="agile_remember_right">
						<a href="#">Forgot Password?</a>
					</div>
					<div class="clearfix"> </div>
				</div>
				<input type="submit" value="login">
			</form>
			<h5>Don't have an account? <a href="#small-dialog1" class="play-icon popup-with-zoom-anim">Sign Up</a></h5>
		</div>
	</div>
	<div id="small-dialog1" class="mfp-hide w3ls_small_dialog wthree_pop">
		<h3>注册</h3>
		<div class="agileits_modal_body">
			<form action="#" method="post">
				<h4>Profile information :</h4>
				<div class="agileits_w3layouts_user">
					<i class="fa fa-user" aria-hidden="true"></i>
					<input type="text" name="Name" placeholder="First Name" required="">
				</div>
				<div class="agileits_w3layouts_user">
					<i class="fa fa-user" aria-hidden="true"></i>
					<input type="text" name="Name" placeholder="Last Name" required="">
				</div>
				<div class="agileinfo_subscribe">
					<div class="check">
						<label class="checkbox"><input type="checkbox" name="checkbox"><i> </i>subscribe to newsletter</label>
					</div>
				</div>
				<h4>Login information :</h4>
				<div class="agileits_w3layouts_user">
					<i class="fa fa-envelope-o" aria-hidden="true"></i>
					<input type="email" name="Email" placeholder="Email" required="">
				</div>
				<div class="agileits_w3layouts_user agileits_w3layouts_user_agileits">
					<i class="fa fa-key" aria-hidden="true"></i>
					<input type="password" name="Password" placeholder="Password" required="">
				</div>
				<div class="agileits_w3layouts_user">
					<i class="fa fa-key" aria-hidden="true"></i>
					<input type="password" name="Password" placeholder="Confirm Password" required="">
				</div>
				<div class="agileinfo_subscribe">
					<div class="check">
						<label class="checkbox"><input type="checkbox" name="checkbox"><i> </i>i accept the terms and conditions</label>
					</div>
				</div>
				<input type="submit" value="Register">
			</form>
			<h5>Already a member <a href="#small-dialog" class="play-icon popup-with-zoom-anim">Sign In</a></h5>
		</div>
	</div>
	<div id="small-dialog-school" class="mfp-hide w3ls_small_dialog wthree_pop">
		<h3>添加学校/培训机构</h3>
		<div class="agileits_modal_body">
		<form action="/MYCourse/addSchool" method="post">
			<div class="agileits_w3layouts_user">
				<input type="text" name="regist_schoolName" placeholder="学校/机构名称" required="">
			</div>
			<div class="agileits_w3layouts_user">
				<input type="text" name="regist_schoolAddr" placeholder="学校/机构地址" required="">
			</div>
			<div class="agileits_w3layouts_user">
				<label>教育类型：</label>
				<select name="regist_schoolType">
					<%
						for(EnumSchoolType schoolType : EnumSchoolType.values()){
							out.println("<option value=\""+schoolType.getType()+"\">"+schoolType.getTypeDes()+"</option>");
						}
					%>
				</select>
			</div>
			<br>
			<input type="submit" value="添加学校">
		</form>
	</div>
	</div>
	<div id="small-dialog-student" class="mfp-hide w3ls_small_dialog wthree_pop">
		<h3>添加学生</h3>
		<div class="agileits_modal_body">
			<form action="/MYCourse/addFamilyStudent" method="post">
				<div class="agileits_w3layouts_user">
					<input type="text" name="regist_studentName" placeholder="学生姓名" required="">
				</div>
				<div class="agileits_w3layouts_user">
					<input type="text" name="regist_studentInterest" placeholder="兴趣" required="">
				</div>
				<div class="agileits_w3layouts_user">
					<input type="text" name="regist_studentMotto" placeholder="格言" required="">
				</div>
				<div class="agileits_w3layouts_user">
					<br>
					出生年月：
					<input type="text" name="regist_studentbirdth_year" list="rs_year" placeholder="年" required="">
						<datalist id="rs_year">
							<script>
								for(var i=1900;i<=2022;i++){
									document.write("<option value="+i+">"+i+"</option>");
								}
							</script>
						</datalist>
					<input type="text" name="regist_studentbirdth_month" list="rs_month" placeholder="月" required="">
						<datalist id="rs_month">
							<script>
								for(var i=1;i<=12;i++){
									document.write("<option value="+i+">"+i+"</option>");
								}
							</script>
						</datalist>
					<input type="text" name="regist_studentbirdth_day" list="rs_day" placeholder="日" required="">
						<datalist id="rs_day">
							<script>
								for(var i=1;i<=31;i++){
									document.write("<option value="+i+">"+i+"</option>");
								}
							</script>
						</datalist>
				</div>
				<div class="agileits_w3layouts_user">
					<label class="radio-inline"><input type="radio" name="regist_studentSex" value="secrecy" checked="checked">保密</label>
					<label class="radio-inline"><input type="radio" name="regist_studentSex" value="male">男</label>
					<label class="radio-inline"><input type="radio" name="regist_studentSex" value="female">女</label>
				</div>
				<br>
				<input type="submit" value="添加学生">
			</form>
		</div>
	</div>
    <div id="small-dialog-course" class="mfp-hide w3ls_small_dialog wthree_pop">
		<h3>添加课程</h3>
		<div class="agileits_modal_body">
		<form action="/MYCourse/addStudentCourse" method="post">
			<div class="agileits_w3layouts_user">
				<input type="text" name="regist_courseName" placeholder="课程名称" required="">
			</div>
			<div class="agileits_w3layouts_user">
				<input type="text" name="regist_courseDes" placeholder="课程描述" required="">
			</div>
			<div class="agileits_w3layouts_user">
				<label>选择学校/机构：</label>
				<select name="regist_schoolSelect" required="">
					<%
						QuerySchoolFactory SchoolFactory = new QuerySchoolFactory();
						ArrayList<SchoolTbEntity> schoolTbEntities = SchoolFactory.produce().querySchoolByFamilyUserId(LoadedUserUtil.getLoadedUserFamilyUserId());
						if(null == schoolTbEntities){
							System.out.println("null == schoolTbEntities");
						}else {
							if(schoolTbEntities.size()>0){
								for(SchoolTbEntity entity : schoolTbEntities){
									out.println("<option value=\""+entity.getSchoolId()+"\">"+entity.getSchoolName()+"</option>");
								}
							}else {
								System.out.println("schoolTbEntities.size == 0");
							}
						}
					%>
				</select>
			</div>
			<br>
			<div class="agileits_w3layouts_user">
				<label>选择学生：</label>
				<select name="regist_studentSelect" required="">
					<%
						QueryFamilyStudentsFactory familyStudentsFactory = new QueryFamilyStudentsFactory();
						ArrayList familyStudents = familyStudentsFactory.produce().getFamilyStudents(LoadedUserUtil.getLoadedUserFamilyUserId());
						if(null != familyStudents){
							if(familyStudents.size()>0){
								for(int i=0;i<familyStudents.size();i++){
									Object[] objects = (Object[])familyStudents.get(i);
									FamilystudentTbEntity familystudentTbEntity = (FamilystudentTbEntity) objects[0];
									StudentTbEntity studentTbEntity = (StudentTbEntity) objects[1];
									out.println("<option value=\""+studentTbEntity.getStudentId()+"\">"+studentTbEntity.getStudentName()+"</option>");
								}
							}else {
								System.out.println("familyStudents.size <= 0");
							}
						}else {
							System.out.println("null == familyStudents");
						}

					%>
				</select>
			</div>
			<br>
			<input type="submit" value="添加课程">
		</form>
	</div>
	</div>
    <div id="small-dialog-course-exists" class="mfp-hide w3ls_small_dialog wthree_pop">
    	<h3>选修已有课程</h3>
    	<div class="agileits_modal_body">
        <form action="/MYCourse/addStudentCourse" method="post">
            <div class="agileits_w3layouts_user">
				<label>选择学生：</label>
				<select name="regist_studentSelect_exists" required="">
					<%
						QueryFamilyStudentsFactory mFamilyStudentsFactory = new QueryFamilyStudentsFactory();
						ArrayList mFamilyStudents = mFamilyStudentsFactory.produce().getFamilyStudents(LoadedUserUtil.getLoadedUserFamilyUserId());
						if(null != mFamilyStudents){
							if(mFamilyStudents.size()>0){
								for(int i=0;i<mFamilyStudents.size();i++){
									Object[] objects = (Object[])mFamilyStudents.get(i);
									FamilystudentTbEntity familystudentTbEntity = (FamilystudentTbEntity) objects[0];
									StudentTbEntity studentTbEntity = (StudentTbEntity) objects[1];
									out.println("<option value=\""+studentTbEntity.getStudentId()+"\">"+studentTbEntity.getStudentName()+"</option>");
								}
							}else {
								System.out.println("mFamilyStudents.size <= 0");
							}
						}else {
							System.out.println("null == mFamilyStudents");
						}

					%>
				</select>
            </div>
            <br>
			<div class="agileits_w3layouts_user">
				<label>选择学校/机构：</label>
				<select id="regist_schoolSelect_exists" name="regist_schoolSelect_exists" onchange="queryCourseList()" required="">
					<%
						QuerySchoolFactory mSchoolFactory = new QuerySchoolFactory();
						ArrayList<SchoolTbEntity> mSchoolTbEntities = mSchoolFactory.produce().querySchoolByFamilyUserId(LoadedUserUtil.getLoadedUserFamilyUserId());
						if(null == mSchoolTbEntities){
							System.out.println("null == mSchoolTbEntities");
						}else {
							if(mSchoolTbEntities.size()>0){
								for(SchoolTbEntity entity : mSchoolTbEntities){
									out.println("<option value=\""+entity.getSchoolId()+"\">"+entity.getSchoolName()+"</option>");
								}
								out.println("<script type=\"text/javascript\"> $(function(){queryCourseList();}); </script>");
							}else {
								System.out.println("mSchoolTbEntities.size == 0");
							}
						}
					%>
				</select>
			</div>
			<br>
            <div id="regist_courseId_exists_div" class="agileits_w3layouts_user">
				<label>选择课程：</label>
				<select id="regist_courseId_exists" name="regist_courseId_exists" required=""></select>
					<script type="text/javascript">
						function queryCourseList(){
							var schoolSelectValue = document.getElementById("regist_schoolSelect_exists").value;
							$.post("${pageContext.request.contextPath}/getCourses",{schoolId:schoolSelectValue},function (data) {
								var regist_courseId_exists = document.getElementById("regist_courseId_exists");
								if(null != regist_courseId_exists){
									regist_courseId_exists.remove();
								}
								$("#regist_courseId_exists_div").append("<select id=\"regist_courseId_exists\" name=\"regist_courseId_exists\" required=\"\"></select>");
								$.each($.parseJSON(data), function (i, object) {
									$("#regist_courseId_exists").append("<option value=\""+object.courseId+"\">"+object.courseName+"</option>");
								});
							},"text");
						}
					</script>
            </div>
            <br>
            <input type="submit" value="添加课程">
        </form>
    </div>
	</div>
<!-- //pop-up-box -->

<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>

<script>
	$(document).ready(function() {
	$('.popup-with-zoom-anim').magnificPopup({
		type: 'inline',
		fixedContentPos: false,
		fixedBgPos: true,
		overflowY: 'auto',
		closeBtnInside: true,
		preloader: false,
		midClick: true,
		removalDelay: 300,
		mainClass: 'my-mfp-zoom-in'
	});
																	
	});
</script>

<!-- banner -->
	<div data-vide-bg="video/nursery">
		<div class="center-container">
			<div class="container">
				<div class="w3_agile_banner_info">
					<p class="w3_agileits_banner_para"><span>用心呵护 陪伴成长</span></p>
					<div class="agileits_w3layouts_header">
						<h2 class="test2">未来皆可期 <i>教育永相随  </i></h2>
					</div>
					<p class="w3_elit_para">孩子的成长 我们不曾错过</p>
					<div class="agile_more">
						<a href="#myModal" class="btn btn-3 btn-3e icon-arrow-right" data-toggle="modal" data-target="#myModal">精彩瞬间</a>
					</div>
				</div>
			</div>
		</div>
	</div>

<!-- course_manage -->
	<div id="course_manage" class="contact">
		<div class="container">
		<h3 class="w3_agileits_head"><span class="w3_child">学生</span><span class="w3_child1">/</span><span class="w3_child4">学校</span><span class="w3_child2">/</span><span class="w3_child1">课程</span></h3>
		<p class="w3_agile_elit">可在此添加和维护学生/学校/课程关系</p>

		<div class="agile_banner_bottom_grids">

			<div class="col-md-4 w3_agile_contact_grid">
				<div class="col-xs-4 agile_contact_grid_left agileits_w3layouts_left">
					<i class="fa fa-building" aria-hidden="true"></i>
				</div>
				<div class="col-xs-8 agile_contact_grid_right agileits_w3layouts_right">
					<h4>学校</h4>
					<br>
					<p><a href="#small-dialog-school" class="play-icon popup-with-zoom-anim">添加学校/培训机构</a></p>
				</div>
				<div class="clearfix"> </div>
			</div>

			<div class="col-md-4 w3_agile_contact_grid">
				<div class="col-xs-4 agile_contact_grid_left">
					<i class="fa fa-user" aria-hidden="true"></i>
				</div>
				<div class="col-xs-8 agile_contact_grid_right agilew3_contact">
					<h4>学生</h4>
					<br>
					<p><a href="#small-dialog-student" class="play-icon popup-with-zoom-anim">添加家庭宝贝</a></p>
				</div>
				<div class="clearfix"> </div>
			</div>

			<div class="col-md-4 w3_agile_contact_grid">
				<div class="col-xs-4 agile_contact_grid_left agileits_w3layouts_left1">
					<i class="fa fa-book" aria-hidden="true"></i>
				</div>
				<div class="col-xs-8 agile_contact_grid_right agileits_w3layouts_right1">
					<h4>课程</h4>
					<p><a href="#small-dialog-course" class="play-icon popup-with-zoom-anim">添加新课程</a></p>
					<p><a href="#small-dialog-course-exists" class="play-icon popup-with-zoom-anim">选修已有课程</a></p>
				</div>
				<div class="clearfix"> </div>
			</div>

			<div class="clearfix"> </div>
		</div>

		<!-- school course student data list -->
		<div id="programs" class="programs">
			<div class="container">
				<div class="agile_banner_bottom_grids">
					<div id="verticalTab">
						<ul class="resp-tabs-list">
							<li><i class="fa fa-user-circle" aria-hidden="true"></i>我家宝贝</li>
							<li><i class="fa fa-building-o" aria-hidden="true"></i>我的学校</li>
							<li><i class="fa fa-bookmark-o" aria-hidden="true"></i>我的课程</li>
						</ul>
						<div class="resp-tabs-container">
							<div class="w3layouts_vertical_tab">
								<div class="table-responsive">
									<table class="table table-bordered table-hover">
										<thead>
										<tr>
											<th> No.</th>
											<th>姓名</th>
											<th>性别</th>
											<th>生日</th>
											<th>兴趣</th>
										</tr>
										</thead>
										<tbody>
										<%
											IQueryFamilyStudentsProvider fsProvider = new QueryFamilyStudentsFactory();
											ArrayList familyStudentList = fsProvider.produce().getFamilyStudents(LoadedUserUtil.getLoadedUserFamilyUserId());
											if(null == familyStudentList){
												out.println("<tr><td>1</td><td>null</td><td>null</td><td>null</td><td>null</td></tr>");
											}else {
												for(int i=0;i<familyStudentList.size();i++){
													Object[] objects = (Object[])familyStudentList.get(i);
													FamilystudentTbEntity familystudentTbEntity = (FamilystudentTbEntity)objects[0];
													StudentTbEntity studentTbEntity = (StudentTbEntity) objects[1];
													out.println("<tr><td>"+(i+1)+"</td><td>"+studentTbEntity.getStudentName()+"</td><td>"+ studentTbEntity.getStudentSex() +"</td>" +
															"<td>"+studentTbEntity.getStudentBirth()+"</td><td>"+studentTbEntity.getStudentInterest()+"</td></tr>");
												}
											}
										%>
										</tbody>
									</table>
								</div>
							</div>
							<div class="w3layouts_vertical_tab">
								<div class="table-responsive">
									<table class="table table-bordered table-hover">
										<thead>
										<tr>
											<th> No.</th>
											<th>学校名称</th>
											<th>学校地址</th>
											<th>教育类型</th>
											<th>添加日期</th>
										</tr>
										</thead>
										<tbody>
										<%
											IQuerySchoolProvider schoolProvider = new QuerySchoolFactory();
											ArrayList schooltList = schoolProvider.produce().querySchoolByFamilyUserId(LoadedUserUtil.getLoadedUserFamilyUserId());
											if(null == schooltList){
												out.println("<tr><td>1</td><td>null</td><td>null</td><td>null</td></tr>");
											}else {
												for(int i=0;i<schooltList.size();i++){
													SchoolTbEntity schoolTbEntity = (SchoolTbEntity) schooltList.get(i);
													out.println("<tr><td>"+(i+1)+"</td><td>"+schoolTbEntity.getSchoolName()+"</td><td>"+ schoolTbEntity.getSchoolAddr() +"</td>" +
															"<td>"+schoolTbEntity.getSchoolType()+"</td><td>"+schoolTbEntity.getSchoolCreateTime()+"</td></tr>");
												}
											}
										%>
										</tbody>
									</table>
								</div>
							</div>
							<div class="w3layouts_vertical_tab">
								<div class="table-responsive">
									<table class="table table-bordered table-hover">
										<thead>
										<tr>
											<th> No.</th>
											<th>学校名称</th>
											<th>课程名称</th>
											<th>课程描述</th>
											<th>添加日期</th>
										</tr>
										</thead>
										<tbody>
										<%
											IQuerySchoolCourseProvider scProvider = new QuerySchoolCourseFactory();
											ArrayList schoolCoursetList = scProvider.produce().getSchCoursesByFamilyUser(EnumSchoolCreatorType.family_creator,LoadedUserUtil.getLoadedUserFamilyUserId());
											if(null == schoolCoursetList){
												out.println("<tr><td>1</td><td>null</td><td>null</td><td>null</td><td>null</td></tr>");
											}else {
												for(int i=0;i<schoolCoursetList.size();i++){
													Object[] objects = (Object[]) schoolCoursetList.get(i);
													SchoolTbEntity schoolTbEntity = (SchoolTbEntity) objects[0];
													CourseTbEntity courseTbEntity = (CourseTbEntity) objects[1];
													out.println("<tr><td>"+(i+1)+"</td><td>"+schoolTbEntity.getSchoolName()+"</td><td>"+ courseTbEntity.getCourseName() +"</td>" +
															"<td>"+courseTbEntity.getCourseDescribe()+"</td><td>"+courseTbEntity.getCourseCreateTime()+"</td></tr>");
												}
											}
										%>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- //school course student data list -->

		<div class="agile_banner_bottom_grids">
			<div class="col-md-offset-0 col-sm-12 col-xs-12">

				<div class="panel panel-default">
					<div class="panel-heading">
						宝贝参与的课程
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-striped table-bordered table-hover">
								<thead>
								<tr>
									<th> No.</th>
									<th>学校名称</th>
									<th>课程名称</th>
									<th>参与宝贝</th>
									<th>报名日期</th>
								</tr>
								</thead>
								<tbody>
								<%
									ISearchStudentCoursesProvider provider = new SearchStudentCoursesFactory();
									ArrayList studentCouses = provider.produce().getFamilyStudentsCourses(LoadedUserUtil.getLoadedUserFamilyUserId());
									if(null == studentCouses){
										out.println("<tr><td>1</td><td>null</td><td>null</td><td>null</td><td>null</td></tr>");
									}else {
										for(int i=0;i<studentCouses.size();i++){
											Object[] objects = (Object[])studentCouses.get(i);
											FamilystudentTbEntity familystudentTbEntity = (FamilystudentTbEntity)objects[0];
											CoursestudentTbEntity coursestudentTbEntity = (CoursestudentTbEntity) objects[1];
											StudentTbEntity studentTbEntity = (StudentTbEntity) objects[2];
											CourseTbEntity courseTbEntity = (CourseTbEntity) objects[3];
											SchoolTbEntity schoolTbEntity = (SchoolTbEntity) objects[4];
											out.println("<tr><td>"+(i+1)+"</td><td>"+schoolTbEntity.getSchoolName()+"</td><td>"+courseTbEntity.getCourseName()+"</td><td>"+studentTbEntity.getStudentName()+"</td><td>"+coursestudentTbEntity.getCourseStudentCreateTime()+"</td></tr>");
										}
									}
								%>
								</tbody>
							</table>
						</div>
					</div>
				</div>

			</div>
		</div>

		<div class="agile_banner_bottom_grids">
			<form action="#" method="post">
				<div class="col-md-6 w3_agileits_contact_left">
						<span class="input input--akira">
							<input class="input__field input__field--akira" type="text" id="input-22" name="Name" placeholder="" required="" />
							<label class="input__label input__label--akira" for="input-22">
								<span class="input__label-content input__label-content--akira">Your Name</span>
							</label>
						</span>
					<span class="input input--akira">
							<input class="input__field input__field--akira" type="email" id="input-23" name="Email" placeholder="" required="" />
							<label class="input__label input__label--akira" for="input-23">
								<span class="input__label-content input__label-content--akira">Your Email</span>
							</label>
						</span>
					<span class="input input--akira">
							<input class="input__field input__field--akira" type="text" id="input-24" name="Subject" placeholder="" required="" />
							<label class="input__label input__label--akira" for="input-24">
								<span class="input__label-content input__label-content--akira">Your Subject</span>
							</label>
						</span>
				</div>
				<div class="col-md-6 w3_agileits_contact_right">
					<div class="w3_agileits_contact_right1">
						<textarea name="Message" placeholder="Your comment here..." required=""></textarea>
					</div>
					<div class="w3_agileits_contact_right2">
						<input type="submit" value=" ">
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="clearfix"> </div>
			</form>
		</div>
	</div>
	</div>
<!-- //course_manage -->

<!-- timetable -->
	<div id="timetable" class="testimonials">
		<div class="container">
			<h3 class="w3_agileits_head"><span class="w3_child">宝贝</span><span class="w3_child1">课程</span><span class="w3_child4">计划表</span></h3>
			<p class="w3_agile_elit">您可以在此创建/浏览/管理您家宝贝的课程计划表，让每一节课都尽收眼底。</p>
			<div class="agile_banner_bottom_grids">
				<div class="col-md-offset-0 col-sm-12 col-xs-12">
					<div class="panel panel-default" id="weekcourse_calendar_frame">
<%--							<object data="../public_resource/fullcalendar/weekcourse_calendar.html" type="" width="100%"></object>--%>
							<embed src="../public_resource/fullcalendar/weekcourse_calendar.html" type="" width="100%" height="630px">
					</div>
				</div>
			</div>
		</div>

	</div>
<!-- //timetable -->

<!-- bootstrap-pop-up -->
	<div class="modal video-modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					Nursery
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>						
				</div>
				<section>
					<div class="modal-body">
						<div class="w3_modal_body_left">
							<img src="images/1.jpg" alt=" " class="img-responsive" />
						</div>
						<div class="w3_modal_body_right">
							<h4>Suspendisse et sapien ac diam suscipit posuere</h4>
							<p>Ut enim ad minima veniam, quis nostrum 
							exercitationem ullam corporis suscipit laboriosam, 
							nisi ut aliquid ex ea commodi consequatur? Quis autem 
							vel eum iure reprehenderit qui in ea voluptate velit 
							esse quam nihil molestiae consequatur.
							<i>" Quis autem vel eum iure reprehenderit qui in ea voluptate velit 
								esse quam nihil molestiae consequatur.</i>
								Fusce in ex eget ligula tempor placerat. Aliquam laoreet mi id felis commodo 
								interdum. Integer sollicitudin risus sed risus rutrum 
								elementum ac ac purus.</p>
						</div>
						<div class="clearfix"> </div>
					</div>
				</section>
			</div>
		</div>
	</div>
<!-- //bootstrap-pop-up -->

<!-- banner-bottom -->
	<div id="about" class="banner-bottom">
		<div class="container">
			<h3>a <span class="w3_child">c</span><span class="w3_child1">h</span><span class="w3_child2">i</span><span class="w3_child3">l</span><span class="w3_child4">d</span>'s life is like a piece of paper on which every person leaves a mark</h3>
			<p class="w3_agile_elit">Quisque dictum elit in nunc malesuada lacinia. Cras id porttitor turpis.</p>
			<div class="agile_banner_bottom_grids">
				<div class="col-md-3 agile_banner_bottom_grid">
					<div class="view view-first">
						<img src="images/2.jpg" alt=" " class="img-responsive" />
						<div class="mask">
							<h5>Nursery</h5>
							<p>Integer ac condimentum ligula. Ut malesuada in purus convallis venenatis.</p>
						</div>
					</div>
					<div class="agile_banner_bottom_grid_pos">
						<h4>Drawing</h4>
					</div>
				</div>
				<div class="col-md-3 agile_banner_bottom_grid">
					<div class="view view-first">
						<img src="images/3.jpg" alt=" " class="img-responsive" />
						<div class="mask">
							<h5 class="agileits_w3layouts1">Nursery</h5>
							<p>Integer ac condimentum ligula. Ut malesuada in purus convallis venenatis.</p>
						</div>
					</div>
					<div class="agile_banner_bottom_grid_pos">
						<h4 class="agileits_w3layouts1">Learning</h4>
					</div>
				</div>
				<div class="col-md-3 agile_banner_bottom_grid">
					<div class="view view-first">
						<img src="images/4.jpg" alt=" " class="img-responsive" />
						<div class="mask">
							<h5 class="agileits_w3layouts2">Nursery</h5>
							<p>Integer ac condimentum ligula. Ut malesuada in purus convallis venenatis.</p>
						</div>
					</div>
					<div class="agile_banner_bottom_grid_pos">
						<h4 class="agileits_w3layouts2">Playing</h4>
					</div>
				</div>
				<div class="col-md-3 agile_banner_bottom_grid">
					<div class="view view-first">
						<img src="images/5.jpg" alt=" " class="img-responsive" />
						<div class="mask">
							<h5 class="agileits_w3layouts3">Nursery</h5>
							<p>Integer ac condimentum ligula. Ut malesuada in purus convallis venenatis.</p>
						</div>
					</div>
					<div class="agile_banner_bottom_grid_pos">
						<h4 class="agileits_w3layouts3">Laughing</h4>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
<!-- //banner-bottom -->

<!-- scheduleTask -->
	<div id="scheduletask" class="stats">
		<div class="container">
			<h3 class="w3_agileits_head"><span class="w3_child">日程</span><span class="w3_child1">事务</span><span class="w3_child4">提醒</span></h3>
			<p class="w3_agile_elit">您可以在此创建/浏览/管理您的日程事务计划，不让重要的事情被遗忘溜走。</p>

			<div class="agile_banner_bottom_grids">
				<div class="col-md-offset-0 col-sm-12 col-xs-12">
					<div class="panel panel-default" id="scheduletask_calendar_frame">
						<embed src="../public_resource/fullcalendar/scheduletask_calendar.html" type="" width="100%" height="630px">
					</div>
				</div>
			</div>
			<div class="clearfix"> </div>

			<p class="w3_agile_elit">浏览您创建的或家人共享的日程事务列表</p>
			<div id="scheduletask_records_container_div" class="agile_banner_bottom_grids">

			</div>

		</div>
	</div>

	<div class="modal fade" id="showScheduleTaskRecordModal" tabindex="-1" role="dialog" aria-labelledby="showScheduleTaskRecordModal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header blueBack">
					<label id="showScheduleTaskRecord_title">日程事务明细</label>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<button id="showScheduleTaskRecord_delete_btn" type="button" class="delete"><span aria-hidden="true">删除</span></button>
				</div>
				<div class="modal-body">
					<div class="agileits_w3layouts_user">
						详细内容：<label id="showScheduleTaskRecord_content" class="modalpopup_content_label"></label>
					</div>
					<div class="agileits_w3layouts_user">
						日程时间：<label id="showScheduleTaskRecord_time" class="modalpopup_content_label"></label>
					</div>
					<div class="agileits_w3layouts_user">
						家庭共享： <label id="showScheduleTaskRecord_fullshare" class="modalpopup_content_label"></label>
					</div>
					<div class="agileits_w3layouts_user">
						提醒时间： <label id="showScheduleTaskRecord_remindtime" class="modalpopup_content_label"></label>
					</div>
					<div class="agileits_w3layouts_user">
						日程创建者： <label id="showScheduleTaskRecord_creator" class="modalpopup_content_label"></label>
					</div>
					<div class="agileits_w3layouts_user">
						创建时间：<label id="showScheduleTaskRecord_createtime" class="showScheduleTask_createtime"></label>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>
		</div>
	</div>

<!-- events -->
	<div id="events" class="events">
		<div class="container">
			<h3 class="w3_agileits_head">Our Latest <span class="w3_child">E</span><span class="w3_child1">v</span><span class="w3_child2">e</span><span class="w3_child4">n</span><span class="w3_child">t</span><span class="w3_child1">s</span></h3>
			<p class="w3_agile_elit">Quisque dictum elit in nunc malesuada lacinia. Cras id porttitor turpis.</p>
			<div class="agile_banner_bottom_grids">
				<div class="agile_events_grid">
					<img src="images/1.jpg" alt=" " class="img-responsive" />
					<div class="agile_events_grid_pos agile_events_grid_pos1">
						<h5><span>01</span> 12 / 2016</h5>
						<h4><a href="#" data-toggle="modal" data-target="#myModal">nunc malesuada lacinia</a></h4>
						<p>Nunc non maximus augue, sit amet dictum diam. Etiam ultrices hendrerit sapien, 
							id volutpat tortor viverra et.Nunc non maximus augue, sit amet dictum diam. Etiam ultrices hendrerit sapien,
							id volutpat tortor viverra et.Nunc non maximus augue, sit amet dictum diam. Etiam ultrices hendrerit sapien,
							id volutpat tortor viverra et.Nunc non maximus augue, sit amet dictum diam. Etiam ultrices hendrerit sapien,
							id volutpat tortor viverra et.Nunc non maximus augue, sit amet dictum diam. Etiam ultrices hendrerit sapien,
							id volutpat tortor viverra et.Nunc non maximus augue, sit amet dictum diam. Etiam ultrices hendrerit sapien,
							id volutpat tortor viverra et.</p>
					</div>
					<div class="agileits_w3layouts_events_grid_social">
						<ul class="agileinfo_social_icons">
							<li><a href="#" class="w3_twitter"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
							<li><a href="#" class="w3l_google"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
							<li><a href="#" class="w3ls_dribble"><i class="fa fa-dribbble" aria-hidden="true"></i></a></li>
						</ul>
					</div>
				</div>
				<div class="agile_events_grid">
					<img src="images/13.jpg" alt=" " class="img-responsive" />
					<div class="agile_events_grid_pos_sub agile_events_grid_pos1">
						<h5 class="w3_agileits_event_head"><span>05</span> 12 / 2016</h5>
						<h4><a href="#" data-toggle="modal" data-target="#myModal">consequat dictum sodales</a></h4>
						<p>Nunc non maximus augue, sit amet dictum diam. Etiam ultrices hendrerit sapien, 
							id volutpat tortor viverra et.</p>
					</div>
					<div class="agileits_w3layouts_events_grid_social1">
						<ul class="agileinfo_social_icons">
							<li><a href="#" class="w3_twitter"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
							<li><a href="#" class="w3l_google"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
							<li><a href="#" class="w3ls_dribble"><i class="fa fa-dribbble" aria-hidden="true"></i></a></li>
						</ul>
					</div>
				</div>
				<div class="agile_events_grid">
					<img src="images/15.jpg" alt=" " class="img-responsive" />
					<div class="agile_events_grid_pos agile_events_grid_pos1">
						<h5><span>09</span> 12 / 2016</h5>
						<h4><a href="#" data-toggle="modal" data-target="#myModal">ultrices hendrerit amet</a></h4>
						<p>Nunc non maximus augue, sit amet dictum diam. Etiam ultrices hendrerit sapien, 
							id volutpat tortor viverra et.</p>
					</div>
					<div class="agileits_w3layouts_events_grid_social">
						<ul class="agileinfo_social_icons">
							<li><a href="#" class="w3_twitter"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
							<li><a href="#" class="w3l_google"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
							<li><a href="#" class="w3ls_dribble"><i class="fa fa-dribbble" aria-hidden="true"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
<!-- //events -->

<!-- work -->
	<div id="work" class="work">
		<div class="container">
			<h3 class="w3_agileits_head">Our <span class="w3_child">W</span><span class="w3_child1">o</span><span class="w3_child4">r</span><span class="w3_child2">k</span> in Nursery</h3>
			<p class="w3_agile_elit">Quisque dictum elit in nunc malesuada lacinia. Cras id porttitor turpis.</p>
			<div class="agile_work_single_grids">
				<div class="bs-example bs-example-tabs wthree_example_tab" role="tabpanel" data-example-id="togglable-tabs">
					<ul id="myTab" class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active"><a href="#home" id="home-tab" role="tab" data-toggle="tab" aria-controls="home" aria-expanded="true">All</a></li>
						<li role="presentation"><a href="#learning" role="tab" id="learning-tab" data-toggle="tab" aria-controls="learning">Category- 1</a></li>
						<li role="presentation"><a href="#playing" role="tab" id="playing-tab" data-toggle="tab" aria-controls="playing">Category- 2</a></li>
						<li role="presentation"><a href="#painting" role="tab" id="painting-tab" data-toggle="tab" aria-controls="painting">Category- 3</a></li>
					</ul>
					<div id="myTabContent" class="tab-content">
						<div role="tabpanel" class="tab-pane fade in active" id="home" aria-labelledby="home-tab">
							<div class="w3_tab_img agileinfo_img">
								<div class="col-md-4 w3_tab_img_left">
									<div class="agileits_demo">
										<a href="images/13.jpg">
											<figure class="w3layouts_work">
												<div class="w3layouts_work_sub">
													<img src="images/13.jpg" alt=" " class="img-responsive" />
												</div>
												<figcaption>
													<span>Nursery</span>
												</figcaption>
											</figure>
										</a>
									</div>
									<div class="agileits_demo">
										<a href="images/15.jpg">
											<figure class="w3layouts_work">
												<div class="w3layouts_work_sub">
													<img src="images/15.jpg" alt=" " class="img-responsive" />
												</div>
												<figcaption>
													<span>Nursery</span>
												</figcaption>
											</figure>
										</a>
									</div>
								</div>
								<div class="col-md-4 w3_tab_img_left">
									<div class="agileits_demo">
										<a href="images/1.jpg">
											<figure class="w3layouts_work">
												<div class="w3layouts_work_sub">
													<img src="images/1.jpg" alt=" " class="img-responsive" />
												</div>
												<figcaption>
													<span>Nursery</span>
												</figcaption>
											</figure>
										</a>
									</div>
									<div class="agileits_demo">
										<a href="images/22.jpg">
											<figure class="w3layouts_work">
												<div class="w3layouts_work_sub">
													<img src="images/22.jpg" alt=" " class="img-responsive" />
												</div>
												<figcaption>
													<span>Nursery</span>
												</figcaption>
											</figure>
										</a>
									</div>
								</div>
								<div class="col-md-4 w3_tab_img_left">
									<div class="agileits_demo">
										<a href="images/12.jpg">
											<figure class="w3layouts_work">
												<div class="w3layouts_work_sub">
													<img src="images/12.jpg" alt=" " class="img-responsive" />
												</div>
												<figcaption>
													<span>Nursery</span>
												</figcaption>
											</figure>
										</a>
									</div>
									<div class="agileits_demo">
										<a href="images/23.jpg">
											<figure class="w3layouts_work">
												<div class="w3layouts_work_sub">
													<img src="images/23.jpg" alt=" " class="img-responsive" />
												</div>
												<figcaption>
													<span>Nursery</span>
												</figcaption>
											</figure>
										</a>
									</div>
								</div>
								<div class="clearfix"> </div>
							</div>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="learning" aria-labelledby="learning-tab">
							<div class="w3_tab_img agileinfo_img">
								<div class="col-md-4 w3_tab_img_left">
									<div class="agileits_demo">
										<a href="images/15.jpg">
											<figure class="w3layouts_work">
												<div class="w3layouts_work_sub">
													<img src="images/15.jpg" alt=" " class="img-responsive" />
												</div>
												<figcaption>
													<span>Nursery</span>
												</figcaption>
											</figure>
										</a>
									</div>
								</div>
								<div class="col-md-4 w3_tab_img_left">
									<div class="agileits_demo">
										<a href="images/1.jpg">
											<figure class="w3layouts_work">
												<div class="w3layouts_work_sub">
													<img src="images/1.jpg" alt=" " class="img-responsive" />
												</div>
												<figcaption>
													<span>Nursery</span>
												</figcaption>
											</figure>
										</a>
									</div>
								</div>
								<div class="col-md-4 w3_tab_img_left">
									<div class="agileits_demo">
										<a href="images/23.jpg">
											<figure class="w3layouts_work">
												<div class="w3layouts_work_sub">
													<img src="images/23.jpg" alt=" " class="img-responsive" />
												</div>
												<figcaption>
													<span>Nursery</span>
												</figcaption>
											</figure>
										</a>
									</div>
								</div>
								<div class="clearfix"> </div>
							</div>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="playing" aria-labelledby="playing-tab">
							<div class="w3_tab_img agileinfo_img">
								<div class="col-md-4 w3_tab_img_left">
									<div class="agileits_demo">
										<a href="images/13.jpg">
											<figure class="w3layouts_work">
												<div class="w3layouts_work_sub">
													<img src="images/13.jpg" alt=" " class="img-responsive" />
												</div>
												<figcaption>
													<span>Nursery</span>
												</figcaption>
											</figure>
										</a>
									</div>
								</div>
								<div class="col-md-4 w3_tab_img_left">
									<div class="agileits_demo">
										<a href="images/23.jpg">
											<figure class="w3layouts_work">
												<div class="w3layouts_work_sub">
													<img src="images/23.jpg" alt=" " class="img-responsive" />
												</div>
												<figcaption>
													<span>Nursery</span>
												</figcaption>
											</figure>
										</a>
									</div>
								</div>
								<div class="clearfix"> </div>
							</div>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="painting" aria-labelledby="painting-tab">
							<div class="w3_tab_img agileinfo_img">
								<div class="col-md-4 w3_tab_img_left">
									<div class="agileits_demo">
										<a href="images/1.jpg">
											<figure class="w3layouts_work">
												<div class="w3layouts_work_sub">
													<img src="images/1.jpg" alt=" " class="img-responsive" />
												</div>
												<figcaption>
													<span>Nursery</span>
												</figcaption>
											</figure>
										</a>
									</div>
								</div>
								<div class="col-md-4 w3_tab_img_left">
									<div class="agileits_demo">
										<a href="images/22.jpg">
											<figure class="w3layouts_work">
												<div class="w3layouts_work_sub">
													<img src="images/22.jpg" alt=" " class="img-responsive" />
												</div>
												<figcaption>
													<span>Nursery</span>
												</figcaption>
											</figure>
										</a>
									</div>
								</div>
								<div class="clearfix"> </div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<!-- //work -->

<!-- newsletter -->
	<div id="newsletter" class="newsletter">
		<div class="container">
			<div class="col-md-5 w3layouts_newsletter_left">
				<h3>Subscribe to our newsletter</h3>
			</div>
			<div class="col-md-6 w3layouts_newsletter_right">
				<form action="#" method="post">
					<input type="email" name="Email" placeholder="Email..." required="">
					<input type="submit" value="Subscribe">
				</form>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
<!-- //newsletter -->

<!-- footer -->
	<div class="w3_agileits_twitter_post">
		<div class="container">
			<h4>"Pellentesque habitant morbi tristique senectus et netus <a href="#">
				http://example.com</a> egestas."</h4>
		</div>
	</div>
	<div class="footer">
		<div class="col-md-6 wthree_footer_grid_left">
			<div class="col-md-5 wthree_footer_grid_left1">
				<h4>About Us</h4>
				<p>Donec viverra nunc eu neque porta, quis laoreet nisl gravida. Proin gravida,
					diam ut consectetur porttitor.</p>
			</div>
			<div class="col-md-4 wthree_footer_grid_left1">
				<h4>Navigation</h4>
				<ul>
					<li><i class="fa fa-arrow-circle-o-right" aria-hidden="true"></i><a href="index.jsp">Home</a></li>
					<li><i class="fa fa-arrow-circle-o-right" aria-hidden="true"></i><a href="#about" class="scroll">About Us</a></li>
					<li><i class="fa fa-arrow-circle-o-right" aria-hidden="true"></i><a href="#programs" class="scroll">Programs</a></li>
					<li><i class="fa fa-arrow-circle-o-right" aria-hidden="true"></i><a href="#newsletter" class="scroll">Newsletter</a></li>
					<li><i class="fa fa-arrow-circle-o-right" aria-hidden="true"></i><a href="#timetable" class="scroll">课程表</a></li>
				</ul>
			</div>
			<div class="col-md-3 wthree_footer_grid_left1">
				<h4>Others</h4>
				<ul>
					<li><i class="fa fa-arrow-circle-o-right" aria-hidden="true"></i><a href="#">Media</a></li>
					<li><i class="fa fa-arrow-circle-o-right" aria-hidden="true"></i><a href="#">Mobile Apps</a></li>
					<li><i class="fa fa-arrow-circle-o-right" aria-hidden="true"></i><a href="#">Privacy Policy</a></li>
				</ul>
			</div>
			<div class="clearfix"> </div>
		</div>
		<div class="col-md-6 wthree_footer_grid_right">
			<div class="wthree_footer_grid_right_main">
				<div class="col-md-5 wthree_footer_grid_right1">
					<h5>Contact Us</h5>
					<ul>
						<li><i class="fa fa-envelope-o" aria-hidden="true"></i><a href="mailto:info@example.com">info@example.com</a></li>
						<li><i class="fa fa-phone" aria-hidden="true"></i>+(000) 123 311</li>
						<li><i class="fa fa-fax" aria-hidden="true"></i>+123 421</li>
					</ul>
				</div>
				<div class="col-md-7 wthree_footer_grid_right2">
					<div class="wthree_footer_grid_right2_w3">
						<a href="#" data-toggle="modal" data-target="#myModal">
							<img src="images/1.jpg" alt=" " class="img-responsive" />
						</a>
					</div>
					<div class="wthree_footer_grid_right2_w3">
						<a href="#" data-toggle="modal" data-target="#myModal">
							<img src="images/12.jpg" alt=" " class="img-responsive" />
						</a>
					</div>
					<div class="wthree_footer_grid_right2_w3">
						<a href="#" data-toggle="modal" data-target="#myModal">
							<img src="images/13.jpg" alt=" " class="img-responsive" />
						</a>
					</div>
					<div class="wthree_footer_grid_right2_w3">
						<a href="#" data-toggle="modal" data-target="#myModal">
							<img src="images/15.jpg" alt=" " class="img-responsive" />
						</a>
					</div>
					<div class="wthree_footer_grid_right2_w3">
						<a href="#" data-toggle="modal" data-target="#myModal">
							<img src="images/22.jpg" alt=" " class="img-responsive" />
						</a>
					</div>
					<div class="wthree_footer_grid_right2_w3">
						<a href="#" data-toggle="modal" data-target="#myModal">
							<img src="images/23.jpg" alt=" " class="img-responsive" />
						</a>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="wthree_footer_grid_right_main1">
				<ul class="agileinfo_social_icons agileits_footer_social">
					<li><a href="#" class="agileits_facebook"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
					<li><a href="#" class="w3_twitter"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
					<li><a href="#" class="w3l_google"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
					<li><a href="#" class="w3ls_dribble"><i class="fa fa-dribbble" aria-hidden="true"></i></a></li>
				</ul>
			</div>
		</div>
		<div class="clearfix"> </div>
	</div>
	<div class="footerpage"></div>
<!-- //footer -->

<!-- contact-effect -->
<script src="js/classie.js"></script>
<script>
	(function() {
		// trim polyfill : https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/Trim
		if (!String.prototype.trim) {
			(function() {
				// Make sure we trim BOM and NBSP
				var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
				String.prototype.trim = function() {
					return this.replace(rtrim, '');
				};
			})();
		}

		[].slice.call( document.querySelectorAll( 'input.input__field' ) ).forEach( function( inputEl ) {
			// in case the input is already filled..
			if( inputEl.value.trim() !== '' ) {
				classie.add( inputEl.parentNode, 'input--filled' );
			}

			// events:
			inputEl.addEventListener( 'focus', onInputFocus );
			inputEl.addEventListener( 'blur', onInputBlur );
		} );

		function onInputFocus( ev ) {
			classie.add( ev.target.parentNode, 'input--filled' );
		}

		function onInputBlur( ev ) {
			if( ev.target.value.trim() === '' ) {
				classie.remove( ev.target.parentNode, 'input--filled' );
			}
		}
	})();
</script>
<!-- //contact-effect -->
<!-- work -->
	<script type="text/javascript"  src="js/jquery.gallery.js" ></script>
	<script>
		$(function() {
			$('.w3_tab_img').createSimpleImgGallery();
		});
	</script>
<!-- //work -->
<!-- flexisel -->
	<script type="text/javascript">
		$(window).load(function() {
			$("#flexiselDemo1").flexisel({
				visibleItems: 5,
				animationSpeed: 1000,
				autoPlay: true,
				autoPlaySpeed: 3000,
				pauseOnHover: true,
				enableResponsiveBreakpoints: true,
				responsiveBreakpoints: {
					portrait: {
						changePoint:480,
						visibleItems: 1
					},
					landscape: {
						changePoint:640,
						visibleItems:3
					},
					tablet: {
						changePoint:768,
						visibleItems: 3
					}
				}
			});

		});
	</script>
	<script type="text/javascript" src="js/jquery.flexisel.js"></script>
<!-- //flexisel -->
<!-- team-slider -->
	<script type="text/javascript" src="js/jquery.glide.js"></script>
	<script type="text/javascript">
		var glide = $('.w3_slider').glide().data('api_glide');

			$(window).on('keyup', function (key) {
				if (key.keyCode === 13) {
					glide.jump(3, console.log('Wooo!'));
				};
			});
	</script>
<!-- //team-slider -->
<!-- responsive-tabs -->
	<script src="js/easy-responsive-tabs.js"></script>
	<script>
		$(document).ready(function () {
		$('#verticalTab').easyResponsiveTabs({
		type: 'vertical',
		width: 'auto',
		fit: true
		});
		});
	</script>
<!-- //responsive-tabs -->	
<!-- text-effect -->
		<script type="text/javascript" src="js/jquery.transit.js"></script> 
		<script type="text/javascript" src="js/jquery.textFx.js"></script> 
		<script type="text/javascript">
			$(document).ready(function() {
					$('.test2').textFx({
						type: 'slideIn',
						direction: 'right',
						iChar: 250,
						iAnim: 1000
					});
			});
		</script>
<!-- //text-effect -->
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!-- start-smoth-scrolling -->
<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			*/
								
			$().UItoTop({ easingType: 'easeOutQuart' });
								
			});
	</script>
<!-- //here ends scrolling icon -->
<!-- for bootstrap working -->
	<script src="js/bootstrap.js"></script>
<!-- //for bootstrap working -->
</body>
</html>