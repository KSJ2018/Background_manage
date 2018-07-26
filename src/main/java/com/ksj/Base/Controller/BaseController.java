package com.ksj.Base.Controller;

import com.ksj.Utils.SecurityTool;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseController {


    @RequestMapping("/")
    public ModelAndView index(Model model) {
        ModelAndView view = new ModelAndView("index", model.asMap());
        return view;
    }

    @RequestMapping("/logoutSuccess")
    public String logoutSuccess(){
        SecurityTool.setAllAuth(null);
        SecurityTool.setCurrentIp(null);
        SecurityTool.setCurrentUser(null);
        return "/login";
    }

    @RequestMapping("/device_type")
    public ModelAndView device_type(Model model) {
        ModelAndView view = new ModelAndView("DeviceType", model.asMap());
        return view;
    }
    @RequestMapping("/alarm_push_manage")
    public ModelAndView alarm_push_manage(Model model) {
        ModelAndView view = new ModelAndView("AlarmPushManager", model.asMap());
        return view;
    }
    @RequestMapping("/client_manage")
    public ModelAndView client_manage(Model model) {
        ModelAndView view = new ModelAndView("ClientManager", model.asMap());
        return view;
    }
    @RequestMapping("/device_table")
    public ModelAndView device_table(Model model) {
        ModelAndView view = new ModelAndView("DeviceTable", model.asMap());
        return view;
    }
    @RequestMapping("/factorys")
    public ModelAndView factorys(Model model) {
        ModelAndView view = new ModelAndView("Factorys", model.asMap());
        return view;
    }
    @RequestMapping("/resource")
    public ModelAndView resource(Model model) {
        ModelAndView view = new ModelAndView("Resource", model.asMap());
        return view;
    }
    @RequestMapping("/sale_manage")
    public ModelAndView sale_manage(Model model) {
        ModelAndView view = new ModelAndView("SaleManager", model.asMap());
        return view;
    }
    @RequestMapping("/taizhang_manage")
    public ModelAndView taizhang_manage(Model model) {
        ModelAndView view = new ModelAndView("TaiZhangManager", model.asMap());
        return view;
    }



}
