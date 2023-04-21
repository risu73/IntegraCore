package dev.integra.command;

import dev.integra.api.command.CommandInfo;
import dev.integra.api.command.CommandResult;
import org.bukkit.command.CommandSender;

import java.util.Map;

public class TestCommand extends IntegraCommand {

    public TestCommand() {
        super("test");
    }

    @Override
    protected String getMessage(CommandResult result) {
        switch (result) {
            case SUCCESS:
                return "Success!";
            case NO_PERMISSION:
                return "No permission!";
            case INVALID_SENDER:
                return "Invalid sender!";
            case ERROR:
                return "Error!";
            case NOT_FOUND:
            default:
                return "Not found!";
        }
    }

    @CommandInfo(
            name = "",
            description = "Test command",
            usage = "/test"
    )
    public void defaultCommand(CommandSender sender, Map<String, String> args) {
        sender.sendMessage("Test command!");
    }

    @CommandInfo(
            name = "subcmd",
            description = "Test command",
            usage = "/test subcmd",
            argumentInfo = {
                    "arg1", "arg2", "arg3"
            },
            playerOnly = true
    )
    public void subCmd(CommandSender sender, Map<String, String> args) {
        sender.sendMessage("Test command! Args: " + args.get("arg1") + ", " + args.get("arg2") + ", " + args.get("arg3"));
    }
}
