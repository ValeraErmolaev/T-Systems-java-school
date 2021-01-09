package vermolae.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
    @RequestMapping("/admin")
    public ModelAndView greetAdmin() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("result");
        mv.addObject("result", "Welcome admin!");
        return mv;
    }

    @RequestMapping("/user")
    public ModelAndView greetUser() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("result");
        mv.addObject("result", "Welcome user!");
        return mv;
    }

}
