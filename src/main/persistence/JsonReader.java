package persistence;

import model.ArmorPiece;
import model.ArmorSet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import org.json.*;

//Represents a reader that reads workroom from JSON data stored in file
//Code adapted from JsonSerializationDemo project
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it
    // throws IOException if an error oocurrs reading data from file
    public ArrayList<ArmorSet> read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseArmorSets(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses a list of ArmorSets from JSON object and returns
    private ArrayList<ArmorSet> parseArmorSets(JSONObject jsonObject) {
        ArrayList<ArmorSet> sets = new ArrayList<>();
        addSets(sets, jsonObject);
        return sets;
    }

    // MODIFIES: sets
    // EFFECTS: parses sets from JSON object and adds them to list of ArmorSets
    private void addSets(ArrayList<ArmorSet> sets, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("sets");
        for (Object json : jsonArray) {
            JSONObject nextSet = (JSONObject) json;
            addSet(sets, nextSet);
        }
    }

    // MODIFIES: sets
    // EFFECTS: parses ArmorSet from JSON
    private void addSet(ArrayList<ArmorSet> sets, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        ArmorSet set = new ArmorSet(name);
        JSONArray jsonArray = jsonObject.getJSONArray("pieces");
        for (Object json : jsonArray) {
            JSONObject nextPiece = (JSONObject) json;
            addPiece(set, nextPiece);
        }
        sets.add(set);
    }

    // MODIFIES: set
    // EFFECTS: parses an ArmorPiece from JSON object and adds it to set
    private void addPiece(ArmorSet set, JSONObject jsonObject) {
        String type = jsonObject.getString("type");
        int mobility = jsonObject.getInt("mobility");
        int resilience = jsonObject.getInt("resilience");
        int recovery = jsonObject.getInt("recovery");
        int intellect = jsonObject.getInt("intellect");
        int discipline = jsonObject.getInt("discipline");
        int strength = jsonObject.getInt("strength");
        ArmorPiece armorPiece = new ArmorPiece(type, mobility, resilience, recovery,
                intellect, discipline, strength);
        set.addPiece(armorPiece);
    }
}
