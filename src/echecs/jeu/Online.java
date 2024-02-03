package jeu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Online {

    public static List<File> find(String toFind){
        String path = "/home/infoetu";
        File f = new File(path);
        List<File> liste = new ArrayList<File>();
        String[] enfant = f.list();
        for(int cpt =0 ;cpt<enfant.length;cpt++){
            File test = new File(path+File.separator+enfant[cpt]+"/"+toFind);
            if(test.isFile())liste.add(test);
        }
        return liste;
    }

    public static List<String> read(String toRead, String condition) throws Exception{
        Scanner sc;
        File file = new File(toRead);
        sc = new Scanner(file);
        while(!sc.hasNextLine() || !sc.nextLine().equals(condition)){
            Affichage.clearScreen();
            System.out.println("\t\tEn attente d'un invité");
            System.out.println("\n\n\n\n\n\n\t\t\t   \u25E4");
            TimeUnit.MILLISECONDS.sleep(300);
            Affichage.clearScreen();
            System.out.println("\t\tEn attente d'un invité");
            System.out.println("\n\n\n\n\n\n\t\t\t   \u25E5");
            TimeUnit.MILLISECONDS.sleep(300);
            Affichage.clearScreen();
            System.out.println("\t\tEn attente d'un invité");
            System.out.println("\n\n\n\n\n\n\t\t\t   \u25E2");
            TimeUnit.MILLISECONDS.sleep(300);
            Affichage.clearScreen();
            System.out.println("\t\tEn attente d'un invité");
            System.out.println("\n\n\n\n\n\n\t\t\t   \u25E3");
            TimeUnit.MILLISECONDS.sleep(300);
            sc.close();
            sc = new Scanner(file);
        }
        List<String> list = new ArrayList<String>();
        while(sc.hasNextLine()) list.add(sc.nextLine());
        sc.close();
        return list;
    }

    public static List<String> toList(String toRead) throws Exception{
        Scanner sc;
        File file = new File(toRead);
        sc = new Scanner(file);
        List<String> list = new ArrayList<String>();
        while(sc.hasNextLine()) list.add(sc.nextLine());
        sc.close();
        return list;
    }

    public static File create(String toCreate, String key) throws Exception{
        String chemin = System.getProperty("user.home")+File.separator+toCreate;
        File f = new File(chemin);
        if(f.isFile()) f.delete();
        f.createNewFile();
        f.setWritable(true, false);
        f.setReadable(true, false);
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(key);
        bw.close();
        return f;
    }

    public static File create(String toCreate) throws Exception{
        String chemin = System.getProperty("user.home")+File.separator+toCreate;
        File f = new File(chemin);
        if(f.isFile()) f.delete();
        f.createNewFile();
        f.setWritable(true, false);
        f.setReadable(true, false);
        return f;
    }

    public static void remove(File toRemove) throws Exception{
        if(toRemove.isFile()){
            toRemove.delete();
        }
    }

    public static void remove(String toRemove) throws Exception{
        remove(new File(toRemove));
    }

    public static void changeKey(File f, String key)throws Exception{
        Scanner sc = new Scanner(f);
        if(sc.hasNextLine()){
            sc.nextLine();
            File temp = create(".tempChess",key);
            FileWriter fw = new FileWriter(temp);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(key+"\n");
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                bw.write(line+"\n");
            }
            bw.close();
            sc.close();
            PrintWriter pw = new PrintWriter(f);
            pw.close();
            writeFrom(temp, f);
            temp.delete();
        }
    }

    public static void changeCoord(File f,String from, String to)throws Exception{
        File temp = create(".tempCoor");
        Scanner scanner = new Scanner(f);
        writeOn(temp,Online.getKey(f));
        writeOn(temp,scanner.nextLine());
        writeOn(temp,from);
        writeOn(temp,to);
        PrintWriter pw = new PrintWriter(f);
        pw.close();
        writeFrom(temp, f);
        scanner.close();
    }

    public static void writeOn(File f, String s) throws Exception{
        File temp = create(".tempChess");
        FileWriter fileWriter = new FileWriter(temp);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        Scanner scanner = new Scanner(f);
        while(scanner.hasNextLine()) bufferedWriter.write(scanner.nextLine()+"\n");
        bufferedWriter.write(s);
        bufferedWriter.close();
        scanner.close();
        writeFrom(temp, f);
    }

    public static String getKey(File f) throws Exception{
        Scanner sc = new Scanner(f);
        String res = "";
        if(sc.hasNextLine()) res = sc.nextLine();
        sc.close();
        return res;
    }

    public static void writeFrom(File from, File to) throws Exception{
            FileWriter fileWriter = new FileWriter(to);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            Scanner scanner = new Scanner(from);
            while(scanner.hasNextLine()) bufferedWriter.write(scanner.nextLine()+"\n");
            bufferedWriter.close();
            scanner.close();
    }
}

