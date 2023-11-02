/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Bar/
 */
package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-bar")
@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^1.19.0")
@JsModule("@ui5/webcomponents-fiori/dist/Bar.js")
public class Ui5Bar extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Bar.class);

	public Ui5Bar() {
		LOGGER.info("constructor ...");
	}

	/**
	 * Defines the ui5-bar design.
	 * Default: Header
	 * @param design
	 */
	public void setDesign(BarDesign design) {
		this.getElement().setProperty("design", design.toString());
	}

	public enum BarDesign {
		Header,
		Subheader,
		Footer,
		FloatingFooter
	}

	/**
	 * Convenience Method
	 * use to add a component to the desired slot
	 * @param component
	 * @param slot
	 */
	public void addTo(Component component, Slot slot) {
		component.getElement().setAttribute("slot", slot.toString());
		if (slot.equals(Slot.middleContent)) {
			component.getElement().setAttribute("slot", "default");
		}
		this.add(component);
	}

	/**
	 * Convenience Method
	 * use to add a component to the `startContent` slot
	 */
	public void addToStart(Component component) {
		addTo(component, Slot.startContent);
	}

	/**
	 * Convenience Method
	 * use to add a component to the `default` slot (which is the "middleContent")
	 */
	public void addToMid(Component component) {
		addTo(component, Slot.middleContent);
	}

	/**
	 * Convenience Method
	 * use to add a component to the `endContent` slot
	 */
	public void addToEnd(Component component) {
		addTo(component, Slot.endContent);
	}

	public enum Slot {
		startContent,
		middleContent,
		endContent
	}

}
