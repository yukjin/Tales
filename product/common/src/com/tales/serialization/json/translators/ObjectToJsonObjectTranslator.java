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
package com.tales.serialization.json.translators;

import com.google.common.base.Preconditions;
import com.google.gson.JsonNull;

import com.tales.parts.translators.Translator;
import com.tales.serialization.json.JsonTypeMap;


/**
 * Translator that converts an object into a {@code JsonObject}
 * or, if null, {@code JsonNull}.
 * @author jmolnar
 *
 */
public class ObjectToJsonObjectTranslator implements Translator {
	private final JsonTypeMap typeMap;
	/**
	 * Empty default constructor.
	 */
	public ObjectToJsonObjectTranslator( JsonTypeMap theTypeMap ) {
		Preconditions.checkNotNull( theTypeMap );
		
		typeMap = theTypeMap;
	}

	/**
	 * Translates the received object into a json primitive.
	 * If the object is of the wrong type, a TranslationException will occur.
	 */
	@Override
	public Object translate(Object anObject) {
		Object returnValue;
		
		if( anObject == null ) {
			returnValue = JsonNull.INSTANCE;
		} else {
			returnValue = typeMap.getData( anObject );
		}
		return returnValue;	
	}
}
