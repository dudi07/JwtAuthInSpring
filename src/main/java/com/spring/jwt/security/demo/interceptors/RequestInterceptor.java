//package com.spring.jwt.security.demo.interceptors;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.util.Base64;
//
//@Component
//@Slf4j
//public class RequestInterceptor implements HandlerInterceptor {
//
//    private static final String USERNAME = "admin";
//    private static final String PASSWORD = "admin";
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws IOException {
////        log.info("1 - pre handle.");
////        System.out.println("METHOD type:" + request.getMethod());
////        System.out.println("Request URI: " + request.getRequestURI());
////        System.out.println("Servlet PATH: " + request.getServletPath());
////        if(object instanceof HandlerMethod){
////            //can be added different logics
////            Class<?> controllerClass = ((HandlerMethod) object).getBeanType();
////            String methodName = ((HandlerMethod) object).getMethod().getName();
////            System.out.println("Controller name: " + controllerClass.getName());
////            System.out.println("Method name:" + methodName);
////        }
////        return true;
//
//        String authHeader = request.getHeader("Authorization");
//        if (authHeader != null && authHeader.startsWith("Basic ")) {
//
//            String base64Credentials = authHeader.substring("Basic ".length());
//            byte[] decodedCredentials = Base64.getDecoder().decode(base64Credentials);
//            String credentials = new String(decodedCredentials, StandardCharsets.UTF_8);
//
//            String[] parts = credentials.split(":");
//            String username = parts[0];
//            String password = parts[1];
//
//            if (USERNAME.equals(username) && PASSWORD.equals(password)) {
//                return true;
//            }
//        }
//
//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
//        return false;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView model){
//        System.out.println("2 - post handle.");
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception){
//        if(exception != null){
//            //exception handle part
//            System.out.println("An error occured.");
//        }
//        System.out.println("3 - after completion.");
//    }
//}
