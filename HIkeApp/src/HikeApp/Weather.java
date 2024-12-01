package HikeApp;

/**
 * Represents the weather conditions associated with a hike.
 * This class includes information about temperature, weather condition, forecast, 
 * and precipitation levels, providing a detailed summary of weather data.
 * 
 * @author Tayden Behunin
 */
public class Weather {
    private float temperature;    // Current temperature in F
    private String condition;     // Weather condition (e.g., sunny, cloudy, rainy)
    private String forecast;      // Weather forecast description
    private float precipitation;  // Precipitation amount in inches

    /**
     * Constructs a Weather object with specified details.
     * 
     * @param temperature   the current temperature in F
     * @param condition     the weather condition (e.g., sunny, cloudy, rainy)
     * @param forecast      a brief description of the weather forecast
     * @param precipitation the amount of precipitation in inches
     */
    public Weather(float temperature, String condition, String forecast, float precipitation) {
        this.temperature = temperature;
        this.condition = condition;
        this.forecast = forecast;
        this.precipitation = precipitation;
    }

    // Getters and Setters

    /**
     * Gets the current temperature.
     * 
     * @return the current temperature in F
     */
    public float getTemperature() {
        return temperature;
    }

    /**
     * Sets the current temperature.
     * 
     * @param temperature the new temperature in F
     */
    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    /**
     * Gets the current weather condition.
     * 
     * @return the current weather condition (e.g., sunny, cloudy, rainy)
     */
    public String getCondition() {
        return condition;
    }

    /**
     * Sets the current weather condition.
     * 
     * @param condition the new weather condition (e.g., sunny, cloudy, rainy)
     */
    public void setCondition(String condition) {
        this.condition = condition;
    }

    /**
     * Gets the weather forecast description.
     * 
     * @return a brief description of the weather forecast
     */
    public String getForecast() {
        return forecast;
    }

    /**
     * Sets the weather forecast description.
     * 
     * @param forecast a brief description of the new weather forecast
     */
    public void setForecast(String forecast) {
        this.forecast = forecast;
    }

    /**
     * Gets the amount of precipitation.
     * 
     * @return the amount of precipitation in inches
     */
    public float getPrecipitation() {
        return precipitation;
    }

    /**
     * Sets the amount of precipitation.
     * 
     * @param precipitation the new amount of precipitation in inches
     */
    public void setPrecipitation(float precipitation) {
        this.precipitation = precipitation;
    }

    /**
     * Returns a summary of all weather information.
     * 
     * @return a string summarizing the temperature, condition, precipitation, and forecast
     */
    public String getWeatherInfo() {
        return "Weather: " + condition + " with a temperature of " + temperature + "°F, " +
                "precipitation: " + precipitation + " inches, forecast: " + forecast;
    }

    /**
     * Returns a string representation of the weather object.
     * 
     * @return a string containing all weather details
     */
    @Override
    public String toString() {
        return "Weather [temperature=" + temperature + ", condition=" + condition + 
               ", forecast=" + forecast + ", precipitation=" + precipitation + "]";
    }
}