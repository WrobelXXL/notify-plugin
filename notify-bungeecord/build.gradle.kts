dependencies {
    api(project(":notify-shared"))
    compileOnly(libs.bungeecord)
    implementation("net.kyori:adventure-platform-bungeecord:4.3.4")
}