package seminars.fourth.hotel;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class BookingServiceTest {
    @Test
    void testBookingServiceAvailable() {
        int room = 2;
        HotelService hService = mock(HotelService.class);
        BookingService bookingService = new BookingService(hService);

        when(hService.isRoomAvailable(room)).thenReturn(true);

        boolean result = bookingService.bookRoom(room);
        verify(hService, times(1)).isRoomAvailable(room);
        assertTrue(result);

    }
}