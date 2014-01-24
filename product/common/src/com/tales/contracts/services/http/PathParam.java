// ***************************************************************************
// *  Copyright 2012 Joseph Molnar
// *
// *  Licensed under the Apache License, Version 2.0 (the "License");
// *  you may not use this file except in compliance with the License.
// *  You may obtain a copy of the License at
// *
// *      http://www.apache.org/licenses/LICENSE-2.0
// *
// *  Unless required by applicable law or agreed to in writing, software
// *  distributed under the License is distributed on an "AS IS" BASIS,
// *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// *  See the License for the specific language governing permissions and
// *  limitations under the License.
// ***************************************************************************
package com.tales.contracts.services.http;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An indication that this is a parameter found on the path.
 * @author jmolnar
 *
 */
@Retention( RetentionPolicy.RUNTIME)
@Target( ElementType.PARAMETER )
public @interface PathParam {
	/**
	 * The name of the param to find on the path.
	 */
    String name( );

    /**
     * This indicates if the parameter is considered sensitive and
     * therefore shouldn't show up in logs, etc. Defaults to false.
     * @return if a sensitive parameter.
     */
    boolean sensitive( ) default false;
}

