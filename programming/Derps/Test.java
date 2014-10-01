//https://commondatastorage.googleapis.com/chromium-browser-continuous/Win/LAST_CHANGE

import java.awt.FlowLayout;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.util.Scanner;
 
public class Test extends JFrame
{
    public static final void main(String[] args) throws Exception
    {
    // File to read
    String r_commit="https://commondatastorage.googleapis.com/chromium-browser-continuous/Win/LAST_CHANGE";
    String commit="LATEST";
    String r_installer="https://commondatastorage.googleapis.com/chromium-browser-continuous/Win/";
    String installer="mini_installer.exe";
    
    // Creating the GUI
    JFrame window=new JFrame("Chromium Downloader");
    // Adding progress bar
    JProgressBar bar = new JProgressBar(0, 100);
    bar.setSize(50,50);
    bar.setValue(0);
    bar.setStringPainted(true);
    window.add(bar);
    // Adding text label
    JLabel text = new JLabel("Downloading version info");
    window.add(text);
    // Window properties
    window.setVisible(true);
    window.setLayout(new FlowLayout());
    window.setSize(400, 200);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    // Getting installers info file
    try {
        System.out.println("Downloading file info...");
        URL info_url=new URL(r_commit);
        HttpsURLConnection connection = (HttpsURLConnection) info_url.openConnection();
        float totalDataRead=0;
        System.out.println("URL opened!");
        java.io.BufferedInputStream info_in = new java.io.BufferedInputStream(connection.getInputStream());
        System.out.println("Hey Jude!");
        java.io.FileOutputStream info_fos = new java.io.FileOutputStream(commit);
        java.io.BufferedOutputStream info_bout = new BufferedOutputStream(info_fos,1024);
        System.out.println("Hello!");
        byte[] info_data = new byte[1024];
        int i=0;
        System.out.println("Saving file info...");
            while((i=info_in.read(info_data,0,1024))>=0)
            {
            totalDataRead=totalDataRead+i;
            info_bout.write(info_data,0,i);
            }  
        info_bout.close();
        info_in.close();
    }
    catch(Exception e)
    {
         javax.swing.JOptionPane.showConfirmDialog((java.awt.Component)
         null,e.getMessage(), "Error",
         javax.swing.JOptionPane.DEFAULT_OPTION);
    }
    
    // Reading info from the file
    FileReader file = new FileReader(commit);
    Scanner info = new Scanner(file);
    String version;
    if (info.hasNext())
        version = info.nextLine();
    else
        version = "240527";
        
    // Setting real installer adress...    
    r_installer = r_installer + version + "/" +  installer;
    // ...and label info
    text.setText("Downloading Chromium (" + version + " build)");
    
    try {
        URL url=new URL(r_installer);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        int filesize = connection.getContentLength();
        float totalDataRead=0;
        java.io.BufferedInputStream in = new java.io.BufferedInputStream(connection.getInputStream());
        java.io.FileOutputStream fos = new java.io.FileOutputStream(installer);
        java.io.BufferedOutputStream bout = new BufferedOutputStream(fos,1024);
        byte[] data = new byte[1024];
        int i=0;
            while((i=in.read(data,0,1024))>=0)
            {
            totalDataRead=totalDataRead+i;
            bout.write(data,0,i);
            float Percent=(totalDataRead*100)/filesize;
            bar.setValue((int)Percent);
            }  
        bout.close();
        in.close();
    }
    catch(Exception e)
    {
         javax.swing.JOptionPane.showConfirmDialog((java.awt.Component)
         null,e.getMessage(), "Error",
         javax.swing.JOptionPane.DEFAULT_OPTION);
    }
    
    
}
}
