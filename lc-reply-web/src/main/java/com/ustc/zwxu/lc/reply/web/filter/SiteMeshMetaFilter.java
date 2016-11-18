/**
 * 
 */
package com.ustc.zwxu.lc.reply.web.filter;

import java.io.IOException;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

import org.sitemesh.DecoratorSelector;
import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.sitemesh.content.Content;
import org.sitemesh.webapp.WebAppContext;

/**
 * @title 		
 * @description	
 * @usage		
 * @company		北京小米支付技术有限公司
 * @author		TQSUMMER
 * @create		2012-8-28 下午5:04:26
 */
/**
 * @author TQSUMMER
 */
public class SiteMeshMetaFilter extends ConfigurableSiteMeshFilter {

	private String prefix;
	private String suffix;

	public void init(FilterConfig filterConfig) throws ServletException {
		super.init(filterConfig);
		prefix = filterConfig.getInitParameter("prefix");
		suffix = filterConfig.getInitParameter("suffix");
	}

	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {

		super.applyCustomConfiguration(builder);

		builder.setCustomDecoratorSelector(new DecoratorSelector<WebAppContext>() {

			@Override
			public String[] selectDecoratorPaths(Content content, WebAppContext context) throws IOException {

				String decorator = content.getExtractedProperties().getChild("meta").getChild("layout").getValue();
				String[] selectDecoratorPath = null;
				if (decorator == null || decorator.trim().equals("")) {
					selectDecoratorPath = new String[] {};
				} else {
					selectDecoratorPath = new String[] { prefix + decorator.trim() + suffix };
				}

				return selectDecoratorPath;

			}

		});

	}
}
