package pl.coderslab.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter", urlPatterns = {"/organizers/*"})
public class AuthenticationFilter implements Filter {


    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        if(!(req instanceof HttpServletRequest)) {
            chain.doFilter(req,resp);
            return;
        }

        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        boolean loggedIn = session.getAttribute("email") != null;

        if(loggedIn) {
            chain.doFilter(req,resp);
            return;
        }

        HttpServletResponse response = (HttpServletResponse) resp;
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "You are not authorized to see this page");
    }

    public void destroy() {

    }
}
