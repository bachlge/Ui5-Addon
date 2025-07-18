/**
 * https://sap.github.io/ui5-webcomponents/components/fiori/UserSettingsDialog/
 */
package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.shared.Registration;

@SuppressWarnings("serial")
@Tag("ui5-user-settings-dialog")

@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^2.12.0")

@JsModule("@ui5/webcomponents-fiori/dist/UserSettingsDialog.js")

public class Ui5UserSettingsDialog extends Component implements HasComponents, HasSize {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5UserSettingsDialog.class);

	/**
	 * Constructor
	 * pre-setting some defaults
	 */
	public Ui5UserSettingsDialog() {
		LOGGER.info("constructor ...");
	}

	/**
	 * Defines, if the User Settings Dialog is opened.
	 * Default: false
	 */
	public void setOpen(Boolean open) {
		this.getElement().setProperty("open", open);
	}

	/**
	 * convenience method
	 */
	public void setOpen() {
		setOpen(true);
	}

	public void setHeaderText(String text) {
		this.getElement().setProperty("headerText", text);
	}


	/**
	 * Defines if the Search Field would be displayed.
	 * Default: false
	 */
	public void setSearchField(Boolean value) {
		this.getElement().setProperty("searchField", value);
	}

	/**
	 * convenience method
	 */
	public void setSearchField() {
		setSearchField(true);
	}


	/*----- Events -----*/

	@DomEvent("selection-change")
	public static class SelectionChangeEvent extends ComponentEvent<Ui5UserSettingsDialog> {

		public SelectionChangeEvent(Ui5UserSettingsDialog source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("SelectionChangeEvent ...");
			Notification.show("Ui5UserSettingsDialog: Selection-Change-Event (source=" + source + ")");
		}
	}

	public Registration addSelectionChangeEventListener(ComponentEventListener<SelectionChangeEvent> listener) {
		return addListener(SelectionChangeEvent.class, listener);
	}

	@DomEvent("open")
	public static class OpenEvent extends ComponentEvent<Ui5UserSettingsDialog> {

		public OpenEvent(Ui5UserSettingsDialog source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("OpenEvent ...");
			Notification.show("Ui5UserSettingsDialog: Open-Event (source=" + source + ")");
		}
	}

	public Registration addOpenEventListener(ComponentEventListener<OpenEvent> listener) {
		return addListener(OpenEvent.class, listener);
	}

	@DomEvent("before-close")
	public static class BeforeCloseEvent extends ComponentEvent<Ui5UserMenuItem> {

		public BeforeCloseEvent(Ui5UserMenuItem source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("BeforeCloseEvent ...");
			Notification.show("Ui5UserSettingsDialog: Before-Close-Event (source=" + source + ")");
		}
	}

	public Registration addBeforeCloseEventListener(ComponentEventListener<BeforeCloseEvent> listener) {
		return addListener(BeforeCloseEvent.class, listener);
	}

	@DomEvent("close")
	public static class CloseEvent extends ComponentEvent<Ui5UserSettingsDialog> {

		public CloseEvent(Ui5UserSettingsDialog source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("CloseEvent ...");
			Notification.show("Ui5UserSettingsDialog: Close-Event (source=" + source + ")");
		}
	}

	public Registration addCloseEventListener(ComponentEventListener<CloseEvent> listener) {
		return addListener(CloseEvent.class, listener);
	}

}
