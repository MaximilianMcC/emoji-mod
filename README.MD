<!-- Shield badges things idk -->
![Minecraft Server Version](https://img.shields.io/badge/Minecraft%20Version-1.17.1-yellow?style=for-the-badge)

# Minecraft Emoji Plugin
This plugin allows you to use emojis in Minecraft.

## How it works
A custom font is used inside a texture pack to get the emojis. Each emoji is a custom unicode character with a custom texture. When you type the name of an emoji in the chat, for example `:flushed:` the plugin will replace it with the custom unicode character so it will become `😳`

## Commands
Below is a list of commands that are available in this plugin. Most of the time you won't need to use them, however they are here.
| Command Name  | Description                        |
| ------------- | ---------------------------------- |
| `/emoji`      | Plugin information and help        |
| `/emoji list` | List of all emojis and their names |

## TODO:
- [ ] Make the resource pack automatically generated
- [ ] Make a basic plugin
- [ ] `/emoji` command
- [ ] Make the list of emojis automatically generated
- [ ] `/emoji list` command
- [ ] Replace the chat text with emojis
- [ ] Add support for multiple Minecraft versions

## Future plans
I am thinking of converting this project from a server-side plugin, to a client-side Fabric mod. This would allow emojis to be used on any server, and any version. This is only an idea though.