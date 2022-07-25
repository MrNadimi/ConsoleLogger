##### Easy and lightweigh java console logger

#### Implemention

Include lines inside  **build.gradle**:


```` 
repositories {
      ...
      maven { url "https://www.jitpack.io" }
}
````
<br/>

```` 
dependencies {
      ...
      implementation 'com.github.MrNadimi:ConsoleLogger:1.0.2'
}
````

#### How to use?
Just create a log object

````Java
private static final Log LOG = Log.getLogger(MainClass.class);

````

Now log with your own level

````Java
LOG.debug("Hi java Console Logger" );
LOG.warn("Hi java Console Logger" );
LOG.error("Hi java Console Logger" );
LOG.trace("Hi java Console Logger" );
LOG.info("Hi java Console Logger" );

````

By default the log String is not colored

![alt text](https://github.com/MrNadimi/ConsoleLogger/blob/master/ScreenShots/ScreenshotNoColor.png)

When you want to log with ansi colors, just add this line on Log class

````Java
//add setWithAnsi(true)
private static final Log LOG = Log.getLogger(MainClass.class).setWithAnsi(true);

````

![alt text](https://github.com/MrNadimi/ConsoleLogger/blob/master/ScreenShots/ScreenshotColored.png)

#### Pay attention

* You cant change the log pattern
* This project cant save logs in file
* This project is very light and just for console printing

#### Thanks
This lib using [JColor](https://github.com/dialex/JColor) for print Ansi colores on console

