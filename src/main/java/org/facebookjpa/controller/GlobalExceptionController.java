package org.facebookjpa.controller;

/**
 * Created by bakhtiar.galib on 4/12/15.
 */
import org.facebookjpa.util.DateTimeHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.OptimisticLockException;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;


@ControllerAdvice
public class GlobalExceptionController {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionController.class);

    @ExceptionHandler(SQLException.class)
    public ModelAndView handleSqlException(HttpServletRequest httpServletRequest,SQLException exception) {
        logError(httpServletRequest, exception);

        return getModelAndView(httpServletRequest,exception);
    }

    @ExceptionHandler(OptimisticLockException.class)
    public ModelAndView handleOptimisticLockException(HttpServletRequest httpServletRequest,OptimisticLockException exception) {
        logError(httpServletRequest,exception);

        return getModelAndView(httpServletRequest,exception);
    }

    @ExceptionHandler(OptimisticLockingFailureException.class)
    public ModelAndView handleOptimisticLockingFailureException(HttpServletRequest httpServletRequest,OptimisticLockingFailureException exception) {
        logError(httpServletRequest, exception);

        return getModelAndView(httpServletRequest,exception);
    }



    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(HttpServletRequest httpServletRequest,Exception exception) {
        logError(httpServletRequest, exception);

        return getModelAndView(httpServletRequest,exception);
    }

    private ModelAndView getModelAndView(HttpServletRequest httpServletRequest,Exception exception){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", exception);
        modelAndView.addObject("url", httpServletRequest.getRequestURL());
        modelAndView.setViewName("error");

        return modelAndView;
    }

    private void logError(HttpServletRequest httpServletRequest,Exception exception){
        log.error(httpServletRequest +" raised "+ exception+ " At "+DateTimeHelper.getCurrentDateTimeString());
        log.error(exception.getStackTrace().toString());
    }

}