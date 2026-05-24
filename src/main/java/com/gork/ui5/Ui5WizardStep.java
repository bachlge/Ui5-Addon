/**
 * https://ui5.github.io/webcomponents/components/fiori/WizardStep/
 * 
 * Java implementation of SAP's UI5 WizardStep web component
 * 
 * javascript-event handled as described here:
 * https://www.youtube.com/watch?v=nkmN5H1e3FE 
 * (Tutorial video by Alejandro Duarte)
 * resp https://vaadin.com/docs/latest/flow/element-api/event-listener
 */
package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-wizard-step")
@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^2.22.0")
@JsModule("@ui5/webcomponents-fiori/dist/WizardStep.js")
public class Ui5WizardStep extends Component implements HasComponents, HasStyle {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5WizardStep.class);

	public Ui5WizardStep() {
		LOGGER.info("constructor ...");
		setBranching(true); // see recommendation of this method
	}

	/**
	 * When branching is enabled a dashed line would be displayed after the step, meant to indicate that the next step
	 * is not yet known and depends on user choice in the current step.
	 * Note: It is recommended to use branching on the last known step and later add new steps when it becomes clear
	 * how the wizard flow should continue.
	 */
	public void setBranching(Boolean value) {
		this.getElement().setProperty("branching", value);
	}

	public void setDisabled(Boolean value) {
		this.getElement().setProperty("disabled", value);
	}

	public void setIcon(String icon) {
		this.getElement().setProperty("icon", icon);
	}

	public void setSelected(Boolean value) {
		this.getElement().setProperty("selected", value);
	}

	public void setTitleText(String title) {
		this.getElement().setProperty("titleText", title);
	}

	public void setSubtitleText(String title) {
		this.getElement().setProperty("subtitleText", title);
	}

}
