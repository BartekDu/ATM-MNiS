package view;

import java.awt.Color;
import java.util.HashMap;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Chart extends JPanel {
	private int iterator = 1;
	private XYSeries graph = new XYSeries("Temperature");
	private XYSeriesCollection dataset = new XYSeriesCollection();
	private HashMap<String, XYSeries> seriesMap = new HashMap();

	public void newValueArrived(double y) {
		graph.add((0 + iterator * 0.1), y);
		iterator++;
		// dataset.addSeries(temperature);
		// JFreeChart chart = ChartFactory.createXYLineChart("Line Chart Demo",
		// "X", "Y", dataset);
		// XYPlot plot = (XYPlot) chart.getPlot();
		// plot.setRangeGridlinePaint(Color.black);
		// ChartPanel chartPanel = new ChartPanel(chart);
		// this.removeAll();
		// this.add(chartPanel);
		// domainAxis = plot.getDomainAxis();
		// domainAxis.setRange((iterator * 0.1 - 5), (iterator * 0.1 + 5));
		this.repaint();
	}

	private ValueAxis domainAxis;
	private JFreeChart chart;
	private XYPlot plot;

	public Chart() {
		super();

		// create a dataset...
		// XYSeries temperature = new XYSeries("Temperature");

		graph.add(0.0, 0.0);

		//
		XYSeries series2 = new XYSeries("Delivered");
		series2.add(1.0, 5.0);
		series2.add(2.0, 7.0);
		series2.add(3.0, 6.0);
		series2.add(4.0, 8.0);
		series2.add(5.0, -4.0);
		series2.add(6.0, 4.0);
		series2.add(7.0, 2.0);
		series2.add(8.0, 1.0);
		//
		// XYSeries series3 = new XYSeries("Third");
		// series3.add(3.0, 4.0);
		// series3.add(4.0, 3.0);
		// series3.add(5.0, 2.0);
		// series3.add(6.0, -3.0);
		// series3.add(7.0, 6.0);
		// series3.add(8.0, 3.0);
		// series3.add(9.0, -4.0);
		// series3.add(10.0, 3.0);
		//

		dataset.addSeries(graph);
		dataset.addSeries(series2);
		// dataset.addSeries(series3);
		//
		chart = ChartFactory.createXYLineChart("Line Chart Demo", "X", "Y",
				dataset);

		//
		plot = (XYPlot) chart.getPlot();

		// plot.setSeriesPaint(0, Color.cyan);
		plot.setRangeGridlinePaint(Color.black);
		//
		// // draw a horizontal line across the chart at y == 0
		// plot.addRangeMarker(new Marker(Color.red,new BasicStroke(1)0, ,
		// Color.red, 1f));

		//
		// plot.addRangeMarker(new Marker() {
		// });
		ChartPanel chartPanel = new ChartPanel(chart);

		add(chartPanel);
		// this.setVisible(true);

	}
	// public static void main(String[] args) {
	// JFrame frame = new JFrame();
	//
	// // frame.getContentPane().add(new ChartOne(), BorderLayout.CENTER);
	// // frame.pack();
	// // frame.setVisible(true);
	// JPanel p = new JPanel();
	// p.add(new ChartOne(), BorderLayout.CENTER);
	// frame.getContentPane().add(p);
	// frame.pack();
	// frame.setVisible(true);
	//
	// }
}
