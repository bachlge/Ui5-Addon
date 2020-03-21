# UI5 Vaadin-Addon

Java classes wrapping UI5 webcomonents
 
## Usage

add dependency in your `pom.xml`:

```
<dependency>
   <groupId>com.gork</groupId>
   <artifactId>ui5-addon</artifactId>
   <version>1.0-SNAPSHOT</version>
</dependency>
```

additionally add in the using application the dependencies like (don't know why this is necessary!)

```
cd /Users/georg/Develop/vaadin/flow/ui5-addon-demo
npm install @ui5/webcomponents
npm install @ui5/webcomponents-fiori
```

## Demo Application

see ui5-addin-demo how the components are used.


## Known bugs & limitations

- bug: Ui5BusyIndicator: does not show
- bug: Ui5Card: setIcon() should replace the default icon but adds instead
- bug: Ui5Badge: shold be possible to add icon/icon only
- general: no listeners yet implemented on buttons/menus 
- general: data binding not yet implemented 



