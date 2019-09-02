package rahul.assignmet.coursera;

public class Mainclass {

	public static void main(String[] args) {
		ParsingExportData ped=new ParsingExportData();
		ped.tester();
		ParsingWeatherData pwd=new ParsingWeatherData();
		pwd.testColdestHourInFile();
		pwd.testFileWithColdestTemperature();
		pwd.testlowestHumidityInFile();
		pwd.testLowestHumidityInManyFiles();
		pwd.testAverageTemperatureInFile();
		pwd.testAverageTemperatureWithHighHumidityInFile();

	}

}
