package springboot.example.system.filter;

import com.github.pagehelper.page.PageMethod;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import springboot.example.system.SystemContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SystemContextFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(SystemContextFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        int offset = 0;
        int pageSize = 15;
        HttpServletRequest httpReq = (HttpServletRequest)servletRequest;
        String firstResultStr = httpReq.getParameter("firstResult");
        String pageSizeStr = httpReq.getParameter("pageSize");
        String language = httpReq.getHeader("language");
        if (StringUtils.isNotBlank(firstResultStr)){
            offset = Integer.parseInt(firstResultStr);
        }
        if (StringUtils.isNotBlank(pageSizeStr)){
            pageSize = Integer.parseInt(pageSizeStr);
        }
        if (StringUtils.isBlank(language)){
            language = "zh-CN";
        }
        try {
            SystemContext.setOrder(httpReq.getParameter("order"));
            SystemContext.setSort(httpReq.getParameter("sort"));
            SystemContext.setFirstResult(offset);
            SystemContext.setPageSize(pageSize);
            SystemContext.setLanguage(language);
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            SystemContext.removeOrder();
            SystemContext.removeSort();
            SystemContext.removeFirstResult();
            SystemContext.removePageSize();
            SystemContext.removeLanguage();
            PageMethod.clearPage();
        }

    }

    @Override
    public void destroy() {
        logger.info("testFilter-----end----");
    }
}
