# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## What this repo is

**LYF Journal** — a native Android app (Kotlin) by Keyonna Monroe. The README is
still a `TODO` stub; the app is in an early skeleton state. Most classes are
placeholders, so most tasks here involve building out functionality rather than
modifying mature code.

## Module structure

Two-module Gradle project (`settings.gradle`):

- **`:app`** — the Android application (`applicationId
  com.keyonnamonroe.lyfjournal.android`). Entry point declared in the manifest is
  `.activity.MainActivity` (launcher); `LyfJournalApplication` is the custom
  `Application`. `BaseActivity` and `SplashActivity` exist but are currently **empty
  stub classes** (no Android superclass yet). `MainActivity` just inflates
  `activity_main.xml`.
- **`:lyf-framework-android`** — a reusable Android **library** module
  (`com.android.library`) holding shared infrastructure. This is where cross-cutting
  utilities live and the intended home for YouTube/networking code (it already pulls
  in `google-api-services-youtube`, `gson`, `okhttp`, and coroutines).

The framework's job is logging and constants today:
- `Logger` — wraps `android.util.Log` (`e/d/i/v/w` + `printOnConsole`). **Every call
  is gated by `Constants.DEBUG`**, so logs only emit in debug builds.
- `Constants.DEBUG` is wired to `BuildConfig.DEBUG_MODE`, a `buildConfigField` set per
  build type in the library's `build.gradle` (`true` in `debug`, `false` in
  `release`). When adding logging, route it through `Logger`, not `Log` directly.

## Build & test

Uses the Gradle wrapper (`./gradlew`). No `local.properties`/SDK is checked in, so a
configured Android SDK is required.

```bash
./gradlew assembleDebug                 # build the app (debug APK)
./gradlew :lyf-framework-android:assembleDebug
./gradlew build                         # build + lint + unit tests, all modules
./gradlew test                          # JVM unit tests, all modules
./gradlew :app:testDebugUnitTest        # unit tests for one module/variant
./gradlew connectedAndroidTest          # instrumented tests (needs device/emulator)
./gradlew clean
```

Run a single unit test class/method:

```bash
./gradlew :app:testDebugUnitTest --tests "com.keyonnamonroe.lyfjournal.android.ExampleUnitTest"
./gradlew :lyf-framework-android:testDebugUnitTest --tests "*.ExampleUnitTest.addition_isCorrect"
```

## Toolchain notes / gotchas

- **Legacy, slightly inconsistent toolchain.** Root `build.gradle` sets
  `kotlin_version = "1.4.31"` but applies the Kotlin Gradle plugin `1.6.10`; AGP is
  `7.1.2`. `:app` targets `compileSdk 30` while `:lyf-framework-android` targets `31`
  (both `minSdk 21`, Java 8). Repositories still include the deprecated **`jcenter()`**.
  Keep changes consistent with these versions unless a deliberate upgrade is intended.
- **Hardcoded secret:** `MainActivity.kt` contains a Google/YouTube API key in a
  comment. Treat it as a leaked credential — do not propagate it; prefer moving any
  real key out of source (e.g. `local.properties` / `BuildConfig`) if you wire up the
  YouTube integration.
- Some coroutine deps use the `-native-mt` variant and explicitly `exclude` the
  `kotlinx-coroutines-core-jvm` module — preserve those exclusions when editing
  `:lyf-framework-android` dependencies.

## Git

Default/primary branch is `master`. Match the existing package layout
(`com.keyonnamonroe.lyfjournal.android` for app code,
`com.keyonnamonroe.lyfjournal.framework.android` for shared code) when adding files.
