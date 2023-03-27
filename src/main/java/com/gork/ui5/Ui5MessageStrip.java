/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Badge/
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
@Tag("ui5-message-strip")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.11.0")
@JsModule("@ui5/webcomponents/dist/MessageStrip.js")
public class Ui5MessageStrip extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5MessageStrip.class);

	public Ui5MessageStrip() {
		LOGGER.info("constructor ...");
	}

	public void setDesign(MessageStripDesign design) {
		this.getElement().setProperty("design", design.toString());
	}

	public enum MessageStripDesign { Information, Positive, Negative, Warning }

	public void setHideCloseButton(Boolean iconEnd) {
		this.getElement().setProperty("hideCloseButton", iconEnd);
	}

	public void setHideIcon(Boolean iconEnd) {
		this.getElement().setProperty("hideIcon", iconEnd);
	}

	/**
	 * Slots: default, icon
	 * @param slot
	 */
	public void setSlot(String slot) {
		this.getElement().setProperty("slot", slot);
	}

}
