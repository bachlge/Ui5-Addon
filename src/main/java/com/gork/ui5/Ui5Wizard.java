/**
 * https://ui5.github.io/webcomponents/components/fiori/Wizard/
 * 
 * Java implementation of SAP's UI5 Wizard web component
 * 
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
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.shared.Registration;

@SuppressWarnings("serial")
@Tag("ui5-wizard")
@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^2.22.0")
@JsModule("@ui5/webcomponents-fiori/dist/Wizard.js")
public class Ui5Wizard extends Component implements HasComponents, HasSize, HasStyle {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Wizard.class);

	public Ui5Wizard() {
		LOGGER.info("constructor ...");
	}

	public void setAccessibleName(String accessibleName) {
		this.getElement().setProperty("accessibleName", accessibleName);
	}

	/**
	 * Default: MultipleSteps
	 */
	public void setContentLayout(WizardContentLayout layout) {
		this.getElement().setProperty("contentLayout", layout.toString());
	}

	public enum WizardContentLayout { SingleStep, MultipleSteps }


	@DomEvent("step-change")
	public static class StepChangeEvent extends ComponentEvent<Ui5Wizard> {

		public StepChangeEvent(Ui5Wizard source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("Ui5Wizard StepChangeEvent ...");
		}
	}

	public Registration addClickListener(ComponentEventListener<StepChangeEvent> listener) {
		return addListener(StepChangeEvent.class, listener);
	}


}
