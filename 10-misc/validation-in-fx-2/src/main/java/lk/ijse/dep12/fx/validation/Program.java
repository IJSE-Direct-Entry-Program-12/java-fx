package lk.ijse.dep12.fx.validation;

import java.util.ArrayList;

public class Program {
    private String id;
    private String name;
    private String code;
    private String type;
    private ArrayList<String> audience;

    public Program(String id, String name, String code, String type, ArrayList<String> audience) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.type = type;
        this.audience = audience;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public ArrayList<String> getAudience() {
        return audience;
    }

    @Override
    public String toString() {
        return "Program{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", type='" + type + '\'' +
                ", audience=" + audience +
                '}';
    }
}
