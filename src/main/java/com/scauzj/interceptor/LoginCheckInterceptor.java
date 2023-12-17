package com.scauzj.interceptor;

import com.scauzj.context.BaseContext;
import com.scauzj.util.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override // 目标资源方法运行前执行，返回true放行，返回false拦截
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        // 1. 从请求头中获取令牌
        String token = request.getHeader("token");

        // 2. 校验令牌
        try {
            log.info("jwt校验:{}", token);
            Claims claims = JwtUtils.parseJwt(token);
            Integer id = Integer.valueOf(claims.get("id").toString());
            log.info("当前用户id：{}", id);
            BaseContext.setCurrentId(id);
            // 3. 通过，放行
            return true;
        } catch (Exception e) {
            // 4. 不通过，响应401状态码
            response.setStatus(401);
            return false;
        }
    }

    @Override // 目标资源方法运行后执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override // 视图渲染完成后执行，最后执行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}