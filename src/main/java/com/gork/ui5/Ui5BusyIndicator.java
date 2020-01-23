package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

@SuppressWarnings("serial")
@Tag("ui5-busyindicator")
@JsModule("@ui5/webcomponents/dist/BusyIndicator.js")
public class Ui5BusyIndicator extends Component {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5BusyIndicator.class);

	public Ui5BusyIndicator() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setAcive(Boolean active) {
		this.getElement().setProperty("active", active);
	}

	public void setSize(BusyIndicatorSize size) {
		this.getElement().setProperty("size", size.name());
	}

	public enum BusyIndicatorSize {
		SMALL		( "Small" ),
		MEDIUM		( "Medium" ),
		LARGE		( "Large" );

		private String size;

		BusyIndicatorSize(String size) {
			this.size = size;
		}

		public String size() {
			return size;
		}

	}

}
