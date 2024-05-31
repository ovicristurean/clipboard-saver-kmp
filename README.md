Tiny KMP library that saves a text to the clipboard, with targets for Android and iOS. This repository has the purpose of showcasing the process of creating a library, uploading it to MavenCentral and automating the release process of new library versions using GitHubActions.

Usage in a sample KMP application:

settings.gradle:
```
dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}
```

libs.versions.toml:
```
[versions]
clipboard-saver = "1.0.0"

[libraries]
clipboard-saver = { module = "io.github.ovicristurean:clipboard-saver", version.ref = "clipboard-saver" }
```

build.gradle.kts common module:
```
commonMain.dependencies {
    implementation(libs.clipboard.saver)
}
```

Depending on the type of DI that you use in your project, you need to provide the `ClipboardSaver` implementations for Android and iOS. In case you do not use a DI framework,
you could provide your `ClipboardSaver` instance as such:
Common source set:
```
expect class ClipboardSaverProvider {
    fun provideClipboardSaver(): ClipboardSaver
}
```

For Android:
```
actual class ClipboardSaverProvider(
    private val context: Context
) {
    actual fun provideClipboardSaver(): ClipboardSaver {
        return ClipboardSaver(context)
    }
}
```

For iOS:
```
actual class ClipboardSaverProvider {
    actual fun provideClipboardSaver(): ClipboardSaver {
        return ClipboardSaver()
    }
}
```

Sample app:

https://github.com/ovicristurean/clipboard-saver-kmp/assets/44752306/a6fb68b2-1347-4628-9baf-32752012d8b3


