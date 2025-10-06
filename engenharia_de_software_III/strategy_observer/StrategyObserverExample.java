import java.util.ArrayList;
import java.util.HashMap;


interface Subscriber {
    public void update(Object data);
}

interface Publisher {
    public void subscribe(String eventType, Subscriber listener);
    public void unsubscribe(String eventType, Subscriber listener);
    public void notify(String eventType, Object data);
}


interface DisplayStrategy {
    public void display(String message, Object data);
}


class SimpleDisplayStrategy implements DisplayStrategy {
    @Override
    public void display(String message, Object data) {
        System.out.println(message + data);
    }
}


class TemperatureDisplay implements Subscriber {
    private DisplayStrategy strategy;

    TemperatureDisplay(DisplayStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(DisplayStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void update(Object data) {
        this.strategy.display("Temperatura atualizada para (°C): ", data);
    }
}


class HumidityDisplay implements Subscriber {
    private DisplayStrategy strategy;
    
    HumidityDisplay(DisplayStrategy strategy) {
        this.strategy = strategy;
    }
    
    public void setStrategy(DisplayStrategy strategy) {
        this.strategy = strategy;
    }
    
    @Override
    public void update(Object data) {
        this.strategy.display("Humidade atualizada para (%): ", data);
    }
}

class PressureDisplay implements Subscriber {
    private DisplayStrategy strategy;
    
    PressureDisplay(DisplayStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(DisplayStrategy strategy) {
        this.strategy = strategy;
    }
    
    @Override
    public void update(Object data) {
        this.strategy.display("Pressão atualizada para: ", data);
    }
}

class EventManager implements Publisher {
    private HashMap<String, ArrayList<Subscriber>> listeners = new HashMap<>();

    EventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, Subscriber listener) {
        this.listeners.get(eventType).add(listener);
    }

    public void unsubscribe(String eventType, Subscriber listener) {
        this.listeners.get(eventType).remove(listener);
    }

    public void notify(String eventType, Object data) {
        ArrayList<Subscriber> listeners = this.listeners.get(eventType);
        for (Subscriber listener : listeners) {
            listener.update(data);
        }
    }
}


class WeatherStation {
    private EventManager eventManager;
    private float temperature;
    private float humidity;
    private float pressure;

    WeatherStation(EventManager eventManager, float temperature, float humidity, float pressure) {
        this.eventManager = eventManager;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        System.out.println("temperatura inicial: " + this.temperature + "°C");
        System.out.println("pressão inicial: " + this.pressure + "%");
        System.out.println("humidade inicial: " + this.humidity + "hPa");
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        eventManager.notify("temperatureChange", this.temperature);
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
        eventManager.notify("humidityChange", this.humidity);
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
        eventManager.notify("pressureChange", this.pressure);
    }

    public float getTemperature() {
        return this.temperature;
    }

}


public class StrategyObserverExample {
    public static void main(String[] args) {
        EventManager eventManager = new EventManager(
            "temperatureChange", 
            "humidityChange", 
            "pressureChange"
        );

        SimpleDisplayStrategy simpleStrategy = new SimpleDisplayStrategy();

        TemperatureDisplay tempDisplay = new TemperatureDisplay(simpleStrategy);
        HumidityDisplay humidityDisplay = new HumidityDisplay(simpleStrategy);
        PressureDisplay pressureDisplay = new PressureDisplay(simpleStrategy);
        
        eventManager.subscribe("temperatureChange", tempDisplay);
        eventManager.subscribe("humidityChange", humidityDisplay);
        eventManager.subscribe("pressureChange", pressureDisplay);
        
        WeatherStation weatherStation = new WeatherStation(eventManager, 30.0f, 54.0f, 987.0f);

        System.out.println("\n");

        weatherStation.setTemperature(25.5f);
        weatherStation.setHumidity(60.0f);
        weatherStation.setPressure(1013.25f);
    }
}