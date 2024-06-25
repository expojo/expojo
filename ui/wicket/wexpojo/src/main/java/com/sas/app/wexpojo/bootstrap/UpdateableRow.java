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
import org.apache.wicket.markup.repeater.Item;


// -[KeepBeforeClass]-
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.model.IModel;


// -[Class]-

/**
 * Class Name : UpdateableRow
 * Diagram    : Bootstrap capable components
 * Project    : WexPOJO - Wicket + exPOJO application core
 * Type       : concrete
 * Each row of a BootstrapDataTable is created with UpdateableRowS instead of ItemS so
 * that they can be updated via:
 * 
 * ajaxRequestTarget.add(findParent(UpdateableRow.class));
 * 
 * @author 
 */
public 
class UpdateableRow<T>
 extends Item<T>
{
// -[KeepWithinClass]-


// -[Fields]-


// -[Methods]-




/**
 * Looks for an ancestor of the given sub component that is an instance of UpdateableRow
 * and then adds that instance to the given AjaxRequestTarget so that it gets rerendered
 * so that the view is updated to reflect the current model state.
 * This is intended to be used with BootstrapDataTable to provide an easy way to update
 * just a single row in the data table.
 */
public static void update(AjaxRequestTarget target, Component subComponent)
{
	Component component = subComponent.findParent(UpdateableRow.class);

	target.add(component);
}

/**
 * Constructs the object
 */
public UpdateableRow(String id, int index, IModel<T> model)
{
	super(id, index, model);

	setOutputMarkupId(true);
}

}


