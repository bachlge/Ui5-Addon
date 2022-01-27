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
 * 	- ui5-li-groupheader
 * 
 */
package com.gork.ui5;

import java.util.Arrays;
import java.util.List;

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
@Tag("ui5-list")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.1.2")
@JsModule("@ui5/webcomponents/dist/List.js")
public class Ui5List extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5List.class);

	public Ui5List() {
		LOGGER.info("constructor ...");
		setNoDataText("list contains no data");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setAccessibleName(String accessibleName) {
		this.getElement().setProperty("accessibleName", accessibleName);
	}

	public void setAccessibleNameRef(String accessibleNameRef) {
		this.getElement().setProperty("accessibleNameRef", accessibleNameRef);
	}

	public void setAccessibleRole(String accessibleRole) {
		this.getElement().setProperty("accessibleRole", accessibleRole);
	}

	public void setBusy(boolean value) {
		this.getElement().setProperty("busy", value);
	}

	public void setHeaderText(String header) {
		this.getElement().setProperty("headerText", header);
	}

	public void setFooterText(String footer) {
		this.getElement().setProperty("footerText", footer);
	}

	/**
	 * Convenience Method
	 * @return
	 */
	public int getNumItems() {
		return this.getElement().getChildCount();
	}

	/**
	 * Convenience Method
	 */
	public void clear() {
		this.getElement().removeAllChildren();
	}

	// Defines the text that is displayed when the ui5-list contains no items.
	// Default value (implemented by SAP) is false
	// Default value implemented in constructor
	public void setNoDataText(String value) {
		this.getElement().setProperty("noDataText", value);
	}

	// Determines whether the list items are indented.
	// Default: false
	public void setIndent(boolean value) {
		this.getElement().setProperty("indent", value);
	}

	// Defines if the component would fire the load-more event when the user scrolls to the bottom of the list,
	// and helps achieving an "infinite scroll" effect by adding new items each time.
	// Default: false
	public void setInfiniteScroll(boolean value) {
		this.getElement().setProperty("infiniteScroll", value);
	}

	// Default value (implemented by SAP) is None
	public void setMode(Mode value) {
		this.getElement().setProperty("mode", value.name());
	}

	// Default value (implemented by SAP) is All
	public void setSeparators(Separators value) {
		this.getElement().setProperty("separators", value.name());
	}

	public void addSelectListener() {}

	public enum Mode { None, SingleSelect, SingleSelectBegin, SingleSelectEnd, MultiSelect, Delete }
	public enum Separators { All, None, Inner }


	// Events: item-click, item-close, item-delete, item-toggle, load-more, selection-change
	@DomEvent("item-click")
//	@DomEvent("itemClick")
	public static class ItemClickEvent extends ComponentEvent<Ui5List> {
		private Element item;
		public ItemClickEvent(Ui5List source, boolean fromClient,
				@EventData("element.item") Element item) {
			super(source, fromClient);
			LOGGER.info("Item click event occured - item=" + item);
			this.item = item;
		}
		public Element getElement() {
			return item;
		}
	}

	public Registration addItemClickListener(ComponentEventListener<ItemClickEvent> listener) {
		return addListener(ItemClickEvent.class, listener);
	}

	@DomEvent("selection-change")
//	@DomEvent("selectionChange")
	public static class SelectionEvent extends ComponentEvent<Ui5List> {
		private List<Element> selectedItems;
		public SelectionEvent(Ui5List source, boolean fromClient,
				@EventData("event.selectedItems") Element selectedItems,
				@EventData("event.previouslySelectedItems") Element prevItems) {
			super(source, fromClient);
			LOGGER.info("List selection click event occured - " + selectedItems + " was: " + prevItems);
			this.selectedItems = Arrays.asList(selectedItems);
		}
		public List<Element> getSelectedItems() {
			return selectedItems;
		}
	}

	public Registration addChangeListener(ComponentEventListener<SelectionEvent> listener) {
		return addListener(SelectionEvent.class, listener);
	}

}
