package cn.ganiner.controller;


import cn.ganiner.pojo.Tk.*;
import cn.ganiner.service.TkService;
import cn.ganiner.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tea_tk/")
public class Tk_TeacherController {
    @Autowired
    TkService tkService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "tea_addchoice.do")
    public String createchoice(Choice choice, Model model){
        try{
            userService.createchoice(choice);
            model.addAttribute("message", "保存章节成功");
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:tea_findallchoice.do";
    }
    @RequestMapping(value = "tea_findallchoice.do")
    public String findChoiceAll(Model model, @RequestParam(defaultValue = "1") int pn){
        PageHelper.startPage(pn,6);

        List<Choice>choice = userService.findChoiceAll();
        PageInfo pageInfo = new PageInfo(choice,5);
        model.addAttribute("pageInfo",pageInfo);
        return  "page/teacher/tea_choice";
    }
    @RequestMapping(value = "deletechoiceall.do")
    public String ManyChoice(String chk_value){
        userService.deleteManyChoice(chk_value);
        return "redirect:tea_findallchoice.do";
    }
    @ResponseBody
    @RequestMapping(value = "tea_findBychId.do")
    public Choice findBychId(@RequestBody Choice choice) {
        Choice choice_info = userService.findBychId(choice.getId());
        if (choice_info != null) {
            return choice_info;
        } else {
            return null;
        }
    }
    @RequestMapping(value = "tea_updatech.do")
    public String updatech(Choice choice, Model model) {
        try {
            userService.updatech(choice);
            model.addAttribute("message", "更新老师信息成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:tea_findallchoice.do";
    }

    @RequestMapping(value = "tea_deletech.do")
    public String deletech(@RequestParam Long id, Model model) {
        try {
            userService.deletech(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:tea_findallchoice.do";
    }


    @RequestMapping(value = "alljudge.do")
    public String AllJudge(Model model, @RequestParam(defaultValue = "1") int pn){

        PageHelper.startPage(pn,6);
        List<Judge>judges = tkService.AllJudge();
        PageInfo pageInfo = new PageInfo(judges,5);
        model.addAttribute("pageInfo",pageInfo);
        return "page/teacher/tea_judge";
    }

    @RequestMapping(value = "createjudge.do")
    public String CreateJudge(Judge judge){
        tkService.CreateJudge(judge);
        return "redirect:alljudge.do";
    }
    @RequestMapping(value = "deletejudge.do")
    public String DeleteJudge(@RequestParam Long id){
        tkService.DeleteJudge(id);
        return "redirect:alljudge.do";
    }
    @RequestMapping(value = "upjudge.do")
    public String UpJudge(Judge judge){
        tkService.UpdateJudge(judge);
        return "redirect:alljudge.do";
    }

    @ResponseBody
    @RequestMapping(value = "judgeId.do")
    public Judge findJudgeId(@RequestBody Judge judge){
        Judge judges = tkService.findJudgeId(judge.getId());
        if(judges != null){
            return judges;
        }else {
            return null;
        }
    }
    @RequestMapping(value = "deletemanyjudge.do")
    public String ManyJudge(String chk_value){
        tkService.deleteManyJudge(chk_value);
        return "redirect:alljudge.do";
    }
}
