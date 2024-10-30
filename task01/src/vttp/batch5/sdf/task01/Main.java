package vttp.batch5.sdf.task01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	int total;

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String inputFile = args[0];
        List<BikeEntryClass> data = new ArrayList<>();

        if (args.length != 1) {
            System.out.println("Usage: java -cp classes vttp.batch5.sdf.task01 <input_file>");
            return;
        }

        //Open inputFile for reading
        // FileRedaer scans file and input file as data
        Reader reader = new FileReader(inputFile);
        BufferedReader br = new BufferedReader(reader);

        //Loop through to reach each line in the csv file
        String line;
		line = br.readLine();
        while ((line = br.readLine()) != null) {

			BikeEntryClass entry = new BikeEntryClass();
            //Put each data into an array
            String[] row = line.split(",");
			data.add(entry);
            line = br.readLine();
        }

        // Close the reader
        br.close();

        // Iterates over the rows in data (2D array) into single array row
        for (BikeEntryClass entry : data) {
			int season = entry.getSeason();
			int weekday = entry.getWeekday();
			int month = entry.getMonth();
			int weather = entry.getWeather();
			boolean holiday = entry.isHoliday();
			int casual = entry.getCasual();
			int registered = entry.getRegistered();
			int total = entry.getTotal(casual,registered);


			System.out.println("The highest (position) recorded number of cyclists was in "+ season + 
			"(season), on a " + weekday + "(day) in the month of " + month +".\n" + "There were a total of " + total 
			+ "(total) cyclist." + "The weather was " + weather + ", Few clouds, Partly cloudy, Partly cloudy (weather).\n"
			+ weekday + "(day) was" + holiday + "." );

			System.out.println("The second highest (position) recorded number of cyclists was in "+ season + 
			"(season), on a " + weekday + "(day) in the month of " + month +".\n" + "There were a total of " + total 
			+ "(total) cyclist." + "The weather was " + weather + ", Few clouds, Partly cloudy, Partly cloudy (weather).\n"
			+ weekday + "(day) was not a holiday." );

			System.out.println("The third highest (position) recorded number of cyclists was in "+ season + 
			"(season), on a " + weekday + "(day) in the month of " + month +".\n" + "There were a total of " + total 
			+ "(total) cyclist." + "The weather was " + weather + ", Few clouds, Partly cloudy, Partly cloudy (weather).\n"
			+ weekday + "(day) was not a holiday." );

			System.out.println("The fourth highest (position) recorded number of cyclists was in "+ season + 
			"(season), on a " + weekday + "(day) in the month of " + month +".\n" + "There were a total of " + total 
			+ "(total) cyclist." + "The weather was " + weather + ", Few clouds, Partly cloudy, Partly cloudy (weather).\n"
			+ weekday + "(day) was not a holiday." );

			System.out.println("The fifth highest (position) recorded number of cyclists was in "+ season + 
			"(season), on a " + weekday + "(day) in the month of " + month +".\n" + "There were a total of " + total 
			+ "(total) cyclist." + "The weather was " + weather + ", Few clouds, Partly cloudy, Partly cloudy (weather).\n"
			+ weekday + "(day) was not a holiday." );
        }


	

    }

}
