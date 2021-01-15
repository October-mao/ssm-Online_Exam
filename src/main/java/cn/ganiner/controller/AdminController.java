package cn.ganiner.controller;

import cn.ganiner.pojo.User;
import cn.ganiner.service.TeacherService;
import cn.ganiner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin/")
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "findstuscore.do")
    public String FindStuScore(){
        return "page/admin/student_score";
    }
}
