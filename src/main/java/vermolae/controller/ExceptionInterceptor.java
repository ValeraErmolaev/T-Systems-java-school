package vermolae.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import vermolae.exeptions.ResourceNotFoundException;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class ExceptionInterceptor {

    @ExceptionHandler(value = {ResourceNotFoundException.class, NoHandlerFoundException.class})
    public ModelAndView handleError404(HttpServletRequest request, Exception e)   {
        ModelAndView mv = new ModelAndView("/404");
        return mv;
    }
    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class})
    public ModelAndView handleError400(HttpServletRequest request, Exception e) {
        ModelAndView mv = new ModelAndView("/400");
        return mv;
    }

    @ExceptionHandler(value = {  AccessDeniedException.class})
    public ModelAndView handleStatusException(HttpServletRequest request, Exception e) {
        ModelAndView mv = new ModelAndView("/blocked");
        return mv;
    }
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(Exception.class)
//    public ModelAndView notFoundHandler() {
//        ModelAndView mv = new ModelAndView("/500");
//        return mv;
//    }

}
