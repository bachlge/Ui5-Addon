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
@NpmPackage(value = "@ui5/webcomponents", version = "^1.19.0")
@JsModule("@ui5/webcomponents/dist/List.js")
public class Ui5List extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5List.class);

	public Ui5List() {
		LOGGER.info("constructor ...");
		setNoDataText("list contains no data");
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

	/**
	 * Delay in milliseconds
	 * @param value
	 */
	public void setBusyDelay(int value) {
		this.getElement().setProperty("busyDelay", value);
	}

	public void setFooterText(String footer) {
		this.getElement().setProperty("footerText", footer);
	}

	/**
	 * Default: None
	 * @param value
	 */
	public void setGrowing(ListGrowingMode value) {
		this.getElement().setProperty("growing", value.name());
	}

	public enum ListGrowingMode { Button, None, Scroll }

	public void setHeaderText(String header) {
		this.getElement().setProperty("headerText", header);
	}

	/**
	 * Determines whether the list items are indented.
	 * Default: false
	 * @param value
	 */
	public void setIndent(boolean value) {
		this.getElement().setProperty("indent", value);
	}

	// Default value (implemented by SAP) is None
	public void setMode(Mode value) {
		this.getElement().setProperty("mode", value.name());
	}

	public enum Mode { None, SingleSelect, SingleSelectBegin, SingleSelectEnd, MultiSelect, Delete }

	/**
	 * Defines the text that is displayed when the ui5-list contains no items.
	 * Default value (implemented by SAP) is ""
	 * Therefore PostConstruct `init()` will set a default value
	 * @param value
	 */
	public void setNoDataText(String value) {
		this.getElement().setProperty("noDataText", value);
	}

	/**
	 * Default: All
	 * @param value
	 */
	public void setSeparators(ListSeparators value) {
		this.getElement().setProperty("separators", value.name());
	}

	public enum ListSeparators { All, None, Inner }

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

	/**
	 * @deprecated use @setGrowing instead
	 */
	@Deprecated()
	public void setInfiniteScroll(boolean value) {
		this.getElement().setProperty("infiniteScroll", value);
	}

	public void addSelectListener() {}

	/**
	 * Events
	 *  - item-click
	 *  - item-close
	 *  - item-delete
	 *  - item-toggle
	 *  - load-more
	 *  - selection-change
	 */

	@DomEvent("item-click")
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


	@DomEvent("item-close")
	public static class ItemCloseEvent extends ComponentEvent<Ui5List> {
		private Element item;
		public ItemCloseEvent(Ui5List source, boolean fromClient,
				@EventData("element.item") Element item) {
			super(source, fromClient);
			LOGGER.info("Item click event occured - item=" + item);
			this.item = item;
		}
		public Element getElement() {
			return item;
		}
	}

	public Registration addItemCloseListener(ComponentEventListener<ItemCloseEvent> listener) {
		return addListener(ItemCloseEvent.class, listener);
	}


	@DomEvent("item-delete")
	public static class ItemDeleteEvent extends ComponentEvent<Ui5List> {
		private Element item;
		public ItemDeleteEvent(Ui5List source, boolean fromClient,
				@EventData("element.item") Element item) {
			super(source, fromClient);
			LOGGER.info("Item click event occured - item=" + item);
			this.item = item;
		}
		public Element getElement() {
			return item;
		}
	}

	public Registration addItemDeleteListener(ComponentEventListener<ItemDeleteEvent> listener) {
		return addListener(ItemDeleteEvent.class, listener);
	}


	@DomEvent("item-toggle")
	public static class ItemToggleEvent extends ComponentEvent<Ui5List> {
		private Element item;
		public ItemToggleEvent(Ui5List source, boolean fromClient,
				@EventData("element.item") Element item) {
			super(source, fromClient);
			LOGGER.info("Item click event occured - item=" + item);
			this.item = item;
		}
		public Element getElement() {
			return item;
		}
	}

	public Registration addItemToggleListener(ComponentEventListener<ItemDeleteEvent> listener) {
		return addListener(ItemDeleteEvent.class, listener);
	}


	@DomEvent("load-more")
	public static class LoadMoreEvent extends ComponentEvent<Ui5List> {
		public LoadMoreEvent(Ui5List source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("Load More event occured ...");
		}
	}

	public Registration addLoadMoreListener(ComponentEventListener<LoadMoreEvent> listener) {
		return addListener(LoadMoreEvent.class, listener);
	}


	@DomEvent("selection-change")
	public static class SelectionChangeEvent extends ComponentEvent<Ui5List> {
		private List<Element> selectedItems;
		public SelectionChangeEvent(Ui5List source, boolean fromClient,
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

	public Registration addSelectionChangeListener(ComponentEventListener<SelectionChangeEvent> listener) {
		return addListener(SelectionChangeEvent.class, listener);
	}

}
