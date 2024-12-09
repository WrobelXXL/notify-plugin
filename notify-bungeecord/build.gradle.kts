dependencies {
    api(project(":notify-shared"))
    compileOnly(libs.bungeecord)
    implementation("net.kyori:adventure-platform-bungeecord:4.3.4")

    implementation("net.kyori:adventure-api:4.17.0")
    implementation("net.kyori:adventure-text-minimessage:4.17.0")
}