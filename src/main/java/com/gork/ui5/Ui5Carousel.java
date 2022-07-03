/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Carousel/
 */
package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.notification.Notification;

@SuppressWarnings("serial")
@Tag("ui5-carousel")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.4.0")
@NpmPackage(value = "@ui5/webcomponents-icons", version = "^1.4.0")
@JsModule("@ui5/webcomponents/dist/Carousel.js")
public class Ui5Carousel extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Carousel.class);

	public Ui5Carousel() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	// default: Content
	public void setArrowsPlacement(CarouselArrowsPlacement arrowsPlacement) {
		this.getElement().setProperty("arrowsPlacement", arrowsPlacement.toString());
	}

	public enum CarouselArrowsPlacement { Content, Navigation }

	// default: false
	public void setCyclic(Boolean cyclic) {
		this.getElement().setProperty("cyclic", cyclic);
	}

	// default: false
	public void setHideNavigationArrows(Boolean hideNavigationArrows) {
		this.getElement().setProperty("hideNavigationArrows", hideNavigationArrows);
	}

	// default: false
	public void setHidePageIndicator(Boolean hidePageIndicator) {
		this.getElement().setProperty("hidePageIndicator", hidePageIndicator);
	}

	// default: 1
	public void setItemsPerPageL(String value) {
		this.getElement().setProperty("itemsPerPageL", value);
	}

	// default: 1
	public void setItemsPerPageM(String value) {
		this.getElement().setProperty("itemsPerPageM", value);
	}

	// default: 1
	public void setItemsPerPageS(String value) {
		this.getElement().setProperty("temsPerPageS", value);
	}

	public void navigateTo(Integer itemIndex) {
		this.getElement().setProperty("itemIndex", itemIndex);
	}

	@DomEvent("navigate")
	public static class NavigateToEvent extends ComponentEvent<Ui5Carousel> {

		public NavigateToEvent(Ui5Carousel source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("NavigateToEventEvent ...");
			Notification.show("Navigated To " + source.getElement().getProperty("itemIndex"));
		}
		
	}



}
