package _08_California_Weather;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a tempeature of 59.01 �F
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature �F = 65.0, max temperature �F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 * 
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api
 */

	
public class CaliforniaWeather implements ActionListener {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JButton findTemp = new JButton();
    JButton weatherToCities = new JButton();
    JButton tempToCities = new JButton();
	HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();
    void start() {
    	frame.add(panel);
    	panel.add(findTemp);
    	panel.add(weatherToCities);
    	panel.add(tempToCities);
    	findTemp.setText("Find Weather of a City");
    	findTemp.addActionListener(this);
    	weatherToCities.setText("Find City from Weather");
    	weatherToCities.addActionListener(this);
    	tempToCities.setText("Find City from Temperature");
    	tempToCities.addActionListener(this);
    	frame.setVisible(true);
    	frame.pack();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // All city keys have the first letter capitalized of each word
        String cityName = Utilities.capitalizeWords( "National City" );
        WeatherData datum = weatherData.get(cityName);
        
        if( datum == null ) {
            System.out.println("Unable to find weather data for: " + cityName);
        } else {
            System.out.println(cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
        }
    }
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == findTemp) {
			String city = JOptionPane.showInputDialog("Enter a city:");
			WeatherData datum = weatherData.get(city);
			if(datum == null) {
				JOptionPane.showMessageDialog(null, "Temperature data cannot be found for " + city + ".");
			} else {
				double temp = datum.temperatureF;
				JOptionPane.showMessageDialog(null, city + " has a temperature of " + temp + " degrees Fahrenheit.");
			}
			
		} else if(arg0.getSource() == weatherToCities) {
			String weather = JOptionPane.showInputDialog("Enter a weather condition:");
			ArrayList<String> cities = new ArrayList<String>();
			for(String city : weatherData.keySet()) {
				WeatherData datum = weatherData.get(city);
				String weatherCondition = datum.weatherSummary;
				if(weatherCondition.equalsIgnoreCase(weather)) {
					cities.add(city);
				}
			}
			String citiesStrings = "";
			for(String city : cities) {
				citiesStrings += city;
				citiesStrings += ", ";
			}
			JOptionPane.showMessageDialog(null, citiesStrings);

		} else if(arg0.getSource() == tempToCities) {
			String minTemp = JOptionPane.showInputDialog("Enter a minimum temperature:");
			String maxTemp = JOptionPane.showInputDialog("Enter a maximum temperature:");
			Double minTempBetter = Double.parseDouble(minTemp);
			Double maxTempBetter = Double.parseDouble(maxTemp);
			ArrayList<String> cities = new ArrayList<String>();
			for(String city : weatherData.keySet()) {
				WeatherData datum = weatherData.get(city);
				Double weatherCondition = datum.temperatureF;
				if(weatherCondition >= minTempBetter && weatherCondition <= maxTempBetter) {
					cities.add(city);
				}
			}
			String citiesStrings = "";
			for(String city : cities) {
				citiesStrings += city;
				citiesStrings += ", ";
			}
			JOptionPane.showMessageDialog(null, citiesStrings);
		}
	}
}
