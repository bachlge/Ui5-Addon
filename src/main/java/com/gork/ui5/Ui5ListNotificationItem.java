/**
 * https://sap.github.io/ui5-webcomponents/playground/components/List/
 * 
 * The ui5-list component allows displaying a list of items,
 * advanced keyboard handling support for navigating between items,
 * and predefined modes to improve the development efficiency.
 * 
 * The ui5-list is a container for the available list items:
 * 	- ui5-li
 * 		The ui5-li represents the simplest type of item for a ui5-list.
 * 		This is a list item, providing the most common use cases such as text, image and icon.
 * 
 * 	- ui5-li-custom
 * 		A component to be used as custom list item within the ui5-list the same way as the standard ui5-li.
 * 		The component accepts arbitrary HTML content to allow full customization.
 * 
 * 	- ui5-li-groupheade
 * 		The ui5-li-groupheader is a special list item, used only to separate other list items into logical groups.
 * 
 */
package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
@Tag("ui5-li-notification")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.11.0")
@JsModule("@ui5/webcomponents-fiori/dist/NotificationListItem.js")
@JsModule("@ui5/webcomponents-fiori/dist/NotificationAction.js")
public class Ui5ListNotificationItem extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5ListNotificationItem.class);

	public Ui5ListNotificationItem() {
		LOGGER.info("constructor ...");
	}

	public void setBusy(boolean value) {
		this.getElement().setProperty("busy", value);
	}

	/**
	 * Delay in milliseconds
	 * @param value
	 */
	public void setBusyDelay(int value) {
		this.getElement().setProperty("busyDelay", value);
	}

	public void setPriority(Priority priority) {
		this.getElement().setProperty("priority", priority.name());
	}

	public enum Priority { None, Low, Medium, High }

	public void setRead(Boolean read) {
		this.getElement().setProperty("read", read);
	}

	public void setTitleText(String titleText) {
		this.getElement().setProperty("titleText", titleText);
	}

	public void setWrappingType(WrappingType wrappingType) {
		this.getElement().setProperty("wrappingType", wrappingType.name());
	}

	public enum WrappingType { None }


	/**
	 * Slots: avatar, default, footnotes, actions
	 * @param slot
	 */
	public void setSlot(String slot) {
		this.getElement().setProperty("slot", slot);
	}


	@DomEvent("close")
	public static class CloseEvent extends ComponentEvent<Ui5ListNotificationItem> {
		private Element item;
		public CloseEvent(Ui5ListNotificationItem source, boolean fromClient,
				@EventData("element.item") Element item) {
			super(source, fromClient);
			LOGGER.info("Item click event occured - item=" + item);
			this.item = item;
		}
		public Element getElement() {
			return item;
		}
	}

	public Registration addCloseListener(ComponentEventListener<CloseEvent> listener) {
		return addListener(CloseEvent.class, listener);
	}

}
