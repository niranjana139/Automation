package payments;

public class PaymentService {
	
	private PaymentGatewayClient paymentGateway;

    public PaymentService(PaymentGatewayClient paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean makePayment(String userId, double amount) {
        PaymentResponse response = paymentGateway.charge(userId, amount);
        return response.isSuccessful();
    }

}
