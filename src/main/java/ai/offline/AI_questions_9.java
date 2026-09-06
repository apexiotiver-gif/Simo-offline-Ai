package ai.offline;
import java.util.*;
public class AI_questions_9 {
    private static final String API_KEY = "API-KEY-AVKtyhhjkuaaweruubhh";
    private static final String BASE_URL = "https://offlineAi.com";
    private static final String TOPIC = "questions";
    private List<String> questions = new ArrayList<>();
    private List<String> answers = new ArrayList<>();
    private List<Integer> tokens = new ArrayList<>();
    private Random random = new Random();
    private int tokensUsed = 0;
    public AI_questions_9() { setupData(); }
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
        questions.add("prompt{question:word9_0a word9_0b}"); answers.add("prompt{answer:word9_0c word9_0d}"); tokens.add(20);
        questions.add("prompt{question:word9_1a word9_1b}"); answers.add("prompt{answer:word9_1c word9_1d}"); tokens.add(21);
        questions.add("prompt{question:word9_2a word9_2b}"); answers.add("prompt{answer:word9_2c word9_2d}"); tokens.add(22);
        questions.add("prompt{question:word9_3a word9_3b}"); answers.add("prompt{answer:word9_3c word9_3d}"); tokens.add(23);
        questions.add("prompt{question:word9_4a word9_4b}"); answers.add("prompt{answer:word9_4c word9_4d}"); tokens.add(24);
    }
}
