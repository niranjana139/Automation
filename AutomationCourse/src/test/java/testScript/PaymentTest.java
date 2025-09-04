package testScript;
import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import payments.PaymentGatewayClient;
import payments.PaymentResponse;
import payments.PaymentService;

public class PaymentTest {

    private PaymentGatewayClient mockGateway;
    private PaymentService paymentService;

    @BeforeMethod
    public void setup() {
        mockGateway = mock(PaymentGatewayClient.class);
        paymentService = new PaymentService(mockGateway);
    }

    @Test
    public void testSuccessfulPayment() {
        // Arrange
        PaymentResponse mockResponse = new PaymentResponse(true);
        
        //PaymentGatewayclient is used to mock in test class.Below given code is used to replace real API call
        //ie, When the charge method is called on the mocked mockGateway with the arguments "user123" and 100.0, return the mockResponse we created
        
        when(mockGateway.charge("user123", 100.0)).thenReturn(mockResponse);

        // Act
        //When makePayment is invoked , charge() is invoked internally.  Instead of the one in real time API, mocked one is invoked.
        boolean result = paymentService.makePayment("user123", 100.0);
        

        // Assert
        assertTrue(result);
        //Verify confirms that the mocked method charge(...) was actually called with the expected arguments.
        verify(mockGateway).charge("user123", 100.0);
    }

    @Test
    public void testFailedPayment() {
        // Arrange
        PaymentResponse mockResponse = new PaymentResponse(false);
        when(mockGateway.charge("user123", 100.0)).thenReturn(mockResponse);

        // Act
        boolean result = paymentService.makePayment("user123", 100.0);

        // Assert
        assertFalse(result);
    }
}
