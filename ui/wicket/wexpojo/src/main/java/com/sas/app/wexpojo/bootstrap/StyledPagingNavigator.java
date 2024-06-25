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
package com.sas.app.wexpojo.bootstrap;

import java.lang.*;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;


// -[KeepBeforeClass]-

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.markup.html.navigation.paging.IPagingLabelProvider;

// -[Class]-

/**
 * Class Name : StyledPagingNavigator
 * Diagram    : Bootstrap capable components
 * Project    : WexPOJO - Wicket + exPOJO application core
 * Type       : concrete
 * Describe here
 * 
 * @author 
 */
public 
class StyledPagingNavigator extends AjaxPagingNavigator
{
// -[KeepWithinClass]-


// -[Fields]-


// -[Methods]-

/**
 * Returns a variation based on the organization ID.
 */
public String getVariation()
{
	WebPage webPage = findParent(WebPage.class);
	
	return webPage.getVariation();
}

/**
 * Constructs the object
 */
public StyledPagingNavigator(String id, IPageable pageable, IPagingLabelProvider labelProvider)
{
	super(id, pageable, labelProvider);
}

/**
 * Constructs the object
 */
public StyledPagingNavigator(String id, IPageable pageable)
{
	super(id, pageable);
}

}


