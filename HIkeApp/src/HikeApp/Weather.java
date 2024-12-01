package HikeApp;

public class Weather {
    private float temperature;
    private String condition;
    private String forecast;
    private float precipitation;

    // Constructor
    public Weather(float temperature, String condition, String forecast, float precipitation) {
        this.temperature = temperature;
        this.condition = condition;
        this.forecast = forecast;
        this.precipitation = precipitation;
    }

    // Getters and Setters
    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getForecast() {
        return forecast;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
    }

    public float getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(float precipitation) {
        this.precipitation = precipitation;
    }

    // Method
    public String getWeatherInfo() {
        return "Weather: " + condition + " with a temperature of " + temperature + "°F, precipitation: " + precipitation + "mm, forecast: " + forecast;
    }

    @Override
    public String toString() {
        return "Weather [temperature=" + temperature + ", condition=" + condition + ", forecast=" + forecast + ", precipitation=" + precipitation + "]";
    }
}