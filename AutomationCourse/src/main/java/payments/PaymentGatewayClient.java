package payments;

public interface PaymentGatewayClient {
    PaymentResponse charge(String userId, double amount);
}

