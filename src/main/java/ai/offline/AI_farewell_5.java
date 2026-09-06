package ai.offline;
import java.util.*;
public class AI_farewell_5 {
    private static final String API_KEY = "API-KEY-AVKtyhhjkuaaweruubhh";
    private static final String BASE_URL = "https://offlineAi.com";
    private static final String TOPIC = "farewell";
    private List<String> questions = new ArrayList<>();
    private List<String> answers = new ArrayList<>();
    private List<Integer> tokens = new ArrayList<>();
    private Random random = new Random();
    private int tokensUsed = 0;
    public AI_farewell_5() { setupData(); }
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
        questions.add("prompt{question:word5_0a word5_0b}"); answers.add("prompt{answer:word5_0c word5_0d}"); tokens.add(20);
        questions.add("prompt{question:word5_1a word5_1b}"); answers.add("prompt{answer:word5_1c word5_1d}"); tokens.add(21);
        questions.add("prompt{question:word5_2a word5_2b}"); answers.add("prompt{answer:word5_2c word5_2d}"); tokens.add(22);
        questions.add("prompt{question:word5_3a word5_3b}"); answers.add("prompt{answer:word5_3c word5_3d}"); tokens.add(23);
        questions.add("prompt{question:word5_4a word5_4b}"); answers.add("prompt{answer:word5_4c word5_4d}"); tokens.add(24);
    }
}
