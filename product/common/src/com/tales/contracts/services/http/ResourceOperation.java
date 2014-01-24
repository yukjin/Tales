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
 * This signifies that a particular method is 
 * available for the world to access over http(s).
 * @author jmolnar
 *
 */
@Retention( RetentionPolicy.RUNTIME)
@Target( ElementType.METHOD )
public @interface ResourceOperation {
	public enum Mode {
		/**
		 * The caller of the operation doesn't have to wait since
		 * the execution will return immediately.
		 */
		ASYNC,
		/**
		 * The caller of the operation waits, but will run in a 
		 * non-blocking fashion in the service. This is largely intended
		 * for longer running operations, such as operations that call other 
		 * services, database calls, etc.
		 */
		WAIT_NONBLOCK,
		/**
		 * caller of the operation waits and the executing thread, if 
		 * calling other services will block and wait. This is largely
		 * intended to short operations that do not rely on other
		 * services, etc.
		 */
		WAIT_BLOCK,
	}
	
	public enum Signed {
		/**
		 * The signature is not to be sent.
		 */
		NO,
		/**
		 * The signature is not required.
		 */
		OPTIONAL,
		/**
		 * The signature is required.
		 */
		REQUIRED,
	}

	/**
	 * The path of the method, relative to the parent.
	 * @return the path of the method
	 */
    String path( );
    
    /**
     * An optional name to given the method. This will 
     * show up for status blocks. If not specified
     * it will show the java name.
     * @return the name of the method
     */
    String name( ) default "";

    /**
     * An optional (though recommended) description of the operation outlining 
     * what the operations behaviour.
     * @return
     */
    String description( ) default "";

    /**
     * The optional set of support versions which the following format:
     * (YYMMDD)?(-YYMMDD)?. If this is not set the operation is considered to be
     * compatible with all version the main ResourceContract has identified. 
     * 
     * @return the supported versions
     */
    String[] versions( ) default {};
    
    /**
     * This is the how the resource operation is executed.
     * It defaults to being a blocking wait.
     * @return the mode to run the operation
     */
    Mode mode( ) default Mode.WAIT_NONBLOCK;
    
    /**
     * This indicates when the request is signed. 
     * It defaults to not being signed.
     * @return if request is signed
     */
    Signed signedRequest( ) default Signed.NO;

    /**
     * This indicates when the response is signed. 
     * It defaults to not being signed.
     * @return when the resource is signed
     */
    Signed signedResponse( ) default Signed.NO;
}
