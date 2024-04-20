package ca.johnholloway.model;

public class Parrot {
    private String name;

    public String speak(){
        return "Squawk!! " + this.name + " wanna cracker!";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
