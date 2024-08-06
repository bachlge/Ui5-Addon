/**
 * https://sap.github.io/ui5-webcomponents/playground/components/List/
 * https://sap.github.io/ui5-webcomponents/playground/components/NotificationListItem/
 * 
The ui5-li-notification is a type of list item, meant to display notifications.
The component has a rich set of various properties that allows the user to set avatar, titleText, descriptive content and footnotes to fully describe a notification.
The user can:
display a Close button
can control whether the titleText and description should wrap or truncate and display a ShowMore button to switch between less and more information
add custom actions by using the ui5-notification-action component
Usage
The component can be used in a standard ui5-list.
 * 
 */
package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gork.ui5.Ui5ListItem.ListItemType;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.shared.Registration;

@SuppressWarnings("serial")
@Tag("ui5-li-custom")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.24.8")
@JsModule("@ui5/webcomponents/dist/ListItemCustom.js")
public class Ui5ListItemCustom extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5ListItemCustom.class);

	public Ui5ListItemCustom() {
		LOGGER.info("constructor ...");
	}

	public void setAccessibleName(String accessibleName) {
		this.getElement().setProperty("accessibleName", accessibleName);
	}

	/**
	 * re-use ListItemType from Ui5ListItem
	 * @param value
	 */
	public void setType(ListItemType value) {
		this.getElement().setProperty("type", value.name());
	}

	public void setSelected(Boolean value) {
		this.getElement().setProperty("selected", value);
	}

	public void setSlot(String slot) {
		this.getElement().setProperty("slot", slot);
	}


	@DomEvent("detail-click")
	public static class DetailClickEvent extends ComponentEvent<Ui5ListItemCustom> {
		private Element item;
		public DetailClickEvent(Ui5ListItemCustom source, boolean fromClient, @EventData("event.item.bla") Element item) {
			super(source, fromClient);
			LOGGER.info("Custom List item detail-click event occured");
			this.item = item;
		}
		public Element getElement() {
			return item;
		}
	}

	public Registration addDetailListener(ComponentEventListener<DetailClickEvent> listener) {
		return addListener(DetailClickEvent.class, listener);
	}

}
