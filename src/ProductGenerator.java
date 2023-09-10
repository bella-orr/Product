import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductGenerator
{
    public static void main(String[] args)
    {
        //Declarations
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestData.csv");
        ArrayList<Product> products = new ArrayList<>();
        boolean done = false;
        Scanner in = new Scanner(System.in);

        String ID = "";
        String name ="";
        String description = "";
        String record = "";
        String csvRec = "";
        Product item;
        double cost = 0;


        do
        {
            //Goes to SafeInput and checks for non-zero length string
            ID = SafeInput.getNonZeroLenString(in, "Please enter the ID (6 digits)" );
            name = SafeInput.getNonZeroLenString(in, "Please enter the name" );
            description = SafeInput.getNonZeroLenString(in, "Please enter the description" );


            //Goes to SafeInput and check for a double
            cost = SafeInput.getDouble(in, "Please enter the cost");

            //creates input to product
            item = new Product(ID, name, description, cost);

            //sets name of the poduct
            item.setName(name);

            //records the product object to an array list products
            products.add(item);

            //ask user for my information using getYN method
            done = SafeInput.getYNConfirm(in, "Are you done entering information?");

        }
        while(!done);

        for(Product i: products)
        {
            System.out.println(i);
        }

        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            for(Product rec : products) //enhanced for loop
            {
                csvRec = rec.toCSVDataRecord();//changes product object toCSVData
                writer.write(csvRec, 0, csvRec.length());
                writer.newLine();// adds the new line

                System.out.println(csvRec);

            }
            writer.close();
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}