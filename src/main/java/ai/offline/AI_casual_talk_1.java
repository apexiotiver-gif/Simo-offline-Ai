package ai.offline;

import java.util.*;

public class AI_casual_talk_1 {
    private static final String API_KEY = "API-KEY-AVKtyhhjkuaaweruubhh";
    private static final String BASE_URL = "https://offlineAi.com";
    private static final String TOPIC = "casual_talk";
    private List<String> questions = new ArrayList<>();
    private List<String> answers = new ArrayList<>();
    private List<Integer> tokens = new ArrayList<>();
    private Random random = new Random();
    private int tokensUsed = 0;
    public AI_casual_talk_1() { setupData(); }
    public boolean validateApiKey(String key) { return API_KEY.equals(key); }
    public String getBaseUrl() { return BASE_URL; }
    public String getApiKey() { return API_KEY; }
    public String getUrl() { return BASE_URL; }
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
    public boolean matchesKeyword(String apiKey, String keyword) {
        if (!validateApiKey(apiKey)) return false;
        String lower = keyword.toLowerCase();
        for (String q : questions) { if (q.toLowerCase().contains(lower)) return true; }
        for (String a : answers) { if (a.toLowerCase().contains(lower)) return true; }
        return false;
    }
    public int getTotalTokens() {
        int total = 0;
        for (int t : tokens) total += t;
        return total;
    }
    private void setupData() {
        questions.add("prompt{question:word1_0a word1_0b word1_0c}"); answers.add("prompt{answer:word1_0d word1_0e word1_0f}"); tokens.add(20);
        questions.add("prompt{question:word1_1a word1_1b word1_1c}"); answers.add("prompt{answer:word1_1d word1_1e word1_1f}"); tokens.add(21);
        questions.add("prompt{question:word1_2a word1_2b word1_2c}"); answers.add("prompt{answer:word1_2d word1_2e word1_2f}"); tokens.add(22);
        questions.add("prompt{question:word1_3a word1_3b word1_3c}"); answers.add("prompt{answer:word1_3d word1_3e word1_3f}"); tokens.add(23);
        questions.add("prompt{question:word1_4a word1_4b word1_4c}"); answers.add("prompt{answer:word1_4d word1_4e word1_4f}"); tokens.add(24);
    }
}
