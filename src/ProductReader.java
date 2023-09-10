//imports
import java.io.File;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.FileNotFoundException;
import static java.nio.file.StandardOpenOption.CREATE;
import javax.swing.JFileChooser;
import java.util.ArrayList;
import java.util.Scanner;


import static java.nio.file.StandardOpenOption.CREATE;

public class ProductReader
{
    public static void main(String[] args)
    {
        //Declarations
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        Scanner con = new Scanner(System.in);
        ArrayList<Product> list = new ArrayList<>();
        boolean start = true;
        Product item;

        start = SafeInput.getYNConfirm(con, "Would you like to select a file?");

        if (start)
        {

            try {
                File workingDirectory = new File(System.getProperty("user.dir"));
                chooser.setCurrentDirectory(workingDirectory);

                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    selectedFile = chooser.getSelectedFile();
                    Path file = selectedFile.toPath();


                    InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                    while (reader.ready())
                    {
                        rec = reader.readLine();
                        String [] details = rec.split(", ");

                        String ID = details[0];
                        String name = details[1];
                        String description = details[2];
                        String strCost = details[3];

                        double cost = Double.parseDouble(strCost);

                        item = new Product(ID, name, description, cost);

                        item.setName(name);

                        list.add(item);

                        System.out.println(item);

                    }

                    System.out.println();
                    System.out.println(String.format("%-8s%-15s%-28s%11s", "ID#", "Name", "Description", "Cost"));
                    System.out.println("================================================================");

                    for(Product p: list)
                    {
                        System.out.println(String.format("%-8s%-15s%-28s%12s",p.getID(), p.getName(), p.getDescription(), p.getCost() ));

                    }


                }else {
                    System.out.println("You must choose a file. Program terminating.");
                    System.exit(0);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        else if (!start)
        {
            start = false;
            System.out.println("You did not want to select a file. Goodbye.");
            System.exit(0);
        }
    }
}




