/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

/**
 *
 * @author nisit
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

public class Panel_Lista extends JPanel
{
    Panel_Opcion panel = new Panel_Opcion(0);
    private static final long serialVersionUID = 1L;
    private JPanel fillerPanel;
    private ArrayList<JPanel> panels;

    public Panel_Lista(List<JPanel> panels, int height)
    {
        this(panels, height, new Insets(2, 0, 2, 0));
    }

    public Panel_Lista(List<JPanel> panels, int height, Insets insets)
    {
        this();
        for (JPanel panel : panels)
            addPanel(panel, height, insets);
    }

    public Panel_Lista()
    {
        super();
        this.fillerPanel = new JPanel();
        this.fillerPanel.setMinimumSize(new Dimension(0, 0));
        this.panels = new ArrayList<JPanel>();
        setLayout(new GridBagLayout());
    }

    public void addPanel(JPanel p, int height)
    {
        addPanel(p, height, new Insets(2, 0, 2, 0));
    }

    public void addPanel(JPanel p, int height, Insets insets)
    {
        super.remove(fillerPanel);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = getComponentCount();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.ipady = height;
        gbc.insets = insets;
        gbc.weightx = 1.0;
        panels.add(p);
        add(p, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = getComponentCount();
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.weighty = 1.0;
        add(fillerPanel, gbc);
        revalidate();
        invalidate();
        repaint();
    }

    public void removePanel(JPanel p)
    {
        removePanel(panels.indexOf(p));
    }

    public void removePanel(int i)
    {
        super.remove(i);
        panels.remove(i);
        revalidate();
        invalidate();
        repaint();
    }

    public ArrayList<JPanel> getPanels()
    {
        return this.panels;
    }

    public static void main(String[] args)
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setMinimumSize(new Dimension(500, 500));
        f.setLocationRelativeTo(null);
        f.getContentPane().setLayout(new BorderLayout());
        final Panel_Lista listPanel = new Panel_Lista();
        for (int i = 1; i <= 10; i++)
            listPanel.addPanel(new Panel_Opcion(0), 5);
        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent paramActionEvent)
            {
                listPanel.addPanel(getRandomJPanel(), 50);
            }
        });
        JButton btnRemove = new JButton("Remove");
        btnRemove.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent paramActionEvent)
            {
                listPanel.removePanel(0);
            }
        });
        f.getContentPane().add(btnRemove, BorderLayout.NORTH);
        f.getContentPane().add(btnAdd, BorderLayout.SOUTH);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setViewportView(listPanel);
        f.getContentPane().add(scrollPane, BorderLayout.CENTER);
        f.setVisible(true);
    }

    public static JPanel getRandomJPanel()
    {
        JPanel panel = new JPanel();
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel.add(new JLabel("This is a randomly sized JPanel"));
        panel.setBackground(new Color(new Random().nextFloat(), new Random().nextFloat(), new Random().nextFloat()));
        return panel;
    }
}
