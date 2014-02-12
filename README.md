Android TDD Example with Gradle
===

This project is a bare-bones example of how to structure an Android project in order to practice
TDD using Robolectric and a Gradle build.

Contents
---

<table>
<tr>
    <td>app/</td>
    <td>a bare-bones Android app</td>
</tr>
<tr>
    <td>unitTest/</td>
    <td>the unit tests that utilize Robolectric</td>
</tr>
</table>

The app module was generated with Android Studio 0.4.4. It only differs from the default settings
by selecting SDK versions to support only the Android 4.x releases.

The unitTest module was created to make it possible to execute the tests with either the
gradle `test` task or the Android Studio JUnit runner. See the README in that module for more
details.
