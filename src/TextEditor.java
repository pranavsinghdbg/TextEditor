//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.IIOException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class TextEditor implements ActionListener {
    JFrame frame = new JFrame();
    JMenuBar menuBar;
    JMenuItem newfile;
    JMenuItem open;
    JMenuItem save;
    JMenuItem cut;
    JMenuItem copy;
    JMenuItem paste;
    JMenuItem selectAll;
    JMenuItem close;
    JMenu file;
    JMenu edit;
    JTextArea textArea;

    TextEditor() {
        this.frame.setBackground(Color.RED);
        this.menuBar = new JMenuBar();
        this.textArea = new JTextArea();
        this.file = new JMenu("File");
        this.edit = new JMenu("Edit");
        this.newfile = new JMenuItem("New File");
        this.save = new JMenuItem("Save");
        this.open = new JMenuItem("Open");
        this.newfile.addActionListener(this);
        this.save.addActionListener(this);
        this.open.addActionListener(this);
        this.file.add(this.newfile);
        this.file.add(this.save);
        this.file.add(this.open);
        this.cut = new JMenuItem("Cut");
        this.copy = new JMenuItem("Copy");
        this.paste = new JMenuItem("Paste");
        this.selectAll = new JMenuItem("Select All");
        this.close = new JMenuItem("Close");
        this.cut.addActionListener(this);
        this.copy.addActionListener(this);
        this.paste.addActionListener(this);
        this.selectAll.addActionListener(this);
        this.close.addActionListener(this);
        this.edit.add(this.cut);
        this.edit.add(this.copy);
        this.edit.add(this.paste);
        this.edit.add(this.selectAll);
        this.edit.add(this.close);
        this.menuBar.add(this.file);
        this.menuBar.add(this.edit);
        this.frame.setJMenuBar(this.menuBar);
        JPanel jPanel = new JPanel();
        jPanel.setBorder(new EmptyBorder(5, 5, 25, 5));
        jPanel.setLayout(new BorderLayout(0, 0));
        jPanel.add(this.textArea, "Center");
        JScrollPane scrollPane = new JScrollPane(this.textArea, 20, 30);
        jPanel.add(scrollPane);
        this.frame.add(jPanel);
        this.frame.setBounds(100, 100, 400, 400);
        this.frame.setTitle("Text Editor By Pranav Singh");
        this.frame.setDefaultCloseOperation(3);
        ImageIcon icon = new ImageIcon("src/resources/notpadimage.png");
        this.frame.setIconImage(icon.getImage());
        this.frame.setVisible(true);
        this.frame.setLayout((LayoutManager)null);
    }

    public static void main(String[] args) {
        new TextEditor();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cut) {
            this.textArea.cut();
        }

        if (e.getSource() == this.copy) {
            this.textArea.copy();
        }

        if (e.getSource() == this.paste) {
            this.textArea.paste();
        }

        if (e.getSource() == this.selectAll) {
            this.textArea.selectAll();
        }

        if (e.getSource() == this.close) {
            System.exit(0);
        }

        JFileChooser jFileChooser;
        int chooseOption;
        File file;
        if (e.getSource() == this.save) {
            jFileChooser = new JFileChooser("C:");
            chooseOption = jFileChooser.showSaveDialog((Component)null);
            if (chooseOption == 0) {
                file = new File(String.valueOf(jFileChooser.getSelectedFile().getAbsoluteFile()) + ".txt");

                try {
                    FileWriter fileWriter = new FileWriter(file);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    this.textArea.write(bufferedWriter);
                    bufferedWriter.close();
                } catch (IOException var10) {
                    var10.fillInStackTrace();
                }
            }
        }

        if (e.getSource() == this.open) {
            jFileChooser = new JFileChooser("C:");
            chooseOption = jFileChooser.showOpenDialog((Component)null);
            if (chooseOption == 0) {
                file = jFileChooser.getSelectedFile();
                String path = file.getPath();

                try {
                    FileReader fileReader = new FileReader(path);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String intermediate = "";

                    String output;
                    for(output = ""; (intermediate = bufferedReader.readLine()) != null; output = output + intermediate + "\n") {
                    }

                    this.textArea.setText(output);
                } catch (IIOException | FileNotFoundException var11) {
                    var11.fillInStackTrace();
                } catch (IOException var12) {
                    throw new RuntimeException(var12);
                }
            }
        }

        if (e.getSource() == this.newfile) {
            new TextEditor();
        }

    }
}
