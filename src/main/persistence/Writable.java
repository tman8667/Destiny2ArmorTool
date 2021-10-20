package persistence;

import org.json.JSONObject;

public interface Writable {
    // EFFECT: returns this as a JSON object
    JSONObject toJson();
}
