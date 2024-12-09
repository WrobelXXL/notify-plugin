# notify-plugin
An in-game plugin that notifies about v3 server changes.

### Features

- Notifies about server changes
- Configurable messages ([minimessage](https://docs.advntr.dev/minimessage/index.html) supported)
- Velocity & BungeeCord support

### Installation

1. Download the latest release for your proxy software (Velocity/BungeeCord)
2. Put the jar file in your `plugins` folder
3. Edit the configuration file at `plugins/notify-[velocity/bungeecord]/config.yml`
4. Start your server

### Configuration

Here you can see the configuration file for the plugin. All possible options are explained in the comments.
```yaml

# The date format pattern the notify plugin uses.
# For more information, see the official Java documentation: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/text/SimpleDateFormat.html
date-format: dd.MM.yyyy HH:mm:ss

# Filter server states to notify about.
server-state-filter:
    # server-state obviously sets the server state to filter for
-   server-state: STARTING
    # The message that is being sent to the permitted players goes here. 
    # Don't get irritated by the |- format, it's just a multiline string. You can also pass oneliners.
    # Possible placeholders you can use here are:
    # - <server_group>: The group name the server belongs to
    # - <server_id>: The numerical id of the server
    # - <server_uuid>: The UUID of the server
    # - <server_state>: The state of the server after the update
    # - <server_ip>: The IP that the server is running on
    # - <server_port>: The port that the server is bound to
    # - <online_players>: The amount of players currently online on the server
    # - <max_players>: The maximum amount of players that can join the server
    # - <server_update_date>: The date of the last update of the server
    # - <server_create_date>: The date of the initial update (creation) of the server
    message: |-
        <color:#38bdf8><bold>⚡</bold></color> <hover:show_text:'<color:#38bdf8><bold>⚡</bold></color> Information of <server_group> <server_id>
           <color:#a3a3a3>Timestamp:</color> <color:#38bdf8><server_update_date></color>
           <color:#a3a3a3>State:</color> <color:#38bdf8><server_state></color>
           <color:#a3a3a3>Server-IP:</color> <color:#38bdf8><server_ip></color>
           <color:#a3a3a3>Port:</color> <color:#38bdf8><server_port></color>
           <color:#a3a3a3>Players:</color> <color:#38bdf8><online_players>/<max_players></color>'><color:white>Server <server_group> <server_id></hover> updated its state to <color:#fbbf24><server_state></color>.
    # Users will need this permission to receive the message. Leave it empty (just '') to allow everyone to receive it.
    permission: notify.receive.state-changed.starting
    
    # You can add more server states to filter like this:
-   server-state: AVAILABLE
    # To design your own messages, we recommend using the minimessage web-ui: https://webui.advntr.dev/
    message: |-
        <color:#38bdf8><bold>⚡</bold></color> <hover:show_text:'<color:#38bdf8><bold>⚡</bold></color> Information of <server_group> <server_id>
           <color:#a3a3a3>Timestamp:</color> <color:#38bdf8><server_update_date></color>
           <color:#a3a3a3>State:</color> <color:#38bdf8><server_state></color>
           <color:#a3a3a3>Server-IP:</color> <color:#38bdf8><server_ip></color>
           <color:#a3a3a3>Port:</color> <color:#38bdf8><server_port></color>
           <color:#a3a3a3>Players:</color> <color:#38bdf8><online_players>/<max_players></color>'><color:white>Server <server_group> <server_id></hover> updated its state to <color:#fbbf24><server_state></color>.
    # The default permission is notify.receive.state-changed.[server-state]
    permission: notify.receive.state-changed.available
    
-   server-state: STOPPING
    message: |-
        <color:#38bdf8><bold>⚡</bold></color> <hover:show_text:'<color:#38bdf8><bold>⚡</bold></color> Information of <server_group> <server_id>
           <color:#a3a3a3>Timestamp:</color> <color:#38bdf8><server_update_date></color>
           <color:#a3a3a3>State:</color> <color:#38bdf8><server_state></color>
           <color:#a3a3a3>Server-IP:</color> <color:#38bdf8><server_ip></color>
           <color:#a3a3a3>Port:</color> <color:#38bdf8><server_port></color>
           <color:#a3a3a3>Players:</color> <color:#38bdf8><online_players>/<max_players></color>'><color:white>Server <server_group> <server_id></hover> updated its state to <color:#fbbf24><server_state></color>.
    # Here you can see that everyone will receive the message, as the permission is empty.
    permission: ''
```