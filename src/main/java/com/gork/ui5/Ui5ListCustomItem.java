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

import javax.annotation.PostConstruct;

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
@Tag("ui5-li")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.1.2")
@JsModule("@ui5/webcomponents/dist/CustomListItem.js")
public class Ui5ListCustomItem extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5ListCustomItem.class);

	public Ui5ListCustomItem() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
		setType(Type.Detail);
	}

	public void setSlot(String slot) {
		this.getElement().setProperty("slot", slot);
	}

	/**
	 * Defines the icon source URI.
	 * Note: SAP-icons font provides numerous built-in icons. To find all the available icons, see the Icon Explorer.
	 * @param value
	 */
	public void setIcon(String value) {
		this.getElement().setProperty("icon", value);
	}

	/**
	 * Defines the description displayed right under the item text, if such is present.
	 * @param value
	 */
	public void setDescription(String value) {
		this.getElement().setProperty("description", value);
	}

	/**
	 * Defines the additionalText, displayed in the end of the list item.
	 * @param additionalText
	 */
	public void setAdditionalText(String additionalText) {
		this.getElement().setProperty("additionalText", additionalText);
	}

	public void setAdditionalTextState(ValueState additionalTextState) {
		this.getElement().setProperty("additionalTextState", additionalTextState.name());
	}

	/**
	 * use setAdditionalText() instead
	 * @param value
	 */
	@Deprecated()
	public void setInfo(String value) {
		setAdditionalText(value);
	}

	/**
	 * use setAdditionalTextState() instead
	 * @param value
	 */
	@Deprecated()
	public void setInfoState(ValueState value) {
		setAdditionalTextState(value);
	}

	public void setType(Type value) {
		this.getElement().setProperty("type", value.name());
	}

	public enum ValueState { None, Success, Warning, Information, Erorr }
	public enum Type { Active, Inactive, Detail }

	@DomEvent("detail-click")
	public static class DetailClickEvent extends ComponentEvent<Ui5ListCustomItem> {
		private Element item;
		public DetailClickEvent(Ui5ListCustomItem source, boolean fromClient, @EventData("event.item.bla") Element item) {
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
