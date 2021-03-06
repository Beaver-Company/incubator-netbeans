/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.installer.utils.helper;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Kirill Sorokin
 */
public class Context {
    private Set<Object> objects;
    
    public Context() {
        objects = new HashSet<Object>();
    }
    
    public Context(Context context) {
        this();
        
        for (Object object: context.objects) {
            objects.add(object);
        }
    }
    
    public synchronized void put(Object object) {
        objects.add(object);
    }
    
    public synchronized Object get(Class<?> clazz) {
        for (Object object: objects) {
            if (clazz.isAssignableFrom((Class<?>) object.getClass())) {
                return object;
            }
        }
        
        return null;
    }
}
