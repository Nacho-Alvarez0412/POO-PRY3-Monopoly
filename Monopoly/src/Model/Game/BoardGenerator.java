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
        
        generateBlueProperties();
        generateBrownProperties();
        generateCommunityChestCards();
        generateFortuneCards();
        generateGreenProperties();
        generateLightBlueProperties();
        generateOrangeProperties();
        generatePinkProperties();
        generateRailRoads();
        generateRedProperties();
        generateServices();
        generateSpecialCards();
        generateYellowProperties();
        
        generateBoard();
    }
    
    public void generateBrownProperties(){
        properties.add(new Property(Color.WHITE,"Mediterranean Avenue",2,50,20,60));
        properties.add(new Property(Color.WHITE,"Baltic Avenue",4,50,30,60));
    }
    
    public void generateLightBlueProperties(){
        properties.add(new Property(Color.CYAN,"Oriental Avenue",6,50,50,100));
        properties.add(new Property(Color.CYAN,"Vermont Avenue",6,50,50,100));
        properties.add(new Property(Color.CYAN,"Connecticut Avenue",8,50,60,120));
    }
    
    public void generatePinkProperties(){
        properties.add(new Property(Color.PINK,"St. Charles Place",10,100,70,140));
        properties.add(new Property(Color.PINK,"States Avenue",10,100,70,140));
        properties.add(new Property(Color.PINK,"Virginia Avenue",12,100,80,160));
    }
    
    public void generateOrangeProperties(){
        properties.add(new Property(Color.ORANGE,"St. James Place",14,100,90,180));
        properties.add(new Property(Color.ORANGE,"Tenessee Avenue",14,100,90,180));
        properties.add(new Property(Color.ORANGE,"New York Avenue",16,100,100,200));
    }
    
    public void generateRedProperties(){
        properties.add(new Property(Color.RED,"Kentucky Avenue",18,150,110,220));
        properties.add(new Property(Color.RED,"Indiana Avenue",18,150,110,220));
        properties.add(new Property(Color.RED,"Illinois Avenue",20,150,120,240));
    }
    
    public void generateYellowProperties(){
        properties.add(new Property(Color.YELLOW,"Atlantic Avenue",22,150,130,260));
        properties.add(new Property(Color.YELLOW,"Ventor Avenue",22,150,130,260));
        properties.add(new Property(Color.YELLOW,"Marvin Gardens",24,150,140,280));
    }
    
    public void generateGreenProperties(){
        properties.add(new Property(Color.GREEN,"Pacific Avenue",26,200,150,300));
        properties.add(new Property(Color.GREEN,"North Carolina Avenue",26,200,150,300));
        properties.add(new Property(Color.GREEN,"Pennsylvania Avenue",28,200,160,320));
    }
    
    public void generateBlueProperties(){
        properties.add(new Property(Color.BLUE,"Park Place",35,200,175,350));
        properties.add(new Property(Color.BLUE,"Boardwalk",50,200,200,400));
    }
    
    public void generateRailRoads(){
        properties.add(new Property(Color.BLACK,"Reading Railroad",25,-1,100,200));
        properties.add(new Property(Color.BLACK,"Pennsylvania Railroad",25,-1,100,200));
        properties.add(new Property(Color.BLACK,"B. & O. Railroad",25,-1,100,200));
        properties.add(new Property(Color.BLACK,"Short Line",25,-1,100,200));
    }
    
    public void generateServices(){
        properties.add(new Property(Color.LIGHT_GRAY,"Electric Company",4,-1,75,150));
        properties.add(new Property(Color.LIGHT_GRAY,"Water Works",4,-1,75,150));
    }
    
    public void generateFortuneCards(){
        fortune.add(new Wildcard(1,"Advance to 'Go'. (Collect $200)",true));
        fortune.add(new Wildcard(2,"Advance to Illinois Ave. If you pass Go, collect $200. ",true));
        fortune.add(new Wildcard(3,"Advance to St. Charles Place. If you pass Go, collect $200.",true));
        fortune.add(new Wildcard(4,"Advance token to nearest Service. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner.",true));
        fortune.add(new Wildcard(5,"Advance token to the nearest Railroad and pay owner. If Railroad is unowned, you may buy it from the Bank.",true));
        fortune.add(new Wildcard(6,"Bank pays you dividend of $50.",true));
        fortune.add(new Wildcard(7,"Get out of Jail Free. This card may be kept until needed, or sold for $100.",true));
        fortune.add(new Wildcard(8,"Go Back Three 3 Spaces.",true));
        fortune.add(new Wildcard(9,"Go to Jail. Go directly to Jail. Do not pass GO, do not collect $200.",true));
        fortune.add(new Wildcard(10,"Make general repairs on all your property: For each house pay $25, For each hotel pay $100.",true));
        fortune.add(new Wildcard(11,"Pay poor tax of $15 ",true));
        fortune.add(new Wildcard(12,"Take a trip to Reading Railroad. If you pass Go, collect $200. ",true));
        fortune.add(new Wildcard(13,"Take a walk on the Boardwalk. Advance token to Boardwalk.",true));
        fortune.add(new Wildcard(14,"You have been elected Chairman of the Board. Pay each player $50. ",true));
        fortune.add(new Wildcard(15,"Your building and loan matures. Receive $150.",true));
        fortune.add(new Wildcard(16,"You have won a crossword competition. Collect $100.",true));
    }
    
    public void generateCommunityChestCards(){
        communityChest.add(new Wildcard(1,"Advance to 'Go'. (Collect $200)",false));
        communityChest.add(new Wildcard(2,"Bank error in your favor. Collect $200.",false));
        communityChest.add(new Wildcard(3,"Doctor's fees. Pay $50.",false));
        communityChest.add(new Wildcard(4,"From sale of stock you get $50.",false));
        communityChest.add(new Wildcard(5,"Get out of Jail Free. This card may be kept until needed, or sold for $100.",false));
        communityChest.add(new Wildcard(6,"Go to Jail. Go directly to jail. Do not pass Go, Do not collect $200. ",false));
        communityChest.add(new Wildcard(7,"Grand Opera Night. Collect $50 from every player for opening night seats.",false));
        communityChest.add(new Wildcard(8,"Holiday Fund matures. Receive $100.",false));
        communityChest.add(new Wildcard(9,"Income tax refund. Collect $20.",false));
        communityChest.add(new Wildcard(10,"It's your birthday. Collect $10 from every player. ",false));
        communityChest.add(new Wildcard(11,"Life insurance matures – Collect $100",false));
        communityChest.add(new Wildcard(12,"Hospital Fees. Pay $50. ",false));
        communityChest.add(new Wildcard(13,"School fees. Pay $50.",false));
        communityChest.add(new Wildcard(14,"Receive $25 consultancy fee.",false));
        communityChest.add(new Wildcard(15,"You are assessed for street repairs: Pay $40 per house and $115 per hotel you own.",false));
        communityChest.add(new Wildcard(16,"You have won second prize in a beauty contest. Collect $10.",false));
    }
    
    public void generateSpecialCards(){
        specialCards.add(new SpecialCard(EnumSpecialType.Go));
        specialCards.add(new SpecialCard(EnumSpecialType.IncomeTax));
        specialCards.add(new SpecialCard(EnumSpecialType.Jail));
        specialCards.add(new SpecialCard(EnumSpecialType.ParkZone));
        specialCards.add(new SpecialCard(EnumSpecialType.ToJail));
        specialCards.add(new SpecialCard(EnumSpecialType.LuxuryTax));
        specialCards.add(new SpecialCard(EnumSpecialType.Chance));
        specialCards.add(new SpecialCard(EnumSpecialType.CommunityChest));
    }

    private void generateBoard() {
        board.add(specialCards.get(0));
        board.add(properties.get(0));
        board.add(specialCards.get(7));
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
        board.add(specialCards.get(7));
        board.add(properties.get(9));
        board.add(properties.get(10));
        board.add(specialCards.get(3));
        board.add(properties.get(11));
        board.add(specialCards.get(6));
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
        board.add(specialCards.get(7));
        board.add(properties.get(19));
        board.add(properties.get(25));
        board.add(specialCards.get(6));
        board.add(properties.get(20));
        board.add(specialCards.get(5));
        board.add(properties.get(21));
    }
}
