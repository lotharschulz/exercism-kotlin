import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
   id("org.jetbrains.kotlin.jvm") version "1.5.21"
}

repositories {
   mavenCentral()
}

dependencies {
   implementation(kotlin("stdlib"))
   testImplementation("junit:junit:4.12")
   testImplementation(kotlin("test-junit"))
}

tasks.withType<Test> {
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events("passed", "failed", "skipped")
    }
}
