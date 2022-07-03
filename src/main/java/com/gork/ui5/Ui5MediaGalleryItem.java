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
@Tag("ui5-media-gallery-item")
@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^1.4.0")
@JsModule("@ui5/webcomponents-fiori/dist/MediaGalleryItem.js")
public class Ui5MediaGalleryItem extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5MediaGalleryItem.class);

	public Ui5MediaGalleryItem() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}


	public void setDisabled(Boolean value) {
		this.getElement().setProperty("disabled", value);
	}

	public void setLayout(MediaGalleryItemLayout layout) {
		this.getElement().setProperty("layout", layout.toString());
	}

	public enum MediaGalleryItemLayout { Square, Wide }

	public void setSelected(Boolean value) {
		this.getElement().setProperty("selected", value);
	}

}
