/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Game;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author nacho
 */
public final class BoardGenerator {
    public ArrayList<Card> board;
    public ArrayList<Property> properties;
    public ArrayList<Wildcard> fortune;
    public ArrayList<Wildcard> communityChest;
    public ArrayList<SpecialCard> specialCards;
    
     
    public BoardGenerator(){
        board = new ArrayList<>();
        properties = new ArrayList<>();
        fortune = new ArrayList<>();
        specialCards = new ArrayList<>();
        communityChest = new ArrayList<>();
        
        generateBrownProperties();
        generateLightBlueProperties();
        generatePinkProperties();
        generateOrangeProperties();
        generateRedProperties();
        generateYellowProperties();
        generateGreenProperties();
        generateBlueProperties();
        generateRailRoads();
        generateServices();
        
        generateFortuneCards();
        generateCommunityChestCards();
        generateSpecialCards();
        
        generateBoard();
    }
    
    public void generateBrownProperties(){
        properties.add(new Property(650,740,Color.WHITE,"Mediterranean Avenue",2,50,20,60));
        properties.add(new Property(520,740,Color.WHITE,"Baltic Avenue",4,50,30,60));
    }
    
    public void generateLightBlueProperties(){
        properties.add(new Property(320,740,Color.CYAN,"Oriental Avenue",6,50,50,100));
        properties.add(new Property(190,740,Color.CYAN,"Vermont Avenue",6,50,50,100));
        properties.add(new Property(120,740,Color.CYAN,"Connecticut Avenue",8,50,60,120));
    }
    
    public void generatePinkProperties(){
        properties.add(new Property(30,650,Color.PINK,"St. Charles Place",10,100,70,140));
        properties.add(new Property(30,520,Color.PINK,"States Avenue",10,100,70,140));
        properties.add(new Property(30,460,Color.PINK,"Virginia Avenue",12,100,80,160));
    }
    
    public void generateOrangeProperties(){
        properties.add(new Property(30,320,Color.ORANGE,"St. James Place",14,100,90,180));
        properties.add(new Property(30,190,Color.ORANGE,"Tenessee Avenue",14,100,90,180));
        properties.add(new Property(30,130,Color.ORANGE,"New York Avenue",16,100,100,200));
    }
    
    public void generateRedProperties(){
        properties.add(new Property(120,30,Color.RED,"Kentucky Avenue",18,150,110,220));
        properties.add(new Property(260,30,Color.RED,"Indiana Avenue",18,150,110,220));
        properties.add(new Property(320,30,Color.RED,"Illinois Avenue",20,150,120,240));
    }
    
    public void generateYellowProperties(){
        properties.add(new Property(450,30,Color.YELLOW,"Atlantic Avenue",22,150,130,260));
        properties.add(new Property(520,30,Color.YELLOW,"Ventor Avenue",22,150,130,260));
        properties.add(new Property(650,30,Color.YELLOW,"Marvin Gardens",24,150,140,280));
    }
    
    public void generateGreenProperties(){
        properties.add(new Property(740,130,Color.GREEN,"Pacific Avenue",26,200,150,300));
        properties.add(new Property(740,190,Color.GREEN,"North Carolina Avenue",26,200,150,300));
        properties.add(new Property(740,330,Color.GREEN,"Pennsylvania Avenue",28,200,160,320));
    }
    
    public void generateBlueProperties(){
        properties.add(new Property(740,520,Color.BLUE,"Park Place",35,200,175,350));
        properties.add(new Property(740,650,Color.BLUE,"Boardwalk",50,200,200,400));
    }
    
    public void generateRailRoads(){
        properties.add(new Property(390,740,Color.BLACK,"Reading Railroad",25,-1,100,200)); //22
        properties.add(new Property(40,390,Color.BLACK,"Pennsylvania Railroad",25,-1,100,200));
        properties.add(new Property(390,40,Color.BLACK,"B. & O. Railroad",25,-1,100,200));
        properties.add(new Property(750,390,Color.BLACK,"Short Line",25,-1,100,200));
    }
    
    public void generateServices(){
        properties.add(new Property(30,580,Color.LIGHT_GRAY,"Electric Company",4,-1,75,150));
        properties.add(new Property(580,40,Color.LIGHT_GRAY,"Water Works",4,-1,75,150));
    }
    
    public void generateFortuneCards(){
        fortune.add(new Wildcard(1,"<html>Advance to 'Go'. <br/>(Collect $200)</html>",true));
        fortune.add(new Wildcard(2,"<html>Advance to Illinois Ave. <br/>If you pass Go, collect $200.</html> ",true));
        fortune.add(new Wildcard(3,"<html>Advance to St. Charles Place. <br/>If you pass Go, collect $200.</html>",true));
        fortune.add(new Wildcard(4,"<html>Advance token to nearest Service. <br/>If unowned you may buy it from the Bank.<br/> If owned, throw dice and pay owner.</html>",true));
        fortune.add(new Wildcard(5,"<html>Advance token to the nearest Railroad and pay owner. <br/>If Railroad is unowned,\n you may buy it from the Bank.</html>",true));
        fortune.add(new Wildcard(6,"<html>Bank pays you <br/>dividend of $50.</html>",true));
        fortune.add(new Wildcard(7,"<html>Get out of Jail Free. <br/>This card may be kept until needed, or sold for $100.</html>",true));
        fortune.add(new Wildcard(8,"<html>Go Back Three 3 Spaces.</html>",true));
        fortune.add(new Wildcard(9,"<html>Go to Jail. Go directly to Jail. <br/>Do not pass GO, do not collect $200.</html>",true));
        fortune.add(new Wildcard(10,"<html>Make general repairs on all your property:<br/> For each house pay $25, For each hotel pay $100.</html>",true));
        fortune.add(new Wildcard(11,"<html>Pay poor tax of $15 </html>",true));
        fortune.add(new Wildcard(12,"<html>Take a trip to Reading Railroad.<br/> If you pass Go, collect $200.</html> ",true));
        fortune.add(new Wildcard(13,"<html>Take a walk on the Boardwalk.<br/> Advance token to Boardwalk.</html>",true));
        fortune.add(new Wildcard(14,"<html>You have been elected Chairman of the Board. <br/>Pay each player $50.</html> ",true));
        fortune.add(new Wildcard(15,"<html>Your building and loan matures. <br/>Receive $150.</html>",true));
        fortune.add(new Wildcard(16,"<html>You have won a crossword competition. <br/>Collect $100.</html>",true));
    }
    
    public void generateCommunityChestCards(){
        communityChest.add(new Wildcard(1,"<html>Advance to 'Go'. <br/>(Collect $200)</html>",false));
        communityChest.add(new Wildcard(2,"<html>Bank error in your favor. <br/>Collect $200.</html>",false));
        communityChest.add(new Wildcard(3,"<html>Doctor's fees. <br/>Pay $50.</html>",false));
        communityChest.add(new Wildcard(4,"<html>From sale of stock <br/>you get $50.</html>",false));
        communityChest.add(new Wildcard(5,"<html>Get out of Jail Free. <br/>This card may be kept until needed,<br/> or sold for $100.</html>",false));
        communityChest.add(new Wildcard(6,"<html>Go to Jail. <br/>Go directly to jail. <br/>Do not pass Go, <br/>Do not collect $200.</html> ",false));
        communityChest.add(new Wildcard(7,"<html>Grand Opera Night. <br/>Collect $50 from every player<br/> for opening night seats.</html>",false));
        communityChest.add(new Wildcard(8,"<html>Holiday Fund matures. <br/>Receive $100.</html>",false));
        communityChest.add(new Wildcard(9,"<html>Income tax refund. <br/>Collect $20.</html>",false));
        communityChest.add(new Wildcard(10,"<html>It's your birthday. <br/>Collect $10 from every player.</html> ",false));
        communityChest.add(new Wildcard(11,"<html>Life insurance matures <br/>Collect $100</html>",false));
        communityChest.add(new Wildcard(12,"<html>Hospital Fees. <br/>Pay $50.</html> ",false));
        communityChest.add(new Wildcard(13,"<html>School fees. <br/>Pay $50.</html>",false));
        communityChest.add(new Wildcard(14,"<html>Receive $25 <br/>consultancy fee.</html>",false));
        communityChest.add(new Wildcard(15,"<html>You are assessed for street repairs: <br/>Pay $40 per house<br/> and $115 per hotel you own.</html>",false));
        communityChest.add(new Wildcard(16,"<html>You have won second prize in a<br/> beauty contest.<br/> Collect $10.</html>",false));
    }
    
    public void generateSpecialCards(){
        specialCards.add(new SpecialCard(730,740,EnumSpecialType.Go));
        specialCards.add(new SpecialCard(450,730,EnumSpecialType.IncomeTax));
        specialCards.add(new SpecialCard(50,730,EnumSpecialType.Jail));
        specialCards.add(new SpecialCard(40,40,EnumSpecialType.ParkZone));
        specialCards.add(new SpecialCard(730,40,EnumSpecialType.ToJail));
        specialCards.add(new SpecialCard(740,590,EnumSpecialType.LuxuryTax));
        
        specialCards.add(new SpecialCard(250,740,EnumSpecialType.Chance)); //6
        specialCards.add(new SpecialCard(190,30,EnumSpecialType.Chance));
        specialCards.add(new SpecialCard(740,460,EnumSpecialType.Chance));
        
        specialCards.add(new SpecialCard(580,730,EnumSpecialType.CommunityChest)); //9
        specialCards.add(new SpecialCard(30,260,EnumSpecialType.CommunityChest));
        specialCards.add(new SpecialCard(740,260,EnumSpecialType.CommunityChest));
    }

    private void generateBoard() {
        board.add(specialCards.get(0));
        board.add(properties.get(0));
        board.add(specialCards.get(9));
        board.add(properties.get(1));
        board.add(specialCards.get(1));
        board.add(properties.get(22));
        board.add(properties.get(2));
        board.add(specialCards.get(6));
        board.add(properties.get(3));
        board.add(properties.get(4));
        board.add(specialCards.get(2));
        board.add(properties.get(5));
        board.add(properties.get(26));
        board.add(properties.get(6));
        board.add(properties.get(7));
        board.add(properties.get(23));
        board.add(properties.get(8));
        board.add(specialCards.get(10));
        board.add(properties.get(9));
        board.add(properties.get(10));
        board.add(specialCards.get(3));
        board.add(properties.get(11));
        board.add(specialCards.get(7));
        board.add(properties.get(12));
        board.add(properties.get(13));
        board.add(properties.get(24));
        board.add(properties.get(14));
        board.add(properties.get(15));
        board.add(properties.get(27));
        board.add(properties.get(16));
        board.add(specialCards.get(4));
        board.add(properties.get(17));
        board.add(properties.get(18));
        board.add(specialCards.get(11));
        board.add(properties.get(19));
        board.add(properties.get(25));
        board.add(specialCards.get(8));
        board.add(properties.get(20));
        board.add(specialCards.get(5));
        board.add(properties.get(21));
    }
}
