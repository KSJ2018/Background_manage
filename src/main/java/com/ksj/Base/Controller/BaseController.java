package com.ksj.Base.Controller;

import com.ksj.Base.Entity.Msg;
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


}
