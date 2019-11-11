package springboot.example.system.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class TestFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(TestFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("testFilter-----begin----");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String token = servletRequest.getParameter("token");
        if ("xzk".equals(token)){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            logger.error("用户验证失败");
        }

    }

    @Override
    public void destroy() {
        logger.info("testFilter-----end----");
    }
}
