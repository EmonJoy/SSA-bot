import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class StartBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "ssa22Mybot";
    }

    @Override
    public String getBotToken() {
        return "7589118069:AAHZ881tjQzS0bBlB49I326rGx94CD21_cI";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String userMessage = update.getMessage().getText();
            String chatId = update.getMessage().getChatId().toString();
            String reply;
            String welcome_reply = "";

            boolean find = false;

            if(userMessage.equalsIgnoreCase("/start"))
            {
                reply = "Hello there, this bot is under testing..";
                find = true;
            } else {
                reply = "Working "+ userMessage;
                find = false;

            }


            SendMessage message = new SendMessage(chatId, reply);

            message.setText("Hello");


            if(!find) {
                System.out.println(chatId + "," + userMessage);
            }

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }




        public static void main(String[] args) {
            try {
                TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
                botsApi.registerBot(new StartBot());
                System.out.println("🤖 Bot is running...");
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }


