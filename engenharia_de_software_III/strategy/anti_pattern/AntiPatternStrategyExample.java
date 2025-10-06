
class PaymentProcessor {
    public void pay(double amount) {
        System.out.println("Pagamento de R$" + amount + " realizado.");
    }
}

class CreditCardProcessor extends PaymentProcessor {
    @Override
    public void pay(double amount) {
        System.out.println("Pagamento de R$" + amount + " realizado com Cartão de Crédito.");
    }
}

class PixProcessor extends PaymentProcessor {
    @Override
    public void pay(double amount) {
        System.out.println("Pagamento de R$" + amount + " realizado via PIX.");
    }
}

class PaypalProcessor extends PaymentProcessor {
    @Override
    public void pay(double amount) {
        System.out.println("Pagamento de R$" + amount + " realizado com PayPal.");
    }
}

public class AntiPatternStrategyExample {
    public static void main(String[] args) {
      
        PaymentProcessor creditCard = new CreditCardProcessor();
        creditCard.pay(150.0);

        PaymentProcessor pix = new PixProcessor();
        pix.pay(200.0);

        PaymentProcessor paypal = new PaypalProcessor();
        paypal.pay(300.0);
    }
}
