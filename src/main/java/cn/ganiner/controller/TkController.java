package cn.ganiner.controller;


import cn.ganiner.pojo.Tk.*;
import cn.ganiner.service.TkService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tk/")
public class TkController {

    @Autowired
    TkService tkService;

    //查询全部判断题
    @RequestMapping("alljudge.do")
    public String AllJudge(Model model,@RequestParam(defaultValue = "1") int pn){
        PageHelper.startPage(pn,6);
        List<Judge>judges = tkService.AllJudge();
        //创建分页对象
        PageInfo pageInfo = new PageInfo(judges,5);
        //返回分页对象
        model.addAttribute("pageInfo",pageInfo);
        return "page/admin/tk_judge";
    }

    //添加判断题
    @RequestMapping(value = "createjudge.do")
    public String CreateJudge(Judge judge){
        tkService.CreateJudge(judge);
        return "redirect:alljudge.do";
    }
    //删除判断题
    @RequestMapping(value = "deletejudge.do")
    public String DeleteJudge(@RequestParam Long id){
        tkService.DeleteJudge(id);
        return "redirect:alljudge.do";
    }

     //更新判断题
    @RequestMapping(value = "upjudge.do")
    public String UpJudge(Judge judge){
        tkService.UpdateJudge(judge);
        return "redirect:alljudge.do";
    }
    //根据题目id查询
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
    //批量删除判断题
    @RequestMapping(value = "deletemanyjudge.do")
    public String ManyJudge(String chk_value){
     tkService.deleteManyJudge(chk_value);
     return "redirect:alljudge.do";
    }

}
