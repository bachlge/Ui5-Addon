/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Table/
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
@Tag("ui5-table")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.19.0")
@JsModule("@ui5/webcomponents/dist/Table.js")
public class Ui5Table extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Table.class);

	public Ui5Table() {
		LOGGER.info("constructor ...");
		setNoDataText("No data in this table");
		setStickyColumnHeader(true);
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

	/**
	 * Default: None
	 * @param value
	 */
	public void setGrowing(TableGrowingMode value) {
		this.getElement().setProperty("growing", value.name());
	}

	public enum TableGrowingMode { Button, None, Scroll }

	public void setGrowingButtonText(String text) {
		this.getElement().setProperty("growingButtonText", text);
	}

	public void setGrowingButtonSubtext(String text) {
		this.getElement().setProperty("growingButtonSubtext", text);
	}

	/**
	 * Defines if the value of noDataText will be diplayed when there is no rows present in the table.
	 * Default: false
	 * @param value
	 */
	public void setHideNoData(boolean value) {
		this.getElement().setProperty("hideNoData", value);
	}

	public void setMode(TableMode value) {
		this.getElement().setProperty("mode", value.name());
	}

	public enum TableMode { None, SingleSelect, MultiSelect }

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
	 * Determines whether the column headers remain fixed at the top of the page during vertical scrolling as long as the Web Component is in the viewport.
	 * Default: false
	 * @param value
	 */
	public void setStickyColumnHeader(boolean value) {
		this.getElement().setProperty("stickyColumnHeader", value);
	}

	/**
	 * Events
	 *  - load-more
	 *  - popin-change
	 *  - row-click
	 *  - selection-change
	 */

	@DomEvent("load-more")
	public static class LoadMoreEvent extends ComponentEvent<Ui5Table> {
		public LoadMoreEvent(Ui5Table source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("Load More event occured ...");
		}
	}

	public Registration addLoadMoreListener(ComponentEventListener<LoadMoreEvent> listener) {
		return addListener(LoadMoreEvent.class, listener);
	}

	@DomEvent("popin-change")
	public static class PopinChangeEvent extends ComponentEvent<Ui5Table> {
		public PopinChangeEvent(Ui5Table source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("List selection click event occured...");
		}
	}

	public Registration addPopinChangeListener(ComponentEventListener<PopinChangeEvent> listener) {
		return addListener(PopinChangeEvent.class, listener);
	}

	@DomEvent("item-click")
	public static class ItemClickEvent extends ComponentEvent<Ui5Table> {
		private Element item;
		public ItemClickEvent(Ui5Table source, boolean fromClient,
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
	public static class SelectionChangeEvent extends ComponentEvent<Ui5Table> {
		private List<Element> selectedItems;
		public SelectionChangeEvent(Ui5Table source, boolean fromClient,
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
