package payments;

public class PaymentResponse {
	
	   private final boolean successful;

	    public PaymentResponse(boolean successful) {
	        this.successful = successful;
	    }

	    public boolean isSuccessful() {
	        return successful;
	    }
	

}
