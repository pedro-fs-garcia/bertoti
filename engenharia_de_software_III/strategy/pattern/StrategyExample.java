
interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Pagamento de R$" + amount + " realizado com Cartão de Crédito.");
    }
}

class PixPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Pagamento de R$" + amount + " realizado via PIX.");
    }
}

class PaypalPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Pagamento de R$" + amount + " realizado com PayPal.");
    }
}

class PaymentProcessor {
    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void processPayment(double amount) {
        if (strategy == null) {
            System.out.println("Nenhuma forma de pagamento selecionada.");
            return;
        }
        strategy.pay(amount);
    }
}

public class StrategyExample {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

    
        processor.setStrategy(new CreditCardPayment());
        processor.processPayment(150.0);

    
        processor.setStrategy(new PixPayment());
        processor.processPayment(200.0);

    
        processor.setStrategy(new PaypalPayment());
        processor.processPayment(300.0);
    }
}
