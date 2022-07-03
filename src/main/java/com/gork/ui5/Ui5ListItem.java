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
 * 	- ui5-li-groupheader
 * 		The ui5-li-groupheader is a special list item, used only to separate other list items into logical groups.
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
@NpmPackage(value = "@ui5/webcomponents", version = "^1.4.0")
@JsModule("@ui5/webcomponents/dist/StandardListItem.js")
public class Ui5ListItem extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5ListItem.class);

	public Ui5ListItem() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setAccessibleName(String accessibleName) {
		this.getElement().setProperty("accessibleName", accessibleName);
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

	public enum ValueState { None, Success, Warning, Information, Erorr }

	public void setDescription(String value) {
		this.getElement().setProperty("description", value);
	}

	public void setIcon(String value) {
		this.getElement().setProperty("icon", value);
	}

	/**
	 * Defines whether the icon should be displayed in the beginning of the list item or in the end.
	 * Default: false
	 * @param iconEnd
	 */
	public void setIconEnd(boolean value) {
		this.getElement().setProperty("iconEnd", value);
	}
	
	public void setImage(String value) {
		this.getElement().setProperty("image", value);
	}

	/**
	 * Defines the visual indication and behavior of the list items.
	 * Available options are Active (by default), Inactive and Detail.
	 * Note: When set to Active, the item will provide visual response upon press and hover,
	 * while with type Inactive and Detail - will not.
	 * @param value
	 */
	public void setType(ListItemType value) {
		this.getElement().setProperty("type", value.name());
	}

	public enum ListItemType { Active, Inactive, Detail }

	/**
	 * Defines the selected state of the ListItem.
	 * @param selected
	 */
	public void setSelected(Boolean value) {
		this.getElement().setProperty("selected", value);
	}

	public void setSlot(String slot) {
		this.getElement().setProperty("slot", slot);
	}


	@DomEvent("detail-click")
	public static class DetailClickEvent extends ComponentEvent<Ui5ListItem> {
		private Element item;
		public DetailClickEvent(Ui5ListItem source, boolean fromClient, @EventData("event.item.bla") Element item) {
			super(source, fromClient);
			LOGGER.info("List item detail-click event occured");
			this.item = item;
		}
		public Element getElement() {
			return item;
		}
	}

	public Registration addDetailListener(ComponentEventListener<DetailClickEvent> listener) {
		return addListener(DetailClickEvent.class, listener);
	}


	/**
	 * @deprecated use @setAdditionalText instead
	 */
	@Deprecated
	public void setInfo(String value) {
		setAdditionalText(value);
	}

	/**
	 * @deprecated use set @setAdditionalTextState instead
	 */
	@Deprecated
	public void setInfoState(ValueState value) {
		setAdditionalTextState(value);
	}

}
