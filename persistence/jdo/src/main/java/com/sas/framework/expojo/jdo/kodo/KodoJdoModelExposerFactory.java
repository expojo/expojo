// -[KeepHeading]-


// -[Copyright]-

/**
 * 
 * 
 * Source file created and managed by Javelin (TM) Step Ahead Software.
 * To maintain code and model synchronization you may directly edit code in method bodies
 * and any sections starting with the 'Keep_*' marker. Make all other changes via Javelin.
 * See http://stepaheadsoftware.com for more details.
 */
package com.sas.framework.expojo.jdo.kodo;

import java.lang.*;
import com.sas.framework.expojo.jdo.JdoExpojoContextFactory;
    
import com.sas.framework.expojo.jdo.JdoPersistenceProvider;
    
import com.sas.framework.expojo.PersistenceProvider;
    
import com.sas.framework.expojo.servlet.ExpojoFoundation;
    
import com.sas.framework.system.IModulesProvider;
    
import com.sas.framework.expojo.ModelRef;
    
import com.sas.framework.expojo.servlet.ExpojoServletFilter;

// -[KeepBeforeClass]-


// -[Class]-

/**
 * Class Name : KodoJdoModelExposerFactory
 * Diagram    : Expojo JDO specific classes
 * Project    : Expojo JDO implementation
 * Type       : concrete
 * Model Exposer factory for KODO persistent domain objects.
 * 
 * @author Chris Colman
 */
public 
class KodoJdoModelExposerFactory extends JdoExpojoContextFactory
{
// -[KeepWithinClass]-


// -[Fields]-


// -[Methods]-

/**
 * Returns the name of the properties file used for configuring the JDO
 * datastore.
 */
public String getPropertiesFilename()
{
	return "kodo.properties";
}

}


