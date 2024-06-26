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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


// -[Class]-

/**
 * Class Name : IUserRepository
 * Diagram    : Interfaces for user service and repository components
 * Project    : Entity Model Framework
 * Type       : interface
 * An interface that supplies user services such as checking if a username, password
 * combination is for a valid user etc.,
 * 
 * @author Chris Colman
 */
public abstract 
interface IUserRepository
{
// -[KeepWithinClass]-



// -[Fields]-


// -[Methods]-




/**
 * Return a list of all entity states.
 */
public abstract List<IEntity.State> getAllEntityStates();



/**
 * Returns all users in the system.
 */
public abstract Collection findAllUsers();




/**
 * Finds the user with the given username.
 */
public abstract IUser findUserByUsername(String username);

}


