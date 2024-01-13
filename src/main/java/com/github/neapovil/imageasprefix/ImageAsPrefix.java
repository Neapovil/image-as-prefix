package com.github.neapovil.imageasprefix;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;

public final class ImageAsPrefix extends JavaPlugin implements Listener
{
    private static ImageAsPrefix instance;

    @Override
    public void onEnable()
    {
        instance = this;

        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable()
    {
    }

    public static ImageAsPrefix instance()
    {
        return instance;
    }

    @EventHandler
    private void asyncChat(AsyncChatEvent event)
    {
        event.renderer(new ChatRenderer());
    }

    final class ChatRenderer implements io.papermc.paper.chat.ChatRenderer
    {
        @Override
        public @NotNull Component render(@NotNull Player source, @NotNull Component sourceDisplayName, @NotNull Component message, @NotNull Audience viewer)
        {
            return Component.text(source.isOp() ? "\ue238 " : "\ue239 ")
                    .append(sourceDisplayName)
                    .append(Component.text(" >> "))
                    .append(message);
        }
    }
}
