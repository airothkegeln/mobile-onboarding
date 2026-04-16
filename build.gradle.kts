plugins {
    kotlin("jvm") version "1.9.22"
}
group = "com.zenply.onboarding"
version = "1.0.0"
repositories { mavenCentral() }
dependencies {
    testImplementation("junit:junit:4.13.2")
    testImplementation("io.mockk:mockk:1.13.9")
}
tasks.test {
    useJUnit()
    testLogging {
        events("passed", "failed", "skipped")
        showStandardStreams = true
    }
}
