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
package com.sas.framework.expojo.thread;

import java.lang.*;
    
import com.sas.framework.expojo.IWrappedOperation;

// [Added by Code Injection Wizard: SLF4J Logging Support]
// Do not edit code injected by the wizard directly in the source file as
// as it will be overwritten during subsequent updates. 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// -[KeepBeforeClass]-

import com.sas.framework.expojo.Ex;

// -[Class]-

/**
 * Class Name : ExpojoThread
 * Diagram    : Excpojo Context in separate thread
 * Project    : ExPOJO Core
 * Type       : concrete
 * Executes an IExceutable in a separate thread, returning only when that thread has
 * completed its task.
 * 
 * Invoked by calling
 * 
 * execute(IWrappedOperation, Object param1, Object param2)
 * 
 * This starts the background thread and starts it.
 * 
 * The background thread establishes an ExpojoContext and then calls iWrappedOperation.execute(param1,
 * param2).
 * 
 * When the background thread has completed its work the execute method will return
 * 
 * @author Chris Colman
 */
public 
class ExpojoThread
{
// -[KeepWithinClass]-


// -[Fields]-



/**
 * References the Runnable associated with this object.
 */
private Runnable updater = null;



/**
 * NoDesc
 */
private Object param1;



/**
 * NoDesc
 */
private Object param2;
    
    protected IWrappedOperation operation;

// [Added by Code Injection Wizard: SLF4J Logging Support]
// Do not edit code injected by the wizard directly in the source file as
// as it will be overwritten during subsequent updates. 
private static final Logger logger = LoggerFactory.getLogger(ExpojoThread.class);


// -[Methods]-

/**
 * Starts the background thread to perform the work and waits until it has completed.
 */
protected void startAndWait()
{
	updater = new Runnable()
	{
		public void run()
		{
			try
			{
				Ex.executeWrappedCreate
				(
					operation, param1, param2
				);
			}
			catch(Exception e)
			{
				logger.error("Operation failed", e);
			}
			finally
			{
				if (updater == null)
					logger.error("Thread terminated before completion");
				else
					updater = null;
			}
		}
	};

	// start running the background thread
	new Thread(updater).start();

	do
	{
		try
		{
			Thread.sleep(100);
		}
		catch(Exception e)
		{
		}
	}
	while(updater != null);
}

/**
 * Constructs the object
 */
public ExpojoThread(IWrappedOperation iOperation, Object iParam1, Object iParam2)
{
	operation = iOperation;
	param1 = iParam1;
	param2 = iParam2;
}

/**
 * Executes the given operation in a separate thread, waiting until the thread has completed
 * before returning.
 */
public static void execute(IWrappedOperation operation, Object param1, Object param2)
{
	ExpojoThread expojoThread = new ExpojoThread(operation, param1, param2);
	
	expojoThread.startAndWait();
}

}


