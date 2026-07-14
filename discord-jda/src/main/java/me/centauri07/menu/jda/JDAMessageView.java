package me.centauri07.menu.jda;

import me.centauri07.menu.engine.core.Menu;
import me.centauri07.menu.engine.core.Option;
import me.centauri07.menu.engine.view.MenuView;
import me.centauri07.menu.jda.util.BlockingMap;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class JDAMessageView extends ListenerAdapter implements MenuView<JDAContext> {
    private final BlockingMap<String, String> selectionTrigger = new BlockingMap<>();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        selectionTrigger.put(toKey(event.getChannel(), event.getAuthor()), event.getMessage().getContentRaw());
    }

    @Override
    public void renderMenu(JDAContext context, Menu menu) {
        EmbedBuilder builder = new EmbedBuilder()
                .setColor(Color.GREEN)
                .setTitle(menu.getName())
                .setDescription(menu.getDescription());

        builder.addField(new MessageEmbed.Field("[0] Back", "Go to previous menu", false));

        for (int i = 0; i < menu.getOptions().length; i++) {
            Option option = menu.getOptions()[i];

            builder.addField(new MessageEmbed.Field("[" + (i + 1) + "] " + option.getName(), option.getDescription(), false));
        }

        context.getChannel().sendMessageEmbeds(builder.build()).queue();
    }

    @Override
    public Option selectOption(JDAContext context, Menu menu) {
        int selection;

        do {
            try {
                selection = Integer.parseInt(selectionTrigger.take(toKey(context.getChannel(), context.getUser())));
            } catch (NumberFormatException e) {
                selection = -1;
            }
        } while (selection < 0 || selection > menu.getOptions().length);

        if (selection == 0) return null;

        return menu.getOptions()[selection - 1];
    }

    private String toKey(MessageChannel channel, User user) {
        return "c_id:" + channel.getId() + "-" + "u_id" + user.getId();
    }
}
