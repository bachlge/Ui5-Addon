/**
 * https://sap.github.io/ui5-webcomponents/components/fiori/ShellBar/
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
@Tag("ui5-shellbar")
@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^2.12.0")
@JsModule("@ui5/webcomponents-fiori/dist/ShellBar.js")
public class Ui5ShellBar extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5ShellBar.class);

	public Ui5ShellBar() {
		LOGGER.info("constructor ...");
		this.showCoPilot(true); // show by default
		this.showProductSwitch(true); // show by default
	}

	public void setPrimaryTitle(String title) {
		this.getElement().setProperty("primaryTitle", title);
	}

	public void setSecondaryTitle(String title) {
		this.getElement().setProperty("secondaryTitle", title);
	}

	public void setNotificationsCount(String notificationsCount) {
		this.getElement().setProperty("notificationsCount", notificationsCount);
	}

	public void showNotifications(Boolean showNotifications) {
		this.getElement().setProperty("showNotifications", showNotifications);
	}

	/**
	 * convenience method
	 */
	public void showNotifications() {
		showNotifications(true);
	}

	public void showProductSwitch(Boolean productswitch) {
		this.getElement().setProperty("showProductSwitch", productswitch);
	}

	/**
	 * convenience method
	 */
	public void showProductSwitch() {
		showProductSwitch(true);
	}

	public void showSearchField(Boolean searchField) {
		this.getElement().setProperty("showSearchField", searchField);
	}

	/**
	 * convenience method
	 */
	public void showSearchField() {
		showSearchField(true);
	}

	@Deprecated
	public void showCoPilot(Boolean copilot) {
		this.getElement().setProperty("showCoPilot", copilot);
	}

	/**
	 * default ... Defines the ui5-shellbar additional items.
	 * assistant ... Defines the assistant slot.
	 * profile ... You can pass ui5-avatar to set the profile image/icon. If no profile slot is set - profile will be excluded from actions.
	 * logo ... Defines the logo of the ui5-shellbar. For example, you can use ui5-avatar or img elements as logo.
	 * menuItems ... Defines the items displayed in menu after a click on the primary title. Note: You can use the <ui5-li></ui5-li> and its ancestors.
	 * searchField ... Defines the ui5-input, that will be used as a search field.
	 * startButton ... Defines a ui5-button in the bar that will be placed in the beginning. We encourage this slot to be used for a back or home button. It gets overstyled to match ShellBar's styling.
	 * 
	 * Note: default slot is not part of the enum because it is a key-word
	 */
	public enum Slot {
		assistant, profile, logo, menuItems, searchField, startButton;
	}

	/**
	 * Convenience Method
	 * @param component
	 * @param slot
	 */
	public void addTo(Component component, Slot slot) {
		component.getElement().setAttribute("slot", slot.toString());
		this.add(component);
	}

	/**
	 * Convenience Method
	 */
	public void addUserMenu(Ui5UserMenu menu) {
		addTo(menu, Slot.profile);
	}

	/**
	 * Convenience Method
	 */
	public void addProductSwitch(Ui5ProductSwitch productSwitch) {
		addTo(productSwitch, Slot.menuItems);
	}

	/*----- Helper -----*/

	public Object getProfileDomRef() {
		return this.getElement().getProperty("profileDomRef");
	}

	public Object getProductSwitchDomRef() {
		return this.getElement().getProperty("productSwitchDomRef");
	}

	/*----- Events -----*/

	@DomEvent("notifications-click")
	public static class NotificationsClickEvent extends ComponentEvent<Ui5ShellBar> {

		public NotificationsClickEvent(Ui5ShellBar source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("Ui5ShellBar NotificationsClickEvent ...");
			Notification.show("clicked on Notifications " + source.getElement().getProperty("text"));
		}
	}

	public Registration addNotificatonsClickListener(ComponentEventListener<NotificationsClickEvent> listener) {
		return addListener(NotificationsClickEvent.class, listener);
	}

	@DomEvent("profile-click")
	public static class ProfileClickEvent extends ComponentEvent<Ui5ShellBar> {

		public ProfileClickEvent(Ui5ShellBar source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("Ui5ShellBar ProfileClickEvent ...");
			Notification.show("clicked on Profile " + source.getElement().getProperty("text"));
		}
	}

	public Registration addProfileClickListener(ComponentEventListener<ProfileClickEvent> listener) {
		return addListener(ProfileClickEvent.class, listener);
	}

	@DomEvent("product-switch-click")
	public static class ProductSwitchClickEvent extends ComponentEvent<Ui5ShellBar> {

		public ProductSwitchClickEvent(Ui5ShellBar source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("Ui5ShellBar ProductSwitchClickEvent ...");
			Notification.show("clicked on ProductSwitch " + source.getElement().getProperty("text"));
		}
	}

	public Registration addProductSwitchClickListener(ComponentEventListener<ProductSwitchClickEvent> listener) {
		return addListener(ProductSwitchClickEvent.class, listener);
	}

	@DomEvent("logo-click")
	public static class LogoClickEvent extends ComponentEvent<Ui5ShellBar> {

		public LogoClickEvent(Ui5ShellBar source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("Ui5ShellBar LogoClickEvent ...");
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
			LOGGER.info("Ui5ShellBar MenuItemClickEvent ...");
			Notification.show("clicked on Menu Item " + source.getElement().getProperty("text"));
		}
	}

	public Registration addMenuItemClickListener(ComponentEventListener<MenuItemClickEvent> listener) {
		return addListener(MenuItemClickEvent.class, listener);
	}

	@DomEvent("search-button-click")
	public static class SearchButtonClickEvent extends ComponentEvent<Ui5ShellBar> {

		public SearchButtonClickEvent(Ui5ShellBar source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("Ui5ShellBar SearchButtonClickEvent ...");
			Notification.show("clicked on CoPilotClickEvent " + source.getElement().getProperty("text"));
		}
	}

	public Registration addSearchButtonClickListener(ComponentEventListener<SearchButtonClickEvent> listener) {
		return addListener(SearchButtonClickEvent.class, listener);
	}

	@DomEvent("co-pilot-click")
	public static class CoPilotClickEvent extends ComponentEvent<Ui5ShellBar> {

		public CoPilotClickEvent(Ui5ShellBar source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("Ui5ShellBar CoPilotClickEvent  ...");
			Notification.show("clicked on CoPilotClickEvent " + source.getElement().getProperty("text"));
		}
	}

	@Deprecated
	public Registration addCoPilotClickListener(ComponentEventListener<CoPilotClickEvent> listener) {
		return addListener(CoPilotClickEvent.class, listener);
	}

	@DomEvent("navigations-click")
	public static class NavigationsClickEvent extends ComponentEvent<Ui5ShellBar> {

		public NavigationsClickEvent(Ui5ShellBar source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("Ui5ShellBar NavigationsClickEvent ClickEvent ...");
			Notification.show("clicked on Navigation " + source.getElement().getProperty("text"));
		}
	}

	@Deprecated
	public Registration addNavigationsClickListener(ComponentEventListener<NavigationsClickEvent> listener) {
		return addListener(NavigationsClickEvent.class, listener);
	}

}
