<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>学生首页</title>
    <!-- Bootstrap Core CSS -->
    <link href="<%=basePath%>/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
    <link href="<%=basePath%>/vendor/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=basePath%>/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="<%=basePath%>/vendor/js/123.js"></script>
    <script src="<%=basePath%>/vendor/js/456.js"></script>
    <![endif]-->

</head>

<body>

<div id="wrapper">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">在线考试系统</a>
        </div>
        <!-- /.navbar-header -->

        <ul class="nav navbar-top-links navbar-right">
            <!-- /.dropdown -->
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i> ${sessionScope.studentsession.username}&nbsp;<i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="<%=basePath%>/student/studentup.do?username=${sessionScope.studentsession.username}">
                        <i class="fa fa-gear fa-fw"></i> 更改密码</a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="<%=basePath%>/student/logout.do"><i class="fa fa-sign-out fa-fw"></i> 退出</a>
                    </li>
                </ul>
                <!-- /.dropdown-user -->
            </li>
            <!-- /.dropdown -->
        </ul>
        <!-- /.navbar-top-links -->

        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">
                    <li>
                        <a href="<%=basePath%>/student/tologin.do"><i class="fa fa-dashboard fa-fw"></i>首页</a>
                    </li>
                    <li>
                        <a href="<%=basePath%>/exam/examallstu.do?studentid=${sessionScope.studentsession.id}">
                            <i class="fa fa-gear fa-fw"></i>考试</a>
                    </li>
                    <li>
                        <a href="<%=basePath%>/exam/examhistory.do?studentid=${sessionScope.studentsession.id}">
                            <i class="fa fa-edit fa-fw"></i>试卷回顾</a>
                    </li>
                </ul>
            </div>
            <!-- /.sidebar-collapse -->
        </div>
        <!-- /.navbar-static-side -->
    </nav>
    <!-- Page Content -->
    <div id="page-wrapper">
        <div class="box">
            <br><br><br>
            <div class="function"><p>[通知]考试系统已开放</p></div>
            <div class="form">
                <table class="news">
                    <tr><td><b>关于本学期校级考试相关事宜安排的通知</b></td></tr>
                    <tr><td>各学院及相关单位:</td></tr>
                    <tr><td>根据学校教学安排，下星期全校考试定于6月8日-6月12日 考试周，考试工作将从6月8日开始。现将有关事项通知如下：</td></tr>
                    <tr><td>一、考试时间：6月8日----6月12日</td></tr>
                    <tr><td>二、学生登录考试管理系统后进入学生考试进行考试。学生考试前请认真阅读考试公告，再进行“网上考试”。</td></tr>
                    <tr><td>三、教师可登陆考试管理系统后进入试卷试题的增删查改， 6月12日14:00之后各位教师及学生登录教务处网站查询自己试卷及其考试成绩。</td> </tr>
                    <tr><td>四、考试均须在选课时间内完成，考试结束后不再进行补退选，请学生注意考试时间。</td></tr>
                    <tr><td>五、请各学院通知并组织学生进行考试，同时请各学院及相关单位通知任课教师按时出卷。教务处将组织相关人员对上课情况进行不定期的检查。</td></tr>
                    <tr><td align="right">2020-6-5</td></tr>
                </table>
            </div>
        </div>

    </div>
    <!-- /#page-wrapper -->

</div>
<!-- jQuery -->
<script src="<%=basePath%>/vendor/jquery/jquery.min.js"></script>
<script src="<%=basePath%>/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=basePath%>/vendor/metisMenu/metisMenu.min.js"></script>
<script src="<%=basePath%>/vendor/dist/js/sb-admin-2.js"></script>
</body>

</html>

