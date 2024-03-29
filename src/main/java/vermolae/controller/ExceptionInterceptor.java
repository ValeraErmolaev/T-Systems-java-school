package vermolae.controller;

import org.hibernate.PropertyNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import vermolae.exeptions.ResourceNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class ExceptionInterceptor {

    @ExceptionHandler(value = {ResourceNotFoundException.class, NoHandlerFoundException.class})
    public ModelAndView handleError404(HttpServletRequest request, Exception e)   {
        return new ModelAndView("/404");
    }
    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class})
    public ModelAndView handleError400(HttpServletRequest request, Exception e) {
        return new ModelAndView("/400");
    }

    @ExceptionHandler(value = {  AccessDeniedException.class})
    public ModelAndView handleStatusException(HttpServletRequest request, Exception e) {
        return new ModelAndView("/blocked");
    }
    @ExceptionHandler(value = { NullPointerException.class, PropertyNotFoundException.class,StackOverflowError.class})
    public ModelAndView notFoundHandler() {
        return new ModelAndView("/500");
    }

}
