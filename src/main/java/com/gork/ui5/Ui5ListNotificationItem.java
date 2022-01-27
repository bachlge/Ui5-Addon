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

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-li-notification")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.1.2")
@JsModule("@ui5/webcomponents-fiori/dist/NotificationListItem.js")
public class Ui5ListNotificationItem extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5ListNotificationItem.class);

	public Ui5ListNotificationItem() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setTitleText(String titleText) {
		this.getElement().setProperty("titleText", titleText);
	}

	public void setRead(Boolean read) {
		this.getElement().setProperty("read", read);
	}

	public void setSlot(String slot) {
		this.getElement().setProperty("slot", slot);
	}

	public void setIcon(String value) {
		this.getElement().setProperty("icon", value);
	}

	public void setDescription(String value) {
		this.getElement().setProperty("description", value);
	}

	public void setInfo(String value) {
		this.getElement().setProperty("info", value);
	}

	public void setWrappingType(WrappingType wrappingType) {
		this.getElement().setProperty("wrappingType", wrappingType.name());
	}

	public void setPriority(Priority priority) {
		this.getElement().setProperty("priority", priority.name());
	}

	public enum ButtonDesign { Default, Emphasized, Positive, Negative, Transparent, Attention }

	public enum Priority { None, Low, Medium, High }

	public enum WrappingType { None }

}
