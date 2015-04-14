<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/views/common.jsp"%>

<header id="header">
	<%--
	<c:choose>
				<c:when test="${empty contextUser}">
				<li><a href="/passport">登录</a></li>
				</c:when>
				<c:otherwise>
				<li class="accountinfo"><span>您好，<a href="/my">${contextUser.realname}</a></span></li>
				<li><a href="/passport/logout">退出</a></li>
				</c:otherwise>
			</c:choose>
	 --%>
	
	<h1 class="logo"><a href="/" title="法律E世界"><img src="/styles/theme/images/logo.png" alt="月旦法学知识库" />法律E世界，月旦法学知识库，燕大元照法学网，燕大元照</a>测试</h1>
	<div class="menubar">
		<ul>
			<li class="home selected"><a href="/chapters"><span>测试页面</span></a></li>
			<!--<li><a href="periodical.html"><span>期刊</span></a></li>
			<li><a href="#"><span>图书文献</span></a>
				<ul>
					<li><a href="#">图书文献库</a></li>
					<li><a href="#">法学名家</a></li>
				</ul>
			</li>
			<li><a href="#"><span>词典工具书</span></a>
				<ul>
					<li><a href="#">元照英美法词典</a></li>
					<li><a href="#">英汉法律词典</a></li>
					<li><a href="#">英汉法律缩略语词典</a></li>
					<li><a href="#">英汉法律用语大词典</a></li>
				</ul>
			</li>
			<li><a href="#"><span>常用法规</span></a>
				<ul>
					<li><a href="#">台湾法规</a></li>
					<li><a href="#">大陆法规</a></li>
				</ul>
			</li>
			<li><a href="#"><span>判解精选</span></a>
				<ul>
					<li><a href="#">大法官解释</span></a>
					<li><a href="#">司法解释</span></a>
					<li><a href="#">最高法院判例 - 民事</span></a>
					<li><a href="#">最高法院判例 - 刑事</span></a>
					<li><a href="#">最高法院决议 - 民事</span></a>
					<li><a href="#">最高法院决议 - 刑事</span></a>
					<li><a href="#">最高法院裁判 - 民事</span></a>
					<li><a href="#">最高法院裁判 - 刑事</span></a>
					<li><a href="#">最高行政法院判例</span></a>
					<li><a href="#">最高行政法院裁判</span></a>
					<li><a href="#">大陆裁判</span></a>
				</ul>
			</li>
			<li><a href="#"><span>教学案例</span></a></li>
			<li><a href="#"><span>博硕论文</span></a></li>
			<li><a href="#"><span>大陆文献索引</span></a>
			</li>
			<li class="last"><a href="#"><span>题库讲座</span></a>
				<!--ul>
					<li><a href="#">台湾地区</a></li>
					<li><a href="#">法研历解</a></li>
					<li><a href="#">大陆地区</a></li>
					<li><a href="#">法观人</a></li>
				</ul-->
			</li>
		</ul>
	</div>
	<ul class="companyLinks">
		<li class="angle-com-tw"><a href="http://www.angle.com.tw/" target="_blank">台湾 元照，网上书店</a></li>
	</ul>
</header>