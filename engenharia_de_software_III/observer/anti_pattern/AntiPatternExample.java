class TemperatureDisplay {
    public void showTemperature(float temperature) {
        System.out.println("Temperatura atualizada para: " + temperature + "°C");
    }
}

class HumidityDisplay {
    public void showHumidity(float humidity) {
        System.out.println("Umidade atualizada para: " + humidity + "%");
    }
}

class PressureDisplay {
    public void showPressure(float pressure) {
        System.out.println("Pressão atualizada para: " + pressure + " hPa");
    }
}

class WeatherStation {
    private TemperatureDisplay temperatureDisplay;
    private HumidityDisplay humidityDisplay;
    private PressureDisplay pressureDisplay;

    private float temperature;
    private float humidity;
    private float pressure;

    WeatherStation() {
        this.temperatureDisplay = new TemperatureDisplay();
        this.humidityDisplay = new HumidityDisplay();
        this.pressureDisplay = new PressureDisplay();

        this.temperature = 30.0f;
        this.humidity = 50.0f;
        this.pressure = 1000.0f;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        temperatureDisplay.showTemperature(temperature);
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
        humidityDisplay.showHumidity(humidity);
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
        pressureDisplay.showPressure(pressure);
    }
}

public class AntiPatternExample {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        station.setTemperature(25.0f);
        station.setHumidity(70.0f);
        station.setPressure(1015.0f);
    }
}
