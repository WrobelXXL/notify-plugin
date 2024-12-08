plugins {
    kotlin("kapt")
}

apply(plugin = "kotlin-kapt")

dependencies {
    api(project(":notify-shared"))
    implementation(libs.velocity)
    kapt("com.velocitypowered:velocity-api:3.4.0-SNAPSHOT")
}
