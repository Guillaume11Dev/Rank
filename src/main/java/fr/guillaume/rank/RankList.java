package fr.guillaume.rank;

public enum RankList {

    ADMINISTRATOR(100, "§4[Admin] ",""),

    PLAYER(1, "§7", "");

    //fields
    private final int power;
    private final  String prefix, suffix;

    //Constructor
    private RankList(int power, String prefix, String suffix){
        this.power = power;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    //Methode GETTER
    public int getPower() {
        return power;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getName(){
        return this.toString();

    }
}
