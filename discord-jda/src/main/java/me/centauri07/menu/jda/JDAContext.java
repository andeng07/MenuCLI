package me.centauri07.menu.jda;

import me.centauri07.menu.engine.core.Context;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

public class JDAContext implements Context {
    private final User user;
    private final MessageChannel channel;

    public JDAContext(User user, MessageChannel channel) {
        this.user = user;
        this.channel = channel;
    }

    public User getUser() {
        return user;
    }

    public MessageChannel getChannel() {
        return channel;
    }
}
