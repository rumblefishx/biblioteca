package br.com.biblioteca.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.biblioteca.model.Usuario;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Usuario user = null;
        HttpSession sess = ((HttpServletRequest) request).getSession(false);
        
        if (sess != null){
              user = (Usuario) sess.getAttribute("usuarioLogado");
        }      

              if (user == null) {
                       String contextPath = ((HttpServletRequest) request)
                                          .getContextPath();
                       ((HttpServletResponse) response).sendRedirect(contextPath
                                          + "/security/login_form.xhtml");
              } else {
                       chain.doFilter(request, response);
              }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
