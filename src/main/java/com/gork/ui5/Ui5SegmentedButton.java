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
@Tag("ui5-segmentedbutton")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.0.0-rc.9")
@JsModule("@ui5/webcomponents/dist/SegmentedButton.js")
public class Ui5SegmentedButton extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5SegmentedButton.class);

	public Ui5SegmentedButton() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

}
