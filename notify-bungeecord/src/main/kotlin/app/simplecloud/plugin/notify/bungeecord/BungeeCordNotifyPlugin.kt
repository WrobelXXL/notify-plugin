package app.simplecloud.plugin.notify.bungeecord

import app.simplecloud.plugin.notify.shared.NotifyPlugin
import net.kyori.adventure.platform.bungeecord.BungeeAudiences
import net.md_5.bungee.api.plugin.Plugin

class BungeeCordNotifyPlugin : Plugin() {

    private val adventure = BungeeAudiences.create(this)

    private val notify = NotifyPlugin(
        dataFolder.toPath()
    )

    override fun onEnable() {
        notify.onFilterMatch { message, permission ->
            proxy.players.forEach { onlinePlayer ->
                if (permission.isEmpty() || onlinePlayer.hasPermission(permission)) adventure.player(onlinePlayer).sendMessage(message)
            }
        }
    }

    override fun onDisable() {
        adventure.close()
    }

}