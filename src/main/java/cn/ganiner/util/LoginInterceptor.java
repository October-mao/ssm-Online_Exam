package cn.ganiner.util;

import cn.ganiner.pojo.Student;
import cn.ganiner.pojo.Teacher;
import cn.ganiner.pojo.User;
import org.apache.poi.poifs.filesystem.Ole10Native;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//拦截器
public class LoginInterceptor implements HandlerInterceptor {
    // 拦截所有请求
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //获取请求的url
        String url = request.getRequestURI();
        //URL：除了登入请求外，其他的URL都进行拦截控制2
        if (url.contains("/login.do")){
            return true;
        }
        //获取session
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("usersession");
        Student student = (Student) session.getAttribute("studentsession");
        Teacher teacher = (Teacher) session.getAttribute("teachersession");
        //判断Session是否有用户数据，如果有返回true，继续向下执行
        if (user!=null){
            return true;
        }else if (student!=null){
            return true;
        }else if (teacher!=null){
            return true;
        }
        //不符合条件的给出提示信息，并转发到登入页面
        request.setAttribute("msg","您还未登入，请先登入！");
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request,response);
        return false;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

