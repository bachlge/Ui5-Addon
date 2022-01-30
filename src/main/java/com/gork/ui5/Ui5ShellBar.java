/**
 * https://sap.github.io/ui5-webcomponents/playground/components/ShellBar/
 */
package com.gork.ui5;

import javax.annotation.PostConstruct;

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
@Tag("ui5-shellbar")
@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^1.1.2")
@JsModule("@ui5/webcomponents-fiori/dist/ShellBar.js")
public class Ui5ShellBar extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5ShellBar.class);

	public Ui5ShellBar() {
		LOGGER.info("constructor ...");
		this.showCoPilot(true); // show by default
		this.showProductSwitch(true); // show by default
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setAccessibleTexts(String accessibleTexts) {
		this.getElement().setProperty("accessibleTexts", accessibleTexts);
	}

	public void setNotificationCount(String notificationCount) {
		this.getElement().setProperty("notificationCount", notificationCount);
	}

	public void setPrimaryTitle(String title) {
		this.getElement().setProperty("primaryTitle", title);
	}

	public void setSecondaryTitle(String title) {
		this.getElement().setProperty("secondaryTitle", title);
	}

	public void showCoPilot(Boolean copilot) {
		this.getElement().setProperty("showCoPilot", copilot);
	}

	public void showNotifications(Boolean showNotifications) {
		this.getElement().setProperty("showNotifications", showNotifications);
	}

	public void showProductSwitch(Boolean productswitch) {
		this.getElement().setProperty("showProductSwitch", productswitch);
	}

	@DomEvent("co-pilot-click")
	public static class CoPilotClickEvent extends ComponentEvent<Ui5ShellBar> {

		public CoPilotClickEvent(Ui5ShellBar source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("CoPilotClickEvent ClickEvent ...");
			Notification.show("clicked on CoPilotClickEvent " + source.getElement().getProperty("text"));
		}
	}

	public Registration addCoPilotClickListener(ComponentEventListener<CoPilotClickEvent> listener) {
		return addListener(CoPilotClickEvent.class, listener);
	}

	@DomEvent("logo-click")
	public static class LogoClickEvent extends ComponentEvent<Ui5ShellBar> {

		public LogoClickEvent(Ui5ShellBar source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("LogoClickEvent ClickEvent ...");
			Notification.show("clicked on Logo " + source.getElement().getProperty("text"));
		}
	}

	public Registration addLogoClickListener(ComponentEventListener<LogoClickEvent> listener) {
		return addListener(LogoClickEvent.class, listener);
	}

	@DomEvent("menu-item-click")
	public static class MenuItemClickEvent extends ComponentEvent<Ui5ShellBar> {

		public MenuItemClickEvent(Ui5ShellBar source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("MenuItemClickEvent ClickEvent ...");
			Notification.show("clicked on Menu Item " + source.getElement().getProperty("text"));
		}
	}

	public Registration addMenuItemClickListener(ComponentEventListener<MenuItemClickEvent> listener) {
		return addListener(MenuItemClickEvent.class, listener);
	}

	@DomEvent("navigations-click")
	public static class NavigationsClickEvent extends ComponentEvent<Ui5ShellBar> {

		public NavigationsClickEvent(Ui5ShellBar source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("NavigationsClickEvent ClickEvent ...");
			Notification.show("clicked on Navigation " + source.getElement().getProperty("text"));
		}
	}

	public Registration addNavigationsClickListener(ComponentEventListener<NavigationsClickEvent> listener) {
		return addListener(NavigationsClickEvent.class, listener);
	}

	@DomEvent("product-switch-click")
	public static class ProductSwitchClickEvent extends ComponentEvent<Ui5ShellBar> {

		public ProductSwitchClickEvent(Ui5ShellBar source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("ProductSwitchClickEvent ClickEvent ...");
			Notification.show("clicked on ProductSwitch " + source.getElement().getProperty("text"));
		}
	}

	public Registration addProductSwitchClickListener(ComponentEventListener<ProductSwitchClickEvent> listener) {
		return addListener(ProductSwitchClickEvent.class, listener);
	}

	@DomEvent("profile-click")
	public static class ProfileClickEvent extends ComponentEvent<Ui5ShellBar> {

		public ProfileClickEvent(Ui5ShellBar source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("ProfileClickEvent ClickEvent ...");
			Notification.show("clicked on Profile " + source.getElement().getProperty("text"));
		}
	}

	public Registration addProfileClickListener(ComponentEventListener<ProfileClickEvent> listener) {
		return addListener(ProfileClickEvent.class, listener);
	}

}
