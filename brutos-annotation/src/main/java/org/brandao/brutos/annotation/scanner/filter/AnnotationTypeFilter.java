/*
 * Brutos Web MVC http://www.brutosframework.com.br/
 * Copyright (C) 2009 Afonso Brandao. (afonso.rbn@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.brandao.brutos.annotation.scanner.filter;

import org.brandao.brutos.annotation.scanner.TypeFilter;
import java.util.Properties;
import org.brandao.brutos.BrutosConstants;
import org.brandao.brutos.BrutosException;
import org.brandao.brutos.ClassUtil;
import org.brandao.brutos.annotation.scanner.TypeFilter;
import org.brandao.brutos.scanner.vfs.Vfs;

/**
 *
 * @author Brandao
 */
public class AnnotationTypeFilter implements TypeFilter{

    private boolean include;
    private Class annotation;
    
    public void setConfiguration(Properties config) {
        this.include = 
            config.getProperty(
                "filter-type", 
                BrutosConstants.INCLUDE)
                    .equals(BrutosConstants.INCLUDE);
        
        try{
            this.annotation =
                ClassUtil.get(config.getProperty(BrutosConstants.EXPRESSION));
        }
        catch(Exception e){
            throw new BrutosException(e);
        }
    }

    public boolean accepts(String resource) {
        try{
            resource = Vfs.toClass(resource);
            Class clazz = ClassUtil.get(resource);
            return clazz.isAnnotationPresent(annotation);
        }
        catch(ClassNotFoundException e){
            throw new BrutosException(e);
        }
    }

    public void setExpression(String value) {
        try{
            this.annotation =
                ClassUtil.get(value);
        }
        catch(ClassNotFoundException e){
            throw new BrutosException(e);
        }
    }

}
