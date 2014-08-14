/*
 * Brutos Web MVC http://www.brutosframework.com.br/
 * Copyright (C) 2009-2012 Afonso Brandao. (afonso.rbn@gmail.com)
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

package org.brandao.brutos;

import java.util.Map;

/**
 *
 * @author Brandao
 */
public interface ConfigurableResultAction extends ResultAction{
    
    ResultParam getResultParam();

    void setResultParam(ResultParam resultParam);

    ResultTypeParam getResultTypeParam();

    void setResultTypeParam(ResultTypeParam resultTypeParam);
    
    public static interface ConfigurableResultTypeParam extends ResultTypeParam{

        Class getType();

        void setType(Class type);

        Object getValue();

        void setValue(Object value);
        
        Map getInfos();

        void setInfos(Map infos);
        
    }
    
    public static interface ConfigurableResultParam extends ResultParam{
        
        String getView();

        void setView(String view);

        boolean isResolved();

        void setResolved(boolean resolved);

        Map getValues();

        void setValues(Map values);
        
        Map getInfos();

        void setInfos(Map infos);
        
    }
    
}
