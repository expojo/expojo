// -[KeepHeading]-


// -[Copyright]-

/**
 * (c) 2008,2019. Step Ahead Software Pty Ltd. All rights reserved.
 * Usage is governed by the terms of the Apache 2 License.
 * 
 * Source file created and managed by Javelin (TM) Step Ahead Software.
 * To maintain code and model synchronization you may directly edit code in method bodies
 * and any sections starting with the 'Keep_*' marker. Make all other changes via Javelin.
 * See http://stepaheadsoftware.com for more details.
 */
package com.sas.app.wexpojo.biz.website;

import java.lang.*;
import com.sas.app.wexpojo.biz.website.IWebsiteBehaviour;


// -[KeepBeforeClass]-


// -[Class]-

/**
 * Class Name : PortalWebsiteBehaviour
 * Diagram    : Website Domain Model Impl
 * Project    : WexPOJO - Wicket + exPOJO application core
 * Type       : concrete
 * The website is actually a web application or "portal" for which the home page and
 * most other pages are available to authenticated users only.
 * 
 * @author Chris Colman
 */
public 
class PortalWebsiteBehaviour implements IWebsiteBehaviour
{
// -[KeepWithinClass]-


// -[Fields]-



/**
 * true if auxiliary challenge is supported.
 */
private boolean auxiliaryChallenge = true;


// -[Methods]-

/**
 * Sets auxiliaryChallenge
 */
public void setAuxiliaryChallenge(boolean auxiliaryChallenge)
{
    this.auxiliaryChallenge = auxiliaryChallenge;
}

/**
 * Returns true if the website has auxiliary challenge authentication available.
 * It does not mean that every log in will invoke an auxiliary authentication challenge
 * - that is left to the application to decide based on business rules.
 * e.g. auxiliary challenge may only be required if the user logs in via a device that
 * they have not previously logged in from.
 */
public boolean supportsAuxiliaryChallenge()
{
	return auxiliaryChallenge;
}




/**
 * Returns true if all pages require an authenticated user - except for the Authenticate
 * pages.
 */
public boolean allPagesRequireAuth()
{
	return true;
}

}


