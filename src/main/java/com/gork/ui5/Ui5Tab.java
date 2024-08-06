/**
 * https://sap.github.io/ui5-webcomponents/playground/components/TabContainer/
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
@Tag("ui5-tab")
@NpmPackage(value = "@ui5/webcomponents", version = "^2.1.1")
@JsModule("@ui5/webcomponents/dist/Tab.js")
public class Ui5Tab extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Tab.class);

	public Ui5Tab() {
		LOGGER.info("constructor ...");
	}

	public void setDesign(SemanticColor color) {
		this.getElement().setProperty("semanticColor", color.toString());
	}

	public enum SemanticColor { Default, Neutral, Positive, Critical, Negative }
	
	public void setText(String text) {
		this.getElement().setProperty("text", text);
	}

	public void setAdditionalText(String text) {
		this.getElement().setProperty("additionalText", text);
	}

	public void setIcon(String icon) {
		this.getElement().setProperty("icon", icon);
	}

	public void setDisabled(Boolean value) {
		this.getElement().setProperty("disabled", value);
	}

	public void setSelected(Boolean value) {
		this.getElement().setProperty("selected", value);
	}

}
