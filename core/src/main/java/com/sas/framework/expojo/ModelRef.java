// -[KeepHeading]-


// -[Copyright]-

/**
 * (c) 2007, 2015. Step Ahead Software Pty Ltd.
 * This software is released under the Apache 2 License, a copy of which can be found
 * at:
 * http://www.apache.org/licenses/LICENSE-2.0.html
 * 
 * Source file created and managed by Javelin (TM) Step Ahead Software.
 * To maintain code and model synchronization you may directly edit code in method bodies
 * and any sections starting with the 'Keep_*' marker. Make all other changes via Javelin.
 * See http://stepaheadsoftware.com for more details.
 */
package com.sas.framework.expojo;

import java.lang.*;
import com.sas.framework.expojo.ClsIdModelRef;


// -[KeepBeforeClass]-

import java.io.IOException;
import java.io.ObjectOutputStream;


// -[Class]-

/**
 * Class Name : ModelRef
 * Diagram    : Expojo Core
 * Project    : ExPOJO Core
 * Type       : abstract
 * An implementation of a IModelRef that uses features of the generic PersistenceProvider
 * interface to detach/reload model objects.
 * 
 * @author Chris Colman
 */
public abstract 
class ModelRef<T>
 extends ClsIdModelRef<T>
{
// -[KeepWithinClass]-
public static final long serialVersionUID = 1L;


// -[Fields]-



/**
 * Reference to the object that is detachable.
 * Attribute MUST be transient to avoid serializing massive object trees.
 */
private transient T object;


// -[Methods]-

/**
 * 
 */
private void readObject(java.io.ObjectInputStream stream)
  throws IOException, ClassNotFoundException
{
	object = null;
}

/**
 * Does not change what is streamed but is here to provide a place to set a breakpoint
 * when debugging streaming of model objects in the entity framework
 */
private void writeObject(java.io.ObjectOutputStream out)
  throws IOException, ClassNotFoundException
{
	// Do nothing - object should not be serializable
	// We mark it as transient but it still seems be getting serialized to the stream

	if (object != null)
		System.out.println("!!!! An attempt was made to serialize an object that has not been detached !!!! : OID: " + getId() + " Class: " +  getCls().getSimpleName());
}

/**
 * Constructs the object
 */
public ModelRef(T o)
{
	super(o);
}



/**
 * Needs to be overridden because default equals plays all kinds of havoc.
 */
public abstract boolean equals(Object o);



/**
 * Detaches the object.
 */
public void detach()

{
	if ( object != null && getId() == -1 )
		System.out.println("An attempt was made to detach an object which has not yet been made persistent: " + (object != null ? object.getClass().toString() : "null"));

	object = null;
}



/**
 * Returns object. This method works differently to getObject in that it will not  trigger
 * an implicit retrieval of the object if object is null.
 * It is useful for diagnostics and debugging to enable visibility of the 'object' attribute
 * without triggering the implicit retrieval mechanism of getObject() which could be
 * quite hazardous depending on at which point in, for example, a http request cycle,
 * an implicit retrieval were to occur.
 */
public T getObjectNoRetrieve()

{
	return object;
}

/**
 * Returns object
 */
public T getObject()
{
	if ( object == null )
	{
		return super.getObject();
	}
	
	return object;
}

/**
 * Sets object
 */
public void setObject(T object)
{
	this.object = object;
	super.setObject(object);
}

}


