package Jour;

import java.time.LocalDateTime;

public class MoodEntry {
    public enum Mood {
        CALM("Calm"),
        SAD("Sad"),
        ANGRY("Angry"),
        HAPPY("Happy"),
        SHY("Shy");

        private final String description;

        Mood(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }

        public static Mood fromString(String text) {
            for (Mood b : Mood.values()) {
                if (b.description.equalsIgnoreCase(text)) {
                    return b;
                }
            }
            return null;
        }
    }

    private Mood mood;
    private String content;
    private LocalDateTime timestamp;

    public MoodEntry(Mood mood, String content) {
        this.mood = mood;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("Mood: %s, Time: %s, Content: %s", mood, timestamp, content);
    }
}
