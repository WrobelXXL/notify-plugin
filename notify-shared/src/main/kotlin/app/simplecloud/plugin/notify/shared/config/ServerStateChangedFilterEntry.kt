package app.simplecloud.plugin.notify.shared.config

import build.buf.gen.simplecloud.controller.v1.ServerState
import org.spongepowered.configurate.objectmapping.ConfigSerializable
import org.spongepowered.configurate.objectmapping.meta.Comment

@ConfigSerializable
data class ServerStateChangedFilterEntry(

    @Comment("The server state to filter for.")
    val serverState: ServerState,

    @Comment("The message to send when the server state changes. MiniMessage is supported so you can add click and hover actions to the text.")
    val message: String,

    @Comment("The permission players need to receive the message. Choose empty string for no permission.")
    val permission: String = "notify.receive.state-changed.${serverState.name.lowercase()}"
)