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


// -[KeepBeforeClass]-


// -[Class]-

/**
 * Class Name : IExCloseListener
 * Diagram    : Expojo Context and Components
 * Project    : ExPOJO Core
 * Type       : interface
 * Called when the current transaction is either committed or rolled back.
 * 
 * @author Chris Colman
 */
public abstract 
interface IExCloseListener
{
// -[KeepWithinClass]-


// -[Fields]-


// -[Methods]-



/**
 * Called when the current transaction is closed i.e. any DB changed have been committed
 * or rollback.
 */
public abstract void exClosed();

}


