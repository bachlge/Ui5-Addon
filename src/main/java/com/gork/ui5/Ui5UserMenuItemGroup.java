/**
 * https://sap.github.io/ui5-webcomponents/components/fiori/UserMenuItemGroup/
 */
package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-user-menu-item-group")

@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^2.13.1")

@JsModule("@ui5/webcomponents-fiori/dist/UserMenuItemGroup.js")
//@JsModule("@ui5/webcomponents-fiori/dist/UserMenuItem.js")

public class Ui5UserMenuItemGroup extends Component {//implements HasComponents, HasSize {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5UserMenuItemGroup.class);

	public Ui5UserMenuItemGroup() {
		LOGGER.info("constructor ...");
	}

	/**
	 * Defines the component's check mode.
	 * Available Types:	"None", "Single", "Multiple"
	 * Default: None
	 */
	public void setCheckMode(UserMenuItemGroupCheckMode checkMode) {
		this.getElement().setProperty("checkMode", checkMode.toString());
	}

	public enum UserMenuItemGroupCheckMode { None, Single, Multiple }

}
