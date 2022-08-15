/*
Brandon Haire
CS1181-Project01
Michelle Cheatham
 */
// package cs1181.haire.project01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class CS1181HaireProject01 {

    /**
     * This program tracks a player's progress towards Assault Rifle and
     * Submachine Gun camouflages in the 2019 game Call of Duty Modern Warfare.
     * It will save the data for both types of guns in the binary files Data.dat
     * and Data2.dat. It will prompt the user at first to choose to update gun
     * progress, see their progress, delete their progress, reset all progress,
     * see what challenges they have left, and quit the program (without
     * saving/writing out). The search functionality is in the what do i need
     * part and the statistic is in the see progress part.
     *
     * @param args
     */
    public static void main(String[] args) {
        //initialize variables and objects
        String ARfile = "Data.dat";
        String SMGfile = "Data2.dat";

        ArrayList<AssaultRifle> ARs = new ArrayList<AssaultRifle>();
        ArrayList<SMG> SMGs = new ArrayList();
       // ArrayList<cs1181.haire.project01.AssaultRifle> ARs = new ArrayList<cs1181.haire.project01.AssaultRifle>();


        AssaultRifle Kilo141 = new AssaultRifle();
        AssaultRifle FAL = new AssaultRifle();
        AssaultRifle M4A1 = new AssaultRifle();
        AssaultRifle FR556 = new AssaultRifle();
        AssaultRifle Oden = new AssaultRifle();
        AssaultRifle M13 = new AssaultRifle();
        AssaultRifle FNScar17 = new AssaultRifle();
        AssaultRifle AK47 = new AssaultRifle();
        SMG AUG = new SMG();
        SMG P90 = new SMG();
        SMG MP5 = new SMG();
        SMG Uzi = new SMG();
        SMG PP19Bizon = new SMG();
        SMG MP7 = new SMG();
        /*
        try to read in from binary file and if file doesnt exist/other exception occurs, 
        load array list with empty/new objects
         */

        try {
            ARs = loadAR(ARfile);
            SMGs = loadSMG(SMGfile);
            Kilo141 = ARs.get(0);
            FAL = ARs.get(1);
            M4A1 = ARs.get(2);
            FR556 = ARs.get(3);
            Oden = ARs.get(4);
            M13 = ARs.get(5);
            FNScar17 = ARs.get(6);
            AK47 = ARs.get(7);
            AUG = SMGs.get(0);
            P90 = SMGs.get(1);
            MP5 = SMGs.get(2);
            Uzi = SMGs.get(3);
            PP19Bizon = SMGs.get(4);
            MP7 = SMGs.get(5);
        } catch (FileNotFoundException e) {
            Kilo141 = new AssaultRifle();
            FAL = new AssaultRifle();
            M4A1 = new AssaultRifle();
            FR556 = new AssaultRifle();
            Oden = new AssaultRifle();
            M13 = new AssaultRifle();
            FNScar17 = new AssaultRifle();
            AK47 = new AssaultRifle();
            ARs.add(Kilo141);
            ARs.add(FAL);
            ARs.add(M4A1);
            ARs.add(FR556);
            ARs.add(Oden);
            ARs.add(M13);
            ARs.add(FNScar17);
            ARs.add(AK47);
            AUG = new SMG();
            P90 = new SMG();
            MP5 = new SMG();
            Uzi = new SMG();
            PP19Bizon = new SMG();
            MP7 = new SMG();
            SMGs.add(AUG);
            SMGs.add(P90);
            SMGs.add(MP5);
            SMGs.add(Uzi);
            SMGs.add(PP19Bizon);
            SMGs.add(MP7);
        } catch (IOException e) {
            Kilo141 = new AssaultRifle();
            FAL = new AssaultRifle();
            M4A1 = new AssaultRifle();
            FR556 = new AssaultRifle();
            Oden = new AssaultRifle();
            M13 = new AssaultRifle();
            FNScar17 = new AssaultRifle();
            AK47 = new AssaultRifle();
            ARs.add(Kilo141);
            ARs.add(FAL);
            ARs.add(M4A1);
            ARs.add(FR556);
            ARs.add(Oden);
            ARs.add(M13);
            ARs.add(FNScar17);
            ARs.add(AK47);
            AUG = new SMG();
            P90 = new SMG();
            MP5 = new SMG();
            Uzi = new SMG();
            PP19Bizon = new SMG();
            MP7 = new SMG();
            SMGs.add(AUG);
            SMGs.add(P90);
            SMGs.add(MP5);
            SMGs.add(Uzi);
            SMGs.add(PP19Bizon);
            SMGs.add(MP7);
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find the specified class in source files");
        }

    //    finish all guns for testing
        // Kilo141.finish();
        // FAL.finish();
        // M4A1.finish();
        // FR556.finish();
        // Oden.finish();
        // M13.finish();
        // FNScar17.finish();
        // AK47.finish();
        // AUG.finish();
        // P90.finish();
        // MP5.finish();
        // Uzi.finish();
        // MP7.finish();
        // PP19Bizon.finish();


        boolean done = false;
        int kills = 0;
        boolean error = true;
        Scanner keyboard = new Scanner(System.in);

        //main while loop for the "game" of the program (ends on line 2034)
        while (done == false) {
            System.out.println("Call of Duty Modern Warfare Gun Camouflage Challenge Tracker");
            System.out.printf("%s\t\t%s\n", "\"U\"=Update Challenges", "\"S\"=See Progress");
            System.out.printf("%s\t%s\n", "\"D\"=Delete Progress(admin)", "\"R\"=Restart Challenge");
            System.out.printf("%s\t%s\n", "\"W\"=What Do I Need?(search)", "\"Q\"=Quit");

            //string input validation through do while loop
            String choice = "";
            do {
                System.out.println("What would you like to do? (U)pdate, (S)ee progress, (D)elete, (R)estart, (W)hat's next, (Q)uit");
                choice = keyboard.next().toUpperCase();
            } while (!(choice.equals("U")) && (!(choice.equals("S")))
                    && (!(choice.equals("D"))) && (!(choice.equals("R"))) && (!(choice.equals("Q"))) && (!(choice.equals("W"))));

            //switch that controls all actions available for the user (ends on line 916)
            switch (choice) {
                case "U":
                    boolean stillUpdating = true;
                    System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    while (stillUpdating) {
                        System.out.printf("%s\t\t%s\t\t%s\n", "1 = Kilo 141", "2 = FAL", "3 = M4A1");
                        System.out.printf("%s\t\t%s\t%s\n", "4 = FR 5.56", "5 = Oden", "6 = M13");
                        System.out.printf("%s\t\t%s\n", "7 = FN Scar 17", "8 = AK-47");
                        System.out.printf("%s\t\t\t%s\t%s\n", "9 = AUG", "10 = P90", "11 = MP5");
                        System.out.printf("%s\t\t%s\t%s\n", "12 = Uzi", "13 = PP19 Bizon", "14 = MP7");
                        //random number determine what kills count for what category
                        Random rand = new Random();
                        int gunNum = 0;
                        //integer input validation through do while and try catch
                        do {
                            try {
                                System.out.println("What gun do you want to update?");
                                gunNum = keyboard.nextInt();
                                if (gunNum >= 1 && gunNum <= 14) {
                                    error = false;
                                } else {
                                    System.out.println("Please enter a number 1-14");
                                }
                            } catch (InputMismatchException e) {
                                System.out.printf("%s\n", "Please enter an integer");
                                keyboard.reset();
                                keyboard.next();
                            }
                        } while (error);
                        error = true;
                        switch (gunNum) {
                            case 1:
                                do {
                                    try {
                                        System.out.println("How many kills did you get with the Kilo 141?");
                                        kills = keyboard.nextInt();
                                        if (kills >= 0 && kills <= 800) {
                                            error = false;
                                        } else {
                                            System.out.println("Please answer honestly");
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.printf("%s\n", "Please enter an integer");
                                        keyboard.reset();
                                        keyboard.next();
                                    }
                                } while (error);
                                /*
                                Updates first category Spray Paint by number of kills and randomly
                                updates all other categories by number of kills
                                 */
                                Kilo141.incrementSprayPaint(kills);
                                for (int i = 0; i < kills; i++) {
                                    int randomPick = 2 + rand.nextInt(10);
                                    switch (randomPick) {
                                        case 2:
                                            Kilo141.incrementWoodland(1);
                                            break;
                                        case 3:
                                            Kilo141.incrementDigital(1);
                                            break;
                                        case 4:
                                            Kilo141.incrementDragon(1);
                                            break;
                                        case 5:
                                            Kilo141.incrementSplinter(1);
                                            break;
                                        case 6:
                                            Kilo141.incrementTopo(1);
                                            break;
                                        case 7:
                                            Kilo141.incrementTiger(1);
                                            break;
                                        case 8:
                                            Kilo141.incrementStripes(1);
                                            break;
                                        case 9:
                                            Kilo141.incrementReptile(1);
                                            break;
                                        case 10:
                                            Kilo141.incrementSkulls(1);
                                            break;
                                    }
                                }
                                break;
                            case 2:
                                do {
                                    try {
                                        System.out.println("How many kills did you get with the FAL?");
                                        kills = keyboard.nextInt();
                                        if (kills >= 0 && kills <= 800) {
                                            error = false;
                                        } else {
                                            System.out.println("Please answer honestly");
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.printf("%s\n", "Please enter an integer");
                                        keyboard.reset();
                                        keyboard.next();
                                    }
                                } while (error);
                                FAL.incrementSprayPaint(kills);
                                for (int i = 0; i < kills; i++) {
                                    int randomPick = 2 + rand.nextInt(10);
                                    switch (randomPick) {
                                        case 2:
                                            FAL.incrementWoodland(1);
                                            break;
                                        case 3:
                                            FAL.incrementDigital(1);
                                            break;
                                        case 4:
                                            FAL.incrementDragon(1);
                                            break;
                                        case 5:
                                            FAL.incrementSplinter(1);
                                            break;
                                        case 6:
                                            FAL.incrementTopo(1);
                                            break;
                                        case 7:
                                            FAL.incrementTiger(1);
                                            break;
                                        case 8:
                                            FAL.incrementStripes(1);
                                            break;
                                        case 9:
                                            FAL.incrementReptile(1);
                                            break;
                                        case 10:
                                            FAL.incrementSkulls(1);
                                            break;
                                    }
                                }
                                break;
                            case 3:
                                do {
                                    try {
                                        System.out.println("How many kills did you get with the M4A1?");
                                        kills = keyboard.nextInt();
                                        if (kills >= 0 && kills <= 800) {
                                            error = false;
                                        } else {
                                            System.out.println("Please answer honsetly");
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.printf("%s\n", "Please enter an integer");
                                        keyboard.reset();
                                        keyboard.next();
                                    }
                                } while (error);
                                M4A1.incrementSprayPaint(kills);
                                for (int i = 0; i < kills; i++) {
                                    int randomPick = 2 + rand.nextInt(10);
                                    switch (randomPick) {
                                        case 2:
                                            M4A1.incrementWoodland(1);
                                            break;
                                        case 3:
                                            M4A1.incrementDigital(1);
                                            break;
                                        case 4:
                                            M4A1.incrementDragon(1);
                                            break;
                                        case 5:
                                            M4A1.incrementSplinter(1);
                                            break;
                                        case 6:
                                            M4A1.incrementTopo(1);
                                            break;
                                        case 7:
                                            M4A1.incrementTiger(1);
                                            break;
                                        case 8:
                                            M4A1.incrementStripes(1);
                                            break;
                                        case 9:
                                            M4A1.incrementReptile(1);
                                            break;
                                        case 10:
                                            M4A1.incrementSkulls(1);
                                            break;
                                    }
                                }
                                break;
                            case 4:
                                do {
                                    try {
                                        System.out.println("How many kills did you get with the FR 5.56?");
                                        kills = keyboard.nextInt();
                                        if (kills >= 0 && kills <= 800) {
                                            error = false;
                                        } else {
                                            System.out.println("Please answer honestly");
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.printf("%s\n", "Please enter an integer");
                                        keyboard.reset();
                                        keyboard.next();
                                    }
                                } while (error);
                                FR556.incrementSprayPaint(kills);
                                for (int i = 0; i < kills; i++) {
                                    int randomPick = 2 + rand.nextInt(10);
                                    switch (randomPick) {
                                        case 2:
                                            FR556.incrementWoodland(1);
                                            break;
                                        case 3:
                                            FR556.incrementDigital(1);
                                            break;
                                        case 4:
                                            FR556.incrementDragon(1);
                                            break;
                                        case 5:
                                            FR556.incrementSplinter(1);
                                            break;
                                        case 6:
                                            FR556.incrementTopo(1);
                                            break;
                                        case 7:
                                            FR556.incrementTiger(1);
                                            break;
                                        case 8:
                                            FR556.incrementStripes(1);
                                            break;
                                        case 9:
                                            FR556.incrementReptile(1);
                                            break;
                                        case 10:
                                            FR556.incrementSkulls(1);
                                            break;
                                    }
                                }
                                break;
                            case 5:
                                do {
                                    try {
                                        System.out.println("How many kills did you get with the Oden?");
                                        kills = keyboard.nextInt();
                                        if (kills >= 0 & kills <= 800) {
                                            error = false;
                                        } else {
                                            System.out.println("Please answer honestly");
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.printf("%s\n", "Please enter an integer");
                                        keyboard.reset();
                                        keyboard.next();
                                    }
                                } while (error);
                                Oden.incrementSprayPaint(kills);
                                for (int i = 0; i < kills; i++) {
                                    int randomPick = 2 + rand.nextInt(10);
                                    switch (randomPick) {
                                        case 2:
                                            Oden.incrementWoodland(1);
                                            break;
                                        case 3:
                                            Oden.incrementDigital(1);
                                            break;
                                        case 4:
                                            Oden.incrementDragon(1);
                                            break;
                                        case 5:
                                            Oden.incrementSplinter(1);
                                            break;
                                        case 6:
                                            Oden.incrementTopo(1);
                                            break;
                                        case 7:
                                            Oden.incrementTiger(1);
                                            break;
                                        case 8:
                                            Oden.incrementStripes(1);
                                            break;
                                        case 9:
                                            Oden.incrementReptile(1);
                                            break;
                                        case 10:
                                            Oden.incrementSkulls(1);
                                            break;
                                    }
                                }
                                break;
                            case 6:
                                do {
                                    try {
                                        System.out.println("How many kills did you get with the M13?");
                                        kills = keyboard.nextInt();
                                        if (kills >= 0 & kills <= 800) {
                                            error = false;
                                        } else {
                                            System.out.println("Please answer honestly");
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.printf("%s\n", "Please enter an integer");
                                        keyboard.reset();
                                        keyboard.next();
                                    }
                                } while (error);
                                M13.incrementSprayPaint(kills);
                                for (int i = 0; i < kills; i++) {
                                    int randomPick = 2 + rand.nextInt(10);
                                    switch (randomPick) {
                                        case 2:
                                            M13.incrementWoodland(1);
                                            break;
                                        case 3:
                                            M13.incrementDigital(1);
                                            break;
                                        case 4:
                                            M13.incrementDragon(1);
                                            break;
                                        case 5:
                                            M13.incrementSplinter(1);
                                            break;
                                        case 6:
                                            M13.incrementTopo(1);
                                            break;
                                        case 7:
                                            M13.incrementTiger(1);
                                            break;
                                        case 8:
                                            M13.incrementStripes(1);
                                            break;
                                        case 9:
                                            M13.incrementReptile(1);
                                            break;
                                        case 10:
                                            M13.incrementSkulls(1);
                                            break;
                                    }
                                }
                                break;
                            case 7:
                                do {
                                    try {
                                        System.out.println("How many kills did you get with the FN Scar 17?");
                                        kills = keyboard.nextInt();
                                        if (kills >= 0 & kills <= 800) {
                                            error = false;
                                        } else {
                                            System.out.println("Please answer honestly");
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.printf("%s\n", "Please enter an integer");
                                        keyboard.reset();
                                        keyboard.next();
                                    }
                                } while (error);
                                FNScar17.incrementSprayPaint(kills);
                                for (int i = 0; i < kills; i++) {
                                    int randomPick = 2 + rand.nextInt(10);
                                    switch (randomPick) {
                                        case 2:
                                            FNScar17.incrementWoodland(1);
                                            break;
                                        case 3:
                                            FNScar17.incrementDigital(1);
                                            break;
                                        case 4:
                                            FNScar17.incrementDragon(1);
                                            break;
                                        case 5:
                                            FNScar17.incrementSplinter(1);
                                            break;
                                        case 6:
                                            FNScar17.incrementTopo(1);
                                            break;
                                        case 7:
                                            FNScar17.incrementTiger(1);
                                            break;
                                        case 8:
                                            FNScar17.incrementStripes(1);
                                            break;
                                        case 9:
                                            FNScar17.incrementReptile(1);
                                            break;
                                        case 10:
                                            FNScar17.incrementSkulls(1);
                                            break;
                                    }
                                }
                                break;
                            case 8:
                                do {
                                    try {
                                        System.out.println("How many kills did you get with the AK-47?");
                                        kills = keyboard.nextInt();
                                        if (kills >= 0 & kills <= 800) {
                                            error = false;
                                        } else {
                                            System.out.println("Please answer honestly");
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.printf("%s\n", "Please enter an integer");
                                        keyboard.reset();
                                        keyboard.next();
                                    }
                                } while (error);
                                AK47.incrementSprayPaint(kills);
                                for (int i = 0; i < kills; i++) {
                                    int randomPick = 2 + rand.nextInt(10);
                                    switch (randomPick) {
                                        case 2:
                                            AK47.incrementWoodland(1);
                                            break;
                                        case 3:
                                            AK47.incrementDigital(1);
                                            break;
                                        case 4:
                                            AK47.incrementDragon(1);
                                            break;
                                        case 5:
                                            AK47.incrementSplinter(1);
                                            break;
                                        case 6:
                                            AK47.incrementTopo(1);
                                            break;
                                        case 7:
                                            AK47.incrementTiger(1);
                                            break;
                                        case 8:
                                            AK47.incrementStripes(1);
                                            break;
                                        case 9:
                                            AK47.incrementReptile(1);
                                            break;
                                        case 10:
                                            AK47.incrementSkulls(1);
                                            break;
                                    }
                                }
                                break;
                            case 9:
                                do {
                                    try {
                                        System.out.println("How many kills did you get with the AUG?");
                                        kills = keyboard.nextInt();
                                        if (kills >= 0 & kills <= 800) {
                                            error = false;
                                        } else {
                                            System.out.println("Please answer honestly");
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.printf("%s\n", "Please enter an integer");
                                        keyboard.reset();
                                        keyboard.next();
                                    }
                                } while (error);
                                AUG.incrementSprayPaint(kills);
                                for (int i = 0; i < kills; i++) {
                                    int randomPick = 2 + rand.nextInt(10);
                                    switch (randomPick) {
                                        case 2:
                                            AUG.incrementWoodland(1);
                                            break;
                                        case 3:
                                            AUG.incrementDigital(1);
                                            break;
                                        case 4:
                                            AUG.incrementDragon(1);
                                            break;
                                        case 5:
                                            AUG.incrementSplinter(1);
                                            break;
                                        case 6:
                                            AUG.incrementTopo(1);
                                            break;
                                        case 7:
                                            AUG.incrementTiger(1);
                                            break;
                                        case 8:
                                            AUG.incrementStripes(1);
                                            break;
                                        case 9:
                                            AUG.incrementReptile(1);
                                            break;
                                        case 10:
                                            AUG.incrementSkulls(1);
                                            break;
                                    }
                                }
                                break;
                            case 10:
                                do {
                                    try {
                                        System.out.println("How many kills did you get with the P90?");
                                        kills = keyboard.nextInt();
                                        if (kills >= 0 & kills <= 800) {
                                            error = false;
                                        } else {
                                            System.out.println("Please answer honestly");
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.printf("%s\n", "Please enter an integer");
                                        keyboard.reset();
                                        keyboard.next();
                                    }
                                } while (error);
                                P90.incrementSprayPaint(kills);
                                for (int i = 0; i < kills; i++) {
                                    int randomPick = 2 + rand.nextInt(10);
                                    switch (randomPick) {
                                        case 2:
                                            P90.incrementWoodland(1);
                                            break;
                                        case 3:
                                            P90.incrementDigital(1);
                                            break;
                                        case 4:
                                            P90.incrementDragon(1);
                                            break;
                                        case 5:
                                            P90.incrementSplinter(1);
                                            break;
                                        case 6:
                                            P90.incrementTopo(1);
                                            break;
                                        case 7:
                                            P90.incrementTiger(1);
                                            break;
                                        case 8:
                                            P90.incrementStripes(1);
                                            break;
                                        case 9:
                                            P90.incrementReptile(1);
                                            break;
                                        case 10:
                                            P90.incrementSkulls(1);
                                            break;
                                    }
                                }
                                break;
                            case 11:
                                do {
                                    try {
                                        System.out.println("How many kills did you get with the MP5?");
                                        kills = keyboard.nextInt();
                                        if (kills >= 0 & kills <= 800) {
                                            error = false;
                                        } else {
                                            System.out.println("Please answer honestly");
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.printf("%s\n", "Please enter an integer");
                                        keyboard.reset();
                                        keyboard.next();
                                    }
                                } while (error);
                                MP5.incrementSprayPaint(kills);
                                for (int i = 0; i < kills; i++) {
                                    int randomPick = 2 + rand.nextInt(10);
                                    switch (randomPick) {
                                        case 2:
                                            MP5.incrementWoodland(1);
                                            break;
                                        case 3:
                                            MP5.incrementDigital(1);
                                            break;
                                        case 4:
                                            MP5.incrementDragon(1);
                                            break;
                                        case 5:
                                            MP5.incrementSplinter(1);
                                            break;
                                        case 6:
                                            MP5.incrementTopo(1);
                                            break;
                                        case 7:
                                            MP5.incrementTiger(1);
                                            break;
                                        case 8:
                                            MP5.incrementStripes(1);
                                            break;
                                        case 9:
                                            MP5.incrementReptile(1);
                                            break;
                                        case 10:
                                            MP5.incrementSkulls(1);
                                            break;
                                    }
                                }
                                break;
                            case 12:
                                do {
                                    try {
                                        System.out.println("How many kills did you get with the Uzi?");
                                        kills = keyboard.nextInt();
                                        if (kills >= 0 & kills <= 800) {
                                            error = false;
                                        } else {
                                            System.out.println("Please answer honestly");
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.printf("%s\n", "Please enter an integer");
                                        keyboard.reset();
                                        keyboard.next();
                                    }
                                } while (error);
                                Uzi.incrementSprayPaint(kills);
                                for (int i = 0; i < kills; i++) {
                                    int randomPick = 2 + rand.nextInt(10);
                                    switch (randomPick) {
                                        case 2:
                                            Uzi.incrementWoodland(1);
                                            break;
                                        case 3:
                                            Uzi.incrementDigital(1);
                                            break;
                                        case 4:
                                            Uzi.incrementDragon(1);
                                            break;
                                        case 5:
                                            Uzi.incrementSplinter(1);
                                            break;
                                        case 6:
                                            Uzi.incrementTopo(1);
                                            break;
                                        case 7:
                                            Uzi.incrementTiger(1);
                                            break;
                                        case 8:
                                            Uzi.incrementStripes(1);
                                            break;
                                        case 9:
                                            Uzi.incrementReptile(1);
                                            break;
                                        case 10:
                                            Uzi.incrementSkulls(1);
                                            break;
                                    }
                                }
                                break;
                            case 13:
                                do {
                                    try {
                                        System.out.println("How many kills did you get with the PP19 Bizon?");
                                        kills = keyboard.nextInt();
                                        if (kills >= 0 & kills <= 800) {
                                            error = false;
                                        } else {
                                            System.out.println("Please answer honestly");
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.printf("%s\n", "Please enter an integer");
                                        keyboard.reset();
                                        keyboard.next();
                                    }
                                } while (error);
                                PP19Bizon.incrementSprayPaint(kills);
                                for (int i = 0; i < kills; i++) {
                                    int randomPick = 2 + rand.nextInt(10);
                                    switch (randomPick) {
                                        case 2:
                                            PP19Bizon.incrementWoodland(1);
                                            break;
                                        case 3:
                                            PP19Bizon.incrementDigital(1);
                                            break;
                                        case 4:
                                            PP19Bizon.incrementDragon(1);
                                            break;
                                        case 5:
                                            PP19Bizon.incrementSplinter(1);
                                            break;
                                        case 6:
                                            PP19Bizon.incrementTopo(1);
                                            break;
                                        case 7:
                                            PP19Bizon.incrementTiger(1);
                                            break;
                                        case 8:
                                            PP19Bizon.incrementStripes(1);
                                            break;
                                        case 9:
                                            PP19Bizon.incrementReptile(1);
                                            break;
                                        case 10:
                                            PP19Bizon.incrementSkulls(1);
                                            break;
                                    }
                                }
                                break;
                            case 14:
                                do {
                                    try {
                                        System.out.println("How many kills did you get with the MP7?");
                                        kills = keyboard.nextInt();
                                        if (kills >= 0 & kills <= 800) {
                                            error = false;
                                        } else {
                                            System.out.println("Please answer honestly");
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.printf("%s\n", "Please enter an integer");
                                        keyboard.reset();
                                        keyboard.next();
                                    }
                                } while (error);
                                MP7.incrementSprayPaint(kills);
                                for (int i = 0; i < kills; i++) {
                                    int randomPick = 2 + rand.nextInt(10);
                                    switch (randomPick) {
                                        case 2:
                                            MP7.incrementWoodland(1);
                                            break;
                                        case 3:
                                            MP7.incrementDigital(1);
                                            break;
                                        case 4:
                                            MP7.incrementDragon(1);
                                            break;
                                        case 5:
                                            MP7.incrementSplinter(1);
                                            break;
                                        case 6:
                                            MP7.incrementTopo(1);
                                            break;
                                        case 7:
                                            MP7.incrementTiger(1);
                                            break;
                                        case 8:
                                            MP7.incrementStripes(1);
                                            break;
                                        case 9:
                                            MP7.incrementReptile(1);
                                            break;
                                        case 10:
                                            MP7.incrementSkulls(1);
                                            break;
                                    }
                                }
                                break;
                        }
                        String yesNo = "";
                        do {
                            System.out.println("Would you like to update another gun? (\"YES\" or \"NO\")");
                            yesNo = keyboard.next().toUpperCase();
                        } while (!(yesNo.equals("YES")) && !(yesNo.equals("NO")));
                        switch (yesNo) {
                            case "NO":
                                stillUpdating = false;
                                break;
                        }
                    }
                    System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    break;
                /*
                    Ouputs how many categories are completed for each gun and how close the 
                    user is to having all categories completed for every gun
                 */
                case "S":
                    System.out.println("Your Progress:");
                    boolean damascus = (Kilo141.isFinished() && FAL.isFinished() && M4A1.isFinished()
                            && FR556.isFinished() && Oden.isFinished() && M13.isFinished()
                            && FNScar17.isFinished() && AK47.isFinished() && AUG.isFinished()
                            && P90.isFinished() && MP5.isFinished() && Uzi.isFinished()
                            && PP19Bizon.isFinished() && MP7.isFinished());
                    if (damascus) {
                        System.out.println("You have successfully completed all Camo Challenges and earned the Damascus Camo");
                    } else {
                        System.out.printf("Gun\tCategory\n");
                        System.out.printf("%s\t%d/%d\n", "Kilo 141", Kilo141.getcategories(), 10);
                        System.out.printf("%s\t\t%d/%d\n", "FAL", FAL.getcategories(), 10);
                        System.out.printf("%s\t\t%d/%d\n", "M4A1", M4A1.getcategories(), 10);
                        System.out.printf("%s\t\t%d/%d\n", "FR 5.56", FR556.getcategories(), 10);
                        System.out.printf("%s\t\t%d/%d\n", "Oden", Oden.getcategories(), 10);
                        System.out.printf("%s\t\t%d/%d\n", "M13", M13.getcategories(), 10);
                        System.out.printf("%s\t%d/%d\n", "FN Scar 17", FNScar17.getcategories(), 10);
                        System.out.printf("%s\t\t%d/%d\n", "AK-47", AK47.getcategories(), 10);
                        System.out.printf("%s\t\t%d/%d\n", "AUG", AUG.getcategories(), 10);
                        System.out.printf("%s\t\t%d/%d\n", "P90", P90.getcategories(), 10);
                        System.out.printf("%s\t\t%d/%d\n", "MP5", MP5.getcategories(), 10);
                        System.out.printf("%s\t\t%d/%d\n", "Uzi", Uzi.getcategories(), 10);
                        System.out.printf("%s\t%d/%d\n", "PP19 Bizon", PP19Bizon.getcategories(), 10);
                        System.out.printf("%s\t\t%d/%d\n\n", "MP7", MP7.getcategories(), 10);
                        System.out.printf("You are %.2f", (((Kilo141.getcategories() + FAL.getcategories()
                                + M4A1.getcategories() + FR556.getcategories() + Oden.getcategories()
                                + M13.getcategories() + FNScar17.getcategories() + AK47.getcategories()
                                + AUG.getcategories() + P90.getcategories() + MP5.getcategories() + Uzi.getcategories()
                                + PP19Bizon.getcategories() + MP7.getcategories() + 0.0) / 140) * 100));
                        System.out.println("% done with your camo challenges");
                        System.out.println("");
                    }
                    break;

                /*
                    Deletes progress in the same way it was updated--removing initally from the 
                    first category and then randomly from the other categories (ends on line 1698)
                 */
                case "D":
                    System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You must be an Infinity Ward employee to delete player progress");
                    System.out.println("Please enter your Infinity Ward Employee ID:");
                    keyboard.next();
                    System.out.println("Password:");
                    keyboard.next();

                    System.out.printf("%s\t\t%s\t\t%s\n", "1 = Kilo 141", "2 = FAL", "3 = M4A1");
                    System.out.printf("%s\t\t%s\t%s\n", "4 = FR 5.56", "5 = Oden", "6 = M13");
                    System.out.printf("%s\t\t%s\n", "7 = FN Scar 17", "8 = AK-47");
                    System.out.printf("%s\t\t\t%s\t%s\n", "9 = AUG", "10 = P90", "11 = MP5");
                    System.out.printf("%s\t\t%s\t%s\n", "12 = Uzi", "13 = PP19 Bizon", "14 = MP7");
                    int gunNum = 0;
                    do {
                        try {
                            System.out.println("What gun do you want to manage?");
                            gunNum = keyboard.nextInt();
                            if (gunNum >= 1 && gunNum <= 14) {
                                error = false;
                            } else {
                                System.out.println("Please enter a number 1-14");
                            }
                        } catch (InputMismatchException e) {
                            System.out.printf("%s\n", "Please enter an integer");
                            keyboard.reset();
                            keyboard.next();
                        }
                    } while (error);
                    error = true;
                    Random rand = new Random();

                    switch (gunNum) {
                        case 1:
                            do {
                                try {
                                    System.out.println("How many kills are you removing from the Kilo 141?");
                                    kills = keyboard.nextInt();
                                    if (kills >= 0 & kills <= 800) {
                                        error = false;
                                    } else {
                                        System.out.println("Please answer honestly");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.printf("%s\n", "Please enter an integer");
                                    keyboard.reset();
                                    keyboard.next();
                                }
                            } while (error);
                            Kilo141.decrementSprayPaint(kills);
                            for (int i = 0; i < kills; i++) {
                                int randomPick = 2 + rand.nextInt(10);
                                switch (randomPick) {
                                    case 2:
                                        Kilo141.decrementWoodland(1);
                                        break;
                                    case 3:
                                        Kilo141.decrementDigital(1);
                                        break;
                                    case 4:
                                        Kilo141.decrementDragon(1);
                                        break;
                                    case 5:
                                        Kilo141.decrementSplinter(1);
                                        break;
                                    case 6:
                                        Kilo141.decrementTopo(1);
                                        break;
                                    case 7:
                                        Kilo141.decrementTiger(1);
                                        break;
                                    case 8:
                                        Kilo141.decrementStripes(1);
                                        break;
                                    case 9:
                                        Kilo141.decrementReptile(1);
                                        break;
                                    case 10:
                                        Kilo141.decrementSkulls(1);
                                        break;
                                }
                            }
                            break;
                        case 2:
                            do {
                                try {
                                    System.out.println("How many kills are you removing from the FAL?");
                                    kills = keyboard.nextInt();
                                    if (kills >= 0 & kills <= 800) {
                                        error = false;
                                    } else {
                                        System.out.println("Please answer honestly");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.printf("%s\n", "Please enter an integer");
                                    keyboard.reset();
                                    keyboard.next();
                                }
                            } while (error);
                            FAL.decrementSprayPaint(kills);
                            for (int i = 0; i < kills; i++) {
                                int randomPick = 2 + rand.nextInt(10);
                                switch (randomPick) {
                                    case 2:
                                        FAL.decrementWoodland(1);
                                        break;
                                    case 3:
                                        FAL.decrementDigital(1);
                                        break;
                                    case 4:
                                        FAL.decrementDragon(1);
                                        break;
                                    case 5:
                                        FAL.decrementSplinter(1);
                                        break;
                                    case 6:
                                        FAL.decrementTopo(1);
                                        break;
                                    case 7:
                                        FAL.decrementTiger(1);
                                        break;
                                    case 8:
                                        FAL.decrementStripes(1);
                                        break;
                                    case 9:
                                        FAL.decrementReptile(1);
                                        break;
                                    case 10:
                                        FAL.decrementSkulls(1);
                                        break;
                                }
                            }
                            break;
                        case 3:
                            do {
                                try {
                                    System.out.println("How many kills are you removing from the M4A1?");
                                    kills = keyboard.nextInt();
                                    if (kills >= 0 & kills <= 800) {
                                        error = false;
                                    } else {
                                        System.out.println("Please answer honestly");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.printf("%s\n", "Please enter an integer");
                                    keyboard.reset();
                                    keyboard.next();
                                }
                            } while (error);
                            M4A1.decrementSprayPaint(kills);
                            for (int i = 0; i < kills; i++) {
                                int randomPick = 2 + rand.nextInt(10);
                                switch (randomPick) {
                                    case 2:
                                        M4A1.decrementWoodland(1);
                                        break;
                                    case 3:
                                        M4A1.decrementDigital(1);
                                        break;
                                    case 4:
                                        M4A1.decrementDragon(1);
                                        break;
                                    case 5:
                                        M4A1.decrementSplinter(1);
                                        break;
                                    case 6:
                                        M4A1.decrementTopo(1);
                                        break;
                                    case 7:
                                        M4A1.decrementTiger(1);
                                        break;
                                    case 8:
                                        M4A1.decrementStripes(1);
                                        break;
                                    case 9:
                                        M4A1.decrementReptile(1);
                                        break;
                                    case 10:
                                        M4A1.decrementSkulls(1);
                                        break;
                                }
                            }
                            break;
                        case 4:
                            do {
                                try {
                                    System.out.println("How many kills are you removing from the FR 5.56?");
                                    kills = keyboard.nextInt();
                                    if (kills >= 0 & kills <= 800) {
                                        error = false;
                                    } else {
                                        System.out.println("Please answer honestly");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.printf("%s\n", "Please enter an integer");
                                    keyboard.reset();
                                    keyboard.next();
                                }
                            } while (error);
                            FR556.decrementSprayPaint(kills);
                            for (int i = 0; i < kills; i++) {
                                int randomPick = 2 + rand.nextInt(10);
                                switch (randomPick) {
                                    case 2:
                                        FR556.decrementWoodland(1);
                                        break;
                                    case 3:
                                        FR556.decrementDigital(1);
                                        break;
                                    case 4:
                                        FR556.decrementDragon(1);
                                        break;
                                    case 5:
                                        FR556.decrementSplinter(1);
                                        break;
                                    case 6:
                                        FR556.decrementTopo(1);
                                        break;
                                    case 7:
                                        FR556.decrementTiger(1);
                                        break;
                                    case 8:
                                        FR556.decrementStripes(1);
                                        break;
                                    case 9:
                                        FR556.decrementReptile(1);
                                        break;
                                    case 10:
                                        FR556.decrementSkulls(1);
                                        break;
                                }
                            }
                            break;
                        case 5:
                            do {
                                try {
                                    System.out.println("How many kills are you removing from the Oden?");
                                    kills = keyboard.nextInt();
                                    if (kills >= 0 & kills <= 800) {
                                        error = false;
                                    } else {
                                        System.out.println("Please answer honestly");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.printf("%s\n", "Please enter an integer");
                                    keyboard.reset();
                                    keyboard.next();
                                }
                            } while (error);
                            Oden.decrementSprayPaint(kills);
                            for (int i = 0; i < kills; i++) {
                                int randomPick = 2 + rand.nextInt(10);
                                switch (randomPick) {
                                    case 2:
                                        Oden.decrementWoodland(1);
                                        break;
                                    case 3:
                                        Oden.decrementDigital(1);
                                        break;
                                    case 4:
                                        Oden.decrementDragon(1);
                                        break;
                                    case 5:
                                        Oden.decrementSplinter(1);
                                        break;
                                    case 6:
                                        Oden.decrementTopo(1);
                                        break;
                                    case 7:
                                        Oden.decrementTiger(1);
                                        break;
                                    case 8:
                                        Oden.decrementStripes(1);
                                        break;
                                    case 9:
                                        Oden.decrementReptile(1);
                                        break;
                                    case 10:
                                        Oden.decrementSkulls(1);
                                        break;
                                }
                            }
                            break;
                        case 6:
                            do {
                                try {
                                    System.out.println("How many kills are you removing from the M13?");
                                    kills = keyboard.nextInt();
                                    if (kills >= 0 & kills <= 800) {
                                        error = false;
                                    } else {
                                        System.out.println("Please answer honestly");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.printf("%s\n", "Please enter an integer");
                                    keyboard.reset();
                                    keyboard.next();
                                }
                            } while (error);
                            M13.decrementSprayPaint(kills);
                            for (int i = 0; i < kills; i++) {
                                int randomPick = 2 + rand.nextInt(10);
                                switch (randomPick) {
                                    case 2:
                                        M13.decrementWoodland(1);
                                        break;
                                    case 3:
                                        M13.decrementDigital(1);
                                        break;
                                    case 4:
                                        M13.decrementDragon(1);
                                        break;
                                    case 5:
                                        M13.decrementSplinter(1);
                                        break;
                                    case 6:
                                        M13.decrementTopo(1);
                                        break;
                                    case 7:
                                        M13.decrementTiger(1);
                                        break;
                                    case 8:
                                        M13.decrementStripes(1);
                                        break;
                                    case 9:
                                        M13.decrementReptile(1);
                                        break;
                                    case 10:
                                        M13.decrementSkulls(1);
                                        break;
                                }
                            }
                            break;
                        case 7:
                            do {
                                try {
                                    System.out.println("How many kills are you removing from the FN Scar 17?");
                                    kills = keyboard.nextInt();
                                    if (kills >= 0 & kills <= 800) {
                                        error = false;
                                    } else {
                                        System.out.println("Please answer honestly");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.printf("%s\n", "Please enter an integer");
                                    keyboard.reset();
                                    keyboard.next();
                                }
                            } while (error);
                            FNScar17.decrementSprayPaint(kills);
                            for (int i = 0; i < kills; i++) {
                                int randomPick = 2 + rand.nextInt(10);
                                switch (randomPick) {
                                    case 2:
                                        FNScar17.decrementWoodland(1);
                                        break;
                                    case 3:
                                        FNScar17.decrementDigital(1);
                                        break;
                                    case 4:
                                        FNScar17.decrementDragon(1);
                                        break;
                                    case 5:
                                        FNScar17.decrementSplinter(1);
                                        break;
                                    case 6:
                                        FNScar17.decrementTopo(1);
                                        break;
                                    case 7:
                                        FNScar17.decrementTiger(1);
                                        break;
                                    case 8:
                                        FNScar17.decrementStripes(1);
                                        break;
                                    case 9:
                                        FNScar17.decrementReptile(1);
                                        break;
                                    case 10:
                                        FNScar17.decrementSkulls(1);
                                        break;
                                }
                            }
                            break;
                        case 8:
                            do {
                                try {
                                    System.out.println("How many kills are you removing from the AK-47?");
                                    kills = keyboard.nextInt();
                                    if (kills >= 0 & kills <= 800) {
                                        error = false;
                                    } else {
                                        System.out.println("Please answer honestly");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.printf("%s\n", "Please enter an integer");
                                    keyboard.reset();
                                    keyboard.next();
                                }
                            } while (error);
                            AK47.decrementSprayPaint(kills);
                            for (int i = 0; i < kills; i++) {
                                int randomPick = 2 + rand.nextInt(10);
                                switch (randomPick) {
                                    case 2:
                                        AK47.decrementWoodland(1);
                                        break;
                                    case 3:
                                        AK47.decrementDigital(1);
                                        break;
                                    case 4:
                                        AK47.decrementDragon(1);
                                        break;
                                    case 5:
                                        AK47.decrementSplinter(1);
                                        break;
                                    case 6:
                                        AK47.decrementTopo(1);
                                        break;
                                    case 7:
                                        AK47.decrementTiger(1);
                                        break;
                                    case 8:
                                        AK47.decrementStripes(1);
                                        break;
                                    case 9:
                                        AK47.decrementReptile(1);
                                        break;
                                    case 10:
                                        AK47.decrementSkulls(1);
                                        break;
                                }
                            }
                            break;
                        case 9:
                            do {
                                try {
                                    System.out.println("How many kills are you removing from the AUG?");
                                    kills = keyboard.nextInt();
                                    if (kills >= 0 & kills <= 800) {
                                        error = false;
                                    } else {
                                        System.out.println("Please answer honestly");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.printf("%s\n", "Please enter an integer");
                                    keyboard.reset();
                                    keyboard.next();
                                }
                            } while (error);
                            AUG.decrementSprayPaint(kills);
                            for (int i = 0; i < kills; i++) {
                                int randomPick = 2 + rand.nextInt(10);
                                switch (randomPick) {
                                    case 2:
                                        AUG.decrementWoodland(1);
                                        break;
                                    case 3:
                                        AUG.decrementDigital(1);
                                        break;
                                    case 4:
                                        AUG.decrementDragon(1);
                                        break;
                                    case 5:
                                        AUG.decrementSplinter(1);
                                        break;
                                    case 6:
                                        AUG.decrementTopo(1);
                                        break;
                                    case 7:
                                        AUG.decrementTiger(1);
                                        break;
                                    case 8:
                                        AUG.decrementStripes(1);
                                        break;
                                    case 9:
                                        AUG.decrementReptile(1);
                                        break;
                                    case 10:
                                        AUG.decrementSkulls(1);
                                        break;
                                }
                            }
                            break;
                        case 10:
                            do {
                                try {
                                    System.out.println("How many kills are you removing from the P90?");
                                    kills = keyboard.nextInt();
                                    if (kills >= 0 & kills <= 800) {
                                        error = false;
                                    } else {
                                        System.out.println("Please answer honestly");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.printf("%s\n", "Please enter an integer");
                                    keyboard.reset();
                                    keyboard.next();
                                }
                            } while (error);
                            P90.decrementSprayPaint(kills);
                            for (int i = 0; i < kills; i++) {
                                int randomPick = 2 + rand.nextInt(10);
                                switch (randomPick) {
                                    case 2:
                                        P90.decrementWoodland(1);
                                        break;
                                    case 3:
                                        P90.decrementDigital(1);
                                        break;
                                    case 4:
                                        P90.decrementDragon(1);
                                        break;
                                    case 5:
                                        P90.decrementSplinter(1);
                                        break;
                                    case 6:
                                        P90.decrementTopo(1);
                                        break;
                                    case 7:
                                        P90.decrementTiger(1);
                                        break;
                                    case 8:
                                        P90.decrementStripes(1);
                                        break;
                                    case 9:
                                        P90.decrementReptile(1);
                                        break;
                                    case 10:
                                        P90.decrementSkulls(1);
                                        break;
                                }
                            }
                            break;
                        case 11:
                            do {
                                try {
                                    System.out.println("How many kills are you removing from the MP5?");
                                    kills = keyboard.nextInt();
                                    if (kills >= 0 & kills <= 800) {
                                        error = false;
                                    } else {
                                        System.out.println("Please answer honestly");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.printf("%s\n", "Please enter an integer");
                                    keyboard.reset();
                                    keyboard.next();
                                }
                            } while (error);
                            MP5.decrementSprayPaint(kills);
                            for (int i = 0; i < kills; i++) {
                                int randomPick = 2 + rand.nextInt(10);
                                switch (randomPick) {
                                    case 2:
                                        MP5.decrementWoodland(1);
                                        break;
                                    case 3:
                                        MP5.decrementDigital(1);
                                        break;
                                    case 4:
                                        MP5.decrementDragon(1);
                                        break;
                                    case 5:
                                        MP5.decrementSplinter(1);
                                        break;
                                    case 6:
                                        MP5.decrementTopo(1);
                                        break;
                                    case 7:
                                        MP5.decrementTiger(1);
                                        break;
                                    case 8:
                                        MP5.decrementStripes(1);
                                        break;
                                    case 9:
                                        MP5.decrementReptile(1);
                                        break;
                                    case 10:
                                        MP5.decrementSkulls(1);
                                        break;
                                }
                            }
                            break;
                        case 12:
                            do {
                                try {
                                    System.out.println("How many kills are you removing from the Uzi?");
                                    kills = keyboard.nextInt();
                                    if (kills >= 0 & kills <= 800) {
                                        error = false;
                                    } else {
                                        System.out.println("Please answer honestly");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.printf("%s\n", "Please enter an integer");
                                    keyboard.reset();
                                    keyboard.next();
                                }
                            } while (error);
                            Uzi.decrementSprayPaint(kills);
                            for (int i = 0; i < kills; i++) {
                                int randomPick = 2 + rand.nextInt(10);
                                switch (randomPick) {
                                    case 2:
                                        Uzi.decrementWoodland(1);
                                        break;
                                    case 3:
                                        Uzi.decrementDigital(1);
                                        break;
                                    case 4:
                                        Uzi.decrementDragon(1);
                                        break;
                                    case 5:
                                        Uzi.decrementSplinter(1);
                                        break;
                                    case 6:
                                        Uzi.decrementTopo(1);
                                        break;
                                    case 7:
                                        Uzi.decrementTiger(1);
                                        break;
                                    case 8:
                                        Uzi.decrementStripes(1);
                                        break;
                                    case 9:
                                        Uzi.decrementReptile(1);
                                        break;
                                    case 10:
                                        Uzi.decrementSkulls(1);
                                        break;
                                }
                            }
                            break;
                        case 13:
                            do {
                                try {
                                    System.out.println("How many kills are you removing from the PP19 Bizon?");
                                    kills = keyboard.nextInt();
                                    if (kills >= 0 & kills <= 800) {
                                        error = false;
                                    } else {
                                        System.out.println("Please answer honestly");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.printf("%s\n", "Please enter an integer");
                                    keyboard.reset();
                                    keyboard.next();
                                }
                            } while (error);
                            PP19Bizon.decrementSprayPaint(kills);
                            for (int i = 0; i < kills; i++) {
                                int randomPick = 2 + rand.nextInt(10);
                                switch (randomPick) {
                                    case 2:
                                        PP19Bizon.decrementWoodland(1);
                                        break;
                                    case 3:
                                        PP19Bizon.decrementDigital(1);
                                        break;
                                    case 4:
                                        PP19Bizon.decrementDragon(1);
                                        break;
                                    case 5:
                                        PP19Bizon.decrementSplinter(1);
                                        break;
                                    case 6:
                                        PP19Bizon.decrementTopo(1);
                                        break;
                                    case 7:
                                        PP19Bizon.decrementTiger(1);
                                        break;
                                    case 8:
                                        PP19Bizon.decrementStripes(1);
                                        break;
                                    case 9:
                                        PP19Bizon.decrementReptile(1);
                                        break;
                                    case 10:
                                        PP19Bizon.decrementSkulls(1);
                                        break;
                                }
                            }
                            break;
                        case 14:
                            do {
                                try {
                                    System.out.println("How many kills are you removing from the MP7?");
                                    kills = keyboard.nextInt();
                                    if (kills >= 0 & kills <= 800) {
                                        error = false;
                                    } else {
                                        System.out.println("Please answer honestly");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.printf("%s\n", "Please enter an integer");
                                    keyboard.reset();
                                    keyboard.next();
                                }
                            } while (error);
                            MP7.decrementSprayPaint(kills);
                            for (int i = 0; i < kills; i++) {
                                int randomPick = 2 + rand.nextInt(10);
                                switch (randomPick) {
                                    case 2:
                                        MP7.decrementWoodland(1);
                                        break;
                                    case 3:
                                        MP7.decrementDigital(1);
                                        break;
                                    case 4:
                                        MP7.decrementDragon(1);
                                        break;
                                    case 5:
                                        MP7.decrementSplinter(1);
                                        break;
                                    case 6:
                                        MP7.decrementTopo(1);
                                        break;
                                    case 7:
                                        MP7.decrementTiger(1);
                                        break;
                                    case 8:
                                        MP7.decrementStripes(1);
                                        break;
                                    case 9:
                                        MP7.decrementReptile(1);
                                        break;
                                    case 10:
                                        MP7.decrementSkulls(1);
                                        break;
                                }
                            }
                            break;
                    }
                    break;

                //Resets all of player progress by resetting all of the category fields in all objects
                case "R":
                    String yesNo = "";
                    do {
                        System.out.println("Are you sure you want to reset all of your progress? (\"YES\" or \"NO\")");
                        yesNo = keyboard.next().toUpperCase();
                    } while (!(yesNo.equals("YES")) && !(yesNo.equals("NO")));
                    switch (yesNo) {
                        case "YES":
                            System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            yesNo = "";
                            do {
                                System.out.println("DUDE THERE'S NO GOING BACK AFTER THIS ARE YOU SURE? (\"YES\" or \"NO\")");
                                yesNo = keyboard.next().toUpperCase();
                            } while (!(yesNo.equals("YES")) && !(yesNo.equals("NO")));
                            switch (yesNo) {
                                case "YES":
                                    System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                    Kilo141.reset();
                                    FAL.reset();
                                    M4A1.reset();
                                    FR556.reset();
                                    Oden.reset();
                                    M13.reset();
                                    FNScar17.reset();
                                    AK47.reset();
                                    AUG.reset();
                                    P90.reset();
                                    MP5.reset();
                                    Uzi.reset();
                                    PP19Bizon.reset();
                                    MP7.reset();
                                    damascus = false;
                                    System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                    System.out.println("Your'e progress has been completely reset");
                                    break;
                            }
                            break;
                    }
                    break;
                /*
                    search functionality of program. uses user string input to find which gun the user wants to see and shows what 
                    challenges they need to complete with the gun (ends on line 2002)
                 */
                case "W":
                    boolean stillSearching = true;
                    while (stillSearching) {
                        System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        String search;
                        System.out.printf("%s\t%s\t%s\n", "Kilo 141", "FAL", "M4A1");
                        System.out.printf("%s\t\t%s\t%s\n", "FR 5.56", "Oden", "M13");
                        System.out.printf("%s\t%s\t%s\n", "FN Scar 17", "AK-47", "AUG");
                        System.out.printf("%s\t\t%s\t%s\n", "P90", "MP5", "Uzi");
                        System.out.printf("%s\t%s\n", "PP19 Bizon", "MP7");
                        keyboard.nextLine();
                        search = keyboard.nextLine().toUpperCase();
                        boolean stillPrompting = true;
                        while (stillPrompting) {
                            switch (search) {
                                case "KILO 141":
                                    System.out.println("Kilo 141");
                                    System.out.printf("You need:\n%d more kills\n%d more headshots\n%d more kills while crouching"
                                            + "\n%d more hipfire kills\n%d more longshots\n%d more mounted kills\n%d more kills w"
                                            + "ith 5 attachments\n%d more kills shortly after reloading\n%d more kills with no att"
                                            + "achments\n%d more 3-killstreaks\n", (800 - Kilo141.getSpraypaint()), (125 - Kilo141.getWoodland()),
                                            (160 - Kilo141.getDigital()), (75 - Kilo141.getDragon()), (100 - Kilo141.getSplinter()),
                                            (100 - Kilo141.getTopo()), (180 - Kilo141.getTiger()), (50 - Kilo141.getStripes()),
                                            (110 - Kilo141.getReptile()), (35 - Kilo141.getSkulls()));
                                    stillPrompting = false;
                                    break;
                                case "KILO141":
                                    System.out.println("Kilo 141");
                                    System.out.printf("You need:\n%d more kills\n%d more headshots\n%d more kills while crouching"
                                            + "\n%d more hipfire kills\n%d more longshots\n%d more mounted kills\n%d more kills w"
                                            + "ith 5 attachments\n%d more kills shortly after reloading\n%d more kills with no att"
                                            + "achments\n%d more 3-killstreaks\n", (800 - Kilo141.getSpraypaint()), (125 - Kilo141.getWoodland()),
                                            (160 - Kilo141.getDigital()), (75 - Kilo141.getDragon()), (100 - Kilo141.getSplinter()),
                                            (100 - Kilo141.getTopo()), (180 - Kilo141.getTiger()), (50 - Kilo141.getStripes()),
                                            (110 - Kilo141.getReptile()), (35 - Kilo141.getSkulls()));
                                    stillPrompting = false;
                                    break;
                                case "KILO":
                                    System.out.println("Kilo 141");
                                    System.out.printf("You need:\n%d more kills\n%d more headshots\n%d more kills while crouching"
                                            + "\n%d more hipfire kills\n%d more longshots\n%d more mounted kills\n%d more kills w"
                                            + "ith 5 attachments\n%d more kills shortly after reloading\n%d more kills with no att"
                                            + "achments\n%d more 3-killstreaks\n", (800 - Kilo141.getSpraypaint()), (125 - Kilo141.getWoodland()),
                                            (160 - Kilo141.getDigital()), (75 - Kilo141.getDragon()), (100 - Kilo141.getSplinter()),
                                            (100 - Kilo141.getTopo()), (180 - Kilo141.getTiger()), (50 - Kilo141.getStripes()),
                                            (110 - Kilo141.getReptile()), (35 - Kilo141.getSkulls()));
                                    stillPrompting = false;
                                    break;
                                case "FAL":
                                    System.out.println("FAL");
                                    System.out.printf("You need:\n%d more kills\n%d more headshots\n%d more kills while crouching"
                                            + "\n%d more hipfire kills\n%d more longshots\n%d more mounted kills\n%d more kills w"
                                            + "ith 5 attachments\n%d more kills shortly after reloading\n%d more kills with no att"
                                            + "achments\n%d more 3-killstreaks\n", (800 - FAL.getSpraypaint()), (125 - FAL.getWoodland()),
                                            (160 - FAL.getDigital()), (75 - FAL.getDragon()), (100 - FAL.getSplinter()),
                                            (100 - FAL.getTopo()), (180 - FAL.getTiger()), (50 - FAL.getStripes()),
                                            (110 - FAL.getReptile()), (35 - FAL.getSkulls()));
                                    stillPrompting = false;
                                    break;
                                case "M4A1":
                                    System.out.println("M4A1");
                                    System.out.printf("You need:\n%d more kills\n%d more headshots\n%d more kills while crouching"
                                            + "\n%d more hipfire kills\n%d more longshots\n%d more mounted kills\n%d more kills w"
                                            + "ith 5 attachments\n%d more kills shortly after reloading\n%d more kills with no att"
                                            + "achments\n%d more 3-killstreaks\n", (800 - M4A1.getSpraypaint()), (125 - M4A1.getWoodland()),
                                            (160 - M4A1.getDigital()), (75 - M4A1.getDragon()), (100 - M4A1.getSplinter()),
                                            (100 - M4A1.getTopo()), (180 - M4A1.getTiger()), (50 - M4A1.getStripes()),
                                            (110 - M4A1.getReptile()), (35 - M4A1.getSkulls()));
                                    stillPrompting = false;
                                    break;
                                case "FR 5.56":
                                    System.out.println("FR 5.56");
                                    System.out.printf("You need:\n%d more kills\n%d more headshots\n%d more kills while crouching"
                                            + "\n%d more hipfire kills\n%d more longshots\n%d more mounted kills\n%d more kills w"
                                            + "ith 5 attachments\n%d more kills shortly after reloading\n%d more kills with no att"
                                            + "achments\n%d more 3-killstreaks\n", (800 - FR556.getSpraypaint()), (125 - FR556.getWoodland()),
                                            (160 - FR556.getDigital()), (75 - FR556.getDragon()), (100 - FR556.getSplinter()),
                                            (100 - FR556.getTopo()), (180 - FR556.getTiger()), (50 - FR556.getStripes()),
                                            (110 - FR556.getReptile()), (35 - FR556.getSkulls()));
                                    stillPrompting = false;
                                    break;
                                case "FR5.56":
                                    System.out.println("FR 5.56");
                                    System.out.printf("You need:\n%d more kills\n%d more headshots\n%d more kills while crouching"
                                            + "\n%d more hipfire kills\n%d more longshots\n%d more mounted kills\n%d more kills w"
                                            + "ith 5 attachments\n%d more kills shortly after reloading\n%d more kills with no att"
                                            + "achments\n%d more 3-killstreaks\n", (800 - FR556.getSpraypaint()), (125 - FR556.getWoodland()),
                                            (160 - FR556.getDigital()), (75 - FR556.getDragon()), (100 - FR556.getSplinter()),
                                            (100 - FR556.getTopo()), (180 - FR556.getTiger()), (50 - FR556.getStripes()),
                                            (110 - FR556.getReptile()), (35 - FR556.getSkulls()));
                                    stillPrompting = false;
                                    break;
                                case "FR556":
                                    System.out.println("FR 5.56");
                                    System.out.printf("You need:\n%d more kills\n%d more headshots\n%d more kills while crouching"
                                            + "\n%d more hipfire kills\n%d more longshots\n%d more mounted kills\n%d more kills w"
                                            + "ith 5 attachments\n%d more kills shortly after reloading\n%d more kills with no att"
                                            + "achments\n%d more 3-killstreaks\n", (800 - FR556.getSpraypaint()), (125 - FR556.getWoodland()),
                                            (160 - FR556.getDigital()), (75 - FR556.getDragon()), (100 - FR556.getSplinter()),
                                            (100 - FR556.getTopo()), (180 - FR556.getTiger()), (50 - FR556.getStripes()),
                                            (110 - FR556.getReptile()), (35 - FR556.getSkulls()));
                                    stillPrompting = false;
                                    break;
                                case "ODEN":
                                    System.out.println("Oden");
                                    System.out.printf("You need:\n%d more kills\n%d more headshots\n%d more kills while crouching"
                                            + "\n%d more hipfire kills\n%d more longshots\n%d more mounted kills\n%d more kills w"
                                            + "ith 5 attachments\n%d more kills shortly after reloading\n%d more kills with no att"
                                            + "achments\n%d more 3-killstreaks\n", (800 - Oden.getSpraypaint()), (125 - Oden.getWoodland()),
                                            (160 - Oden.getDigital()), (75 - Oden.getDragon()), (100 - Oden.getSplinter()),
                                            (100 - Oden.getTopo()), (180 - Oden.getTiger()), (50 - Oden.getStripes()),
                                            (110 - Oden.getReptile()), (35 - Oden.getSkulls()));
                                    stillPrompting = false;
                                    break;
                                case "M13":
                                    System.out.println("M13");
                                    System.out.printf("You need:\n%d more kills\n%d more headshots\n%d more kills while crouching"
                                            + "\n%d more hipfire kills\n%d more longshots\n%d more mounted kills\n%d more kills w"
                                            + "ith 5 attachments\n%d more kills shortly after reloading\n%d more kills with no att"
                                            + "achments\n%d more 3-killstreaks\n", (800 - M13.getSpraypaint()), (125 - M13.getWoodland()),
                                            (160 - M13.getDigital()), (75 - M13.getDragon()), (100 - M13.getSplinter()),
                                            (100 - M13.getTopo()), (180 - M13.getTiger()), (50 - M13.getStripes()),
                                            (110 - M13.getReptile()), (35 - M13.getSkulls()));
                                    stillPrompting = false;
                                    break;
                                case "FN SCAR 17":
                                    System.out.println("FN Scar 17");
                                    System.out.printf("You need:\n%d more kills\n%d more headshots\n%d more kills while crouching"
                                            + "\n%d more hipfire kills\n%d more longshots\n%d more mounted kills\n%d more kills w"
                                            + "ith 5 attachments\n%d more kills shortly after reloading\n%d more kills with no att"
                                            + "achments\n%d more 3-killstreaks\n", (800 - FNScar17.getSpraypaint()), (125 - FNScar17.getWoodland()),
                                            (160 - FNScar17.getDigital()), (75 - FNScar17.getDragon()), (100 - FNScar17.getSplinter()),
                                            (100 - FNScar17.getTopo()), (180 - FNScar17.getTiger()), (50 - FNScar17.getStripes()),
                                            (110 - FNScar17.getReptile()), (35 - FNScar17.getSkulls()));
                                    stillPrompting = false;
                                    break;
                                case "FNSCAR17":
                                    System.out.println("FN Scar 17");
                                    System.out.printf("You need:\n%d more kills\n%d more headshots\n%d more kills while crouching"
                                            + "\n%d more hipfire kills\n%d more longshots\n%d more mounted kills\n%d more kills w"
                                            + "ith 5 attachments\n%d more kills shortly after reloading\n%d more kills with no att"
                                            + "achments\n%d more 3-killstreaks\n", (800 - FNScar17.getSpraypaint()), (125 - FNScar17.getWoodland()),
                                            (160 - FNScar17.getDigital()), (75 - FNScar17.getDragon()), (100 - FNScar17.getSplinter()),
                                            (100 - FNScar17.getTopo()), (180 - FNScar17.getTiger()), (50 - FNScar17.getStripes()),
                                            (110 - FNScar17.getReptile()), (35 - FNScar17.getSkulls()));
                                    stillPrompting = false;
                                    break;
                                case "AK-47":
                                    System.out.println("AK-47");
                                    System.out.printf("You need:\n%d more kills\n%d more headshots\n%d more kills while crouching"
                                            + "\n%d more hipfire kills\n%d more longshots\n%d more mounted kills\n%d more kills w"
                                            + "ith 5 attachments\n%d more kills shortly after reloading\n%d more kills with no att"
                                            + "achments\n%d more 3-killstreaks\n", (800 - AK47.getSpraypaint()), (125 - AK47.getWoodland()),
                                            (160 - AK47.getDigital()), (75 - AK47.getDragon()), (100 - AK47.getSplinter()),
                                            (100 - AK47.getTopo()), (180 - AK47.getTiger()), (50 - AK47.getStripes()),
                                            (110 - AK47.getReptile()), (35 - AK47.getSkulls()));
                                    stillPrompting = false;
                                    break;
                                case "AK47":
                                    System.out.println("AK-47");
                                    System.out.printf("You need:\n%d more kills\n%d more headshots\n%d more kills while crouching"
                                            + "\n%d more hipfire kills\n%d more longshots\n%d more mounted kills\n%d more kills w"
                                            + "ith 5 attachments\n%d more kills shortly after reloading\n%d more kills with no att"
                                            + "achments\n%d more 3-killstreaks\n", (800 - AK47.getSpraypaint()), (125 - AK47.getWoodland()),
                                            (160 - AK47.getDigital()), (75 - AK47.getDragon()), (100 - AK47.getSplinter()),
                                            (100 - AK47.getTopo()), (180 - AK47.getTiger()), (50 - AK47.getStripes()),
                                            (110 - AK47.getReptile()), (35 - AK47.getSkulls()));
                                    stillPrompting = false;
                                    break;
                                case "AUG":
                                    System.out.println("AUG");
                                    System.out.printf("You need:\n%d more kills\n%d more headshots\n%d more kills while crouching"
                                            + "\n%d more hipfire kills\n%d more longshots\n%d more mounted kills\n%d more kills w"
                                            + "ith 5 attachments\n%d more kills shortly after reloading\n%d more kills with no att"
                                            + "achments\n%d more 3-killstreaks\n", (500 - AUG.getSpraypaint()), (100 - AUG.getWoodland()),
                                            (110 - AUG.getDigital()), (100 - AUG.getDragon()), (50 - AUG.getSplinter()),
                                            (50 - AUG.getTopo()), (250 - AUG.getTiger()), (40 - AUG.getStripes()),
                                            (75 - AUG.getReptile()), (25 - AUG.getSkulls()));
                                    stillPrompting = false;
                                    break;
                                case "P90":
                                    System.out.println("P90");
                                    System.out.printf("You need:\n%d more kills\n%d more headshots\n%d more kills while crouching"
                                            + "\n%d more hipfire kills\n%d more longshots\n%d more mounted kills\n%d more kills w"
                                            + "ith 5 attachments\n%d more kills shortly after reloading\n%d more kills with no att"
                                            + "achments\n%d more 3-killstreaks\n", (500 - P90.getSpraypaint()), (100 - P90.getWoodland()),
                                            (110 - P90.getDigital()), (100 - P90.getDragon()), (50 - P90.getSplinter()),
                                            (50 - P90.getTopo()), (250 - P90.getTiger()), (40 - P90.getStripes()),
                                            (75 - P90.getReptile()), (25 - P90.getSkulls()));
                                    stillPrompting = false;
                                    break;
                                case "MP5":
                                    System.out.println("MP5");
                                    System.out.printf("You need:\n%d more kills\n%d more headshots\n%d more kills while crouching"
                                            + "\n%d more hipfire kills\n%d more longshots\n%d more mounted kills\n%d more kills w"
                                            + "ith 5 attachments\n%d more kills shortly after reloading\n%d more kills with no att"
                                            + "achments\n%d more 3-killstreaks\n", (500 - MP5.getSpraypaint()), (100 - MP5.getWoodland()),
                                            (110 - MP5.getDigital()), (100 - MP5.getDragon()), (50 - MP5.getSplinter()),
                                            (50 - MP5.getTopo()), (250 - MP5.getTiger()), (40 - MP5.getStripes()),
                                            (75 - MP5.getReptile()), (25 - MP5.getSkulls()));
                                    stillPrompting = false;
                                    break;
                                case "UZI":
                                    System.out.println("Uzi");
                                    System.out.printf("You need:\n%d more kills\n%d more headshots\n%d more kills while crouching"
                                            + "\n%d more hipfire kills\n%d more longshots\n%d more mounted kills\n%d more kills w"
                                            + "ith 5 attachments\n%d more kills shortly after reloading\n%d more kills with no att"
                                            + "achments\n%d more 3-killstreaks\n", (500 - Uzi.getSpraypaint()), (100 - Uzi.getWoodland()),
                                            (110 - Uzi.getDigital()), (100 - Uzi.getDragon()), (50 - Uzi.getSplinter()),
                                            (50 - Uzi.getTopo()), (250 - Uzi.getTiger()), (40 - Uzi.getStripes()),
                                            (75 - Uzi.getReptile()), (25 - Uzi.getSkulls()));
                                    stillPrompting = false;
                                    break;
                                case "PP19 BIZON":
                                    System.out.println("PP19 Bizon");
                                    System.out.printf("You need:\n%d more kills\n%d more headshots\n%d more kills while crouching"
                                            + "\n%d more hipfire kills\n%d more longshots\n%d more mounted kills\n%d more kills w"
                                            + "ith 5 attachments\n%d more kills shortly after reloading\n%d more kills with no att"
                                            + "achments\n%d more 3-killstreaks\n", (500 - PP19Bizon.getSpraypaint()), (100 - PP19Bizon.getWoodland()),
                                            (110 - PP19Bizon.getDigital()), (100 - PP19Bizon.getDragon()), (50 - PP19Bizon.getSplinter()),
                                            (50 - PP19Bizon.getTopo()), (250 - PP19Bizon.getTiger()), (40 - PP19Bizon.getStripes()),
                                            (75 - PP19Bizon.getReptile()), (25 - PP19Bizon.getSkulls()));
                                    stillPrompting = false;
                                    break;
                                case "PP19BIZON":
                                    System.out.println("PP19 Bizon");
                                    System.out.printf("You need:\n%d more kills\n%d more headshots\n%d more kills while crouching"
                                            + "\n%d more hipfire kills\n%d more longshots\n%d more mounted kills\n%d more kills w"
                                            + "ith 5 attachments\n%d more kills shortly after reloading\n%d more kills with no att"
                                            + "achments\n%d more 3-killstreaks\n", (500 - PP19Bizon.getSpraypaint()), (100 - PP19Bizon.getWoodland()),
                                            (110 - PP19Bizon.getDigital()), (100 - PP19Bizon.getDragon()), (50 - PP19Bizon.getSplinter()),
                                            (50 - PP19Bizon.getTopo()), (250 - PP19Bizon.getTiger()), (40 - PP19Bizon.getStripes()),
                                            (75 - PP19Bizon.getReptile()), (25 - PP19Bizon.getSkulls()));
                                    stillPrompting = false;
                                    break;
                                case "MP7":
                                    System.out.println("MP7");
                                    System.out.printf("You need:\n%d more kills\n%d more headshots\n%d more kills while crouching"
                                            + "\n%d more hipfire kills\n%d more longshots\n%d more mounted kills\n%d more kills w"
                                            + "ith 5 attachments\n%d more kills shortly after reloading\n%d more kills with no att"
                                            + "achments\n%d more 3-killstreaks\n", (500 - MP7.getSpraypaint()), (100 - MP7.getWoodland()),
                                            (110 - MP7.getDigital()), (100 - MP7.getDragon()), (50 - MP7.getSplinter()),
                                            (50 - MP7.getTopo()), (250 - MP7.getTiger()), (40 - MP7.getStripes()),
                                            (75 - MP7.getReptile()), (25 - MP7.getSkulls()));
                                    stillPrompting = false;
                                    break;
                                default:
                                    System.out.println("Watch your spelling buddy");
                                    stillPrompting = false;
                                    break;
                            }

                        }
                        stillSearching = false;
                    }
                    break;

                //Force quits the program without writing any information to the binary files
                case "Q":
                    yesNo = "";
                    do {
                        System.out.println("Are you sure you want to Quit? \nYour data will not be saved (\"YES\" or \"NO\")");
                        yesNo = keyboard.next().toUpperCase();
                    } while (!(yesNo.equals("YES")) && !(yesNo.equals("NO")));
                    switch (yesNo) {
                        case "YES":
                            System.exit(0);
                            break;
                        case "NO":
                            System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            break;
                    }
                    break;
            }
            String yesNo = "";
            do {
                System.out.println("Would you like to do anything else? (\"YES\" or \"NO\")");
                yesNo = keyboard.next().toUpperCase();
            } while (!(yesNo.equals("YES")) && !(yesNo.equals("NO")));
            switch (yesNo) {
                case "YES":
                    System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    break;
                case "NO":
                    done = true;
                    break;
            }
        }//end of big while loop
        
        //tries to write out the information of the assault rifles and submachine guns
        try {
            System.out.println("Writing to binary files...");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(ARfile)));
            oos.writeObject(ARs);
            oos.close();
        } catch (Exception e) {
            System.out.println("Error with AR save file");
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(SMGfile)));
            oos.writeObject(SMGs);
            oos.close();
        } catch (Exception e) {
            System.out.println("Error with  SMG save file");
        }

    }
/**
 * This method takes in a filename as an argument and returns an arraylist of the AssaultRifle class from the given binary filename
 * @param filename
 * @return
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ClassNotFoundException 
 */
    public static ArrayList<AssaultRifle> loadAR(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File(filename)));
        ArrayList<AssaultRifle> temp = (ArrayList<AssaultRifle>) ois.readObject();
        ois.close();
        return temp;
    }

    /**
     * This method takes in a filename as an argument and returns an arraylist of the SMG class from the given binary filename
     * @param filename
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException e
     */
    public static ArrayList<SMG> loadSMG(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File(filename)));
        ArrayList<SMG> temp = (ArrayList<SMG>) ois.readObject();
        ois.close();
        return temp;
    }
}



class AssaultRifle implements Serializable {

    private boolean finished = false;
    private int categories;
    private int SprayPaint;
    boolean DoneSprayPaint = false;
    private int Woodland;
    boolean DoneWoodland = false;
    private int Digital;
    boolean DoneDigital = false;
    private int Dragon;
    boolean DoneDragon = false;
    private int Splinter;
    boolean DoneSplinter = false;
    private int Topo;
    boolean DoneTopo = false;
    private int Tiger;
    boolean DoneTiger = false;
    private int Stripes;
    boolean DoneStripes = false;
    private int Reptile;
    boolean DoneReptile = false;
    private int Skulls;
    boolean DoneSkulls = false;

    public AssaultRifle() {
    }

    public boolean isFinished() {
        return finished;
    }
/**
 * Finishes all of the categories for testing purposes
 */
    public void finish() {
        this.finished = true;
        SprayPaint = 800;
        Woodland = 125;
        Digital = 160;
        Dragon = 75;
        Splinter = 100;
        Topo = 100;
        Tiger = 180;
        Stripes = 50;
        Reptile = 110;
        Skulls = 35;
        categories = 10;
    }

    /**
     * Resets all values for each category
     */
    public void reset() {
        this.finished = false;
        SprayPaint = 0;
        Woodland = 0;
        Digital = 0;
        Dragon = 0;
        Splinter = 0;
        Topo = 0;
        Tiger = 0;
        Stripes = 0;
        Reptile = 0;
        Skulls = 0;
        categories = 0;
    }

    public int getcategories() {
        return categories;
    }

    public int getSpraypaint() {
        return SprayPaint;
    }

    public int getWoodland() {
        return Woodland;
    }

    public int getDigital() {
        return Digital;
    }

    public int getDragon() {
        return Dragon;
    }

    public int getSplinter() {
        return Splinter;
    }

    public int getTopo() {
        return Topo;
    }

    public int getTiger() {
        return Tiger;
    }

    public int getStripes() {
        return Stripes;
    }

    public int getReptile() {
        return Reptile;
    }

    public int getSkulls() {
        return Skulls;
    }

    public void incrementSprayPaint(int kills) {
        if ((this.getSpraypaint() + kills) > 800) {
            this.SprayPaint = 800;
            if (DoneSprayPaint == false) {
                categories++;
            }
            DoneSprayPaint = true;
        } else {
            this.SprayPaint += kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        }
    }

    public void incrementWoodland(int kills) {
        if ((this.getWoodland() + kills) > 125) {
            this.Woodland = 125;
            if (DoneWoodland == false) {
                categories++;
            }
            DoneWoodland = true;
        } else {
            this.Woodland += kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        }
    }

    public void incrementDigital(int kills) {
        if ((this.getDigital() + kills) > 160) {
            this.Digital = 160;
            if (DoneDigital == false) {
                categories++;
            }
            DoneDigital = true;
        } else {
            this.Digital += kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        }
    }

    public void incrementDragon(int kills) {
        if ((this.getDragon() + kills) > 75) {
            this.Dragon = 75;
            if (DoneDragon == false) {
                categories++;
            }
            DoneDragon = true;
        } else {
            this.Dragon += kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        }
    }

    public void incrementSplinter(int kills) {
        if ((this.getSplinter() + kills) > 100) {
            this.Splinter = 100;
            if (DoneSplinter == false) {
                categories++;
            }
            DoneSplinter = true;
        } else {
            this.Splinter += kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        }
    }

    public void incrementTopo(int kills) {
        if ((this.getTopo() + kills) > 100) {
            this.Topo = 100;
            if (DoneTopo == false) {
                categories++;
            }
            DoneTopo = true;
        } else {
            this.Topo += kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        }
    }

    public void incrementTiger(int kills) {
        if ((this.getTiger() + kills) > 180) {
            this.Tiger = 180;
            if (DoneTiger == false) {
                categories++;
            }
            DoneTiger = true;
        } else {
            this.Tiger += kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        }
    }

    public void incrementStripes(int kills) {
        if ((this.getStripes() + kills) > 50) {
            this.Stripes = 50;
            if (DoneStripes == false) {
                categories++;
            }
            DoneStripes = true;
        } else {
            this.Stripes += kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        }
    }

    public void incrementReptile(int kills) {
        if ((this.getReptile() + kills) > 110) {
            this.Reptile = 110;
            if (DoneReptile == false) {
                categories++;
            }
            DoneReptile = true;
        } else {
            this.Reptile += kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        }
    }

    public void incrementSkulls(int kills) {
        if ((this.getSkulls() + kills) > 35) {
            this.Skulls = 35;
            if (DoneSkulls == false) {
                categories++;
            }
            DoneSkulls = true;
        } else {
            this.Skulls += kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        }
    }

    public void decrementSprayPaint(int kills) {
        if ((this.getSpraypaint() - kills) < 0) {
            this.SprayPaint = 0;
            if (DoneSprayPaint) {
                categories--;
                DoneSprayPaint = true;
            }
        } else {
            this.SprayPaint -= kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        } else {
            this.finished = false;
        }
    }

    public void decrementWoodland(int kills) {
        if ((this.getSpraypaint() - kills) < 0) {
            this.Woodland = 0;
            if (DoneWoodland) {
                categories--;
                DoneWoodland = false;
            }
        } else {
            this.Woodland -= kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        } else {
            this.finished = false;
        }
    }

    public void decrementDigital(int kills) {
        if ((this.getDigital() - kills) < 0) {
            this.Digital = 0;
            if (DoneDigital) {
                categories--;
                DoneDigital = false;
            }
        } else {
            this.Digital -= kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        } else {
            this.finished = false;
        }
    }

    public void decrementDragon(int kills) {
        if ((this.getDragon() - kills) < 0) {
            this.Dragon = 0;
            if (DoneDragon) {
                categories--;
                DoneDragon = false;
            }
        } else {
            this.Dragon -= kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        } else {
            this.finished = false;
        }
    }

    public void decrementSplinter(int kills) {
        if ((this.getSplinter() - kills) < 0) {
            this.Splinter = 0;
            if (DoneSplinter) {
                categories--;
                DoneSplinter = false;
            }
        } else {
            this.Splinter -= kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        } else {
            this.finished = false;
        }
    }

    public void decrementTopo(int kills) {
        if ((this.getTopo() - kills) < 0) {
            this.Topo = 0;
            if (DoneTopo) {
                categories--;
                DoneTopo = false;
            }
        } else {
            this.Topo -= kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        } else {
            this.finished = false;
        }
    }

    public void decrementTiger(int kills) {
        if ((this.getTiger() - kills) < 0) {
            this.Tiger = 0;
            if (DoneTiger) {
                categories--;
                DoneTiger = false;
            }
        } else {
            this.Tiger -= kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        } else {
            this.finished = false;
        }
    }

    public void decrementStripes(int kills) {
        if ((this.getStripes() - kills) < 0) {
            this.Stripes = 0;
            if (DoneStripes) {
                categories--;
                DoneStripes = false;
            }
        } else {
            this.Stripes -= kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        } else {
            this.finished = false;
        }
    }

    public void decrementReptile(int kills) {
        if ((this.getReptile() - kills) < 0) {
            this.Reptile = 0;
            if (DoneReptile) {
                categories--;
                DoneReptile = false;
            }
        } else {
            this.Reptile -= kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        } else {
            this.finished = false;
        }
    }

    public void decrementSkulls(int kills) {
        if ((this.getSkulls() - kills) < 0) {
            this.Skulls = 0;
            if (DoneSkulls) {
                categories--;
                DoneSkulls = false;
            }
        } else {
            this.Skulls -= kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        } else {
            this.finished = false;
        }
    }
}



class SMG implements Serializable {

    private boolean finished = false;
    private int categories;
    private int SprayPaint;
    boolean DoneSprayPaint = false;
    private int Woodland;
    boolean DoneWoodland = false;
    private int Digital;
    boolean DoneDigital = false;
    private int Dragon;
    boolean DoneDragon = false;
    private int Splinter;
    boolean DoneSplinter = false;
    private int Topo;
    boolean DoneTopo = false;
    private int Tiger;
    boolean DoneTiger = false;
    private int Stripes;
    boolean DoneStripes = false;
    private int Reptile;
    boolean DoneReptile = false;
    private int Skulls;
    boolean DoneSkulls = false;

    public SMG() {
    }

    public boolean isFinished() {
        return finished;
    }

    /**
     * Finishes all of the guns for testing purposes
     */
    public void finish() {
        this.finished = true;
        SprayPaint = 500;
        Woodland = 100;
        Digital = 110;
        Dragon = 100;
        Splinter = 50;
        Topo = 50;
        Tiger = 250;
        Stripes = 40;
        Reptile = 75;
        Skulls = 25;
        categories = 10;
    }

    /**
     * Resets all values for each category
     */
    public void reset() {
        this.finished = false;
        SprayPaint = 0;
        Woodland = 0;
        Digital = 0;
        Dragon = 0;
        Splinter = 0;
        Topo = 0;
        Tiger = 0;
        Stripes = 0;
        Reptile = 0;
        Skulls = 0;
        categories = 0;
    }

    public int getcategories() {
        return categories;
    }

    public int getSpraypaint() {
        return SprayPaint;
    }

    public int getWoodland() {
        return Woodland;
    }

    public int getDigital() {
        return Digital;
    }

    public int getDragon() {
        return Dragon;
    }

    public int getSplinter() {
        return Splinter;
    }

    public int getTopo() {
        return Topo;
    }

    public int getTiger() {
        return Tiger;
    }

    public int getStripes() {
        return Stripes;
    }

    public int getReptile() {
        return Reptile;
    }

    public int getSkulls() {
        return Skulls;
    }


    public void incrementSprayPaint(int kills) {
        if ((this.getSpraypaint() + kills) > 500) {
            this.SprayPaint = 500;
            if (DoneSprayPaint == false) {
                categories++;
            }
            DoneSprayPaint = true;
        } else {
            this.SprayPaint += kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        }
    }

    public void incrementWoodland(int kills) {
        if ((this.getWoodland() + kills) > 100) {
            this.Woodland = 100;
            if (DoneWoodland == false) {
                categories++;
            }
            DoneWoodland = true;
        } else {
            this.Woodland += kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        }
    }

    public void incrementDigital(int kills) {
        if ((this.getDigital() + kills) > 110) {
            this.Digital = 110;
            if (DoneDigital == false) {
                categories++;
            }
            DoneDigital = true;
        } else {
            this.Digital += kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        }
    }

    public void incrementDragon(int kills) {
        if ((this.getDragon() + kills) > 100) {
            this.Dragon = 100;
            if (DoneDragon == false) {
                categories++;
            }
            DoneDragon = true;
        } else {
            this.Dragon += kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        }
    }

    public void incrementSplinter(int kills) {
        if ((this.getSplinter() + kills) > 50) {
            this.Splinter = 50;
            if (DoneSplinter == false) {
                categories++;
            }
            DoneSplinter = true;
        } else {
            this.Splinter += kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        }
    }

    public void incrementTopo(int kills) {
        if ((this.getTopo() + kills) > 50) {
            this.Topo = 50;
            if (DoneTopo == false) {
                categories++;
            }
            DoneTopo = true;
        } else {
            this.Topo += kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        }
    }

    public void incrementTiger(int kills) {
        if ((this.getTiger() + kills) > 250) {
            this.Tiger = 250;
            if (DoneTiger == false) {
                categories++;
            }
            DoneTiger = true;
        } else {
            this.Tiger += kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        }
    }

    public void incrementStripes(int kills) {
        if ((this.getStripes() + kills) > 40) {
            this.Stripes = 40;
            if (DoneStripes == false) {
                categories++;
            }
            DoneStripes = true;
        } else {
            this.Stripes += kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        }
    }

    public void incrementReptile(int kills) {
        if ((this.getReptile() + kills) > 75) {
            this.Reptile = 75;
            if (DoneReptile == false) {
                categories++;
            }
            DoneReptile = true;
        } else {
            this.Reptile += kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        }
    }

    public void incrementSkulls(int kills) {
        if ((this.getSkulls() + kills) > 25) {
            this.Skulls = 25;
            if (DoneSkulls == false) {
                categories++;
            }
            DoneSkulls = true;
        } else {
            this.Skulls += kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        }
    }

    public void decrementSprayPaint(int kills) {
        if ((this.getSpraypaint() - kills) < 0) {
            this.SprayPaint = 0;
            if (DoneSprayPaint) {
                categories--;
                DoneSprayPaint = true;
            }
        } else {
            this.SprayPaint -= kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        } else {
            this.finished = false;
        }
    }

    public void decrementWoodland(int kills) {
        if ((this.getSpraypaint() - kills) < 0) {
            this.Woodland = 0;
            if (DoneWoodland) {
                categories--;
                DoneWoodland = false;
            }
        } else {
            this.Woodland -= kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        } else {
            this.finished = false;
        }
    }

    public void decrementDigital(int kills) {
        if ((this.getDigital() - kills) < 0) {
            this.Digital = 0;
            if (DoneDigital) {
                categories--;
                DoneDigital = false;
            }
        } else {
            this.Digital -= kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        } else {
            this.finished = false;
        }
    }

    public void decrementDragon(int kills) {
        if ((this.getDragon() - kills) < 0) {
            this.Dragon = 0;
            if (DoneDragon) {
                categories--;
                DoneDragon = false;
            }
        } else {
            this.Dragon -= kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        } else {
            this.finished = false;
        }
    }

    public void decrementSplinter(int kills) {
        if ((this.getSplinter() - kills) < 0) {
            this.Splinter = 0;
            if (DoneSplinter) {
                categories--;
                DoneSplinter = false;
            }
        } else {
            this.Splinter -= kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        } else {
            this.finished = false;
        }
    }

    public void decrementTopo(int kills) {
        if ((this.getTopo() - kills) < 0) {
            this.Topo = 0;
            if (DoneTopo) {
                categories--;
                DoneTopo = false;
            }
        } else {
            this.Topo -= kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        } else {
            this.finished = false;
        }
    }

    public void decrementTiger(int kills) {
        if ((this.getTiger() - kills) < 0) {
            this.Tiger = 0;
            if (DoneTiger) {
                categories--;
                DoneTiger = false;
            }
        } else {
            this.Tiger -= kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        } else {
            this.finished = false;
        }
    }

    public void decrementStripes(int kills) {
        if ((this.getStripes() - kills) < 0) {
            this.Stripes = 0;
            if (DoneStripes) {
                categories--;
                DoneStripes = false;
            }
        } else {
            this.Stripes -= kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        } else {
            this.finished = false;
        }
    }

    public void decrementReptile(int kills) {
        if ((this.getReptile() - kills) < 0) {
            this.Reptile = 0;
            if (DoneReptile) {
                categories--;
                DoneReptile = false;
            }
        } else {
            this.Reptile -= kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        } else {
            this.finished = false;
        }
    }

    public void decrementSkulls(int kills) {
        if ((this.getSkulls() - kills) < 0) {
            this.Skulls = 0;
            if (DoneSkulls) {
                categories--;
                DoneSkulls = false;
            }
        } else {
            this.Skulls -= kills;
        }
        if (DoneSprayPaint && DoneWoodland && DoneDigital && DoneDragon && DoneSplinter && DoneTopo && DoneTiger && DoneStripes && DoneReptile && DoneSkulls) {
            this.finished = true;
        } else {
            this.finished = false;
        }
    }
}
