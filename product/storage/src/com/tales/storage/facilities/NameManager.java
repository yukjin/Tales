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
package com.tales.storage.facilities;

import com.tales.system.Facility;

/**
 * This interface is used to validate and/or transform
 * names used by the storage system. Examples of could
 * be done include: a) ensuring names are short,
 * b) names have a particular style, c) transform 
 * table names for use in test/shared environments
 * to aid isolation. 
 * @author jmolnar
 *
 */
public interface NameManager extends Facility {
	String confirmTableName( String theName );
	
//	String confirmTableName( String theName );
//	String confirmFamilyName( String theName );
//	String confirmColumnName( String theName );
}
