package org.example;

public class Coin {
    private int rank;
    private String code;
    private String name;
    private double price;
    private long volume;
    public Coin(int coinrank,String coincode,String coinname,double coinprice,long volume){
        this.rank=coinrank;
        this.code=coincode;
        this.name=coinname;
        this.price=coinprice;
        this.volume=volume;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getVolume() {
        return volume;
    }

    // Setters
    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
    public String toString() {
        return "Coin{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                ", symbol='" + code + '\'' +
                ", price=" + price +
                ", circulatingSupply=" + volume +
                '}';
    }
}
