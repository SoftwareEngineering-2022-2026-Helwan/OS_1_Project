import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class ReportFrame extends JFrame implements ActionListener {
    public JLabel process,waiting,turn,response,totalwait,totalturn,totalresponse,t1,t2,t3,label;

    GanttChart chart;
    public JPanel panel2,panel;
    public JScrollPane scroll;
    CPU cpu;

    public  JButton close,gantt;

    private BufferedImage backgroundImage;
    ReportFrame(CPU cpu){

        this.cpu = cpu;
        Border border=BorderFactory.createLineBorder(Color.black,3);


        try {
            backgroundImage = ImageIO.read(new File("bgImage.jpeg"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        panel.setBounds(0,0,720,496);
        panel.setLayout(null);

        panel2=new JPanel();
        panel2.setBounds(41,120,497,180);
        panel2.setBackground(Color.gray);
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

        //fill the scroll with process here
        Border borderLabel = BorderFactory.createLineBorder(Color.white);
        JPanel processPanal ;
        for (Process pro :cpu.waitingQueue) {
            processPanal = new JPanel();
            processPanal.setBackground(Color.darkGray);
            processPanal.setLayout(new BoxLayout(processPanal, BoxLayout.X_AXIS));


            label =  new JLabel("               " + pro.getProcessName(),SwingConstants.CENTER);

            label.setForeground(Color.green);
            processPanal.add(label);

            processPanal.add(Box.createVerticalStrut(40));

            label =   new JLabel("                " + pro.getFinalWaitingTime(),SwingConstants.CENTER);

            label.setForeground(Color.green);
            processPanal.add(label);

            processPanal.add(Box.createVerticalStrut(40));

            label = new JLabel("                    " + pro.getFinalTurnAroundTime(),SwingConstants.CENTER);

            label.setForeground(Color.green);
            processPanal.add(label);

            processPanal.add(Box.createVerticalStrut(40));

            label = new JLabel("                        " + pro.getFinalResponseTime(),SwingConstants.CENTER);

            label.setForeground(Color.green);
            processPanal.add(label);

            processPanal.add(Box.createVerticalStrut(1));
            processPanal.setBorder(borderLabel);
            panel2.add(processPanal);
        }

        scroll=new JScrollPane(panel2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(41,120,520,180);

        process=new JLabel("Process Name");
        process.setBounds(42,75,200,50);
        process.setForeground(Color.white);
        process.setFont(new Font("Consolas",Font.BOLD,15));

        waiting=new JLabel("Waiting Time");
        waiting.setBounds(162,75,200,50);
        waiting.setForeground(Color.white);
        waiting.setFont(new Font("Consolas",Font.BOLD,15));

        turn=new JLabel("TurnAround Time");
        turn.setBounds(282,75,200,50);
        turn.setForeground(Color.white);
        turn.setFont(new Font("Consolas",Font.BOLD,15));

        response=new JLabel("Response Time");
        response.setBounds(430,75,200,50);
        response.setForeground(Color.white);
        response.setFont(new Font("Consolas",Font.BOLD,15));

        totalwait=new JLabel("Average Waiting Time");
        totalwait.setBounds(48,290,200,50);
        totalwait.setForeground(Color.white);
        totalwait.setFont(new Font("Consolas",Font.BOLD,15));

        totalturn=new JLabel("Average TurnAround Time");
        totalturn.setBounds(222,290,200,50);
        totalturn.setForeground(Color.white);
        totalturn.setFont(new Font("Consolas",Font.BOLD,15));

        totalresponse=new JLabel("Average Response Time");
        totalresponse.setBounds(420,290,200,50);
        totalresponse.setForeground(Color.white);
        totalresponse.setFont(new Font("Consolas",Font.BOLD,15));

        //fill the total average time here


        t1=new JLabel(String.format("%.3f",cpu.getTotalAverageWaitingTime()));
        t1.setBounds(88,330,60,30);
        t1.setForeground(Color.green);
        t1.setFont(new Font("Consolas",Font.PLAIN,15));
        t1.setBorder(border);
        t1.setBackground(Color.DARK_GRAY);
        t1.setOpaque(true);
        t1.setHorizontalAlignment(JLabel.CENTER);

        t2=new JLabel(String.format("%.3f",cpu.getTotalAverageTurnAroundTime()));
        t2.setBounds(222+55,330,60,30);
        t2.setForeground(Color.green);
        t2.setFont(new Font("Consolas",Font.PLAIN,15));
        t2.setBorder(border);
        t2.setBackground(Color.DARK_GRAY);
        t2.setOpaque(true);
        t2.setHorizontalAlignment(JLabel.CENTER);

        t3=new JLabel(String.format("%.3f",cpu.getTotalAverageResponseTime()));
        t3.setBounds(420+55,330,60,30);
        t3.setForeground(Color.green);
        t3.setFont(new Font("Consolas",Font.PLAIN,15));
        t3.setBorder(border);
        t3.setBackground(Color.DARK_GRAY);
        t3.setOpaque(true);
        t3.setHorizontalAlignment(JLabel.CENTER);

        close=new JButton("Close");
        close.setBounds(180,400,115,40);
        close.setBackground(Color.cyan);
        close.addActionListener(this);

        gantt=new JButton("GanttChart");
        gantt.setBounds(350,400,115,40);
        gantt.setBackground(Color.cyan);
        gantt.addActionListener(this);

        panel.add(process);
        panel.add(waiting);
        panel.add(turn);
        panel.add(response);
        panel.add(totalwait);
        panel.add(totalturn);
        panel.add(totalresponse);
        panel.add(t1);
        panel.add(t2);
        panel.add(t3);

        panel.add(scroll);

        panel.add(close);
        panel.add(gantt);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(720,496);
        this.setLayout(null);
        this.add(panel);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==close)
        {
            this.setVisible(false);
            if(chart.isVisible())
            {
                chart.dispose();
            }
            //empty the program for new run
            InputFrame.setDefaultValues();
            this.dispose();
        }
        if(e.getSource()==gantt)
        {
            chart = new GanttChart(cpu);
            chart.setTitle("Gantt Chart");
            chart.setVisible(true);
            chart.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }

    }


}
