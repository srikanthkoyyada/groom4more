<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<!-- Google font -->
<link href='http://fonts.googleapis.com/css?family=Lato:300,400,700'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Raleway:300,400,700,900'
	rel='stylesheet' type='text/css'>
<!-- Css -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/library/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/library/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/library/owl.carousel.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/md-font.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css">
<style>
/* Pricing table #1 */
.pricel {
	text-align: center;
	margin-top: 10px;
	margin-bottom: 20px !important;
}

.plist a i {
	color: #333;
}

.plist a:hover i {
	color: #333;
	text-decoration: none;
}

.pricel .phead-top {
	margin: 0px;
	padding: 15px 10px;
}

.pricel .phead-top h4 {
	color: #fff;
}

.pricel .phead-bottom {
	background: #f8f8f8;
	border-left: 1px solid #ddd;
	border-right: 1px solid #ddd;
	border-bottom: 1px solid #ddd;
	margin: 0px;
	padding: 10px 10px 5px 10px;
	color: #777;
	font-weight: 700;
	font-size: 18px;
	line-height: 27px;
}

.pricel .pst {
	font-size: 12px;
	position: relative;
	top: -5px;
	font-weight: normal;
}

.pricel .psb {
	font-size: 12px;
	font-weight: normal;
}

.pricel .pbutton {
	background: #eee;
	border: 1px solid #ddd;
	padding: 10px 0px 15px 0px;
	color: #777;
	font-size: 20px;
	text-align: center;
	margin-top: 0px;
}

.pricel .plist {
	border-left: 1px solid #ddd;
	border-right: 1px solid #ddd;
	background: #fcfcfc;
}

.pricel .plist ul {
	margin-left: 0px;
	margin-bottom: 0px !important;
	padding-left: 0px;
}

.pricel .plist li {
	list-style-type: none;
	background: none;
	padding: 13px 0px;
	font-size: 12px;
	border-bottom: 1px solid #e1e1e1;
}

.pricel .plist li:nth-child(even) {
	background-color: #f8f8f8;
}

.pricel .plist li:hover {
	background: #fff;
}

.pricel .phead-top {
	display: block;
}

/* Pricing #2 */
.pricing-two .pricel {
	max-width: 260px;
	margin: 40px auto;
}

.pricing-two .phead-top {
	padding-top: 60px;
}

.phead-round {
	width: 80px;
	height: 80px;
	line-height: 22px;
	margin: 0 auto;
	padding-top: 20px;
	border-radius: 100px;
	border: 4px solid #fff;
	cursor: pointer;
	color: #fff;
	-webkit-transition: background 1s ease;
	-moz-transition: background 1s ease;
	-o-transition: background 1s ease;
	transition: background 1s ease;
	margin-top: -150px;
}

.pricing-two .pricel .phead-top {
	border-top-left-radius: 10px;
	border-top-right-radius: 10px;
	text-transform: uppercase;
}

.phead-round:hover {
	-webkit-transition: background 1s ease;
	-moz-transition: background 1s ease;
	-o-transition: background 1s ease;
	transition: background 1s ease;
}

.phead-round span {
	display: block;
	font-size: 13px;
	font-weight: normal;
}
</style>
<!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
    <![endif]-->
<title>Olympiad - Groom4More</title>
</head>
<!--/head-->
<body id="page-top" class="home">
	<!-- PAGE WRAP -->
	<div id="page-wrap">
		<!-- HEADER -->
		<jsp:include page="/jsp/header.jsp"></jsp:include>
		<!-- END / HEADER -->

		<section class="sub-banner sub-banner-course">
			<div class="awe-static bg-sub-banner-course"></div>
			<div class="container">
				<div class="sub-banner-content">
					<h2 class="text-center">Olympiad</h2>
				</div>
			</div>
		</section>
		<!-- END / SUB BANNER -->
		<!-- BLOG -->
		<section id="questions" class="questions" style="min-height: 520px;">
			<div class="container">
				<div class="row">
					<div class="col-md-10 col-md-offset-1">
						<div class="tabs-page">
							<ul class="nav-tabs" role="tablist">
								<li class="active"><a href="#introduction" role="tab"
									data-toggle="tab">Introduction</a></li>
								<li><a href="#goals" role="tab" data-toggle="tab">Goal of Course</a></li>
								<li><a href="#judgement" role="tab" data-toggle="tab">Judgement</a></li>
								
								<li><a href="#conment" role="tab" data-toggle="tab"></a></li>
							</ul>
							<!-- Tab panes -->
							<div class="tab-content">
								<!-- INTRODUCTION -->
								<div class="tab-pane fade in active" id="introduction">


									<div class="row" style="align: center;">
										
										<div class="col-md-12 text-justify">
											<h4 class="sm black bold">Introduction</h4>
											<div class="col-md-8 text-justify">
											<p>Olympiads are conducted by various educational
												organizations around the world. Mainly, Olympiads are
												conducted as annual competitions for school students in
												subjects like Math, Science, Computers,Astronomy,
												Philosophy, Social sciences, Linguistics, Earth science etc.
												The main objective of an Olympiad is to evaluate a student's
												subject in a particular subject.</p>
											<p>This also plays a key role in shaping students future
												goals according to their interests. Along with evaluating a
												student, Olympiads also evaluates the study methods adapted
												by several educational institutions.Most popular Olympiads
												conducted in India are the International Mathematics
												Olympiad and theNational Science Olympiad conducted by
												Science Olympiad Foundation (SOF). These two Olympians
												gained the most popularity these days. Every year, thousands
												of students around the world apply forOlympiads. Students
												from classes 2nd-12th can apply for the Olympiads conducted
												by SOF.</p>
												<p>The ScienceOlympiad 2012 is also a great Olympiad
												apart from International Mathematics Olympiad and
												theNational Science Olympiad. The science Olympiad is
												conducted by Indira Gandhi National OpenUniversity (IGNOU)
												in collaboration with the United Nations Educational
												Scientific and CulturalOrganization (UNESCO).</p>
												</div>
												<div class="col-md-4">
											<div class="pricel">
												<h5 class="phead-top tabred">Grand Tests</h5>
												<div class="phead-bottom" align="center">
													<img src="<%=request.getContextPath()%>/images/111.jpg"
														alt="" style="height: 100px; width: 100px;" />
												</div>
												<div class="plist">
													<p>Test your over all skills here. Every week, you will
														be able to participate in one grand test, get analysis and
														improve your performances. This is the start of something
														amazing in your IIT preparation Journey.</p>
												</div>
												<div class="pbutton button">
													<s:form action="start-test" method="post" align="center"
														theme="simple">
														<s:hidden name="category" value="grand"></s:hidden>
														<s:hidden name="testCategory" value="2"></s:hidden>
														<s:submit cssClass="mc-btn btn-style-1"
															style="background: #ff5d5e; color: #FFF;" value="PROCEED"></s:submit>
													</s:form>
												</div>
											</div>
										</div>
											
											<p>This Olympiad is conducted for the students of Class
												XI in various south Asian countries (India, Sri Lanka,
												Afghanistan, Bangladesh, Bhutan, Maldives, Nepal and
												Pakistan).Olympiads are the best platforms for the young
												brains to test their skills. As the standard of an Olympiad
												is high, the rewards also weigh fairly. The goodies the
												students can get ranges from PCs, laptops, mobile phones,
												cash prizes along with fellowship access to a good
												university. Apart from that, each student who attends the
												Olympiad gets a participation certificate according to the
												levels that they have passed.Covering textbooks only doesn't
												matter for attending an Olympiad; the student should know
												more than what is printed in the textbooks.</p>
											<p>Along with their high standard skills, students also
												need to practice well to do their best in the Olympiad.
												Students who wish to prepare and participate for such
												Olympiads must improve their knowledge by reading good
												Olympiad guides.</p>
											
										</div>



									</div>
								</div>
								
								<div class="tab-pane fade" id="goals">
									
									<h4 class="sm black bold">Goal of Course</h4>
											<ul class="list-disc">
												<li><p></p></li>
												<li><p></p></li>
											</ul>
									<p>
										
									</p>
								</div>
								<div class="tab-pane fade" id="judgement">
									<h4 class="sm black bold">About Judgement</h4>
									<p>
										
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- END / BLOG -->
		<!-- FOOTER -->
		<jsp:include page="/jsp/footer.jsp"></jsp:include>
		<!-- END / FOOTER -->
	</div>
	<!-- END / PAGE WRAP -->

	<!-- Load jQuery -->
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/library/jquery-1.11.0.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/library/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/library/jquery.owl.carousel.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/library/jquery.appear.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/library/perfect-scrollbar.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/library/jquery.easing.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/scripts.js"></script>
	<script>
		$('document').ready(function() {
			$('#tests').removeClass();
			$('#tests').addClass('current-menu-item');
		});
	</script>
</body>
</html>