import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;

public class InputFrame extends JFrame implements ActionListener {
    private static int Quant;
    CPU cpu;
    private static ArrayList<Process> PROCESS=new ArrayList<Process>();
    public JLabel addprocess,nameprocess,arrival,burst,quantum,label;
    public JTextField processname,arriv,burs,quant;
    public JButton add_process,add_quantun,clear,submit;
    private static JPanel panel2,panel;
    private static JScrollPane scroll;

    public ArrayList<JCheckBox> checkBox = new ArrayList<>();


    ReportFrame report;
    private BufferedImage backgroundImage;

    InputFrame(){


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

        panel.setBounds(0,0,800,550);
        panel.setLayout(null);

        panel2=new JPanel();
        panel2.setBounds(499,96,195,180);
        panel2.setBackground(Color.gray);
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));


        addprocess=new JLabel("Add New Process");
        addprocess.setBounds(100,120,290,50);
        addprocess.setForeground(Color.WHITE);
        addprocess.setFont(new Font("Consolas",Font.BOLD,30));

        nameprocess=new JLabel("Process Name");
        nameprocess.setBounds(45,160,200,50);
        nameprocess.setForeground(Color.white);
        nameprocess.setFont(new Font("Consolas",Font.PLAIN,15));

        arrival=new JLabel("Arrival Time");
        arrival.setBounds(179,160,200,50);
        arrival.setForeground(Color.white);
        arrival.setFont(new Font("Consolas",Font.PLAIN,15));

        burst=new JLabel("Burst Time");
        burst.setBounds(294,160,200,50);
        burst.setForeground(Color.white);
        burst.setFont(new Font("Consolas",Font.PLAIN,15));

        quantum=new JLabel("Quantum Time");
        quantum.setBounds(47,341,200,50);
        quantum.setForeground(Color.white);
        quantum.setFont(new Font("Consolas",Font.PLAIN,15));

        processname=new JTextField();
        processname.setBounds(43,205,100,25);
        processname.setBackground(Color.darkGray);
        processname.setForeground(new Color(0x00FF00));
        processname.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
        processname.setHorizontalAlignment(JTextField.CENTER);

        arriv=new JTextField();
        arriv.setBounds(180,205,90,25);
        arriv.setBackground(Color.darkGray);
        arriv.setForeground(new Color(0x00FF00));
        arriv.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
        arriv.setHorizontalAlignment(JTextField.CENTER);

        burs=new JTextField();
        burs.setBounds(295,205,90,25);
        burs.setBackground(Color.darkGray);
        burs.setForeground(new Color(0x00FF00));
        burs.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
        burs.setHorizontalAlignment(JTextField.CENTER);

        quant=new JTextField();
        quant.setBounds(48,393,90,25);
        quant.setBackground(Color.darkGray);
        quant.setForeground(new Color(0x00FF00));
        quant.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
        quant.setHorizontalAlignment(JTextField.CENTER);

        scroll=new JScrollPane(panel2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(430,96,290,180);

        add_process=new JButton("Add Process");
        add_process.setBounds(162,241,115,40);
        add_process.setBackground(Color.cyan);
        add_process.addActionListener(this);

        add_quantun=new JButton("Add Quantum");
        add_quantun.setBounds(168,380,115,40);
        add_quantun.setBackground(Color.cyan);
        add_quantun.addActionListener(this);

        clear=new JButton("Clear Selected");
        clear.setBounds(525,280,120,40);
        clear.setBackground(Color.cyan);
        clear.addActionListener(this);

        submit=new JButton("Simulate");
        submit.setBounds(525,375,115,40);
        submit.setBackground(Color.cyan);
        submit.addActionListener(this);

        panel.add(addprocess);
        panel.add(nameprocess);
        panel.add(arrival);
        panel.add(burst);
        panel.add(quantum);

        panel.add(processname);
        panel.add(arriv);
        panel.add(burs);
        panel.add(quant);

        panel.add(add_process);
        panel.add(add_quantun);
        panel.add(clear);
        panel.add(submit);

        panel.add(scroll);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(720,496);
        this.setLayout(null);
        this.add(panel);
        this.setResizable(false);
        this.setVisible(true);

    }
    private boolean  IsInteger(String s)
    {
        try {
            Integer.parseInt(s);
            return true;
        }catch (Exception e)
        {
            return false;
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            if(e.getSource()==add_process)
            {
                if(IsInteger(arriv.getText())&&IsInteger(burs.getText())){
                    int x=Integer.parseInt(arriv.getText());
                    int y=Integer.parseInt(burs.getText());
                    if(x>=0&&y>0){
                        PROCESS.add(new Process(processname.getText(),x,y));
                        processname.setText("");
                        arriv.setText("");
                        burs.setText("");
                        panel2.setVisible(true);
                        panelscroll();
                    }
                    else if (y <= 0 )
                    {
                        JOptionPane.showMessageDialog(null,"Burst Time \nMust be Greater than  0 ","error",JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Arrival Time \nMust be Greater than or Equal 0 ","error",JOptionPane.ERROR_MESSAGE);

                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Arrival , Burst Time \nMust be  Number","error",JOptionPane.ERROR_MESSAGE);

                }
            }
        }catch (Exception v)
        {
            System.out.println(v);
        }

        try {
            if(e.getSource()==add_quantun)
            {
                if(IsInteger(quant.getText())){
                    int quantum =Integer.parseInt(quant.getText());
                    if (quantum>=0)
                    {
                        Quant=quantum;
                        quant.setText("");
                        JOptionPane.showMessageDialog(null,"Quantum is : "+ Quant,"Added",JOptionPane.INFORMATION_MESSAGE);

                    }
                    else {
                        quant.setText("");
                        JOptionPane.showMessageDialog(null,"Invalid Quantum\nPositive Only","error",JOptionPane.ERROR_MESSAGE);

                    }
                }
                else {
                    quant.setText("");
                    JOptionPane.showMessageDialog(null,"Numeric Values only","error",JOptionPane.ERROR_MESSAGE);

                }
            }}catch (Exception v)
        {
        }
        if (e.getSource()==clear)
        {
            JCheckBox selectedCheckBox;
            Process process;
            int counter = 0;
            while ( counter < PROCESS.size() )
            {
                selectedCheckBox = checkBox.remove(counter);
                process = PROCESS.remove(counter);

                if(!selectedCheckBox.isSelected())
                {
                        PROCESS.add(counter,process);
                        Process.NumberOfProcess = PROCESS.size();
                        checkBox.add(counter,selectedCheckBox);

                    counter++;
                }
                else
                {
                    if (PROCESS.isEmpty())
                    {
                        break;
                    }
                    counter = 0;
                }
            }
            panelscroll();

        }
        if (e.getSource()==submit)
        {
            if(PROCESS.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Missing Process List","error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(Quant <= 0)
            {
                JOptionPane.showMessageDialog(null,"Missing time Quantum","error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            //put cpu in constructor
            cpu = new CPU(PROCESS,Quant);

            cpu.startProcess();

            report=new ReportFrame(cpu);
            report.setLocationRelativeTo(null);





        }
    }

    public static  void setDefaultValues()
    {
        PROCESS.clear();
        Quant = -1;
        Process.NumberOfProcess = 0;
        TimeInterpretur.consumedQuantum = 0;

        //reset the scroll panel
        panel2.removeAll();
        scroll.setViewportView(panel2);
        panel2.revalidate();
        panel2.repaint();

    }
    private void panelscroll() {
        Border border = BorderFactory.createLineBorder(Color.white);
        JPanel headPanal = new JPanel() , processPanal;
        headPanal.setBackground(Color.black);
        headPanal.setLayout(new BoxLayout(headPanal, BoxLayout.X_AXIS));
        JComponent component;

        panel2.removeAll();

        panel2.add((JComponent) Box.createVerticalStrut(1));

        for(int i = 0; i < 3; i++)
        {
            label = new JLabel();

            if(i == 0)  label.setText(" Process Name ");
            else if (i == 1)    label.setText(" Arrival Time ");
            else    label.setText(" Burst Time ");

            label.setForeground(Color.pink);

            headPanal.add(label);

            component = (JComponent) Box.createVerticalStrut(1);

            headPanal.add(component);


        }

        headPanal.setBorder(border);
        headPanal.setBounds(new Rectangle(headPanal.getWidth(),10));

        panel2.add(headPanal);
        panel2.add((JComponent) Box.createVerticalStrut(5));

        JCheckBox processCheckBox;
        checkBox.clear();
        for (Process pro :PROCESS) {
            processPanal = new JPanel();
            processPanal.setBackground(Color.DARK_GRAY);
            processPanal.setLayout(new BoxLayout(processPanal, BoxLayout.X_AXIS));


            processCheckBox = new JCheckBox();
            processCheckBox.setText(pro.getProcessName());
            processCheckBox.setForeground(Color.DARK_GRAY);
            processCheckBox.setBackground(Color.DARK_GRAY);
            processCheckBox.setFocusPainted(false);
            checkBox.add(processCheckBox);

            processPanal.add(processCheckBox);


            label =  new JLabel(" " + pro.getProcessName(),SwingConstants.CENTER);

            label.setForeground(Color.green);
            processPanal.add(label);

            processPanal.add(Box.createVerticalStrut(40));

            label =   new JLabel("          " + pro.getArrivalTime(),SwingConstants.CENTER);

            label.setForeground(Color.green);
            processPanal.add(label);

            processPanal.add(Box.createVerticalStrut(40));

            label = new JLabel("            " + pro.getBurstTime(),SwingConstants.CENTER);

            label.setForeground(Color.green);
            processPanal.add(label);

            processPanal.add(Box.createVerticalStrut(30));
            processPanal.setBorder(border);
            panel2.add(processPanal);
        }
        scroll.setViewportView(panel2);
        panel2.revalidate();
        panel2.repaint();

    }
}

