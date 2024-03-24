package Jour;

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    MoodDiary diary = new MoodDiary();

    while (true) {
        System.out.println("Please choose a mood (Calm, Sad, Angry, Happy, Shy) or type 'exit' to quit:");
        String moodInput = scanner.nextLine();
        if (moodInput.equalsIgnoreCase("exit")) {
            break;
        }

        Mood mood = Mood.fromString(moodInput);
        if (mood == null) {
            System.out.println("Invalid mood, please try again.");
            continue;
        }

        System.out.println("Enter your diary content:");
        String content = scanner.nextLine();

        diary.addEntry(mood, content);
        System.out.println("Diary entry added successfully!");
    }

    System.out.println("Your mood diary entries:");
    diary.showEntries();
}

