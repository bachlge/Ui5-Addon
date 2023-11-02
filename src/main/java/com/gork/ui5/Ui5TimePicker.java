package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-timepicker")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.19.0")
@JsModule("@ui5/webcomponents/dist/TimePicker.js")
@JsModule("@ui5/webcomponents/dist/features/InputElementsFormSupport.js")
public class Ui5TimePicker extends Component {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5TimePicker.class);

	public Ui5TimePicker() {
		LOGGER.info("constructor ...");
	}

	public void setPlaceholder(String placeholder) {
		this.getElement().setProperty("placeholder", placeholder);
	}


}
