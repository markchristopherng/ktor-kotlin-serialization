
plugins {
    id("application")
}

val ktorVersion: String by project
val koinVersion: String by project
val kotlinSerializationVersion: String by project
val logbackVersion: String by project

dependencies {
    implementation(project(":greeting-model"))

    implementation ("io.ktor:ktor-server-core:$ktorVersion")
    implementation ("io.ktor:ktor-server-netty:$ktorVersion")
    implementation ("io.ktor:ktor-serialization:$ktorVersion")
    implementation ("io.ktor:ktor-client-apache:$ktorVersion")
    implementation ("io.ktor:ktor-client-json:$ktorVersion")
    implementation ("io.ktor:ktor-client-serialization:$ktorVersion")
    implementation ("ch.qos.logback:logback-classic:$logbackVersion")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinSerializationVersion")
}