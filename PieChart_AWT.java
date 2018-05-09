import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
 
public class PieChart_AWT extends JFrame {
   
   public PieChart_AWT( String title,DefaultPieDataset dataset ,String title1 ) {
      super( title ); 
      setContentPane(createDemoPanel(dataset,title1 ));
   }
   
   
   
   private static JFreeChart createChart( PieDataset dataset,String title ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         title,   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         false);

      return chart;
   }
   
   public static JPanel createDemoPanel( DefaultPieDataset dataset,String title ) {
      JFreeChart chart = createChart(dataset,title );  
      return new ChartPanel( chart ); 
   }

   
}