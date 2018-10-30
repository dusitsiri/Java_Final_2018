package gamecharacter;

public class Skills {
    private String name;
    private String type;
    private int level;

    public Skills(String name, String type) {
        this.name = name;
        this.type = type;
        this.level = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
