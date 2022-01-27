/**
 * https://sap.github.io/ui5-webcomponents/playground/components/IllustratedMessage/
 */
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
@Tag("ui5-illustrated-message")
@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^1.1.2")
@JsModule("@ui5/webcomponents-fiori/dist/IllustratedMessage.js")
@JsModule("@ui5/webcomponents-fiori/dist/illustrations/BeforeSearch.js")
@JsModule("@ui5/webcomponents-fiori/dist/illustrations/NoData.js")
@JsModule("@ui5/webcomponents-fiori/dist/illustrations/UnableToUpload.js")
public class Ui5IllustratedMessage extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5IllustratedMessage.class);

	public Ui5IllustratedMessage() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setName(IllustrationMessageType name) {
		this.getElement().setProperty("name", name.toString());
	}

	public void setTitle(String title) {
		this.getElement().setProperty("titleText", title);
	}

	public void setSubTitle(String title) {
		this.getElement().setProperty("subtitleText", title);
	}

	public enum IllustrationMessageType { BeforeSearch, NoActivities, NoData, NoEntries, NoMail,
		NoNotifications, NoSavedItems, NoSearchResults, NoTasks, UnableToLoad, UnableToUpload }

}
