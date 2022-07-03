/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Icon/
 * 
 * NOTE: need to import every icon that is used! TODO: look for universal import
 */
package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-icon")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.4.0")
@NpmPackage(value = "@ui5/webcomponents-icons", version = "^1.4.0")
@NpmPackage(value = "@ui5/webcomponents-icons-tnt", version = "^1.4.0")

@JsModule("@ui5/webcomponents/dist/Icon.js")
@JsModule("@ui5/webcomponents-icons/dist/Allicons.js")

/* -> Allicons.js is the universal import!??
@JsModule("@ui5/webcomponents-icons/dist/home.js")
@JsModule("@ui5/webcomponents-icons/dist/employee.js")
@JsModule("@ui5/webcomponents-icons/dist/folder-blank.js")
@JsModule("@ui5/webcomponents-icons/dist/factory.js")
@JsModule("@ui5/webcomponents-icons/dist/loan.js")
@JsModule("@ui5/webcomponents-icons/dist/value-help.js")

@JsModule("@ui5/webcomponents-icons-tnt/dist/antenna.js")
*/

public class Ui5Icon extends Component {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Icon.class);

	public Ui5Icon() {
		LOGGER.info("constructor ...");
		this.getElement().setProperty("name", "employee"); // default icon
	}

	public Ui5Icon(String name) {
		LOGGER.info("constructor(name) ...");
		setIcon(name);
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setAccessibleName(String accessibleName) {
		this.getElement().setProperty("accessibleName", accessibleName);
	}

	public void setAccessibleRole(String accessibleRole) {
		this.getElement().setProperty("accessibleRole", accessibleRole);
	}

	public void setInteractive(Boolean value) {
		this.getElement().setProperty("interactive", value);
	}

	public void setName(String icon) {
		this.getElement().setProperty("name", icon);
	}

	/**
	 * Convenience Method
	 * @param icon
	 */
	public void setIcon(String icon) {
		setName(icon);
	}

	public void setShowTooltip(Boolean value) {
		this.getElement().setProperty("showTooltip", value);
	}

	/**
	 * Convenience Method
	 */
	public void setBig() {
		this.getElement().setProperty("style", "width:3rem;height:3rem;font-size:1.5rem;color:crimson;background-color:#fafafa");
	}

	/**
	 * Convenience Method
	 * Ui5Badge for example wants the Icon to be put in slot `icon`
	 * therefore will apply this method
	 * @param slot
	 */
	public void setSlot(String slot) {
		this.getElement().setProperty("slot", slot);
	}

}
