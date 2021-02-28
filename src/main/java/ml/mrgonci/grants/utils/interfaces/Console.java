package ml.mrgonci.grants.utils.interfaces;

import java.util.HashSet;
import java.util.List;

public class Console implements Grant {
    public final void Message(String message) {
        plugin.getServer().getConsoleSender().sendMessage(StringUtils.toColor(message));
    }
    public final void Message(List<String> message) {
        for (String str : message) {
            Message(str);
        }
    }
    public final void Message(HashSet<String> messages) {
        for (String str : messages) {
            Message(str);
        }
    }
}
