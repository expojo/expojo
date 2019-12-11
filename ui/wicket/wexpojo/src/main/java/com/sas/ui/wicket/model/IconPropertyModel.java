// -[KeepHeading]-


// -[Copyright]-

/**
 * (c) 2006, 2012 Step Ahead Software Pty Ltd. All rights reserved.
 * 
 * Source file created and managed by Javelin (TM) Step Ahead Software.
 * To maintain code and model synchronization you may directly edit code in method bodies
 * and any sections starting with the 'Keep_*' marker. Make all other changes via Javelin.
 * See http://stepaheadsoftware.com for more details.
 */
package com.sas.ui.wicket.model;

import java.lang.*;
import com.sas.ui.wicket.model.ChainingPropertyModel;


// -[KeepBeforeClass]-
import org.apache.wicket.model.IModel;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;

// -[Class]-

/**
 * Class Name : IconPropertyModel
 * Diagram    : Wicket models for Icons and Attribute modifiers
 * Project    : Pagebloom
 * Type       : abstract
 * Displays an icon based on a the domain model object D.
 * 
 * Currently implemented to use "icofont" but could be easily enhanced to be switchable
 * between a range of different font icon libraries eg., Font-Awesome.
 * 
 * The generics here are slightly confusing.
 * 
 * The base class ChainingModel is instantiated with 'String' type for its T parameter
 * type because we need to ensure that Component.getDefaultModelObjectAsString sees a
 * String objet returned (not the domain model object which determines the value of that
 * String via its current state or whatever).
 * 
 * This class then has its own type parameter to specify the domain model object and
 * that type is given the generic parameter 'D'.
 * 
 * 
 * @author Chris Colman
 */
public abstract 
class IconPropertyModel<D>
 extends ChainingPropertyModel<D>
{
// -[KeepWithinClass]-


// -[Fields]-


// -[Methods]-




/**
 * Returns the icon size suffix - this may be a suffix like 2x, 4x or sm, lg, xl etc.,
 * so not necessarily numeric for all icon font libraries.
 * 
 * eg., for icofont the classes are 
 * icofont-1x, icofont-2x, icofont-4x etc.,
 * 
 * This method returns the 1x, 2x, 4x etc., suffix as appropriate.
 */
public String getIconSize(D d)
{
	return "2x";
}

/**
 * Returns the string that contains all the CSS classes required to display the icon.
 */
public String getIconCssClasses(D d)
{
	String iconName = getIconName(d);
	StringBuilder sb = new StringBuilder("icofont icofont-");
	sb.append(getIconSize(d));
	sb.append(" icofont-");
	sb.append(iconName == null ? "question" : iconName);
	return sb.toString();
}

/**
 * Returns a String object representing the icon.
 */
public String getObject()
{
	D object = getInnermostModelObject();
	
	StringBuilder sb = new StringBuilder("<i class=\"");
	String iconCssClasses = getIconCssClasses(object);
	sb.append(iconCssClasses);
	sb.append("\" aria-hidden=\"true\"></i>");

	return sb.toString();
}




/**
 * Provides the name of the icon to use based on the given object.
 * If null is returned then a '?' icon will be displayed.
 */
public abstract String getIconName(D object);

/**
 * Constructs the object
 */
public IconPropertyModel(Object modelObject)
{
	super(modelObject);
}

}

