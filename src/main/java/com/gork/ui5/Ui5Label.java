/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Label/
 */
package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-label")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.1.2")
@JsModule("@ui5/webcomponents/dist/Label.js")
public class Ui5Label extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Label.class);

	public Ui5Label() {
		LOGGER.info("constructor ...");
	}

	public Ui5Label(String value) {
		this();
		add(value);
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setFor(String value) {
		this.getElement().setProperty("for", value);
	}

	public void setRequired(boolean value) {
		this.getElement().setProperty("required", value);
	}

	/**
	 * Convenience Method: set to true
	 */
	public void setRequired() {
		setRequired(true);
	}

	public void setShowColon(boolean value) {
		this.getElement().setProperty("showColon", value);
	}

	/**
	 * Convenience Method: set to true
	 */
	public void setShowColon() {
		setShowColon(true);
	}

	public void setWrappingType(WrappingType value) {
		this.getElement().setProperty("wrapping-type", value.toString());
	}

	/**
	 * Defines how the text of a component will be displayed when there is not enough space.
	 * Available options are:
	 * 		None - The text will be truncated with an ellipsis.
	 * 		Normal - The text will wrap. The words will not be broken based on hyphenation.
	 */
	public enum WrappingType { None, Normal }

	// Convenience
	public void setWrap(boolean wrap) {
		if (wrap) {
			setWrappingType(WrappingType.Normal);
		} else {
			setWrappingType(WrappingType.None);
		}
	}

}
