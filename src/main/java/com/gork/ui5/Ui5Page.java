/**
 * 
 * https://ui5.github.io/webcomponents/components/fiori/Page/
 * 
 * Slots:
 * 		default
 * 		header
 * 		footer
 * 
 */
package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-page")
@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^2.22.0")
@JsModule("@ui5/webcomponents-fiori/dist/Page.js")
public class Ui5Page extends Component implements HasComponents, HasSize, HasStyle {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Page.class);

	public Ui5Page() {
		LOGGER.info("constructor ...");
	}

	/**
	 * Default: Solid
	 */
	public void setBackgroundDesign(BackgroundDesign design) {
		this.getElement().setProperty("backgroundDesign", design.toString());
	}

	/**
	 * Default: false
	 */
	public void setFixedFooter(boolean value) {
		this.getElement().setProperty("fixedFooter", value);
	}

	/**
	 * convenience method
	 */
	public void setFixedFooter() {
		this.setFixedFooter(true);
	}

	/**
	 * Default: false
	 */
	public void setHideFooter(boolean value) {
		this.getElement().setProperty("hideFooter", value);
	}

	/**
	 * convenience method
	 */
	public void setHideFooter() {
		this.setHideFooter(true);
	}

	/**
	 * Default: false
	 */
	public void setNoScrolling(boolean value) {
		this.getElement().setProperty("noScrolling", value);
	}

	/**
	 * convenience method
	 */
	public void setNoScrolling() {
		this.setNoScrolling(true);
	}

	public enum BackgroundDesign {
		List,
		Solid,
		Transparent,
	}

	/**
	 * Convienience Method
	 * @param component
	 * @param slot
	 */
	public void addTo(Component component, Slot slot) {
		component.getElement().setAttribute("slot", slot.toString());
		this.add(component);
	}

	public void addToHeader(Component component) {
		this.addTo(component, Slot.header);
	}

	public void addToFooter(Component component) {
		this.addTo(component, Slot.footer);
	}

	public void addToDefault(Component component) {
		this.add(component);
	}

	/**
	 * Slots: default, header, footer
	 */
	public enum Slot {
		header,
		footer		
	}

}
