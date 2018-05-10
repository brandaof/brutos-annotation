package org.brandao.brutos.annotation;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.brandao.brutos.annotation.WebAnnotationApplicationContextAnyTesttHelper.BeanAnyField;
import org.brandao.brutos.annotation.WebAnnotationApplicationContextAnyTesttHelper.BeanAnyFieldControllerTest;
import org.brandao.brutos.annotation.WebAnnotationApplicationContextAnyTesttHelper.PropertyTypeA;
import org.brandao.brutos.web.ConfigurableWebApplicationContext;
import org.brandao.brutos.web.test.WebApplicationContextTester;

import com.mockrunner.mock.web.MockHttpServletRequest;

public class WebAnnotationApplicationContextAnyTest extends BrutosTestCase{

	public void testAnyField(){
		WebApplicationContextTester.run(
			"/action", 
			new WebApplicationTester(){
				
            	public void prepareRequest(MockHttpServletRequest request) {
            		
            		request.setupAddParameter("prop.property.type", "A");
            		request.setupAddParameter("prop.property.commonField", "Value1");
            		request.setupAddParameter("prop.property.fieldA", "Value");
            		
            	}
            	
				public void checkResult(HttpServletRequest request,
						HttpServletResponse response, ServletContext context,
						ConfigurableWebApplicationContext applicationContext) {
					
					BeanAnyField bean =
							(BeanAnyField) request.getAttribute("prop");
					
					assertNotNull(bean);
					assertNotNull(bean.property);
					assertEquals("Value1", bean.property.commonField);
					
					assertTrue(bean.property instanceof PropertyTypeA);
					assertEquals("Value", ((PropertyTypeA)bean.property).fieldA);
					
				}
				
			}, 
			new Class[]{BeanAnyFieldControllerTest.class}
		);
	}
	
}
