package name.xu.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Maybe has infinite possibilities
 *
 * session拦截，检测用胡是否登录
 *
 * @author Created by Sugar on 2018/3/9
 */
public class SessionInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(SessionInterceptor.class);

    public static String sessionUserId="_session_user_"  ;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        if (LOGGER.isInfoEnabled()) {
            //LOGGER.info("检测到的URI是：--->>>" + request.getRequestURI());
            //不进行拦截
            return true;
        }

        //登录不做拦截
        if (request.getRequestURI().equals("/user/login") || request.getRequestURI().equals("/user/login_view")) {
            return true;
        }
        //验证session是否存在
        Object obj = request.getSession().getAttribute(sessionUserId);
        if (obj == null) {
            response.sendRedirect("/user/login_view");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
