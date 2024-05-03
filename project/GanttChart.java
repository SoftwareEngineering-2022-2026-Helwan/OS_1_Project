import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.GanttRenderer;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.time.SimpleTimePeriod;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GanttChart {
    public ArrayList<ProcessTable> pt = new ArrayList<>();
    TaskSeriesCollection dataset = new TaskSeriesCollection();

    public GanttChart(CPU cpu) {
        pt = cpu.getProcessTableList();
        TaskSeries level1Series;

        for (int i = 0; i < pt.size(); i++) {
            level1Series = new TaskSeries(pt.get(i).getProcessName());
            Task t1 = new Task(pt.get(i).getProcessName(), new SimpleTimePeriod(0,cpu.getMaxClock()));
            t1.addSubtask(new Task(pt.get(i).getProcessName(), new SimpleTimePeriod(pt.get(i).getStartTime(), pt.get(i).getEndTime())));

            while (i < pt.size() - 1 && pt.get(i).getProcessName().equals(pt.get(i + 1).getProcessName())) {
                i++;
                t1.addSubtask(new Task(pt.get(i).getProcessName(), new SimpleTimePeriod(pt.get(i).getStartTime(), pt.get(i).getEndTime())));
            }

            level1Series.add(t1);
            dataset.add(level1Series);
        }


        JFreeChart chart = ChartFactory.createGanttChart(
                "Gantt Chart",
                "Task",
                "Time",
                dataset,
                true,
                true,
                false);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        GanttRenderer renderer = new GanttRenderer();

        renderer.setMaximumBarWidth(0.05);
        plot.getDomainAxis().setCategoryMargin(0.2);
        plot.setRenderer(renderer);

        SwingUtilities.invokeLater(() -> {
            // Create and set up the window
            JFrame frame = new JFrame("Gantt Chart");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new ChartPanel(chart));
            // Display the window
            frame.pack();
            frame.setVisible(true);
            frame.setBounds(new Rectangle(frame.getWidth()+350,frame.getHeight()));
            frame.setLocationRelativeTo(null);
        });
    }
}