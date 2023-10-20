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
 extends Item
{
// -[KeepWithinClass]-


// -[Fields]-


// -[Methods]-

/**
 * Constructs the object
 */
public UpdateableRow(String id, int index, IModel<T> model)
{
	super(id, index, model);

	setOutputMarkupId(true);
}

}


