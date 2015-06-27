package org.facebookjpa.security.interceptor;

import org.facebookjpa.util.AuthenticationHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by bakhtiar.galib on 4/5/15.
 */
public class HttpAuthenticationInterceptor extends HandlerInterceptorAdapter {

    private static final Logger log = LoggerFactory.getLogger(HttpAuthenticationInterceptor.class);

    public boolean isRequestedPageForAuthenticatedUserOnly(String requestedUri) {
        return  !requestedUri.contains("login") && !requestedUri.contains("signup");
    }

    public boolean isRequestedPageForNotAuthenticatedUserOnly(String requestedUri) {
        return requestedUri.contains("login") || requestedUri.contains("signup");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestedUri = request.getRequestURI().substring(request.getContextPath().length());

        log.debug("At Interceptor");

        log.debug("Requested URL " + requestedUri);

        if (!AuthenticationHelper.isUserAuthenticated(request.getSession()) && isRequestedPageForAuthenticatedUserOnly(requestedUri)) {
            response.sendRedirect("/FacebookSpringJpa/login");
            return false;
        } else if (AuthenticationHelper.isUserAuthenticated(request.getSession()) && isRequestedPageForNotAuthenticatedUserOnly(requestedUri)) {
            response.sendRedirect("/FacebookSpringJpa/home");
            return false;
        }else{
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
