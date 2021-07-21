package Amod.ABC;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class DayforJTree {

//
    public static void main(String[] args) throws Exception{
//        new JFUI();

        JPanel jPanel = new JPanel(new GridLayout(1,2));

        DefaultMutableTreeNode soft = new DefaultMutableTreeNode("软件部");
        soft.add(new DefaultMutableTreeNode(" 小王"));
        soft.add(new DefaultMutableTreeNode(new Person(" 小众").getName()));
        soft.add(new DefaultMutableTreeNode(new Person(" 小阿达").getName()));
        soft.insert(new DefaultMutableTreeNode(new Person(" 小阿qwe").getName()),1);

        DefaultMutableTreeNode sales = new DefaultMutableTreeNode("销售部");
        sales.add(new DefaultMutableTreeNode(new Person("小刘").getName()));
        sales.add(new DefaultMutableTreeNode(new Person("小撒").getName()));
        sales.add(new DefaultMutableTreeNode(new Person("小爱的").getName()));

        DefaultMutableTreeNode top = new DefaultMutableTreeNode("职员管理");
        top.add(new DefaultMutableTreeNode(new Person("总经理").getName()));
        top.add(soft);
        top.add(sales);


        final JTree tree = new JTree(top);
        jPanel.add(tree);


        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu.add(new JMenuItem("新建"));

        jPanel.add(popupMenu);

        JFrame f = new JFrame("JTree");
        new JFUI();
        f.add(jPanel);
        f.setBounds(100,100,600,300);
//        f.pack();
        f.setResizable(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);

        JPanel jPanel2 =new JPanel(new BorderLayout());
        JLabel j1= new JLabel();
        JLabel j2= new JLabel();
        jPanel2.add(j1,BorderLayout.NORTH);
        jPanel2.add(j2,BorderLayout.CENTER);
        jPanel.add(jPanel2);



        tree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton()==MouseEvent.BUTTON3){
                  popupMenu.show(jPanel,e.getX(),e.getY());
                }
            }//触发
        });

        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                //添加节点选择事件
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (node==null){
                    return;
                }

                if (node.isLeaf()){
//                    Person user  = (Person) object;
                    j1.setText("选择"+ node.toString());
                    j2.setText("父节点"+node.getParent());

                }


            }
        });


    }//main

}

class Person{
    String name;
    Person(String name){
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}