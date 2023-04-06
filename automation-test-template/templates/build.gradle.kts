import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "{{kotlin_version}}"
}

group = "{{project_group}}"
version = "{{project_version}}"

repositories {
    mavenCentral()
}

dependencies {
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "{{jvm_target}}"
}