/**
 * https://sap.github.io/ui5-webcomponents/components/fiori/UserMenuItem/
 */
package com.gork.ui5;

import java.util.Map;

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
@Tag("ui5-user-menu-item")

@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^2.13.1")

@JsModule("@ui5/webcomponents-fiori/dist/UserMenuItem.js")

public class Ui5UserMenuItem extends Component {//implements HasComponents, HasSize {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5UserMenuItem.class);

	public Ui5UserMenuItem() {
		LOGGER.info("constructor ...");
//		setIcon("employee"); // default
	}

	public void setText(String text) {
		this.getElement().setProperty("text", text);
	}

	public void setAdditionalText(String text) {
		this.getElement().setProperty("additionalText", text);
	}

	public void setIcon(String icon) {
		this.getElement().setProperty("icon", icon);
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

	/**
	 * Defines the delay in milliseconds, after which the loading indicator will be displayed inside the corresponding ui5-menu popover.
	 * Default: false
	 */
	public void setLoadingDelay(Number value) {
		this.getElement().setProperty("loading", value.toString());
	}

	public void setAccessibleName(String text) {
		this.getElement().setProperty("accessibleName", text);
	}

	public void setTooltip(String tooltip) {
		this.getElement().setProperty("tooltip", tooltip);
	}

	public void setChecked(Boolean value) {
		this.getElement().setProperty("checked", value);
	}

	/**
	 * convenience method
	 */
	public void setChecked() {
		setChecked(true);
	}

	/**
	 * Defines the visual indication and behavior of the list items.
	 * Available options are Active (by default), Inactive, Detail and Navigation.
	 * Note: When set to Active or Navigation, the item will provide visual response upon press and hover,
	 * while with type Inactive and Detail - will not.
	 * Default: Active
	 */
	public void setType(UserMenuItemType type) {
		this.getElement().setProperty("type", type.toString());
	}

	public enum UserMenuItemType { Inactive, Active, Detail, Navigation }

	/**
	 * The navigated state of the list item.
	 * If set to true, a navigation indicator is displayed at the end of the list item.
	 * @param value
	 */
	public void setNavigated(Boolean value) {
		this.getElement().setProperty("navigated", value);
	}

	/**
	 * convenience method
	 */
	public void setNavigated() {
		setNavigated(true);
	}

	/**
	 * Defines the highlight state of the list items.
	 * Available options are: "None" (by default), "Positive", "Critical", "Information" and "Negative".
	 * Default: None
	 */
	public void setHighlight(UserMenuItemHighlight highlight) {
		this.getElement().setProperty("highlight", highlight.toString());
	}

	public enum UserMenuItemHighlight { None, Positive, Critical, Negative, Information }

	public void setSelected(Boolean value) {
		this.getElement().setProperty("selected", value);
	}

	/**
	 * convenience method
	 */
	public void setSelected() {
		setSelected(true);
	}


	/*----- Events -----*/

	@DomEvent("before-open")
	public static class BeforeOpenEvent extends ComponentEvent<Ui5UserMenuItem> {

		public BeforeOpenEvent(Ui5UserMenuItem source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("BeforeOpenEvent ...");
			Notification.show("Ui5UserMenuItem: Before-Open-Event (source=" + source + ")");
		}
	}

	public Registration addBeforeOpenEventEventListener(ComponentEventListener<BeforeOpenEvent> listener) {
		return addListener(BeforeOpenEvent.class, listener);
	}

	@DomEvent("open")
	public static class OpenEvent extends ComponentEvent<Ui5UserMenuItem> {

		public OpenEvent(Ui5UserMenuItem source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("OpenEvent ...");
			Notification.show("Ui5UserMenuItem: Open-Event (source=" + source + ")");
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
			Notification.show("Ui5UserMenuItem: Before-Close-Event (source=" + source + ")");
		}
	}

	public Registration addBeforeCloseEventListener(ComponentEventListener<BeforeCloseEvent> listener) {
		return addListener(BeforeCloseEvent.class, listener);
	}

	@DomEvent("close")
	public static class CloseEvent extends ComponentEvent<Ui5UserMenuItem> {

		public CloseEvent(Ui5UserMenuItem source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("CloseEvent ...");
			Notification.show("Ui5UserMenuItem: Close-Event (source=" + source + ")");
		}
	}

	public Registration addCloseEventListener(ComponentEventListener<CloseEvent> listener) {
		return addListener(CloseEvent.class, listener);
	}

	@DomEvent("check")
	public static class CheckEvent extends ComponentEvent<Ui5UserMenuItem> {

		public CheckEvent(Ui5UserMenuItem source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("CheckEvent ...");
			Notification.show("Ui5UserMenuItem: Check (source=" + source + ")");
		}
	}

	public Registration addCheckEventListener(ComponentEventListener<CheckEvent> listener) {
		return addListener(CheckEvent.class, listener);
	}

	@DomEvent("detail-click")
	public static class DetailClickEvent extends ComponentEvent<Ui5UserMenuItem> {

		public DetailClickEvent(Ui5UserMenuItem source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("DetailClickEvent ...");
			Notification.show("Ui5UserMenuItem: Sign-Out-Click (source=" + source + ")");
		}
	}

	public Registration addDetailClickEventListener(ComponentEventListener<DetailClickEvent> listener) {
		return addListener(DetailClickEvent.class, listener);
	}

}
