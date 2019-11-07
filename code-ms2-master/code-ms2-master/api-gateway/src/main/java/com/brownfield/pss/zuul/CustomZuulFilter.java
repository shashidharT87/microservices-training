package com.brownfield.pss.zuul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;


public class CustomZuulFilter extends ZuulFilter{
	
	private static final Logger logger = LoggerFactory.getLogger(CustomZuulFilter.class);

	@Override
	public Object run() {	
		logger.info("executing run() from CustomZuulFilter class"); 
		RequestContext ctx = RequestContext.getCurrentContext();
		ctx.getRequest().setAttribute("custom-attribute", "custom-value");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		logger.info("executing shouldFilter() from CustomZuulFilter class"); 
		return true;
	}

	@Override
	public int filterOrder() {
		logger.info("executing filterOrder() from CustomZuulFilter class"); 
		return 1;
	}

	@Override
	public String filterType() {
		logger.info("executing filterType() from CustomZuulFilter class"); 
		return "pre";
	}
} 