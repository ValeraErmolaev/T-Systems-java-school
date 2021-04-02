package vermolae.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername(); }
        else {
            String username = principal.toString();
            System.out.println("username "+username);
        }

        mv.setViewName("result");
        mv.addObject("result", "Welcome user!");
        return mv;
    }

}
