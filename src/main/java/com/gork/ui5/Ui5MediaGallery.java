package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-media-gallery")
@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^1.14.0")
@JsModule("@ui5/webcomponents-fiori/dist/MediaGallery.js")
public class Ui5MediaGallery extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5MediaGallery.class);

	public Ui5MediaGallery() {
		LOGGER.info("constructor ...");
		this.getElement().setProperty("slot", "default");
	}

	/**
	 * if enbled, a display-area-click event is fired when the user clicks on the display area
	 * default: false
	 * @param value
	 */
	public void setInteractiveDisplayData(Boolean value) {
		this.getElement().setProperty("interactiveDisplayData", value);
	}

	public void setLayout(MediaGalleryLayout layout) {
		this.getElement().setProperty("layout", layout.toString());
	}

	public enum MediaGalleryLayout { Auto, Vertical, Horizontal }

	public void setMenuHorizontalAlign(MediaGalleryMenuHorizontalAlign layout) {
		this.getElement().setProperty("menuHorizontalAlign", layout.toString());
	}

	public enum MediaGalleryMenuHorizontalAlign { Left, Right }

	public void setMenuVerticalAlign(MediaGalleryMenuVerticalAlign layout) {
		this.getElement().setProperty("menuHorizontalAlign", layout.toString());
	}

	public enum MediaGalleryMenuVerticalAlign { Top, Bottom }

	public void setShowAllThumbnails(Boolean value) {
		this.getElement().setProperty("showAllThumbnails", value);
	}

}
