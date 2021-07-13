

val kotlinSerializationVersion: String by project

plugins {
	id ("org.jmailen.kotlinter") version "3.4.5"
	kotlin("jvm") version "1.5.20"
	kotlin("plugin.serialization") version "1.5.20"
}

allprojects {
	repositories {
		mavenCentral()
	}
}

subprojects {

	apply {
		plugin("org.jetbrains.kotlin.jvm")
		plugin ("org.jmailen.kotlinter")
		plugin ("org.jetbrains.kotlin.plugin.serialization")
	}

	java.sourceCompatibility = JavaVersion.VERSION_1_8

	dependencies {
		implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
		implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinSerializationVersion")
	}
}

dependencies {
	implementation(project(":greeting-app"))
	implementation(project(":greeting-model"))
}