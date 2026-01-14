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
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;


// -[KeepBeforeClass]-
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.extensions.markup.html.repeater.data.table.*;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;

import org.apache.wicket.extensions.markup.html.repeater.data.grid.DataGridView;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackHeadersToolbar;


// -[Class]-

/**
 * Class Name : BootstrapDataTable
 * Diagram    : Bootstrap capable components
 * Project    : WexPOJO - Wicket + exPOJO application core
 * Type       : concrete
 * Extends DataTable to add an appender that outputs bootstrap table (CSS) classes.
 * 
 * @author 
 */
public 
class BootstrapDataTable<T,S>
 extends DataTable<T,S>
{
// -[KeepWithinClass]-


// -[Fields]-



/**
 * Holds reference to the DataGridView that was created.
 */
private DataGridView<T> protectedDataGridView;


// -[Methods]-

/**
 * Constructs the new table
 */
public BootstrapDataTable(final String id, final List<? extends IColumn<T, S>> columns, final ISortableDataProvider<T, S> dataProvider, final int rowsPerPage, boolean striped)
{
	this(id, columns, dataProvider, rowsPerPage, striped, null);
}

/**
 * Calls base class to create the DataGridView but maintains a reference to it so that
 * it can be used by this derived class.
 */
public DataGridView<T> newDataGridView(String id, List<? extends IColumn<T, S>> columns, IDataProvider<T> dataProvider)
{
	protectedDataGridView = super.newDataGridView(id, columns, dataProvider);
	return protectedDataGridView;
}




/**
 * Find the ListItem associated with the given modelObject.
 */
public ListItem<T> findListItem(T modelObject)
{
	ListItem<T> found = null;

	Iterator<Item<T>> components = protectedDataGridView.getItems();

	while (components.hasNext())
	{
		ListItem<T> listItem = components.next();
		T t = listItem.getModelObject();
		if (t.equals(modelObject))
		{
			found = listItem;
			break;
		}
	}

	return found;
}




/**
 * Override row creation to ensure that we set the markup output to true so that rows
 * can be updated.
 */
protected Item<T> newRowItem(String id, int index, IModel<T> model)
{
	Item<T> item = new UpdateableRow<T>(id, index, model);

	item.setOutputMarkupId(true);

	return item;
}

/**
 * Constructs the new table
 */
public BootstrapDataTable(final String id, final List<? extends IColumn<T, S>> columns, final ISortableDataProvider<T, S> dataProvider, final int rowsPerPage)
{
	this(id, columns, dataProvider, rowsPerPage, false, null);
}

/**
 * Constructs the new table
 */
public BootstrapDataTable(final String id, final List<? extends IColumn<T, S>> columns, final ISortableDataProvider<T, S> dataProvider, final int rowsPerPage, boolean striped, String style)
{
	super(id, columns, dataProvider, rowsPerPage);

	String bootstrapTableClasses;
	if (style != null)
		bootstrapTableClasses = " " + style;
	else
		bootstrapTableClasses = " table table-condensed table-hover table-stemless";
		
	if (striped)
		bootstrapTableClasses += " table-striped";
		
	add(new AttributeAppender("class", bootstrapTableClasses));

	
        this.setOutputMarkupId(true);
        this.setVersioned(false);
        this.addTopToolbar(new StyledNavigationToolbar(this));
        this.addTopToolbar(new AjaxFallbackHeadersToolbar(this, dataProvider));
        this.addBottomToolbar(new NoRecordsToolbar(this));
}

}


