// -[KeepHeading]-


// -[Copyright]-

/**
 * (c) 2006, 2014 Step Ahead Software Pty Ltd. All rights reserved.
 * 
 * Source file created and managed by Javelin (TM) Step Ahead Software.
 * To maintain code and model synchronization you may directly edit code in method bodies
 * and any sections starting with the 'Keep_*' marker. Make all other changes via Javelin.
 * See http://stepaheadsoftware.com for more details.
 */
package com.sas.framework.iam.user;

import java.lang.*;
    
import com.sas.framework.entity.IEntity;


// -[KeepBeforeClass]-
import java.util.Date;

import com.sas.framework.iam.realm.IRealm;


// -[Class]-

/**
 * Class Name : IUser
 * Diagram    : Interfaces for user model classes
 * Project    : Entity Model Framework
 * Type       : interface
 * Interface for all users in a system.
 * 
 * @author Chris Colman
 */
public abstract 
interface IUser
{
// -[KeepWithinClass]-


// -[Fields]-


// -[Methods]-




/**
 * Describe here
 */
public abstract IEntity getEntity();



/**
 * Describe here
 */
public abstract long getMemberId();



/**
 * Sets the activationCode.
 */
public abstract void setActivationCode(String iActivationCode);



/**
 * Returns the activation code.
 */
public abstract String getActivationCode();



/**
 * Describe here
 */
public abstract String toString();




/**
 * Registers a successful authentication for a particular IRealm. Typically would add
 * some kind of authentication tracking object to keep a trail of successful logins of
 * user along with the time it occurred and the realm they logged into.
 */
public abstract void registerAuthentication(IRealm realm);



/**
 * Returns currentLogon
 */
public abstract Date getCurrentLogon();



/**
 * Returns previousLogon
 */
public abstract Date getPreviousLogon();




/**
 * Returns (ideally a digested) password.
 */
public abstract String getPassword();



/**
 * Returns username
 */
public abstract String getUsername();

}


