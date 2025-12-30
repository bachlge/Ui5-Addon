/**
 * https://sap.github.io/ui5-webcomponents/components/fiori/UserMenu/
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
@Tag("ui5-user-menu")

@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^2.13.1")

@JsModule("@ui5/webcomponents-fiori/dist/UserMenu.js")

public class Ui5UserMenu extends Component implements HasComponents, HasSize {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5UserMenu.class);

	/**
	 * Constructor
	 * pre-setting some defaults
	 */
	public Ui5UserMenu() {
		LOGGER.info("constructor ...");
		this.setShowManageAccount();
		this.setShowOtherAccounts();
		this.setShowEditAccounts();
		this.setShowEditButton();
		this.setMinWidth("10%");
		this.setMaxHeight("10%");
		this.setOpen();
	}

	/**
	 * Defines if the User Menu is opened.
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

	/**
	 * Defines the ID or DOM Reference of the element at which the user menu is shown.
	 * When using this attribute in a declarative way, you must only use the id (as a string) of the element
	 * at which you want to show the popover.
	 * You can only set the opener attribute to a DOM Reference when using JavaScript.
	 */
	public void setOpener(String opener) {
		this.getElement().setProperty("opener", opener);
	}

	/**
	 * Defines if the User Menu shows the Manage Account option.
	 * Default: false
	 */
	public void setShowManageAccount(Boolean value) {
		this.getElement().setProperty("showManageAccount", value);
	}

	/**
	 * convenience method
	 */
	public void setShowManageAccount() {
		setShowManageAccount(true);
	}

	/**
	 * Defines if the User Menu shows the Other Accounts option.
	 * Default: false
	 */
	public void setShowOtherAccounts(Boolean value) {
		this.getElement().setProperty("showOtherAccounts", value);
	}

	/**
	 * convenience method
	 */
	public void setShowOtherAccounts() {
		setShowOtherAccounts(true);
	}

	/**
	 * Defines if the User Menu shows the Edit Accounts option.
	 * Default: false
	 */
	public void setShowEditAccounts(Boolean value) {
		this.getElement().setProperty("showEditAccounts", value);
	}

	/**
	 * convenience method
	 */
	public void setShowEditAccounts() {
		setShowEditAccounts(true);
	}

	/**
	 * Defines if the User Menu shows the Edit Accounts option.
	 * Default: false
	 */
	public void setShowEditButton(Boolean value) {
		this.getElement().setProperty("showEditButton", value);
	}

	/**
	 * convenience method
	 */
	public void setShowEditButton() {
		setShowEditButton(true);
	}

	/**
	 * default ... Defines the menu items.
	 * accounts ... Defines the user accounts.
	 * 
	 * Note: default slot is not part of the enum because it is a key-word
	 */
	public enum Slot {
		accounts		
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

	public void addAccount(Ui5UserMenuAccount account) {
		addTo(account, Slot.accounts);
	}

	public void addItem(Ui5UserMenuItem item) {
		add(item);
	}


	/*----- Events -----*/

	@DomEvent("avatar-click")
	public static class AvatarClickEvent extends ComponentEvent<Ui5UserMenu> {

		public AvatarClickEvent(Ui5UserMenu source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("AvatarClickEvent ...");
			Notification.show("Ui5UserMenu: Avatar cllicked (source=" + source + ")");
		}
	}

	public Registration addAvatarClickEventListener(ComponentEventListener<AvatarClickEvent> listener) {
		return addListener(AvatarClickEvent.class, listener);
	}

	@DomEvent("manage-account-click")
	public static class ManageAccountClickEvent extends ComponentEvent<Ui5UserMenu> {

		public ManageAccountClickEvent(Ui5UserMenu source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("ManageAccountClickEvent ...");
			Notification.show("Ui5UserMenu: Manage-Account clicked (source=" + source + ")");
		}
	}

	public Registration addManageAccountClickEventListenet(ComponentEventListener<ManageAccountClickEvent> listener) {
		return addListener(ManageAccountClickEvent.class, listener);
	}

	@DomEvent("edit-account-click")
	public static class EditAccountsClickEvent extends ComponentEvent<Ui5UserMenu> {

		public EditAccountsClickEvent(Ui5UserMenu source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("AddAccountClickEvent ...");
			Notification.show("Ui5UserMenu: opened (source=" + source + ")");
		}
	}

	public Registration addEditAccountslickEventListener(ComponentEventListener<EditAccountsClickEvent> listener) {
		return addListener(EditAccountsClickEvent.class, listener);
	}

	@DomEvent("change-account")
	public static class ChangeAccountEvent extends ComponentEvent<Ui5UserMenu> {

		public ChangeAccountEvent(Ui5UserMenu source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("ChangeAccountEvent ...");
			Notification.show("Ui5UserMenu: change account (source=" + source + ")");
		}
	}

	public Registration addChangeAccountEventListener(ComponentEventListener<ChangeAccountEvent> listener) {
		return addListener(ChangeAccountEvent.class, listener);
	}

	@DomEvent("item-click")
	public static class ItemClickEvent extends ComponentEvent<Ui5UserMenu> {

		public ItemClickEvent(Ui5UserMenu source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("ItemClickEvent ...");
			Notification.show("Ui5UserMenu: item clicked (source=" + source + ")");
		}
	}

	public Registration addItemClickEventListener(ComponentEventListener<ItemClickEvent> listener) {
		return addListener(ItemClickEvent.class, listener);
	}

	@DomEvent("open")
	public static class OpenEvent extends ComponentEvent<Ui5UserMenu> {

		public OpenEvent(Ui5UserMenu source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("OpenEvent ...");
			Notification.show("Ui5UserMenu: opened (source=" + source + ")");
		}
	}

	public Registration addOpenEventListener(ComponentEventListener<OpenEvent> listener) {
		return addListener(OpenEvent.class, listener);
	}

	@DomEvent("close")
	public static class CloseEvent extends ComponentEvent<Ui5UserMenu> {

		public CloseEvent(Ui5UserMenu source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("CloseEvent ...");
			Notification.show("Ui5UserMenu: closed (source=" + source + ")");
		}
	}

	public Registration addCloseEventListener(ComponentEventListener<CloseEvent> listener) {
		return addListener(CloseEvent.class, listener);
	}

	@DomEvent("sign-out-click")
	public static class SignOutClickEvent extends ComponentEvent<Ui5UserMenu> {

		public SignOutClickEvent(Ui5UserMenu source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("SignOutClickEvent ...");
			Notification.show("Ui5UserMenu: Sign-Out-Click (source=" + source + ")");
		}
	}

	public Registration addSignOutClickEventListener(ComponentEventListener<SignOutClickEvent> listener) {
		return addListener(SignOutClickEvent.class, listener);
	}

}
