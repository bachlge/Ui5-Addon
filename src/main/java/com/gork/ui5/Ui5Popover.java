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
@Tag("ui5-popover")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.0.0-rc.6")
@JsModule("@ui5/webcomponents/dist/Popover.js")
public class Ui5Popover extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Popover.class);

	public Ui5Popover() {
		LOGGER.info("constructor ...");
		this.setModal(true); // modal by default
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setTitle(String title) {
		this.getElement().setProperty("headerText", title);
	}

	public void setHeaderText(String headerText) {
		this.getElement().setProperty("headerText", headerText);
	}

	public void setModal(Boolean modal) {
		this.getElement().setProperty("modal", modal);
	}

	public void setHorizontalAlign(HorizontalAlign align) {
		this.getElement().setProperty("horizontalAlign", align.toString());
	}

	public void setVerticalAlign(VerticalAlign align) {
		this.getElement().setProperty("verticalAlign", align.toString());
	}

	public void setPlacementType(PlacementType type) {
		this.getElement().setProperty("placementType", type.toString());
	}

	public enum HorizontalAlign { Center, Left, Right, Stretch }
	public enum VerticalAlign { Center, Left, Right, Stretch }
	public enum PlacementType { Top, Bottom, Left, Right }

}
