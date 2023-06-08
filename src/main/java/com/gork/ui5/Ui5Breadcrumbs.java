/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Breadcrumbs/
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
import com.vaadin.flow.shared.Registration;

import elemental.json.JsonValue;

@SuppressWarnings("serial")
@Tag("ui5-breadcrumbs")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.14.0")
@JsModule("@ui5/webcomponents/dist/Breadcrumbs.js")
public class Ui5Breadcrumbs extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Breadcrumbs.class);

	public Ui5Breadcrumbs() {
		LOGGER.info("constructor ...");
	}

	/**
	 * Defines the visual indication and behavior of the breadcrumbs.
	 * Default: Standard
	 * @param design
	 */
	public void setDesign(BreadcrumbsDesign design) {
		this.getElement().setProperty("design", design.toString());
	}

	public enum BreadcrumbsDesign { Standard, NoCurrentPage }

	/**
	 * Determines the visual style of the separator between the breadcrumb items.
	 * Default: Slash
	 * @param separatorStyle
	 */
	public void setSeparatorStyle(BreadcrumbsSeparatorStyle separatorStyle) {
		this.getElement().setProperty("separatorStyle", separatorStyle.toString());
	}

	public enum BreadcrumbsSeparatorStyle { Slash, BackSlash, DoubleBackSlash, DoubleGreaterThan, DoubleSlash, GreaterThan }


	/**
	 * Dummy Property for Event-Test purposes
	 */
	public void setBla(String bla) {
		this.getElement().setProperty("bla", bla);
	}

	public Registration addItemClickListener(ComponentEventListener<ItemClickEvent> listener) {
		return addListener(ItemClickEvent.class, listener);
	}

	@DomEvent("item-click")
	public static class ItemClickEvent extends ComponentEvent<Ui5Breadcrumbs> {

		private final String bla;
		private final JsonValue item;
		private final String s;

		public ItemClickEvent(Ui5Breadcrumbs source, boolean fromClient,
				@EventData("element.bla") String bla,
				@EventData("event.item") JsonValue item,
				@EventData("event.bubbles") String s) {
			super(source, fromClient);
			this.item = item;
			this.bla = bla;
			this.s = s;
			LOGGER.info("Ui5Breadcrumbs.ItemClickEvent - source=" + source);
			LOGGER.info("Ui5Breadcrumbs.ItemClickEvent - bla=" + bla);
			LOGGER.info("Ui5Breadcrumbs.ItemClickEvent - item=" + s);
		}

		public String getBla() {
			return bla;
		}
		public String getItem() {
			return item.asString();
		}
		public String getS() {
			return s;
		}
	}

}
