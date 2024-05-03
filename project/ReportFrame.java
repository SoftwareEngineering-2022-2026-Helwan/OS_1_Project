import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ReportFrame extends JFrame implements ActionListener {
    public JLabel process,waiting,turn,response,totalwait,totalturn,totalresponse,t1,t2,t3;

    public JPanel panel2,panel;
    public JScrollPane scroll;
    public ArrayList<String> PROCESS=new ArrayList<String>();
    CPU cpu=new CPU();

    public  JButton close;
    ReportFrame(){
        Border border=BorderFactory.createLineBorder(Color.black,3);


        panel=new JPanel();
        panel.setBounds(0,0,720,496);
        panel.setLayout(null);

        panel2=new JPanel();
        panel2.setBounds(41,120,497,180);
        panel2.setBackground(Color.pink);
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

        PROCESS.add("p1  8  9  7 ");
        PROCESS.add("p2  8  9  7 ");
        PROCESS.add("p3  8  9  7 ");
        PROCESS.add("p4  8  9  7 ");
        PROCESS.add("p5  8  9  7 ");


        for (int i=0;i<PROCESS.size();i++)
        {
            panel2.add(new JLabel(PROCESS.get(i)));
        }

        scroll=new JScrollPane(panel2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(41,120,497,180);

        process=new JLabel("Process Name");
        process.setBounds(42,75,200,50);
        process.setForeground(Color.black);
        process.setFont(new Font("Consolas",Font.BOLD,15));

        waiting=new JLabel("Waiting Time");
        waiting.setBounds(162,75,200,50);
        waiting.setForeground(Color.black);
        waiting.setFont(new Font("Consolas",Font.BOLD,15));

        turn=new JLabel("TurnAround Time");
        turn.setBounds(282,75,200,50);
        turn.setForeground(Color.black);
        turn.setFont(new Font("Consolas",Font.BOLD,15));

        response=new JLabel("Response Time");
        response.setBounds(430,75,200,50);
        response.setForeground(Color.black);
        response.setFont(new Font("Consolas",Font.BOLD,15));

        totalwait=new JLabel("Total Waiting Time");
        totalwait.setBounds(48,290,200,50);
        totalwait.setForeground(Color.black);
        totalwait.setFont(new Font("Consolas",Font.BOLD,15));

        totalturn=new JLabel("Total TurnAround Time");
        totalturn.setBounds(222,290,200,50);
        totalturn.setForeground(Color.black);
        totalturn.setFont(new Font("Consolas",Font.BOLD,15));

        totalresponse=new JLabel("Total Response Time");
        totalresponse.setBounds(420,290,200,50);
        totalresponse.setForeground(Color.black);
        totalresponse.setFont(new Font("Consolas",Font.BOLD,15));

        cpu.setTotalAverageWaitingTime(9.5);
        cpu.setTotalAverageResponseTime(11.9);
        cpu.setTotalAverageTurnAroundTime(99.6);

        t1=new JLabel(String.valueOf(cpu.getTotalAverageWaitingTime()));
        t1.setBounds(48,330,60,30);
        t1.setForeground(Color.green);
        t1.setFont(new Font("Consolas",Font.PLAIN,15));
        t1.setBorder(border);
        t1.setBackground(Color.DARK_GRAY);
        t1.setOpaque(true);

        t2=new JLabel(String.valueOf(cpu.getTotalAverageTurnAroundTime()));
        t2.setBounds(222,330,60,30);
        t2.setForeground(Color.green);
        t2.setFont(new Font("Consolas",Font.PLAIN,15));
        t2.setBorder(border);
        t2.setBackground(Color.DARK_GRAY);
        t2.setOpaque(true);

        t3=new JLabel(String.valueOf(cpu.getTotalAverageResponseTime()));
        t3.setBounds(420,330,60,30);
        t3.setForeground(Color.green);
        t3.setFont(new Font("Consolas",Font.PLAIN,15));
        t3.setBorder(border);
        t3.setBackground(Color.DARK_GRAY);
        t3.setOpaque(true);

        close=new JButton("Close");
        close.setBounds(217,415,115,40);
        close.setBackground(Color.cyan);
        close.addActionListener(this);

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
            this.dispose();
        }

    }
}
