// ***************************************************************************
// *  Copyright 2011 Joseph Molnar
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
package com.tales.parts.translators;

import java.util.UUID;

/**
 * Class to convert a string to a UUID. If the string
 * cannot be translated a translation exception is thrown. 
 * @author cschertz
 * @author jmolnar
 * 
 *
 */
public class StringToUuidTranslator extends StringToObjectTranslatorBase implements Translator {
	/**
	 * The default constructor, which will trim and set empty, null strings to the value null.
	 */
	public StringToUuidTranslator( ) {
		this( true, null, null );
	}
	
	/**
	 * Constructor taking all options.
	 * @param shouldTrim should trim or not
	 * @param theEmptyValue what to return if empty
	 * @param theNullValue what to return if null
	 */
	public StringToUuidTranslator( boolean shouldTrim, Object theEmptyValue, Object theNullValue) {
		super(shouldTrim, theEmptyValue, theNullValue);
	}

	/**
	 * Translators the string into a UUID. If the UUID
	 * is not a a string or is not a properly formatted
	 * string UUID then translation exception is thrown.
	 */
	@Override
	public Object translate(Object anObject) {
		Object returnValue;
		if( anObject == null ) {
			returnValue = this.nullValue;
		} else {
			try {
				String stringValue = ( String )anObject;
				
				if( this.trim ) {
					stringValue = stringValue.trim();
				}
				if( stringValue.equals("") ) {
					returnValue = this.emptyValue;
				} 
				
				returnValue = UUID.fromString(stringValue);
				
			} catch( ClassCastException e ) {
				throw new TranslationException( e );
			} catch( IllegalArgumentException e ) {
				throw new TranslationException( e );
			}
		}
		return returnValue;	
	}
}
