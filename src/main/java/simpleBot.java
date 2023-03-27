import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class simpleBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        String command = update.getMessage().getText();
        String message;
        SendMessage response = new SendMessage();
        switch (command) {
            case "/run":
                message = "Running man, fuck off!";
                response.setChatId(update.getMessage().getChatId().toString());
                response.setText(message);
                try {
                    execute(response);
                } catch (TelegramApiException t) {
                    t.printStackTrace();
                }
                break;
            case "/help":
                message = "Go Kill yourself";
                response.setChatId(update.getMessage().getChatId().toString());
                response.setText(message);
                try {
                    execute(response);
                } catch (TelegramApiException t) {
                    t.printStackTrace();
                }
                break;
            case "/info":
                message = "Don't need my info!";
                response.setChatId(update.getMessage().getChatId().toString());
                response.setText(message);
                try {
                    execute(response);
                } catch (TelegramApiException t) {
                    t.printStackTrace();
                }
                break;
        }
    }
    @Override
    public String getBotUsername() {
        // TODO
        return "simpleTelegrBot";
    }

    @Override
    public String getBotToken() {
        // TODO
        return "6164660349:AAH3EdMD-B_14BMpFTe6P-mSUwzfViTrcTk";
    }
}
