plugins {
    kotlin("jvm") version "1.8.21"
}

description = "Yggdrasil API - 接口定义"

dependencies {
    ext {
        set("jacksonVersion", "2.15.2")
        set("slf4jVersion", "2.0.9")
        set("logbackVersion", "1.4.11")
    }

    implementation("com.fasterxml.jackson.core:jackson-databind:${ext.get("jacksonVersion")}")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:${ext.get("jacksonVersion")}")
    implementation("org.slf4j:slf4j-api:${ext.get("slf4jVersion")}")

    testImplementation(kotlin("test"))
    testImplementation("ch.qos.logback:logback-classic:${ext.get("logbackVersion")}")
}

// tasks.test {
//     useJUnitPlatform()
// }