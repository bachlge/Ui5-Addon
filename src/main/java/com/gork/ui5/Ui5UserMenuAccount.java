/**
 * https://sap.github.io/ui5-webcomponents/components/fiori/UserMenuAccount/
 */
package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-user-menu-account")

@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^2.12.0")

@JsModule("@ui5/webcomponents-fiori/dist/UserMenuAccount.js")
@JsModule("@ui5/webcomponents-icons/dist/person-placeholder.js")

public class Ui5UserMenuAccount extends Component {//implements HasComponents, HasSize {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5UserMenuAccount.class);

	/**
	 * Constructor
	 * pre-setting some defaults
	 */
	public Ui5UserMenuAccount() {
		LOGGER.info("constructor ...");
		setAvatarSrc("person-placeholder"); // default Avatar
		setAvatarInitials("?.?."); // default Avatar Initials
	}

	public void setOpen(Boolean open) {
		this.getElement().setProperty("open", open);
	}

	/**
	 * convenience method
	 */
	public void setOpen() {
		setOpen(true);
	}

	public void setAvatarSrc(String string) {
		this.getElement().setProperty("avatarSrc", string);
	}

	public void setAvatarInitials(String string) {
		this.getElement().setProperty("avatarInitials", string);
	}

	public void setTitleText(String string) {
		this.getElement().setProperty("titleText", string);
	}

	public void setSubtitleText(String string) {
		this.getElement().setProperty("subtitleText", string);
	}

	public void setDescription(String string) {
		this.getElement().setProperty("description", string);
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

	public void setLoading(Boolean value) {
		this.getElement().setProperty("loading", value);
	}

	/**
	 * convenience method
	 */
	public void setLoading() {
		setLoading(true);
	}

}
