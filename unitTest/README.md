Unit Tests
===

The Android gradle plugin (as of version 0.8) only directly supports [Android Instrumention Testing
framework](http://developer.android.com/tools/testing/testing_android.html#Instrumentation). Tests
build with this framework can only be run on a device or emulator, which is too slow for effective
TDD. Further complicating TDD and unit testing are bugs in the Dalvik VM which make it impossible
to mock Android framework classes with Mockito. This makes it more difficult to test components in
isolation and exert control over the execution environment for a unit test. The Android test
framework also only supports JUnit 3.8.

Robolectic makes it possible to execute unit tests in a stand-alone JVM. This is much faster than
running unit tests on a device or emulator. Unfortunately, the way in which the Android gradle
plugin models an Android project is not directly interoperable with the gradle Java plugin and Test
task, which one would ordinarily use to compile and run unit tests.

There are a variety of work-arounds for running Robolectric tests from within an Android app
module's gradle build, but the tradeoff is incomplete integration with Android Studio. The
inherent compromises significantly degrade TDD productivity.

To overcome the interoperability problems, the unit tests are placed in their own module. This
module uses the gradle Java plugin, which makes it possible to put the test code in the `src/test`
subtree, where the Test task and Android Studio will find it by convention.

The `build.gradle` file demonstrates the tricky/dirty work of expressing the dependencies
that the unit tests have on the app code and the Android SDK in a way that makes it possible to
both run the tests from the shell and allows Android Studio to resolve the dependencies so that
one can use the IDE completion, navigation, code inspection, JUnit runner, and debugger while
developing unit tests.

Android Studio JUnit Test Execution
----

In order to execute JUnit tests directly from Android Studio, I found it necessary to run the IDE
with JDK 7 and configure the Project's Android SDK to use JDK 7.

To run Android Studio on the Mac with JDK 7:

1. install the Oracle JDK 7
1. edit `/Applications/Android Studio.app/Contents/Info.plist` to change the JDK version

To change the Android Studio Project SDK:

1. Open the Module Settings
1. Click on Android SDK and enter the path the JDK 7 home (on the Mac it will probably be
`/Library/Java/JavaVirtualMachines/<version>/Contents/Home`

To configure the JUnit runner:

1. create a new Gradle task to execute the testClasses task
1. create a new JUnit task
1. set the working directory `src/main` in the app module
1. set the classpath to the unitTest module
1. under Before Launch, add an entry to execute the Gradle testClasses task created in the first step

Caveats:

* If you get a Class Not Found exception on one of the test classes, or a test run does not reflect
the recent code changes, manually invoke the testClasses task