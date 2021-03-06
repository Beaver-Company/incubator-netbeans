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
package org.netbeans.modules.profiler.spi;

import java.util.List;

/**
 *
 * @author Tomas Hurka
 */
public abstract class JavaPlatformManagerProvider {

    /** Gets an list of JavaPlatformProvider objects registered in the IDE.
     * @return the array of java platform definitions.
     */
    public abstract List<JavaPlatformProvider> getPlatforms();

    /**
     * Get the "default platform", meaning the JDK on which profiler itself is running.
     * @return the default platform, if it can be found, or null
     */
    public abstract JavaPlatformProvider getDefaultPlatform();

    /**
     * Shows java platforms customizer
     */
    public abstract void showCustomizer();
}
