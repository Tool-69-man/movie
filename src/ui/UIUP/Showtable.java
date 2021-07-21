package  ui.UIUP;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
import org.jb2011.swing9patch.toast.Toast;

public class Showtable extends JPanel
{
    private JTextArea txtMsg = null;
    private JTextField txtPositionX = null;
    private JTextField txtPositionY = null;
    private JTextField txtDelay = null;
    private JButton btnShowToast = null;

    public Showtable(String html)
    {
        super(new BorderLayout());

        initGUI(html);
        initListeners();
    }

    private void initGUI(String html)
    {
        txtMsg = new JTextArea(5,5);
        txtPositionX = new JTextField();
        txtPositionY = new JTextField();
        txtDelay = new JTextField();
        btnShowToast = new JButton("Show toast");

        // init sub coms
        txtMsg.setText(html);

//        "<html>\n" +
//                "<body>\n" +
//                "Hello ninepatch for JavaSE, you are <b>so cool</b>!\n" +
//                "</body>\n" +
//                "</html>\n"


        txtPositionX.setText("-1");
        txtPositionY.setText("-1");
        txtDelay.setText("3000");
        txtPositionX.setColumns(10);
        txtPositionY.setColumns(10);
        txtDelay.setColumns(10);
        btnShowToast.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));
        btnShowToast.setForeground(Color.white);

        // init btn pane
        JPanel btnPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnPane.add(new JLabel("Position x:"));
        btnPane.add(txtPositionX);
        btnPane.add(new JLabel("Position y:"));
        btnPane.add(txtPositionY);
        btnPane.add(new JLabel("Delay(ms):"));
        btnPane.add(txtDelay);
        btnPane.add(btnShowToast);

        // init main ui
        this.add(btnPane, BorderLayout.SOUTH);
        this.add(new JScrollPane(txtMsg), BorderLayout.CENTER);
        this.setBorder(BorderFactory.createEmptyBorder(10,100,20,100));
    }

    private void initListeners()
    {
        btnShowToast.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Toast.showTost(Integer.parseInt(txtDelay.getText().trim())
                        , txtMsg.getText()
                        , new Point(Integer.parseInt(txtPositionX.getText().trim())
                                ,Integer.parseInt(txtPositionY.getText().trim())));
            }
        });
    }
}
