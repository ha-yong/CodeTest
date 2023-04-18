import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;


public class Test02 {
	public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.err.println("Usage: MyApp input.csv");
            System.exit(1);
        }
        String filename = args[0];

        // CSVファイルをパースする
        FileReader fileReader = new FileReader(filename);
        CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withHeader());
        List<CSVRecord> records = csvParser.getRecords();
        csvParser.close();

        // ヘッダー行を確認する
        String[] header = { "City", "Altitude", "Temperature", "Humidity" };
        for (int i = 0; i < header.length; i++) {
            if (!records.get(0).get(i).equals(header[i])) {
                System.err.println("Invalid header: " + records.get(0));
                System.exit(1);
            }
        }

        // データを解析する
        List<Double> THIs = new ArrayList<Double>();
        List<Double> altitudes = new ArrayList<Double>();
        List<Double> temperatures = new ArrayList<Double>();
        List<Double> humidities = new ArrayList<Double>();
        for (int i = 1; i < records.size(); i++) {
            CSVRecord record = records.get(i);
            String city = record.get("City");
            double altitude = Double.parseDouble(record.get("Altitude"));
            double temperature = Double.parseDouble(record.get("Temperature"));
            double humidity = Double.parseDouble(record.get("Humidity"));

            // THIを計算する
            double THI = 0.81 * temperature + 0.01 * humidity * (0.99 * temperature - 14.3) + 46.3;
            THIs.add(THI);

            // 高度、気温、湿度を記録する
            altitudes.add(altitude);
            temperatures.add(temperature);
            humidities.add(humidity);
        }

        // ピアソンの積率相関係数を計算する
        double[] altitudeArray = altitudes.stream().mapToDouble(Double::doubleValue).toArray();
        double[] temperatureArray = temperatures.stream().mapToDouble(Double::doubleValue).toArray();
        double[] humidityArray = humidities.stream().mapToDouble(Double::doubleValue).toArray();
        PearsonsCorrelation correlation = new PearsonsCorrelation();
        double correlationCoefficient = correlation.correlation(temperatureArray, altitudeArray);

        // 結果を出力する
        System.out.printf("%.3f %.3f%n", average(THIs), correlationCoefficient);
    }

    private static double average(List<Double> values) {
        double sum = 0.0;
        for (double value : values) {
            sum += value;
        }
        return sum / values.size();
    }
}

