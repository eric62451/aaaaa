package com.waypoint.global;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.util.org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {

    private final String HELLO_MESSAGE = "Hello world... (this is the example bukkit plugin.)";
    private final String GOODBYE_MESSAGE = "Goodbye world... (this is the example bukkit plugin.)";
    private Location worldspawn, netherspawn;
    private final String folder = "./plugins/Teleporter/";

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        getLogger().info("plugin commad used");

        if (cmd.getName().equalsIgnoreCase("foo")) {
            Player player = (Player) sender;
            getLogger().info("Im ThaMaster of coding");
            if (args.length == 0) {
                args = new String[]{"0"};
            }
            sender.sendMessage(player.getWorld().getName());
            player.teleport(new Location(Bukkit.getWorld("world"), 100, 100, 100));
            return true;
        } /*else if (cmd.getName().equalsIgnoreCase("getthetime")) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        sender.sendMessage("The time is now " + dateFormat.format(date));
        } else*/

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (cmd.getLabel().equalsIgnoreCase("sethome")) {
                if (args.length == 0) {
                    sender.sendMessage("Please enter a name for the location Ex: /sethome <LocationName>");
                } else {
                    String yn = "private";
                    if (args.length == 2) {
                        if (args[1].equalsIgnoreCase("public")) {
                            yn = "public";
                        }
                    }
                    Location loc = player.getLocation();
                    String content = "";
                    String path = folder + player.getName() + ".txt";
                    File file = new File(path);
                    Scanner reader =null;
                    int counter = 1;
                    try {
                        reader = new Scanner(file);
                        String readLine = null;
                        while (reader.hasNext()) {
                            readLine = reader.nextLine();
                        }
                        String[] split = readLine.split(" ");
                        counter = Integer.parseInt(split[6]);
                        counter++;
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    String data = args[0] + " '" + loc.getWorld().getName() + "' " + loc.getX() + " " + loc.getY() + " " + loc.getZ() + " " + yn + " " + counter;
                    try {
                        rm(args[0], path);
                        content = new Scanner(new File(path)).useDelimiter("\\Z").next();
                        content = content + "\r\n" + data;

                    } catch (Exception e) {
                        //data = data;
                        content = data;
                    } finally {
                        try {
                            PrintWriter out = new PrintWriter(path);
                            out.print(content);
                            out.close();
                        } catch (FileNotFoundException e) {
                        }
                        sender.sendMessage("Location " + args[0] + " set");
                    }
                }
            } 
            
            else if (cmd.getLabel().equalsIgnoreCase("switchpermission")) {
            if (args.length == 0 ) {
                    sender.sendMessage("Please follow the command setpermission <place>");
                } 
                 else if(args.length == 1){
                    String path = folder + player.getName() + ".txt";
                    try {
                        File file = new File(path);
                        Scanner reader = new Scanner(file);
                        String line = args[0] + " ";
                        String readLine = null;
                        while ((readLine = reader.nextLine()) != null && !readLine.contains(line)) {
                        }

                        String[] split = readLine.split(" ");
                        String worldType = split[1].replace("'", "");
                        double xCoord = Double.parseDouble(split[2]);
                        double yCoord = Double.parseDouble(split[3]);
                        double zCoord = Double.parseDouble(split[4]);
                        int counter = Integer.parseInt(split[6]);

                        if(split[5].equals("public"))
                        {
                    String fileString = FileUtils.readFileToString(file);
                    String finalString = fileString.replace("public " + counter, "private " + counter);
                    FileUtils.writeStringToFile(file, finalString);
                    sender.sendMessage("Switched "+args[0]+" to private");
                        }
                        else if (split[5].equals("private"))
                        {
                    String fileString = FileUtils.readFileToString(file);
                    String finalString = fileString.replace("private " + counter, "public " + counter);
                    FileUtils.writeStringToFile(file, finalString);
                    sender.sendMessage("Switched "+args[0]+" to public");
                        }
                    } catch (Exception e) {
                        sender.sendMessage("Player '" + player.getName() + "' does not have location '");
                    }
                }

            }
            
            else if (cmd.getLabel().equalsIgnoreCase("rmhome")) {
                if (args.length == 0) {
                    args = new String[]{"world"};
                }
                String path = folder + player.getName() + ".txt";
                try {
                    rm(args[0], path);
                } catch (FileNotFoundException ex) {
                }
                sender.sendMessage("home " + args[0] + " removed");

            } else if (cmd.getLabel().equalsIgnoreCase("tele")) {
                if (args.length == 0) {
                    sender.sendMessage("Please enter a location name you wish to teleport Ex: /tp <LocationName>");
                } else if(args.length == 1){
                    String path = folder + player.getName() + ".txt";
                    try {
                        Scanner reader = new Scanner(new File(path));
                        String line = args[0] + " ";
                        String readLine = null;
                        while ((readLine = reader.nextLine()) != null && !readLine.contains(line)) {
                        }

                        String[] split = readLine.split(" ");
                        String worldType = split[1].replace("'", "");
                        double xCoord = Double.parseDouble(split[2]);
                        double yCoord = Double.parseDouble(split[3]);
                        double zCoord = Double.parseDouble(split[4]);

                        player.teleport(new Location((Bukkit.getWorld(worldType)), xCoord, yCoord, zCoord));

                    } catch (Exception e) {
                        sender.sendMessage("Location " + args[0] + " unknown");
                    }

                } else if(args.length == 2){
                    String path = folder + args[0] + ".txt";
                    try {
                        Scanner reader = new Scanner(new File(path));
                        String line = args[1] + " ";
                        String readLine = null;
                        while ((readLine = reader.nextLine()) != null && !readLine.contains(line)) {
                        }

                        String[] split = readLine.split(" ");
                        String worldType = split[1].replace("'", "");
                        double xCoord = Double.parseDouble(split[2]);
                        double yCoord = Double.parseDouble(split[3]);
                        double zCoord = Double.parseDouble(split[4]);

                        if(split[5].equals("public"))player.teleport(new Location((Bukkit.getWorld(worldType)), xCoord, yCoord, zCoord));
                        else sender.sendMessage("That is a private location");

                    } catch (Exception e) {
                        sender.sendMessage("Player '" + args[0] + "' does not have location '" +args[1]+"'");
                    }
                }

            } else if (cmd.getLabel().equalsIgnoreCase("teleglobal")) {
                if (args.length == 0) {
                    sender.sendMessage("Please enter a location name you wish to teleport Ex: /tp <LocationName>");
                } else {
                    String path = folder + "global.in";
                    try {
                        Scanner reader = new Scanner(new File(path));
                        String line = args[0] + " ";
                        String readLine = null;
                        while ((readLine = reader.nextLine()) != null && !readLine.contains(line)) {
                        }

                        String[] split = readLine.split(" ");
                        String worldType = split[1].replace("'", "");
                        double xCoord = Double.parseDouble(split[2]);
                        double yCoord = Double.parseDouble(split[3]);
                        double zCoord = Double.parseDouble(split[4]);

                        player.teleport(new Location((Bukkit.getWorld(worldType)), xCoord, yCoord, zCoord));

                    } catch (Exception e) {
                        sender.sendMessage("Location " + args[0] + " unknown");
                    }

                }

            } else if (cmd.getLabel().equalsIgnoreCase("setglobalhome")) {
                if (args.length == 0) {
                    sender.sendMessage("Please enter a name for the location Ex: /setglobalhome <LocationName>");
                } else {
                    Location loc = player.getLocation();
                    String content = "";
                    String path = folder + "global.in";
                    String data = args[0] + " '" + loc.getWorld().getName() + "' " + loc.getX() + " " + loc.getY() + " " + loc.getZ() + " public";
                    try {
                        rm(args[0], path);
                        content = new Scanner(new File(path)).useDelimiter("\\Z").next();
                        content = content + "\r\n" + data;

                    } catch (Exception e) {
                        //data = data;
                        content = data;
                    } finally {
                        try {
                            PrintWriter out = new PrintWriter(path);
                            out.print(content);
                            out.close();
                        } catch (FileNotFoundException e) {
                        }
                        sender.sendMessage("Location " + args[0] + " set");
                    }
                }
            } else if (cmd.getLabel().equalsIgnoreCase("printtele")) {
                try {
                    String path = folder + player.getName() + ".txt";
                    Scanner reader = new Scanner(new File(path));
                    int count = 1;
                    while (reader.hasNextLine()) {
                        String readLine = reader.nextLine();
                        String places = readLine.substring(0, readLine.indexOf(" "));
                        sender.sendMessage(count + ") " + places);
                        count++;
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                 else if (cmd.getLabel().equalsIgnoreCase("printglobal")) {
                try {
                    String path = folder + "global.in";
                    Scanner reader = new Scanner(new File(path));
                    int count = 1;
                    while (reader.hasNextLine()) {
                        String readLine = reader.nextLine();
                        String places = readLine.substring(0, readLine.indexOf(" "));
                        sender.sendMessage(count + ") " + places);
                        count++;
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }


            } else if (cmd.getLabel().equalsIgnoreCase("randomtele")) {
                File f = new File(folder);
                File[] a = f.listFiles();
                int search = 0;
                Random gen = new Random();
                ArrayList<Integer> array = new ArrayList<Integer>();
                for (int i = 0; i < a.length; i++) {
                    array.add(i);
                }
                Collections.shuffle(array);
                String content = "";
                int ran = -1;
                try {
                    while (search != a.length) {
                        ran = array.get(search);
                        content = new Scanner(a[ran]).useDelimiter("\\Z").next();
                        if (content.contains(" public")) {
                            break;
                        } else if (search == a.length - 1) {
                            ran = -1;
                            break;
                        }
                        search++;
                    }
                    if (ran == -1) {
                        sender.sendMessage("No Locations available");
                        return true;
                    }
                    String[] temp = content.split("\r\n");
                    ran = gen.nextInt(temp.length);
                    while (!temp[ran].contains(" public")) {
                        ran = gen.nextInt(temp.length);
                    }
                    String readLine = temp[ran];
                    String[] split = readLine.split(" ");
                    String worldType = split[1].replace("'", "");
                    double xCoord = Double.parseDouble(split[2]);
                    double yCoord = Double.parseDouble(split[3]);
                    double zCoord = Double.parseDouble(split[4]);

                    sender.sendMessage("Teleported to " + split[0]);
                    player.teleport(new Location((Bukkit.getWorld(worldType)), xCoord, yCoord, zCoord));

                } catch (Exception e) {
                    sender.sendMessage("Location " + args[0] + " unknown");
                }



            }
        }
        return true;
    }

    /* onEnable and onDisable get invoked when the server is started up, shut down, restarted...
     * In the console try doing a /reload
     */
    @Override
    public void onEnable() {
        getLogger().info(HELLO_MESSAGE);
        File direct = new File("plugins/Teleporter");
        direct.mkdir();
        try {
            Scanner in = new Scanner(new File(folder + "settings.set"));
            in.next();
            worldspawn = new Location(Bukkit.getWorld("world"), in.nextDouble(), in.nextDouble(), in.nextDouble());
            in.next();
            netherspawn = new Location(Bukkit.getWorld("world_nether"), in.nextDouble(), in.nextDouble(), in.nextDouble());
        } catch (FileNotFoundException e) {
            try {
                PrintWriter out = new PrintWriter(folder + "settings.set");
                String content = "world 0 0 0 nether 0 0 0";
                out.print(content);
                out.close();
            } catch (FileNotFoundException a) {
            }
        }
    }

    @Override
    public void onDisable() {
        getLogger().info(GOODBYE_MESSAGE);
    }

    public void logToFile(String message) {
        try {
            File dataFolder = getDataFolder();
            if (!dataFolder.exists()) {
                dataFolder.mkdir();
            }

            File saveTo = new File(getDataFolder(), "myplugin.log");
            if (!saveTo.exists()) {
                saveTo.createNewFile();
            }

            FileWriter fw = new FileWriter(saveTo, true);

            PrintWriter pw = new PrintWriter(fw);

            pw.println(message);
            pw.flush();
            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void rm(String remove, String path) throws FileNotFoundException {
        try {
            String content = new Scanner(new File(path)).useDelimiter("\\Z").next();
            int index = content.indexOf(remove + " ");
            if (index != -1) {
                int ind = content.indexOf("\r\n", index);
                if (ind != -1) {
                    content = content.substring(0, index) + content.substring(ind + 2);
                } else {
                    content = content.substring(0, index);
                }
            }
            //content = "world normal 1 2 3\ncavee nether 3 2 1\nhi normal 1 2 3\n";
            PrintWriter out = new PrintWriter(path);
            out.print(content);
            out.close();
        } catch (NoSuchElementException e) {
        }

    }
}
