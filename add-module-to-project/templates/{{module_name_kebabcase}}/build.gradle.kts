plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":base-module"))
    implementation("io.rest-assured:kotlin-extensions:5.3.0")
    implementation("com.google.code.gson:gson:2.10")
    implementation(platform("org.junit:junit-bom:5.9.+"))
    implementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}