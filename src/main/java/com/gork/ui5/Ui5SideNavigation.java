/**
 * https://sap.github.io/ui5-webcomponents/playground/components/SideNavigation/
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
@Tag("ui5-side-navigation")
@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^1.19.0")
@JsModule("@ui5/webcomponents-fiori/dist/SideNavigation.js")
public class Ui5SideNavigation extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5SideNavigation.class);

	public Ui5SideNavigation() {
		LOGGER.info("constructor ...");
	}

	public void setCollapsed(Boolean value) {
		this.getElement().setProperty("collapsed", value);
	}

	@DomEvent("selection-change")
	public static class SelectionChangeEvent extends ComponentEvent<Ui5SideNavigation> {

		public SelectionChangeEvent(Ui5SideNavigation source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("selection changed to " + source.getElement().getProperty("item"));
			Notification.show("selection changed to " + source.getElement().getProperty("item"));
		}
	}

	public Registration addSelectionChangeListener(ComponentEventListener<SelectionChangeEvent> listener) {
		return addListener(SelectionChangeEvent.class, listener);
	}

}
