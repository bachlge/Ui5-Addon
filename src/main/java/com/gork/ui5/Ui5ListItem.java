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
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-li")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.1.2")
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
	 * Defines whether the icon should be displayed in the beginning of the list item or in the end.
	 * Default: false
	 * @param iconEnd
	 */
	public void setIconEnd(Boolean iconEnd) {
		this.getElement().setProperty("iconEnd", iconEnd);
	}

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
	 * use setAdditionalText instead
	 * @param value
	 */
	@Deprecated
	public void setInfo(String value) {
		setAdditionalText(value);
	}

	/**
	 * use set setAdditionalTextState instead
	 * @param value
	 */
	@Deprecated
	public void setInfoState(ValueState value) {
		setAdditionalTextState(value);
	}

	/**
	 * Defines the visual indication and behavior of the list items.
	 * Available options are Active (by default), Inactive and Detail.
	 * Note: When set to Active, the item will provide visual response upon press and hover,
	 * while with type Inactive and Detail - will not.
	 * @param value
	 */
	public void setType(Type value) {
		this.getElement().setProperty("type", value.name());
	}

	/**
	 * Defines the selected state of the ListItem.
	 * @param selected
	 */
	public void setSelected(Boolean selected) {
		this.getElement().setProperty("selected", selected);
	}


	public enum ValueState { None, Success, Warning, Information, Erorr }
	public enum Type { Active, Inactive, Detail }

}
