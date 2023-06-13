import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;
import java.io.IOException;
import java.util.Arrays;

class Charts {
    public static void charts(String args[]) throws IOException {

        //// X axis data
        //int[] inputAxis = {512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 251282};

        //// Create sample data for linear runtime
        //double[][] yAxis = new double[2][10];
        //yAxis[0] = new double[]{512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 251282};
        //yAxis[1] = new double[]{300, 800, 1800, 3000, 7000, 15000, 31000, 64000, 121000, 231000};

        //// Save the char as .png and show it
        //showAndSaveChart("Sample Test", inputAxis, yAxis);
    }

    public static void showAndSaveChart(String title, int[] xAxis, double[][] yAxis, int decider) throws IOException {
        // Create Chart
        XYChart chart = new XYChartBuilder().width(800).height(600).title(title)
                .yAxisTitle("Time in Milliseconds").xAxisTitle("Input Size").build();

        // Convert x axis to double[]
        double[] doubleX = Arrays.stream(xAxis).asDoubleStream().toArray();


        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);

        // Add a plot for a sorting algorithm

        if (decider == 0){
            chart.addSeries("Quicksort", doubleX, yAxis[0]);
            chart.addSeries("Bucket Sort", doubleX, yAxis[1]);
            chart.addSeries("Selection Sort", doubleX, yAxis[2]);

        }

        else if (decider == 1){

            chart.addSeries("Sorted Quicksort", doubleX, yAxis[0]);
            chart.addSeries("Sorted Bucket Sort", doubleX, yAxis[1]);
            chart.addSeries("Sorted Selection Sort", doubleX, yAxis[2]);

        }


        else if ( decider == 2){
            chart.addSeries("Reverse Sorted Quicksort", doubleX, yAxis[0]);
            chart.addSeries("Reverse Sorted Bucket Sort", doubleX, yAxis[1]);
            chart.addSeries("Reverse Sorted Selection Sort", doubleX, yAxis[2]);


        }


        else if (decider == 3){
            chart.addSeries("Linear Search", doubleX, yAxis[0]);
            chart.addSeries("Sorted Linear Search", doubleX, yAxis[1]);
            chart.addSeries("Binary Search", doubleX, yAxis[2]);


        }


        // Save the chart as PNG
        BitmapEncoder.saveBitmap(chart, title + ".png", BitmapEncoder.BitmapFormat.PNG);

        // Show the chart
        new SwingWrapper(chart).displayChart();
    }
}
