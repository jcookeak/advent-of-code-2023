plugins {
    kotlin("jvm") version "1.9.21"
    id("com.diffplug.spotless") version "6.23.3"
}

dependencies {
    testImplementation(libs.bundles.kotest)
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

configure<com.diffplug.gradle.spotless.SpotlessExtension> {
    kotlin {
        ktlint()
    }
    kotlinGradle {
        ktlint()
    }
}
