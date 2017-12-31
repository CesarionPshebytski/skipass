package Entities;

import java.util.ArrayList;

public class SkiPassSystem {
    public ArrayList<SkiPass> skiPasses = new ArrayList<SkiPass>();

    public void add(SkiPass skiPass) {
        if (!skiPasses.contains(skiPass)) skiPasses.add(skiPass);
        unblockSkiPass(skiPass);
    }

    public void blockSkiPass(SkiPass skiPass) {
        for (SkiPass pass : skiPasses) {
            if (pass.equals(skiPass))
                pass.block();
        }
    }

    public void blockSkiPass(int id) {
        for (SkiPass pass : skiPasses) {
            if (pass.getId() == id)
                pass.block();
        }
    }

    public void unblockSkiPass(SkiPass skiPass) {
        for (SkiPass pass : skiPasses) {
            if (pass.equals(skiPass))
                pass.unblock();
        }
    }

    public void unblockSkiPass(int id) {
        for (SkiPass pass : skiPasses) {
            if (pass.getId() == id)
                pass.unblock();
        }
    }

    @Override
    public String toString() {
        String string = "";
        for (SkiPass pass : skiPasses) {
            string += pass + "\n";
        }
        return string;
    }
}
