package seminars.fourth.message;


import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

class NotificationServiceTest {
    @Test
    void testNotificationServiceSendNotification() {
        String message = "MSG";
        String recipient = "RCP";
        String mess = "Отправка сообщения \"" + message + "\" получателю " + recipient;
        MessageService mService = mock(MessageService.class);
        NotificationService notificationService = new NotificationService(mService);

        mService.sendMessage("Hello", "Vasia");

        verify(mService, times(1)).sendMessage("Hello", "Vasia");

    }

}