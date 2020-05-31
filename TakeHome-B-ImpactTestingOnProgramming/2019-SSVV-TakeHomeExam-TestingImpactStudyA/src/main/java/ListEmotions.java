import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class ListEmotions {
    private List<Emotion> lstEmotions;
    public ListEmotions(List<Emotion> newLstEmotions) {
        this.lstEmotions = newLstEmotions;
    }
    public int getNumberOfEmotions() {
        return lstEmotions.size();
    }
    // Task A_1
    // return the number of emotion of the given EmotionType et
    // Remark: No test cases are going to be created.
    public int howGivenManyEmotionTypeInListEmotions(EmotionType et) {
        return (int) lstEmotions.stream().filter(emotion -> emotion.getEmotionType().equals(et)).count();
    }
    // Task A_2
    // return the list of predominant emotions
    // Remark: Create a set of test cases to assess the correctness of your code.
    //         Create a class to test this method, several test cases are needed.
    //         One sample test case is provided in class Test_ListEmotions.
    public List<Emotion> predominantEmotion() {
        List<Emotion> lstEPredominant = new ArrayList<Emotion>();
        //Add code here
        Map<EmotionType, Long> frequencies = this.lstEmotions.stream().collect(Collectors.groupingBy(Emotion::getEmotionType, Collectors.counting()));
        List<Emotion> present = this.lstEmotions.stream().distinct().collect(Collectors.toList());
        final Long[] maximum = {0L};
        frequencies.forEach((emotionType, frequency) -> {
            if (frequency > maximum[0]) {
                maximum[0] = frequency;
                lstEPredominant.clear();
            }
            if (frequency.equals(maximum[0])) {
                lstEPredominant.add(present
                        .stream()
                        .filter(emotion -> emotion.getEmotionType().equals(emotionType))
                        .findFirst()
                        .orElseThrow(RuntimeException::new));
            }
        });
        return lstEPredominant;
    }
    // Task A_3
    // Eliminate the emotions that are of given type EmotionType et
    // Remark: A set of test cases to assess the correctness of your code is provided.
    //         A class to test this method was created, several test cases were added.
    //         Use the test cases to check for your code.
    public void eliminateAllProvidedEmotion(EmotionType et) {
        this.lstEmotions.removeIf(emotion -> emotion.getEmotionType().equals(et));
    }
}