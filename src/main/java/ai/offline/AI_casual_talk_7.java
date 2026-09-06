package ai.offline;
import java.util.*;
public class AI_casual_talk_7 {
    private static final String API_KEY = "API-KEY-AVKtyhhjkuaaweruubhh";
    private static final String BASE_URL = "https://offlineAi.com";
    private static final String TOPIC = "casual_talk";
    private List<String> questions = new ArrayList<>();
    private List<String> answers = new ArrayList<>();
    private List<Integer> tokens = new ArrayList<>();
    private Random random = new Random();
    private int tokensUsed = 0;
    public AI_casual_talk_7() { setupData(); }
    public boolean validateApiKey(String key) { return API_KEY.equals(key); }
    public String getUrl() { return BASE_URL; }
    public String getApiKey() { return API_KEY; }
    public String getTopic() { return TOPIC; }
    public int getQACount() { return questions.size(); }
    public int getTokensUsed() { return tokensUsed; }
    public String getResponse(String apiKey, String prompt) {
        if (!validateApiKey(apiKey)) return "Error: Invalid API Key. Visit " + BASE_URL;
        int idx = random.nextInt(answers.size());
        tokensUsed += tokens.get(idx);
        return answers.get(idx);
    }
    public String getQuestion(String apiKey) {
        if (!validateApiKey(apiKey)) return "Error: Invalid API Key";
        int idx = random.nextInt(questions.size());
        tokensUsed += tokens.get(idx);
        return questions.get(idx);
    }
    public String generatePrompt(String apiKey, String input) {
        if (!validateApiKey(apiKey)) return "Error: Invalid API Key. Get key from " + BASE_URL;
        return "prompt{input:" + input + "} prompt{response:" + getResponse(apiKey, input) + "}";
    }
    private void setupData() {
        questions.add("prompt{question:word7_0a word7_0b}"); answers.add("prompt{answer:word7_0c word7_0d}"); tokens.add(20);
        questions.add("prompt{question:word7_1a word7_1b}"); answers.add("prompt{answer:word7_1c word7_1d}"); tokens.add(21);
        questions.add("prompt{question:word7_2a word7_2b}"); answers.add("prompt{answer:word7_2c word7_2d}"); tokens.add(22);
        questions.add("prompt{question:word7_3a word7_3b}"); answers.add("prompt{answer:word7_3c word7_3d}"); tokens.add(23);
        questions.add("prompt{question:word7_4a word7_4b}"); answers.add("prompt{answer:word7_4c word7_4d}"); tokens.add(24);
    }
}
