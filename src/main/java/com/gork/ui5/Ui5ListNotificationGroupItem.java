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
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.shared.Registration;

@SuppressWarnings("serial")
@Tag("ui5-li-notification-group")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.14.0")
@JsModule("@ui5/webcomponents-fiori/dist/NotificationListGroupItem.js")
public class Ui5ListNotificationGroupItem extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5ListNotificationGroupItem.class);

	public Ui5ListNotificationGroupItem() {
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

	public void setCollapsed(boolean value) {
		this.getElement().setProperty("collapsed", value);
	}

	public void setShowClose(boolean value) {
		this.getElement().setProperty("showClose", value);
	}

	public void setShowCounter(boolean value) {
		this.getElement().setProperty("showCounter", value);
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


	/**
	 * Slots: default, actions
	 * @param slot
	 */
	public void setSlot(String slot) {
		this.getElement().setProperty("slot", slot);
	}


	@DomEvent("close")
	public static class CloseEvent extends ComponentEvent<Ui5ListNotificationItem> {
		public CloseEvent(Ui5ListNotificationItem source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("Close event occured");
		}
	}

	public Registration addCloseListener(ComponentEventListener<CloseEvent> listener) {
		return addListener(CloseEvent.class, listener);
	}

	@DomEvent("toggle")
	public static class ToggleEvent extends ComponentEvent<Ui5ListNotificationGroupItem> {
		public ToggleEvent(Ui5ListNotificationGroupItem source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("Toggle event occured");
		}
	}

	public Registration addToggleListener(ComponentEventListener<ToggleEvent> listener) {
		return addListener(ToggleEvent.class, listener);
	}


}
