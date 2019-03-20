package com.example.demo.controller;

import com.example.demo.pojo.Administrator;
import com.example.demo.pojo.Source;
import com.example.demo.pojo.Specialrule;
import com.example.demo.pojo.UserInfo;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = {"/"})
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IAlertService alertService;

    @Autowired
    private IMaintenanceService maintenanceService;

    @Autowired
    private ISourceService sourceService;

    @Autowired
    private IIgnoreService ignoreService;

    @Autowired
    private ISpecialService specialService;

    @Autowired
    private ISpecialruleService specialruleService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/index")
    public String index(HttpSession session,Model model) {
        Administrator admin=(Administrator)session.getAttribute("admin");
        model.addAttribute("admin",admin);
        return "index";
    }

    @RequestMapping("/addlogin")
    public String addlogin(HttpServletRequest request, Model model, HttpSession session){
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Administrator admin = adminService.findByNameAndPassword(name,password);
        String str = "";
        if (admin !=null){
            model.addAttribute("admin",admin);
            session.setAttribute("admin",admin);
            str = "index";
        }else {
            str = "login";
        }
        return str;
    }

    @RequestMapping("/changepassword")
    public String changepassword(){
        return "changepassword";
    }

    @RequestMapping("/addchangepassword")
    @ResponseBody
    public Map<String,String> addchangepassword(HttpServletRequest request, HttpSession session){
        Map<String,String> map=new HashMap<>();
        String password = request.getParameter("password");
        Administrator admin = (Administrator) session.getAttribute("admin");
        String name = admin.getAdmin_name();
        Integer version = adminService.getVersionByName(name);
        Integer issuccess=adminService.changePasswordByName(name,password,version);
        map.put("issuccess",""+issuccess);
        return map;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }

    @RequestMapping("/showuser")
    public String showuser(Model model){
        List userlist=userService.getAllUser();
        model.addAttribute("userlist",userlist);
        return "usershow";
    }

    @RequestMapping("/showsubuser")
    public String showsubuser(Model model){
        List subuserlist=userService.getAllSubUser();
        model.addAttribute("subuserlist",subuserlist);
        return "subusershow";
    }

    @RequestMapping("/userdetail")
    public String userdetail(HttpServletRequest request,Model model,HttpSession session){
        Integer userid=0;
        if(request.getParameter("userid")!=null){
            userid=Integer.parseInt(request.getParameter("userid"));
        }
        else{
            userid=(Integer)session.getAttribute("userid");
        }
        List subuserlist=userService.getUserByGroup(userid);
        model.addAttribute("subuserlist",subuserlist);
        List unsubuserlist=userService.getUserExceptGroup(userid);
        model.addAttribute("unsubuserlist",unsubuserlist);
        session.setAttribute("userid",userid);
        return "userdetail";
    }

    @RequestMapping("/subuserdetail")
    public String subuserdetail(HttpServletRequest request,Model model,HttpSession session){
        Integer userid=0;
        if(request.getParameter("userid")!=null){
            userid=Integer.parseInt(request.getParameter("userid"));
        }
        else{
            userid=(Integer)session.getAttribute("userid");
        }
        UserInfo subuser=userService.getUserById(userid);
        model.addAttribute("subuser",subuser);
        session.setAttribute("userid",userid);
        return "subuserdetail";
    }

    @RequestMapping("/showalert")
    public String showalert(Model model){
        List alertlist=alertService.getAllAlert();
        model.addAttribute("alertlist",alertlist);
        return "alertshow";
    }

    @RequestMapping("/listalert")
    @ResponseBody
    public Map<String,Object> listalert(@RequestParam(value = "limit", required = false)Integer limit, @RequestParam(value = "offset", required = false)Integer offset, @RequestParam(value = "searchday", required = false)String searchday) {
        Map<String,Object> map = new HashMap<>();
        List alertlist = new ArrayList();
        if(searchday.length()==0){
            alertlist=alertService.getAllAlert();
        }
        else{
            alertlist=alertService.getAlertByDate(searchday);
        }
        List newalertlist = new ArrayList();
        for (int i = offset; i < limit+offset; i++) {
            if(i < alertlist.size())
                newalertlist.add(alertlist.get(i));
        }
        map.put("total", alertlist.size());
        map.put("rows", newalertlist);
        return map;
    }

    @RequestMapping("/searchalertbydate")
    public String searchalertbydate(HttpServletRequest request,Model model){
        String date=request.getParameter("searchdate");
        List alertlist=alertService.getAlertByDate(date);
        model.addAttribute("alertlist",alertlist);
        return "alertshow";
    }

    @RequestMapping("/showsource")
    public String showsource(Model model){
        List sourcelist=sourceService.getAllSourceGroup();
        model.addAttribute("sourcelist",sourcelist);
        return "sourceshow";
    }

    @RequestMapping("/showadmin")
    public String showadmin(Model model){
        List adminlist=adminService.getAllAdmin();
        model.addAttribute("adminlist",adminlist);
        return "adminshow";
    }

    @RequestMapping("/admindetail")
    public String admindetail(HttpServletRequest request,Model model){
        String name=request.getParameter("name");
        Administrator admindetail=adminService.getAdminByName(name);
        model.addAttribute("admindetail",admindetail);
        return "admindetail";
    }

    @RequestMapping("/sourcedetail")
    public String sourcedetail(HttpServletRequest request,Model model,HttpSession session){
        Integer sourceid=0;
        if(request.getParameter("sourceid")!=null){
            sourceid=Integer.parseInt(request.getParameter("sourceid"));
        }
        else{
            sourceid=(Integer)session.getAttribute("sourceid");
        }
        Source s=sourceService.getSourceBySourceid(sourceid);
        model.addAttribute("sourcedetail",s);
        session.setAttribute("sourceid",sourceid);
        return "sourcedetail";
    }

    @RequestMapping("/specialruledetail")
    public String specialruledetail(HttpServletRequest request,Model model,HttpSession session){
        Integer sourceid=0;
        if(request.getParameter("sourceid")!=null){
            sourceid=Integer.parseInt(request.getParameter("sourceid"));
        }
        else{
            sourceid=(Integer)session.getAttribute("sourceid");
        }
        String specialname = request.getParameter("special_name");
        Specialrule s = specialruleService.getSpecialrule(sourceid,specialname);
        model.addAttribute("specialrule",s);
        session.setAttribute("sourceid",sourceid);
        return "specialruledetail";
    }

    @RequestMapping("/removespecialrule")
    public String removespecialrule(HttpServletRequest request,Model model,HttpSession session){
        Integer sourceid=0;
        if(request.getParameter("sourceid")!=null){
            sourceid=Integer.parseInt(request.getParameter("sourceid"));
        }
        else{
            sourceid=(Integer)session.getAttribute("sourceid");
        }
        String specialname = request.getParameter("special_name");
        specialruleService.removeSpecialrule(sourceid,specialname);
        session.setAttribute("sourceid",sourceid);
        return "redirect:sourcespecial";
    }

    @RequestMapping("/globalmonitor")
    public String globalmonitor(HttpServletRequest request,Model model,HttpSession session){
        Integer sourceid = 0;
        Source s = sourceService.getSourceBySourceid(sourceid);
        model.addAttribute("globalsource",s);
        session.setAttribute("sourceid",sourceid);
        return "globalmonitor";
    }

    @RequestMapping("/sourcegroupdetail")
    public String sourcegroupdetail(HttpServletRequest request,Model model,HttpSession session){
        Integer sourcegroupid=0;
        if(request.getParameter("sourcegroupid")!=null){
            sourcegroupid=Integer.parseInt(request.getParameter("sourcegroupid"));
        }
        else{
            sourcegroupid=(Integer)session.getAttribute("sourcegroupid");
        }
        List sourcelist=sourceService.getSourceBySourceGroupid(sourcegroupid);
        model.addAttribute("sourcelist",sourcelist);
        session.setAttribute("sourcegroupid",sourcegroupid);
        return "sourcegroupdetail";
    }

    @RequestMapping("/changesource")
    @ResponseBody
    public Map<String,String> changesource(HttpServletRequest request,Model model,HttpSession session){
        Map<String,String> map=new HashMap<>();
        Integer sourceid=(Integer)session.getAttribute("sourceid");
        String start=request.getParameter("start");
        String end=request.getParameter("end");
        String silent=request.getParameter("silent");
        String recovery=request.getParameter("recovery");
        Integer issuccess=sourceService.changeSourceBySourceid(sourceid,start,end,silent,recovery);
        map.put("issuccess",""+issuccess);
        return map;
    }

    @RequestMapping("/changespecialrule")
    @ResponseBody
    public Map<String,String> changespecialrule(HttpServletRequest request,Model model,HttpSession session){
        Map<String,String> map=new HashMap<>();
        Integer sourceid=(Integer)session.getAttribute("sourceid");
        String start=request.getParameter("start");
        String end=request.getParameter("end");
        String recovery=request.getParameter("recovery");
        Integer alert_status=Integer.parseInt(request.getParameter("alert_status"));
        String special_name=request.getParameter("special_name");
        Integer issuccess=specialruleService.changeSpecialrule(sourceid,special_name,start,end,recovery,alert_status);
        map.put("issuccess",""+issuccess);
        return map;
    }

    @RequestMapping("/changesubuser")
    @ResponseBody
    public Map<String,String> changesubuser(HttpServletRequest request,Model model,HttpSession session){
        Map<String,String> map=new HashMap<>();
        String username=request.getParameter("username");
        String tele=request.getParameter("tele");
        Integer userid=Integer.parseInt(request.getParameter("userid"));
        Integer version=Integer.parseInt(request.getParameter("version"));
        Integer issuccess=userService.changeSubUser(userid,username,tele,version);
        map.put("issuccess",""+issuccess);
        return map;
    }

    @RequestMapping("/changeadmin")
    @ResponseBody
    public Map<String,String> changeadmin(HttpServletRequest request,Model model,HttpSession session){
        Map<String,String> map=new HashMap<>();
        String admin_name=request.getParameter("admin_name");
        Integer manage_user=Integer.parseInt(request.getParameter("manage_user"));
        Integer manage_maintenance=Integer.parseInt(request.getParameter("manage_maintenance"));
        Integer manage_admin=Integer.parseInt(request.getParameter("manage_admin"));
        Integer version=Integer.parseInt(request.getParameter("version"));
        Integer issuccess=adminService.changeAdmin(admin_name,manage_user,manage_maintenance,manage_admin,version);
        map.put("issuccess",""+issuccess);
        return map;
    }

    @RequestMapping("/sourcemaintenance")
    public String sourcemaintenance(HttpServletRequest request,Model model,HttpSession session){
        Integer sourceid=0;
        if(request.getParameter("sourceid")!=null){
            sourceid=Integer.parseInt(request.getParameter("sourceid"));
        }
        else{
            sourceid=(Integer)session.getAttribute("sourceid");
        }
        session.setAttribute("sourceid",sourceid);
        List maintenancelist=maintenanceService.getMaintenanceBySourceid(sourceid);
        model.addAttribute("maintenancelist",maintenancelist);
        return "maintenanceshow";
    }

    @RequestMapping("/addmaintenance")
    public String addmaintenance() {
        return "addmaintenance";
    }

    @RequestMapping("/submitaddmaintenance")
    @ResponseBody
    public Map<String,String> submitaddmaintenance(HttpServletRequest request,Model model,HttpSession session){
        Map<String,String> map=new HashMap<>();
        Integer sourceid=(Integer) session.getAttribute("sourceid");
        String detail=request.getParameter("detail");
        String start=request.getParameter("start");
        String end=request.getParameter("end");
        Integer issuccess=maintenanceService.addMaintenanceBySourceid(sourceid,detail,start,end);
        map.put("issuccess",""+issuccess);
        return map;
    }

    @RequestMapping("/sourceignore")
    public String sourceignore(HttpServletRequest request,Model model,HttpSession session){
        Integer sourceid=0;
        if(request.getParameter("sourceid")!=null){
            sourceid=Integer.parseInt(request.getParameter("sourceid"));
        }
        else{
            sourceid=(Integer)session.getAttribute("sourceid");
        }
        List ignorelist=ignoreService.getIgnoreBySourceid(sourceid);
        model.addAttribute("ignorelist",ignorelist);
        session.setAttribute("sourceid",sourceid);
        return "sourceignore";
    }

    @RequestMapping("/sourcespecial")
    public String sourcespecial(HttpServletRequest request,Model model,HttpSession session){
        Integer sourceid=0;
        if(request.getParameter("sourceid")!=null){
            sourceid=Integer.parseInt(request.getParameter("sourceid"));
        }
        else{
            sourceid=(Integer)session.getAttribute("sourceid");
        }
        List specialrulelist = specialruleService.getSpecialruleBySourceid(sourceid);
        model.addAttribute("specialrulelist",specialrulelist);
        session.setAttribute("sourceid",sourceid);
        return "sourcespecial";
    }

    @RequestMapping("/globalignore")
    public String globalignore(HttpServletRequest request,Model model,HttpSession session){
        Integer sourceid = 0;
        List ignorelist=ignoreService.getIgnoreBySourceid(sourceid);
        model.addAttribute("ignorelist",ignorelist);
        session.setAttribute("sourceid",sourceid);
        return "globalignore";
    }

    @RequestMapping("/deleteignore")
    public String deleteignore(HttpServletRequest request,Model model,HttpSession session){
        Integer sourceid=(Integer)session.getAttribute("sourceid");
        String ignore_name=request.getParameter("ignore_name");
        ignoreService.deleteIgnore(sourceid,ignore_name);
        return "redirect:sourceignore";
    }

    @RequestMapping("/deletespecial")
    public String deletespecial(HttpServletRequest request,Model model,HttpSession session){
        Integer userid=(Integer)session.getAttribute("userid");
        String special_name=request.getParameter("special_name");
        specialService.deleteSpecial(userid,special_name);
        return "redirect:subuserspecial";
    }

    @RequestMapping("/addignore")
    @ResponseBody
    public Map<String,String> addignore(HttpServletRequest request,Model model,HttpSession session){
        Map<String,String> map=new HashMap<>();
        Integer sourceid=(Integer)session.getAttribute("sourceid");
        String ignore_name=request.getParameter("newignore");
        Integer issuccess=ignoreService.addIgnore(sourceid,ignore_name);
        map.put("issuccess",""+issuccess);
        return map;
    }

    @RequestMapping("/addspecial")
    @ResponseBody
    public Map<String,String> addspecial(HttpServletRequest request,Model model,HttpSession session){
        Map<String,String> map=new HashMap<>();
        Integer userid=(Integer)session.getAttribute("userid");
        String special_name=request.getParameter("newspecial");
        Integer issuccess=specialService.addSpecial(userid,special_name);
        map.put("issuccess",""+issuccess);
        return map;
    }

    @RequestMapping("/sourceuser")
    public String sourceuser(HttpServletRequest request,Model model,HttpSession session){
        Integer sourcegroupid=0;
        if(request.getParameter("sourcegroupid")!=null){
            sourcegroupid=Integer.parseInt(request.getParameter("sourcegroupid"));
        }
        else{
            sourcegroupid=(Integer)session.getAttribute("sourcegroupid");
        }
        List userlist=userService.getUserBySourceid(sourcegroupid);
        List unuserlist=userService.getUserExceptSourceid(sourcegroupid);
        model.addAttribute("userlist",userlist);
        model.addAttribute("unuserlist",unuserlist);
        session.setAttribute("sourcegroupid",sourcegroupid);
        return "sourceuser";
    }

    @RequestMapping("/removeuser")
    public String removeuser(HttpServletRequest request,Model model,HttpSession session){
        Integer sourceid=(Integer)session.getAttribute("sourcegroupid");
        Integer user_id=Integer.parseInt(request.getParameter("usergroupid"));
        userService.removeUser(sourceid,user_id);
        return "redirect:sourceuser";
    }

    @RequestMapping("/usersource")
    public String usersource(HttpServletRequest request,Model model,HttpSession session){
        Integer userid=0;
        if(request.getParameter("userid")!=null){
            userid=Integer.parseInt(request.getParameter("userid"));
        }
        else{
            userid=(Integer)session.getAttribute("userid");
        }
        List sourcelist=sourceService.getSourceByUserid(userid);
        model.addAttribute("sourcelist",sourcelist);
        List unsourcelist=sourceService.getSourceExceptUserid(userid);
        model.addAttribute("unsourcelist",unsourcelist);
        session.setAttribute("userid",userid);
        return "usersource";
    }

    @RequestMapping("/removesource")
    public String removesource(HttpServletRequest request,Model model,HttpSession session){
        Integer userid=(Integer)session.getAttribute("userid");
        Integer sourceid=Integer.parseInt(request.getParameter("sourceid"));
        sourceService.removeSource(userid,sourceid);
        return "redirect:usersource";
    }

    @RequestMapping("/addsourceuser")
    @ResponseBody
    public Map<String,String> addsourceuser(HttpServletRequest request,Model model,HttpSession session){
        Map<String,String> map=new HashMap<>();
        Integer sourceid=(Integer)session.getAttribute("sourcegroupid");
        Integer userid=Integer.parseInt(request.getParameter("newuser"));
        Integer issuccess=userService.addSourceUser(sourceid,userid);
        map.put("issuccess",""+issuccess);
        return map;
    }

    @RequestMapping("/addusersource")
    @ResponseBody
    public Map<String,String> addusersource(HttpServletRequest request,Model model,HttpSession session){
        Map<String,String> map=new HashMap<>();
        Integer usergroupid=(Integer)session.getAttribute("userid");
        Integer sourcegroupid=Integer.parseInt(request.getParameter("newsource"));
        Integer issuccess=userService.addSourceUser(sourcegroupid,usergroupid);
        map.put("issuccess",""+issuccess);
        return map;
    }

    @RequestMapping("/addgroupuser")
    @ResponseBody
    public Map<String,String> addgroupuser(HttpServletRequest request,Model model,HttpSession session){
        Map<String,String> map=new HashMap<>();
        Integer user_group_id=(Integer)session.getAttribute("userid");
        Integer userid=Integer.parseInt(request.getParameter("newuser"));
        Integer issuccess=userService.addGroupUser(user_group_id,userid);
        map.put("issuccess",""+issuccess);
        return map;
    }

    @RequestMapping("/adduser")
    @ResponseBody
    public Map<String,String> adduser(HttpServletRequest request,Model model,HttpSession session){
        Map<String,String> map=new HashMap<>();
        String username=request.getParameter("username");
        Integer issuccess=userService.addUser(username);
        map.put("issuccess",""+issuccess);
        return map;
    }

    @RequestMapping("/addsubuser")
    @ResponseBody
    public Map<String,String> addsubuser(HttpServletRequest request,Model model,HttpSession session){
        Map<String,String> map=new HashMap<>();
        String username=request.getParameter("username");
        String telephone=request.getParameter("telephone");
        Administrator admin=(Administrator)session.getAttribute("admin");
        String createname=admin.getAdmin_name();
        Integer issuccess=userService.addSubUser(username,telephone,createname);
        map.put("issuccess",""+issuccess);
        return map;
    }

    @RequestMapping("/addadmin")
    @ResponseBody
    public Map<String,String> addadmin(HttpServletRequest request,Model model,HttpSession session){
        Map<String,String> map=new HashMap<>();
        String adminname=request.getParameter("adminname");
        String password=request.getParameter("password");
        Integer issuccess=adminService.addAdmin(adminname,password);
        map.put("issuccess",""+issuccess);
        return map;
    }

    @RequestMapping("/addspecialrule")
    @ResponseBody
    public Map<String,String> addspecialrule(HttpServletRequest request,Model model,HttpSession session){
        Map<String,String> map=new HashMap<>();
        Integer sourceid=(Integer)session.getAttribute("sourceid");
        String name=request.getParameter("name");
        String start=request.getParameter("start");
        String end=request.getParameter("end");
        String recovery=request.getParameter("recovery");
        Integer status = Integer.parseInt(request.getParameter("alert_status"));
        Integer issuccess=specialruleService.addSpecialrule(sourceid,name,start,end,recovery,status);
        map.put("issuccess",""+issuccess);
        return map;
    }

    @RequestMapping("/removegroupuser")
    public String removegroupuser(HttpServletRequest request,Model model,HttpSession session){
        Integer usergroupid=(Integer)session.getAttribute("userid");
        Integer userid=Integer.parseInt(request.getParameter("subuserid"));
        userService.removeGroupUser(usergroupid,userid);
        return "redirect:userdetail";
    }

    @RequestMapping("/subuserspecial")
    public String subuserspecial(HttpServletRequest request,Model model,HttpSession session){
        Integer userid=0;
        if(request.getParameter("userid")!=null){
            userid=Integer.parseInt(request.getParameter("userid"));
        }
        else{
            userid=(Integer)session.getAttribute("userid");
        }
        List speciallist = specialService.getSpecialByUserid(userid);
        model.addAttribute("speciallist",speciallist);
        session.setAttribute("userid",userid);
        return "subuserspecial";
    }
}


