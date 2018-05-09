import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class ScatterAdd extends JFrame {
	/*
	 * 
	 * ScatterAdd demo = new ScatterAdd("Clustering using K-means",k);
    demo.pack();
    demo.setLocationRelativeTo(null);
    demo.setVisible(true);
	 * */

    private static final int SIZE = 345;
    private static final Random rand = new Random();
    private final XYSeries c1 = new XYSeries("Cluster1");
    private final XYSeries c2 = new XYSeries("Cluster2");
    private final XYSeries c3 = new XYSeries("Cluster3");
    String title="";
    int data[][];

    public ScatterAdd(String s,int data1[][]) {
        super(s);
        title=s;
        data=data1;
        final ChartPanel chartPanel = createDemoPanel();
        chartPanel.setPreferredSize(new Dimension(SIZE, SIZE));
        this.add(chartPanel, BorderLayout.CENTER);
        JPanel control = new JPanel();
        this.add(control, BorderLayout.SOUTH);
    }

    private ChartPanel createDemoPanel() {
        JFreeChart jfreechart = ChartFactory.createScatterPlot(
            title, "X", "Y", createSampleData(),
            PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyPlot = (XYPlot) jfreechart.getPlot();
        xyPlot.setDomainCrosshairVisible(true);
        xyPlot.setRangeCrosshairVisible(true);
        XYItemRenderer renderer = xyPlot.getRenderer();
        renderer.setSeriesPaint(0, Color.blue);
        //adjustAxis((NumberAxis) xyPlot.getDomainAxis(), true);
        //adjustAxis((NumberAxis) xyPlot.getRangeAxis(), false);
        xyPlot.setBackgroundPaint(Color.white);
        return new ChartPanel(jfreechart);
    }

    private void adjustAxis(NumberAxis axis, boolean vertical) {
        axis.setRange(-3.0, 3.0);
        axis.setTickUnit(new NumberTickUnit(0.5));
        axis.setVerticalTickLabels(vertical);
    }

    private XYDataset createSampleData() {
        XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
        for (int i=0;i<3;i++) {
        	for(int temp:data[i]) {
        		if(i==0) {
        			c1.add(i, temp);
        		}
        		else if(i==1) {
        			c2.add(i, temp);
        		}
        		else if(i==2) {
        			c3.add(i, temp);
        		}
        	}
        }
        xySeriesCollection.addSeries(c1);
        xySeriesCollection.addSeries(c2);
        xySeriesCollection.addSeries(c3);
        return xySeriesCollection;
    }

    
}