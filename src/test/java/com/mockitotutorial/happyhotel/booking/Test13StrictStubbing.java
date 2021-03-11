package com.mockitotutorial.happyhotel.booking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
public class Test13StrictStubbing {

    @InjectMocks
    private BookingService bookingService;

    @Mock
    private PaymentService paymentServiceMock;

    @Mock
    private RoomService roomServiceMock;

    @Spy
    private BookingDAO bookingDAOMock;

    @Mock
    private MailSender mailSenderMock;

    @Captor
    private ArgumentCaptor<Double> doubleCaptor;


    @Test
    void should_Invoke_Payment_When_Prepaid() {
        // given
        BookingRequest bookingRequest = new BookingRequest("2", LocalDate.of(2020, 1, 1),
                LocalDate.of(2020, 1, 5), 2, false);
        lenient().when(paymentServiceMock.pay(any(), anyDouble())).thenReturn("1");

        // when
        bookingService.makeBooking(bookingRequest);

        // then
        // no exceptions is thrown

    }

}
