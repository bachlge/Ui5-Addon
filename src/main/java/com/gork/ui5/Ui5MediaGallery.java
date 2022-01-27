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
@Tag("ui5-media-gallery")
@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^1.1.2")
@JsModule("@ui5/webcomponents-fiori/dist/MediaGallery.js")
public class Ui5MediaGallery extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5MediaGallery.class);

	public Ui5MediaGallery() {
		LOGGER.info("constructor ...");
		this.getElement().setProperty("slot", "default");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public enum MediaGalleryLayout { Auto, Vertical, Horizontal }
	public enum MediaGalleryMenuHorizontalAlign { Left, Right }
	public enum MediaGalleryMenuVerticalAlign { Top, Bottom }

}
