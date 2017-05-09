package lab_3.exercise_1;

// Utilities needed for mapping the informations
import java.util.Map;
import java.util.HashMap;

// Used for marshaling
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "dictionary")
final class Dictionary {
    /**
    * The actual dictionary.
    * Built outside the class constructor
    * to be shared to all the instances of this class.
    */
    @XmlElement(name = "words")
    private static Map<String, String> stored_words = new HashMap<String,String>();

    /**
     * Return the words dictionary.
     * @return The dictionary as a {@link Map} with keys as {@link String} and * descriptions as {@link String} 
     */
    Map<String,String> getWords() {
        return stored_words;
    }

    /**
     * Set the words dictionary.
     * @param new_words The new {@link Map} of words (as {@link String})
     * to desctiptions (as {@link String})
     */
    void setWords(Map<String,String> new_words) {
        stored_words = new_words;
    }
}