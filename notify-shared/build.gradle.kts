dependencies {
    compileOnly(libs.simplecloud.controller)
    compileOnly("app.simplecloud.droplet.api:droplet-api:0.0.1-dev.66efe83")

    api("org.spongepowered:configurate-yaml:4.0.0")
    api("org.spongepowered:configurate-extra-kotlin:4.1.2") {
        exclude(group = "org.jetbrains.kotlin")
        exclude(group = "org.jetbrains.kotlinx")
    }

    compileOnly("net.kyori:adventure-api:4.17.0")
    compileOnly("net.kyori:adventure-text-minimessage:4.17.0")
}