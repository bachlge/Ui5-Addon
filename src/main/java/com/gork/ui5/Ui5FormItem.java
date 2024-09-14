/**
 * https://sap.github.io/ui5-webcomponents/components/FormGroup/
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
@Tag("ui5-form-group")
@NpmPackage(value = "@ui5/webcomponents", version = "^2.1.1")
@JsModule("@ui5/webcomponents/dist/FormGroup.js")
public class Ui5FormItem extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5FormItem.class);

	public Ui5FormItem() {
		LOGGER.info("constructor ...");
	}

	public void setHeaderText(String headerText) {
		this.getElement().setProperty("headerText", headerText);
	}

	public void setColumnSpan(int columnSpan) {
		this.getElement().setProperty("columnSpan", columnSpan);
	}


}
