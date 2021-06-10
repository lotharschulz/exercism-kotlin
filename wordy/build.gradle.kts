import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    kotlin("jvm") version "1.4.31"
}

repositories {
    jcenter()
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