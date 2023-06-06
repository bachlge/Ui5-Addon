/**
 * https://sap.github.io/ui5-webcomponents/playground/components/TabContainer/
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
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.shared.Registration;

@SuppressWarnings("serial")
@Tag("ui5-tabcontainer")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.14.0")
@JsModule("@ui5/webcomponents/dist/TabContainer.js")
public class Ui5TabContainer extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5TabContainer.class);

	public Ui5TabContainer() {
		LOGGER.info("constructor ...");
	}

	public void setCollapsed(Boolean value) {
		this.getElement().setProperty("collapsed", value);
	}

	public void setFixed(Boolean value) {
		this.getElement().setProperty("fixed", value);
	}

	public void setShowOverflow(Boolean value) {
		this.getElement().setProperty("showOverflow", value);
	}

	public void setTabLayout(TabLayout value) {
		this.getElement().setProperty("tabLayout", value.name());
	}

	public enum TabLayout { Standard, Inline }

	public void setTabsOverflowMode(TabsOverflowMode value) {
		this.getElement().setProperty("tabsOverflowMode", value.name());
	}

	public enum TabsOverflowMode { End, StartAtEnd }

	@DomEvent("tab-selection")
	public static class TabSelectEvent extends ComponentEvent<Ui5TabContainer> {

		public TabSelectEvent(Ui5TabContainer source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("selection changed to " + source.getElement().getProperty("item"));
			Notification.show("selection changed to " + source.getElement().getProperty("item"));
		}
	}

	public Registration addSelectionChangeListener(ComponentEventListener<TabSelectEvent> listener) {
		return addListener(TabSelectEvent.class, listener);
	}

}
