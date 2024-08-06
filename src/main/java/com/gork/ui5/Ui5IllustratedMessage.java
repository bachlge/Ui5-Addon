/**
 * https://sap.github.io/ui5-webcomponents/playground/components/IllustratedMessage/
 */
package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-illustrated-message")
@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^2.1.1")
@JsModule("@ui5/webcomponents-fiori/dist/IllustratedMessage.js")
@JsModule("@ui5/webcomponents-icons/dist/Allicons.js")
@JsModule("@ui5/webcomponents-fiori/dist/illustrations/BeforeSearch.js")
@JsModule("@ui5/webcomponents-fiori/dist/illustrations/NoData.js")
@JsModule("@ui5/webcomponents-fiori/dist/illustrations/UnableToUpload.js")
@JsModule("@ui5/webcomponents-fiori/dist/illustrations/tnt/Lock.js") // TntLock
@JsModule("@ui5/webcomponents-fiori/dist/illustrations/tnt/Success.js") // TntSuccess
public class Ui5IllustratedMessage extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5IllustratedMessage.class);

	public Ui5IllustratedMessage() {
		LOGGER.info("constructor ...");
	}

	/**
	 * Default: BeforeSearch
	 * @param name
	 */
	public void setName(IllustrationMessageType name) {
		this.getElement().setProperty("name", name.toString());
	}

	public void setAccessibleNameRef(String name) {
		this.getElement().setProperty("accessibleNameRef", name);
	}

	public void setTitle(String title) {
		this.getElement().setProperty("titleText", title);
	}

	public void setSubTitle(String title) {
		this.getElement().setProperty("subtitleText", title);
	}

	public void setSize(IllustrationMessageSize size) {
		this.getElement().setProperty("size", size.toString());
	}


	public enum IllustrationMessageType {
/* pre 1.14 list:
		BeforeSearch,
		NoActivities,
		NoData,
		NoEntries,
		NoMail,
		NoNotifications,
		NoSavedItems,
		NoSearchResults,
		NoTasks,
		UnableToLoad,
		UnableToUpload,
*/
		AddColumn,
		AddPeople,
		AddDimensions,
		BalloonSky,
		BeforeSearch,
		Connection,
		EmptyCalendar,
		EmptyList,
		EmptyPlanningCalendar,
		ErrorScreen,
		FilterTable,
		GroupTable,
		NoActivities,
		NoColumnsSet,
		NoData,
		NoEntries,
		NoFilterResults,
		NoMail_v1,
		NoMail,
		NoNotifications,
		NoSavedItems_v1,
		NoSavedItems,
		NoSearchResults,
		NoTasks_v1,
		NoTasks,
		NoDimensionsSet,
		PageNotFound,
		ReloadScreen,
		ResizeColumn,
		SearchEarth,
		SearchFolder,
		SimpleBalloon,
		SimpleBell,
		SimpleCalendar,
		SimpleCheckMark,
		SimpleConnection,
		SimpleEmptyDoc,
		SimpleEmptyList,
		SimpleError,
		SimpleMagnifier,
		SimpleMail,
		SimpleNoSavedItems,
		SimpleNotFoundMagnifier,
		SimpleReload,
		SimpleTask,
		SleepingBell,
		SortColumn,
		SuccessBalloon,
		SuccessCheckMark,
		SuccessHighFive,
		SuccessScreen,
		Survey,
		Tent,
		UnableToLoad,
		UnableToLoadImage,
		UnableToUpload,
		UploadToCloud,
		UploadCollection,
		TntChartArea,
		TntChartArea2,
		TntChartBar,
		TntChartBPMNFlow,
		TntChartBullet,
		TntChartDoughnut,
		TntChartFlow,
		TntChartGantt,
		TntChartOrg,
		TntChartPie,
		TntCodePlaceholder,
		TntCompany,
		TntComponents,
		TntExternalLink,
		TntFaceID,
		TntFingerprint,
		TntLock,
		TntMission,
		TntNoApplications,
		TntNoFlows,
		TntNoUsers,
		TntRadar,
		TntSecrets,
		TntServices,
		TntSessionExpired,
		TntSessionExpiring,
		TntSuccess,
		TntSuccessfulAuth,
		TntSystems,
		TntTeams,
		TntTools,
		TntUnableToLoad,
		TntUnlock,
		TntUnsuccessfulAuth,
		TntUser2,
	}

	public enum IllustrationMessageSize {
		Auto,
		Base,
		Dot,
		Spot,
		Dialog,
		Scene,
	}

}
