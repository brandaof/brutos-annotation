/*
 * Brutos Web MVC http://brutos.sourceforge.net/
 * Copyright (C) 2009 Afonso Brandao. (afonso.rbn@gmail.com)
 *
 * This library is free software. You can redistribute it
 * and/or modify it under the terms of the GNU General Public
 * License (GPL) version 3.0 or (at your option) any later
 * version.
 * You may obtain a copy of the License at
 *
 * http://www.gnu.org/licenses/gpl.html
 *
 * Distributed WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied.
 *
 */

package org.brandao.brutos;

import java.io.OutputStream;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Afonso Brandao
 */
public class DefaultResponseDispatcher implements ResponseDispatcher{

    public void process( Object object ){
        JOptionPane.showMessageDialog(null, String.valueOf( object ) );
    }

    public OutputStream processStream() {
        return null;
    }

    public void process(Object object, Map config, Map info) {
    }

    public OutputStream processStream(Map config, Map info) {
        return null;
    }
    
}
