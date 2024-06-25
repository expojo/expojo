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
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxNavigationToolbar;


// -[KeepBeforeClass]-

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;


// -[Class]-

/**
 * Class Name : StyledNavigationToolbar
 * Diagram    : Bootstrap capable components
 * Project    : WexPOJO - Wicket + exPOJO application core
 * Type       : concrete
 * Describe here
 * 
 * @author 
 */
public 
class StyledNavigationToolbar extends AjaxNavigationToolbar
{
// -[KeepWithinClass]-


// -[Fields]-


// -[Methods]-

/**
 * Describe here
 */
public PagingNavigator newPagingNavigator(String navigatorId, final DataTable<?, ?> table)
{
	return new StyledPagingNavigator(navigatorId, table)
	{
		private static final long serialVersionUID = 1L;

		protected void onAjaxEvent(AjaxRequestTarget target)
	    {
            target.add(new Component[]{table});
		}
	};
}




/**
 * Constructs the object
 */
public StyledNavigationToolbar(DataTable<?,?> table)
{
	super(table);
}

}


