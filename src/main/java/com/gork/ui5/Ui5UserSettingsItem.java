/**
 * https://sap.github.io/ui5-webcomponents/components/fiori/UserSettingsItem/
 */
package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.shared.Registration;

@SuppressWarnings("serial")
@Tag("ui5-user-settings-item")

@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^2.13.1")

@JsModule("@ui5/webcomponents-fiori/dist/UserSettingsItem.js")

public class Ui5UserSettingsItem extends Component {//implements HasComponents, HasSize {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5UserSettingsItem.class);

	public Ui5UserSettingsItem() {
		LOGGER.info("constructor ...");
//		setIcon("employee"); // default
	}

	public void setText(String text) {
		this.getElement().setProperty("text", text);
	}

	public void setTooltip(String tooltip) {
		this.getElement().setProperty("tooltip", tooltip);
	}

	public void setHeaderlText(String text) {
		this.getElement().setProperty("headerText", text);
	}

	public void setSelected(Boolean value) {
		this.getElement().setProperty("selected", value);
	}

	/**
	 * convenience method
	 */
	public void setSelected() {
		setSelected(true);
	}

	/**
	 * Defines whether ui5-menu-item is in disabled state.
	 * Default: false
	 */
	public void setDisabled(Boolean value) {
		this.getElement().setProperty("disabled", value);
	}

	/**
	 * convenience method
	 */
	public void setDisabled() {
		setDisabled(true);
	}

	/**
	 * Default: false
	 */
	public void setLoading(Boolean value) {
		this.getElement().setProperty("loading", value);
	}

	/**
	 * convenience method
	 */
	public void setLoading() {
		setLoading(true);
	}

	public void setLoadingReason(String reason) {
		this.getElement().setProperty("loadingReason", reason);
	}

	public void setIcon(String icon) {
		this.getElement().setProperty("icon", icon);
	}

	public void setAccessibleName(String text) {
		this.getElement().setProperty("accessibleName", text);
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

}
