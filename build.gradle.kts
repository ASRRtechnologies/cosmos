import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

repositories {
    maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
}

plugins {
    kotlin("jvm") version "1.4.21-2"
    kotlin("plugin.spring") version "1.4.21-2"
    id("org.springframework.boot") version "2.4.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("com.github.johnrengelman.processes") version "0.5.0"
    id("org.springdoc.openapi-gradle-plugin") version "1.3.0"
    id("com.diffplug.spotless") version "5.12.4"
    jacoco
}

group = "nl.asrr.cosmos"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/snapshot") }
    jcenter()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springdoc:springdoc-openapi-ui:1.2.33")
    implementation("org.projectlombok:lombok:1.18.16")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("com.ninja-squad:springmockk:1.1.3")
}

// spotless { // if you are using build.gradle.kts, instead of 'spotless {' use:
configure<com.diffplug.gradle.spotless.SpotlessExtension> {
    kotlin {
        ktlint("0.40.0")
//        licenseHeader("/* (C) ASRR B.V. 2021 */'") // or licenseHeaderFile
    }
    kotlinGradle {
        target("*.gradle.kts") // default target for kotlinGradle
        ktlint() // or ktfmt() or prettier()
    }
}

tasks.jacocoTestReport {
    reports {
        xml.isEnabled = true
        xml.destination = file("$buildDir/reports/jacoco/report.xml")
    }
}

openApi {
    outputDir.set(file("$buildDir/docs"))
    outputFileName.set("swagger.json")
    waitTimeInSeconds.set(10)
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    finalizedBy(tasks.jacocoTestReport)
    useJUnitPlatform()
}
