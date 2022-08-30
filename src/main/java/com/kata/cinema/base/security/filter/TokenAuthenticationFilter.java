package com.kata.cinema.base.security.filter;

import com.kata.cinema.base.security.JwtUserDetailService;
import com.kata.cinema.base.security.jwt.JwtUserProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUserProvider jwtUserProvider;
    private final JwtUserDetailService userDetailService;


    public TokenAuthenticationFilter(JwtUserProvider jwtUserProvider, JwtUserDetailService userDetailService) {
        this.jwtUserProvider = jwtUserProvider;
        this.userDetailService = userDetailService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = parseToken(request);

            if (jwt != null && jwtUserProvider.validateToken(jwt)) {
                String email = jwtUserProvider.getUsername(jwt);
                UserDetails userDetails = userDetailService.loadUserByUsername(email);
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        } catch (Exception e) {
            log.error("Cannot set user authentication: ", e.getMessage());
        }

        filterChain.doFilter(request, response);
    }

    public String parseToken(HttpServletRequest httpServletRequest) {
        String headerAuth = httpServletRequest.getHeader("Authorization");
        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7);
        }
        log.warn("Authorization header is null");
        return null;
    }

}
