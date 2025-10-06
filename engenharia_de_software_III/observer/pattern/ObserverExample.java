import java.util.ArrayList;
import java.util.HashMap;


interface Subscriber {
    public void update(Object data);
}


class TemperatureDisplay implements Subscriber {
    @Override
    public void update(Object data) {
        System.out.println("Temperatura atualizada para: " + data + "°C");
    }
}

class HumidityDisplay implements Subscriber {
    @Override
    public void update(Object data) {
        System.out.println("Humidade atualizada para: " + data + "%");
    }
}

class PressureDisplay implements Subscriber {
    @Override
    public void update(Object data) {
        System.out.println("Pressão atualizada para: " + data + " hPa");
    }
}

class EventManager {
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


public class ObserverExample {
    public static void main(String[] args) {
        EventManager eventManager = new EventManager(
            "temperatureChange", 
            "humidityChange", 
            "pressureChange"
        );
        TemperatureDisplay tempDisplay = new TemperatureDisplay();
        HumidityDisplay humidityDisplay = new HumidityDisplay();
        PressureDisplay pressureDisplay = new PressureDisplay();
        
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