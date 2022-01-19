package cs1181.haire.project01;

import java.io.Serializable;

/*
Brandon Haire
CS1181-Project01
Michelle Cheatham
 */

/**
 * This class represents the submachine guns in Modern warfare which each have 10 categories to 
 * be completed by players. Each of those categories can be seen, incremented, and decremented. 
 * @author bucke
 */
public class SMG implements Serializable {

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
