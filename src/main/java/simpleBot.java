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
        if(command.contains("GeoPay Georgia payout")) {
            message = "Geo pay georgia payout";
            response.setChatId(update.getMessage().getChatId().toString());
            response.setText(message);
            try {
                execute(response);
            } catch (TelegramApiException t) {
                t.printStackTrace();
            }
        }else if(command.contains("GeoPay Georgia deposit")) {
            message = "Geo pay georgia deposit";
            response.setChatId(update.getMessage().getChatId().toString());
            response.setText(message);
            try {
                execute(response);
            } catch (TelegramApiException t) {
                t.printStackTrace();
            }
        }else if(command.contains("iPay Georgia deposit")){
            message = "iPay Georgia deposit";
            response.setChatId(update.getMessage().getChatId().toString());
            response.setText(message);
            try {
                execute(response);
            } catch (TelegramApiException t) {
                t.printStackTrace();
            }
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
