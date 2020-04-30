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
@Tag("ui5-wheelslider-item")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.0.0-rc.7")
@JsModule("@ui5/webcomponents/dist/WheelSlider.js")  // <== TODO: change as soon as available
public class Ui5WheelSliderItem extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5WheelSliderItem.class);

	public Ui5WheelSliderItem() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

}
