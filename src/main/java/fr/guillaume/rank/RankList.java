package fr.guillaume.rank;

public enum RankList {

    ADMINISTRATOR(100, "§4[Admin] ",""," §8§1>> §3"),

    PLAYER(1, "§7", "", " > ");

    //fields
    private final int power;
    private final  String prefix, suffix, chatSeparator;

    //Constructor
    private RankList(int power, String prefix, String suffix, String chatSeparator){
        this.power = power;
        this.prefix = prefix;
        this.suffix = suffix;
        this.chatSeparator = chatSeparator;

    }

    //Methode GETTER
    public int getPower() {
        return power;
    }

    public final String getPrefix() {
        return prefix;
    }

    public final String getSuffix() {
        return suffix;
    }

    public final String getName(){
        return this.toString();

    }

    public final String getChatSeparator() {
        return chatSeparator;
    }
}

