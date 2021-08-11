<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
    <head>  
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>:: servicePage ::</title>
        <link rel="icon" type="image/x-icon" href="../resources/img/assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css2?family=Sunflower:wght@300&display=swap" rel="stylesheet">
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="../resources/css/style-servicePage.css" rel="stylesheet" />
    </head>
    <body id="page-top">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="#page-top">Suwon Animal Find Platform</a>
                <button class="navbar-toggler navbar-toggler-right" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item"><a class="nav-link" href="#about">About</a></li>
                        <li class="nav-item"><a class="nav-link" href="#projects">Projects</a></li>
                        <li class="nav-item"><a class="nav-link" href="#signup">Contact</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- Masthead-->
        <header class="masthead">
            <div class="container px-4 px-lg-5 d-flex h-100 align-items-center justify-content-center">
                <div class="d-flex justify-content-center">
                    <div class="text-center">
                        <h1 class="mx-auto my-0 text-uppercase">about</h1>
                        <h2 class="text-white-50 mx-auto mt-2 mb-5">This page, Suwon Animal Find Platform for many animal owners, is created by KCK.</h2>
                        <a class="btn btn-primary" href="#about">Get Started</a>
                    </div>
                </div>
            </div>
        </header>
        <!-- About-->
        <section class="about-section text-center" id="about">
            <div class="container px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-lg-8 fontSetting">
                        <h2 class="text-white mb-4">서비스 소개</h2>
                        <p class="text-white-50">
			                            최근 애견·애묘 등 반려동물과 함께하는 인구가 증가하고 있다. 
							국내 반려인구는 2015년에 이미 1,000만 시대에 진입했고 올해는 1500만 명을 넘어섰다.
							이는 국민 서너 명 중 한명 꼴로 가정에서 반려동물을 기르고 있는 셈이다. <br><br>
							이러한 흐름에 발맞춰 최근에는 반려동물 관련 서비스 산업 또한 고급화와 다양화 되고 있다. 
							최근에는 수가 늘어난 반려인들은 연결해 반려동물 분실 시 정보를 공유해 도움을 요청할 수 있는 여러 앱, 웹 서비스들이 등장 하였다.<br><br>
							하지만 사이트 별 상이한 카테고리와 광범위한 지역 설정으로 인해 상용화에 어려움을 겪고 있다.<br>
							이에 해당 서비스를 진행하는 바, 수원 내 분실동물만을 다루어 사용자 접근성은 높이고 ui는 직관적으로 배치 하여 사용성을 높이도록 하였다.
                        </p>
                    </div>
                </div>
                <img class="img-fluid" src="../resources/img/assets/img/ipad.png" alt="..." />
            </div>
        </section>
        <!-- Projects-->
        <section class="projects-section bg-light" id="projects">
            <div class="container px-4 px-lg-5">
                <!-- Featured Project Row-->
                <div class="row gx-0 mb-4 mb-lg-5 align-items-center">
                    <div class="col-xl-8 col-lg-7"><img class="img-fluid mb-3 mb-lg-0s" src="../resources/img/assets/img/masthead.png" alt="..." /></div>
                    <div class="col-xl-4 col-lg-5">
                        <div class="featured-text text-center text-lg-left">
                            <h4>To Be Updated!</h4>
                            <p class="text-black-50 mb-0 fontSetting" style="text-align: left">
                            	 - 자유게시판 업데이트 예정 <smaller>2021-11-22 ver 1.2.5</smaller><br>
                            	 - 실시간 댓글 기능 업데이트 예정 <smaller>2022-01-23 ver 1.2.6</smaller><br>
                            	 - 반려동물 용품 관련 중고거래 게시판 업데이트 예정 <smaller>2022-03-25 ver 1.2.7</smaller>
                            </p>
                        </div>
                    </div>
                </div>
                <!-- Project One Row-->
                <div class="row gx-0 mb-5 mb-lg-0 justify-content-center">
                    <div class="col-lg-6"><img class="img-fluid" src="../resources/img/assets/img/img-01.png" alt="..." /></div>
                    <div class="col-lg-6">
                        <div class="bg-black text-center h-100 project">
                            <div class="d-flex h-100">
                                <div class="project-text w-100 my-auto text-center text-lg-left">
                                    <h4 class="text-white">Project Direction</h4>
                                    <p class="mb-0 text-white-50 fontSetting">1000만 애견인 시대에 발맞춘 분실동물 찾기 플랫폼 서비스로, <br>지역을 한정하여 정확도 및 신속성 향상 </p>
                                    <hr class="d-none d-lg-block mb-0 ms-0" />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Project Two Row-->
                <div class="row gx-0 justify-content-center">
                    <div class="col-lg-6"><img class="img-fluid" src="../resources/img/assets/img/img-02.png" alt="..." /></div>
                    <div class="col-lg-6 order-lg-first">
                        <div class="bg-black text-center h-100 project">
                            <div class="d-flex h-100">
                                <div class="project-text w-100 my-auto text-center text-lg-right">
                                    <h4 class="text-white">Go to Related Sites!</h4>
                                    <p class="mb-0">
                                    	<div class="site fontSetting">
											<li><a href="https://www.animal.go.kr/front/awtis/protection/protectionList.do?menuNo=1000000060"><i class="fas fa-caret-right"></i>동물보호관리시스템 바로가기(전국 보호 중 동물)</a></li>
											<li><a href="https://www.instagram.com/suwonacc/"><i class="fas fa-caret-right"></i>수원시 동물 보호센터 인스타그램 바로가기 </a></li>
											<li><a href="https://quickprint.co.kr/category/%EB%B0%98%EB%A0%A4%EB%8F%99%EB%AC%BC%EC%B0%BE%EA%B8%B0-%EC%A0%84%EB%8B%A8/212/"><i class="fas fa-caret-right"></i>반려동물 찾기 전단지 퀵프린트 </a></li>
										</div>     
                                    </p>
                                    <hr class="d-none d-lg-block mb-0 me-0" />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- feedback-->
        <section class="signup-section" id="signup">
            <div class="container px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5">
                    <div class="col-md-10 col-lg-8 mx-auto text-center">
                        <i class="far fa-paper-plane fa-2x mb-2 text-white"></i>
                        <h2 class="text-white mb-5">Send us your comments!</h2>
 
 						
                        <form class="form-signup" id="contactForm" data-sb-form-api-token="API_TOKEN">
                            <!-- Email address input-->
                            <div class="row input-group-newsletter">
                                <div class="col"><input class="form-control" id="emailAddress" type="email" placeholder="Please write your comments..." aria-label="Send us your comments" /></div>
                                <div class="col-auto"><button class="btn btn-primary disabled" id="submitButton" type="submit">Send!</button></div>
                                <div><p style="font-family: 'Sunflower', sans-serif; font-size: 12px; color: lightgray; padding-top: 20px;">* 사이트 개선사항에 대한 코멘트를 자유롭게 보내주세요!</p></div>
                            </div>
                            
                            <div class="d-none" id="submitSuccessMessage">
                                <div class="text-center mb-3 mt-2 text-white">
                                    <div class="fw-bolder">Your comment has been sent successful!</div>
                                    Thank you for your valuable comments
                                </div>
                            </div>
                            <!-- Submit error message-->
                            <!---->
                            <!-- This is what your users will see when there is-->
                            <!-- an error submitting the form-->
                            <div class="d-none" id="submitErrorMessage"><div class="text-center text-danger mb-3 mt-2">Error sending message!</div></div>
                            
                        </form>
                        
                    </div>
                </div>
            </div>
        </section>
        <!-- Contact-->
        <section class="contact-section bg-black">
            <div class="container px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5">
                    <div class="col-md-4 mb-3 mb-md-0">
                        <div class="card py-4 h-100">
                            <div class="card-body text-center">
                                <i class="fas fa-map-marked-alt text-primary mb-2"></i>
                                <h4 class="text-uppercase m-0">Address</h4>
                                <hr class="my-4 mx-auto" />
                                <div class="small text-black-50 fontSetting">경기도 수원시 팔달구 매산동 매산로 12-1</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 mb-3 mb-md-0">
                        <div class="card py-4 h-100">
                            <div class="card-body text-center">
                                <i class="fas fa-envelope text-primary mb-2"></i>
                                <h4 class="text-uppercase m-0">Email</h4>
                                <hr class="my-4 mx-auto" />
                                <div class="small text-black-50"><a href="#!">kck827@yourdomain.com</a></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 mb-3 mb-md-0">
                        <div class="card py-4 h-100">
                            <div class="card-body text-center">
                                <i class="fas fa-mobile-alt text-primary mb-2"></i>
                                <h4 class="text-uppercase m-0">Phone</h4>
                                <hr class="my-4 mx-auto" />
                                <div class="small text-black-50">+82 (031) 123-4567</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="social d-flex justify-content-center">
                    <a class="mx-2" href="#!"><i class="fab fa-twitter"></i></a>
                    <a class="mx-2" href="#!"><i class="fab fa-facebook-f"></i></a>
                    <a class="mx-2" href="#!"><i class="fab fa-github"></i></a>
                </div>
            </div>
        </section>
        <!-- Footer-->
        <footer class="footer bg-black small text-center text-white-50"><div class="container px-4 px-lg-5">COPYRIGHT &copy; KCK All Rights Reserved.</div></footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="../resources/script/script-servicePage.js"></script>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    </body>

</html>


<!-- <body id="bodyServicePate">

	<div class="wrapServicePage">
	
		<section class="sectionServicePage">
			<div>
				<h2>K C K</h2>
				<P><i class="fab fa-accusoft"></i><P>
				<P>KOREA CODING KING</P>
			</div>
			<div class="serviceIntroduce">
				<h2>서비스 소개</h2>
				<p>
				최근 애견·애묘 등 반려동물과 함께하는 인구가 증가하고 있다. <BR>
				국내 반려인구는 2015년에 이미 1,000만 시대에 진입했고 올해는 1500만 명을 넘어섰다. <BR>
				이는 국민 서너 명 중 한명 꼴로 가정에서 반려동물을 기르고 있는 셈이다.  <BR>
				이러한 흐름에 발맞춰 최근에는 반려동물 관련 서비스 산업 또한 고급화와 다양화 되고 있다. <BR>
				최근에는 수가 늘어난 반려인들은 연결해 반려동물 분실 시 정보를 공유해 도움을 요청할 수 있는 여러 앱, 웹 서비스들이 등장 하였다.<BR>
				하지만 사이트 별 상이한 카테고리와 광범위한 지역 설정으로 인해 상용화에 어려움을 겪고 있다. <BR>
				이에 해당 서비스를 진행하는 바, 수원 내 분실동물만을 다루어 사용자 접근성은 높이고 ui는 직관적으로 배치 하여 사용성을 높임.
				</p>
			</div>
			<div class="alliance">
				<h2>제휴문의</h2>
				<p>
				The Lorm alphabet is a method of tactile signing named after Hieronymus Lorm, <BR>
				who developed it in the late 19th century. Letters are spelled by tapping or stroking <BR>
				different parts of the listener's hand.[1] The Lorm alphabet is mostly used in German-speaking countries, <BR>
				the Netherlands, Czech Republic, Poland and Georgia.
				</p>
			</div>
			<div class="serviceCenter">
				<h2>고객센터</h2>
				<p>
				The Lorm alphabet is a method of tactile signing named after Hieronymus Lorm, <BR>
				who developed it in the late 19th century. Letters are spelled by tapping or stroking <BR>
				different parts of the listener's hand.[1] The Lorm alphabet is mostly used in German-speaking countries, <BR>
				the Netherlands, Czech Republic, Poland and Georgia.
				</p>
			</div>
			<div class="notice">
				<h2>공지사항</h2>
				<p>
				The Lorm alphabet is a method of tactile signing named after Hieronymus Lorm, <BR>
				who developed it in the late 19th century. Letters are spelled by tapping or stroking <BR>
				different parts of the listener's hand.[1] The Lorm alphabet is mostly used in German-speaking countries, <BR>
				the Netherlands, Czech Republic, Poland and Georgia.
				</p>
			</div>
		
		
		</section>
		<div class="btnServicePage">
			<div class="sidebtn0" type="button" onclick="goTop()">TOP</div>
			<div class="sidebtn3" onclick="window.scrollTo(3500,3500);">미정미정</div>
			sidebtn1,2는 qna페이지에서 설명글로 씀
			<div class="sidebtn4" onclick="window.scrollTo(2500,2500);">관련사이트</div>
			<div class="sidebtn5" onclick="window.scrollTo(1700,1700);">제휴문의</div>
			<div class="sidebtn6" onclick="window.scrollTo(850,850);">서비스소개</div>
		</div>
	</div>	
</body> -->