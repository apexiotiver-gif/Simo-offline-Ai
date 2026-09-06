# Simo-offline-Ai

**Offline Rule-Based AI Chatbot Library for Android — 228 Java Classes — No Internet — No Server — No LLM**

## What Is This?

This is a **rule-based AI** library, NOT an LLM, NOT a server-based AI, NOT ChatGPT. It works fully offline. All 228 Java classes are bundled inside the JAR with pre-written Hinglish Q&A pairs. Responses are selected randomly from the Q&A list — like ELIZA chatbot but with 228 specialized classes.

- **228 Java classes** — each with Hinglish Q&A pairs
- **No internet required** — fully offline, zero HTTP calls
- **No server** — `https://offlineAi.com` is just a reference string, no request is made
- **No LLM** — rule-based, pre-written responses, random selection
- **API Key** — validated locally against hardcoded string, not online
- **Token tracking** — every response consumes virtual tokens
- **Prompt format** — `prompt{question:...}` / `prompt{answer:...}`

---

## Dependency

```gradle
implementation 'com.github.apexiotiver-gif:Simo-offline-Ai:v1.0.7'
```

### JitPack Repository

```gradle
repositories {
    google()
    mavenCentral()
    maven { url 'https://jitpack.io' }
}
```

### Package

```
ai.offline.*
```

---

## Full Java Class Code (Every Class Has This Structure)

Here is the complete source code of `AI_casual_talk_1.java`. All 228 classes follow this exact same pattern — only the class name, topic, and Q&A data differ.

```java
package ai.offline;

import java.util.*;

public class AI_casual_talk_1 {

    // ===== CONSTANTS (same in all 228 classes) =====
    private static final String API_KEY = "API-KEY-AVKtyhhjkuaaweruubhh";
    private static final String BASE_URL = "https://offlineAi.com";
    private static final String TOPIC = "casual_talk";      // changes per class
    private static final int FILE_ID = 1;                   // changes per class

    // ===== DATA STORAGE =====
    private List<String> questions = new ArrayList<>();
    private List<String> answers = new ArrayList<>();
    private List<Integer> tokens = new ArrayList<>();
    private Random random = new Random();
    private int tokensUsed = 0;

    // ===== CONSTRUCTOR (calls setup methods) =====
    public AI_casual_talk_1() {
        setupData1();
        setupData2();
        setupData3();
        setupData4();
    }

    // ===== API KEY VALIDATION (local check, no server) =====
    public boolean validateApiKey(String key) {
        return API_KEY.equals(key);
    }

    // ===== GET LIBRARY INFO =====
    public String getBaseUrl() { return BASE_URL; }
    public String getApiKey()  { return API_KEY; }
    public String getUrl()     { return BASE_URL; }
    public String getTopic()   { return TOPIC; }
    public int    getFileId()  { return FILE_ID; }
    public int    getQACount() { return questions.size(); }
    public int    getTokensUsed() { return tokensUsed; }

    // ===== MAIN METHOD: Get AI Response =====
    // Pass API key + user input, returns random answer
    // If wrong key, returns error string
    // Each call increments tokensUsed
    public String getResponse(String apiKey, String prompt) {
        if (!validateApiKey(apiKey)) {
            return "Error: Invalid API Key. Visit " + BASE_URL;
        }
        int idx = random.nextInt(answers.size());
        tokensUsed += tokens.get(idx);
        return answers.get(idx);
    }

    // ===== GET RANDOM QUESTION =====
    // Returns a random question from the Q&A list
    public String getQuestion(String apiKey) {
        if (!validateApiKey(apiKey)) {
            return "Error: Invalid API Key";
        }
        int idx = random.nextInt(questions.size());
        tokensUsed += tokens.get(idx);
        return questions.get(idx);
    }

    // ===== GENERATE FULL PROMPT =====
    // Returns combined prompt{input:...} prompt{response:...}
    public String generatePrompt(String apiKey, String input) {
        if (!validateApiKey(apiKey)) {
            return "Error: Invalid API Key. Get key from " + BASE_URL;
        }
        return "prompt{input:" + input + "} prompt{response:"
             + getResponse(apiKey, input) + "}";
    }

    // ===== KEYWORD MATCHING =====
    // Check if a keyword exists in any question or answer
    public boolean matchesKeyword(String apiKey, String keyword) {
        if (!validateApiKey(apiKey)) return false;
        String lower = keyword.toLowerCase();
        for (String q : questions) {
            if (q.toLowerCase().contains(lower)) return true;
        }
        for (String a : answers) {
            if (a.toLowerCase().contains(lower)) return true;
        }
        return false;
    }

    // ===== TOTAL TOKENS AVAILABLE =====
    public int getTotalTokens() {
        int total = 0;
        for (int t : tokens) total += t;
        return total;
    }

    // ===== DATA SETUP (split into multiple methods) =====
    // Each method adds Q&A pairs with token costs
    private void setupData1() {
        questions.add("prompt{question:kaise ho}");
        answers.add("prompt{answer:main bilkul thik hoon}");
        tokens.add(15);

        questions.add("prompt{question:kya kar rahe ho}");
        answers.add("prompt{answer:kuch nahi bas aise hi}");
        tokens.add(12);
    }

    private void setupData2() {
        questions.add("prompt{question:khana khaaya}");
        answers.add("prompt{answer:haan abhi khaaya}");
        tokens.add(10);
    }

    private void setupData3() {
        questions.add("prompt{question:kahan ja rahe ho}");
        answers.add("prompt{answer:bas market ja raha hoon}");
        tokens.add(14);
    }

    private void setupData4() {
        questions.add("prompt{question:free ho kya}");
        answers.add("prompt{answer:haan bilkul free hoon}");
        tokens.add(8);
    }
}
```

### How Each Part Works

| Part | Purpose | Example |
|---|---|---|
| `API_KEY` | Hardcoded key, same in all 228 classes | `API-KEY-AVKtyhhjkuaaweruubhh` |
| `BASE_URL` | Reference URL, NO HTTP call made | `https://offlineAi.com` |
| `TOPIC` | Category name, different per class | `casual_talk`, `emotions`, `greetings` |
| `questions` | List of pre-written questions | `prompt{question:kaise ho}` |
| `answers` | List of pre-written answers | `prompt{answer:main bilkul thik hoon}` |
| `tokens` | Token cost per Q&A pair | `15`, `12`, `10` |
| `tokensUsed` | Running total of consumed tokens | starts at 0, increments per call |
| `random` | Random selector for Q&A pairs | picks any index randomly |

---

## All 228 Classes

| Category | Class Pattern | Example Classes |
|---|---|---|
| Casual Talk | `AI_casual_talk_*` | `AI_casual_talk_1`, `AI_casual_talk_7`, `AI_casual_talk_13` |
| Emotions | `AI_emotions_*` | `AI_emotions_2`, `AI_emotions_8`, `AI_emotions_14` |
| Questions | `AI_questions_*` | `AI_questions_3`, `AI_questions_9`, `AI_questions_15` |
| Compliments | `AI_compliments_*` | `AI_compliments_4`, `AI_compliments_10`, `AI_compliments_16` |
| Farewell | `AI_farewell_*` | `AI_farewell_5`, `AI_farewell_11` |
| Greetings | `AI_greetings_*` | `AI_greetings_6`, `AI_greetings_12` |

---

## All Methods Reference

| Method | Parameters | Returns | Description |
|---|---|---|---|
| `getResponse(key, prompt)` | String, String | String | Get random answer |
| `getQuestion(key)` | String | String | Get random question |
| `generatePrompt(key, input)` | String, String | String | Full prompt{input:...} prompt{response:...} |
| `validateApiKey(key)` | String | boolean | Check if key is valid |
| `getApiKey()` | none | String | Returns API key |
| `getBaseUrl()` | none | String | Returns https://offlineAi.com |
| `getUrl()` | none | String | Same as getBaseUrl() |
| `getTopic()` | none | String | Category name |
| `getFileId()` | none | int | File ID number |
| `getQACount()` | none | int | Q&A pair count |
| `getTokensUsed()` | none | int | Tokens consumed |
| `getTotalTokens()` | none | int | Total tokens available |
| `matchesKeyword(key, word)` | String, String | boolean | Keyword exists in Q&A? |

---

## 50 Usage Examples

All examples use this constant:
```java
String API_KEY = "API-KEY-AVKtyhhjkuaaweruubhh";
```

### Example 1 — Basic response
```java
AI_casual_talk_1 ai = new AI_casual_talk_1();
String response = ai.getResponse(API_KEY, "hello");
// Returns: prompt{answer:main bilkul thik hoon}
```

### Example 2 — Random question
```java
AI_casual_talk_1 ai = new AI_casual_talk_1();
String question = ai.getQuestion(API_KEY);
// Returns: prompt{question:kaise ho}
```

### Example 3 — Full prompt generation
```java
AI_casual_talk_1 ai = new AI_casual_talk_1();
String prompt = ai.generatePrompt(API_KEY, "kaise ho");
// Returns: prompt{input:kaise ho} prompt{response:prompt{answer:...}}
```

### Example 4 — Validate API key
```java
AI_casual_talk_1 ai = new AI_casual_talk_1();
boolean valid = ai.validateApiKey(API_KEY);
// Returns: true
boolean invalid = ai.validateApiKey("wrong");
// Returns: false
```

### Example 5 — Get base URL
```java
AI_casual_talk_1 ai = new AI_casual_talk_1();
String url = ai.getBaseUrl();
// Returns: https://offlineAi.com
```

### Example 6 — Get API key from class
```java
AI_casual_talk_1 ai = new AI_casual_talk_1();
String key = ai.getApiKey();
// Returns: API-KEY-AVKtyhhjkuaaweruubhh
```

### Example 7 — Get topic name
```java
AI_casual_talk_1 ai = new AI_casual_talk_1();
String topic = ai.getTopic();
// Returns: casual_talk
```

### Example 8 — Get Q&A count
```java
AI_casual_talk_1 ai = new AI_casual_talk_1();
int count = ai.getQACount();
// Returns: number of Q&A pairs
```

### Example 9 — Check tokens used
```java
AI_casual_talk_1 ai = new AI_casual_talk_1();
ai.getResponse(API_KEY, "test");
int used = ai.getTokensUsed();
// Returns: token cost of last response
```

### Example 10 — Get total tokens
```java
AI_casual_talk_1 ai = new AI_casual_talk_1();
int total = ai.getTotalTokens();
// Returns: sum of all token values
```

### Example 11 — Wrong API key
```java
AI_casual_talk_1 ai = new AI_casual_talk_1();
String response = ai.getResponse("WRONG_KEY", "hello");
// Returns: "Error: Invalid API Key. Visit https://offlineAi.com"
```

### Example 12 — Wrong key on generatePrompt
```java
AI_casual_talk_1 ai = new AI_casual_talk_1();
String response = ai.generatePrompt("WRONG_KEY", "test");
// Returns: "Error: Invalid API Key. Get key from https://offlineAi.com"
```

### Example 13 — Keyword matching
```java
AI_casual_talk_1 ai = new AI_casual_talk_1();
boolean found = ai.matchesKeyword(API_KEY, "khana");
// Returns: true if "khana" in any Q&A
```

### Example 14 — Multiple random responses
```java
AI_casual_talk_1 ai = new AI_casual_talk_1();
String r1 = ai.getResponse(API_KEY, "test");
String r2 = ai.getResponse(API_KEY, "test");
String r3 = ai.getResponse(API_KEY, "test");
// r1, r2, r3 may all be different
```

### Example 15 — Token tracking after multiple calls
```java
AI_casual_talk_1 ai = new AI_casual_talk_1();
ai.getResponse(API_KEY, "a");
ai.getResponse(API_KEY, "b");
ai.getResponse(API_KEY, "c");
int total = ai.getTokensUsed();
// Returns: sum of 3 responses tokens
```

### Example 16 — Emotions class
```java
AI_emotions_2 ai = new AI_emotions_2();
String response = ai.getResponse(API_KEY, "sad hoon");
// Returns: prompt{answer:...} from emotions
```

### Example 17 — Greetings class
```java
AI_greetings_6 ai = new AI_greetings_6();
String response = ai.getResponse(API_KEY, "hi");
// Returns: prompt{answer:...} from greetings
```

### Example 18 — Compliments class
```java
AI_compliments_4 ai = new AI_compliments_4();
String response = ai.getResponse(API_KEY, "nice");
// Returns: prompt{answer:...} from compliments
```

### Example 19 — Farewell class
```java
AI_farewell_5 ai = new AI_farewell_5();
String response = ai.getResponse(API_KEY, "bye");
// Returns: prompt{answer:...} from farewell
```

### Example 20 — Questions class
```java
AI_questions_3 ai = new AI_questions_3();
String response = ai.getResponse(API_KEY, "what");
// Returns: prompt{answer:...} from questions
```

### Example 21 — Get URL from any class
```java
AI_emotions_2 ai = new AI_emotions_2();
String url = ai.getUrl();
// Returns: https://offlineAi.com
```

### Example 22 — Get file ID
```java
AI_casual_talk_1 ai = new AI_casual_talk_1();
int id = ai.getFileId();
// Returns: 1
```

### Example 23 — Sketchware button click
```java
// onCreate:
final AI_casual_talk_1 ai = new AI_casual_talk_1();
final String KEY = "API-KEY-AVKtyhhjkuaaweruubhh";

// button1 onClick:
String response = ai.getResponse(KEY, edittext1.getText().toString());
textview1.setText(response);
```

### Example 24 — Token display in Sketchware
```java
// button2 onClick:
int used = ai.getTokensUsed();
int total = ai.getTotalTokens();
textview1.setText("Tokens: " + used + " / " + total);
```

### Example 25 — Route to class by keyword
```java
String input = edittext1.getText().toString();
String response;
if (input.contains("bye") || input.contains("tata")) {
    response = new AI_farewell_5().getResponse(API_KEY, input);
} else if (input.contains("hi") || input.contains("hello")) {
    response = new AI_greetings_6().getResponse(API_KEY, input);
} else if (input.contains("sad") || input.contains("dukhi")) {
    response = new AI_emotions_2().getResponse(API_KEY, input);
} else if (input.contains("nice") || input.contains("accha")) {
    response = new AI_compliments_4().getResponse(API_KEY, input);
} else {
    response = new AI_casual_talk_1().getResponse(API_KEY, input);
}
textview1.setText(response);
```

### Example 26 — Question + answer together
```java
AI_casual_talk_1 ai = new AI_casual_talk_1();
String q = ai.getQuestion(API_KEY);
String a = ai.getResponse(API_KEY, q);
// q = prompt{question:kaise ho}
// a = prompt{answer:main bilkul thik hoon}
```

### Example 27 — Keyword check before responding
```java
AI_casual_talk_1 ai = new AI_casual_talk_1();
String word = "khana";
if (ai.matchesKeyword(API_KEY, word)) {
    String r = ai.getResponse(API_KEY, word);
    textview1.setText(r);
} else {
    textview1.setText("Not found");
}
```

### Example 28 — Multiple classes together
```java
AI_casual_talk_1 casual = new AI_casual_talk_1();
AI_emotions_2 emotions = new AI_emotions_2();
AI_greetings_6 greetings = new AI_greetings_6();
String r1 = casual.getResponse(API_KEY, "test");
String r2 = emotions.getResponse(API_KEY, "test");
String r3 = greetings.getResponse(API_KEY, "test");
```

### Example 29 — Token budget check
```java
AI_casual_talk_1 ai = new AI_casual_talk_1();
if (ai.getTokensUsed() < ai.getTotalTokens()) {
    String r = ai.getResponse(API_KEY, "hello");
    textview1.setText(r);
} else {
    textview1.setText("Budget exhausted");
}
```

### Example 30 — Validate before use
```java
AI_casual_talk_1 ai = new AI_casual_talk_1();
if (ai.validateApiKey(API_KEY)) {
    String r = ai.getResponse(API_KEY, "hello");
    textview1.setText(r);
} else {
    textview1.setText("Invalid key. Visit " + ai.getUrl());
}
```

### Example 31 — Loop responses
```java
AI_casual_talk_1 ai = new AI_casual_talk_1();
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 5; i++) {
    sb.append(ai.getResponse(API_KEY, "test")).append("\n");
}
textview1.setText(sb.toString());
```

### Example 32 — Parse answer from prompt
```java
AI_casual_talk_1 ai = new AI_casual_talk_1();
String full = ai.generatePrompt(API_KEY, "kaise ho");
int idx = full.indexOf("prompt{answer:");
if (idx >= 0) {
    String answer = full.substring(idx);
    textview1.setText(answer);
}
```

### Example 33 — Compare tokens across classes
```java
AI_casual_talk_1 c = new AI_casual_talk_1();
AI_emotions_2 e = new AI_emotions_2();
c.getResponse(API_KEY, "test");
e.getResponse(API_KEY, "test");
textview1.setText("Casual: " + c.getTokensUsed() + " | Emotions: " + e.getTokensUsed());
```

### Example 34 — Show topic name
```java
AI_casual_talk_1 ai = new AI_casual_talk_1();
textview1.setText("Topic: " + ai.getTopic());
// Shows: Topic: casual_talk
```

### Example 35 — Q&A count for categories
```java
int c1 = new AI_casual_talk_1().getQACount();
int c2 = new AI_emotions_2().getQACount();
int c3 = new AI_greetings_6().getQACount();
textview1.setText("Casual: " + c1 + " | Emotions: " + c2 + " | Greetings: " + c3);
```

### Example 36 — Error handling
```java
AI_casual_talk_1 ai = new AI_casual_talk_1();
String r = ai.getResponse(API_KEY, "test");
if (r.startsWith("Error:")) {
    textview1.setText("Error: " + r);
} else {
    textview1.setText("AI: " + r);
}
```

### Example 37 — Display URL
```java
AI_casual_talk_1 ai = new AI_casual_talk_1();
textview1.setText("Visit: " + ai.getUrl());
// Shows: Visit: https://offlineAi.com
```

### Example 38 — Random class selection
```java
Random rand = new Random();
String r;
switch(rand.nextInt(6)) {
    case 0: r = new AI_casual_talk_1().getResponse(API_KEY, "test"); break;
    case 1: r = new AI_emotions_2().getResponse(API_KEY, "test"); break;
    case 2: r = new AI_questions_3().getResponse(API_KEY, "test"); break;
    case 3: r = new AI_compliments_4().getResponse(API_KEY, "test"); break;
    case 4: r = new AI_farewell_5().getResponse(API_KEY, "test"); break;
    default: r = new AI_greetings_6().getResponse(API_KEY, "test"); break;
}
textview1.setText(r);
```

### Example 39 — Token percentage
```java
AI_casual_talk_1 ai = new AI_casual_talk_1();
ai.getResponse(API_KEY, "a");
ai.getResponse(API_KEY, "b");
int pct = (ai.getTokensUsed() * 100) / ai.getTotalTokens();
textview1.setText("Usage: " + pct + "%");
```

### Example 40 — Keyword search across classes
```java
String word = "khana";
boolean found = new AI_casual_talk_1().matchesKeyword(API_KEY, word)
    || new AI_emotions_2().matchesKeyword(API_KEY, word)
    || new AI_greetings_6().matchesKeyword(API_KEY, word);
textview1.setText("Found: " + found);
```

### Example 41 — Chat history
```java
List<String> history = new ArrayList<>();
AI_casual_talk_1 ai = new AI_casual_talk_1();
String user = edittext1.getText().toString();
String reply = ai.getResponse(API_KEY, user);
history.add("You: " + user);
history.add("AI: " + reply);
StringBuilder sb = new StringBuilder();
for (String h : history) sb.append(h).append("\n");
textview1.setText(sb.toString());
```

### Example 42 — Quiz mode (questions only)
```java
AI_questions_3 ai = new AI_questions_3();
String q = ai.getQuestion(API_KEY);
textview1.setText(q);
// Shows: prompt{question:...}
```

### Example 43 — Validate then generate
```java
AI_casual_talk_1 ai = new AI_casual_talk_1();
if (ai.validateApiKey(API_KEY)) {
    textview1.setText(ai.generatePrompt(API_KEY, "hello"));
} else {
    textview1.setText("Invalid key");
}
```

### Example 44 — File ID for logging
```java
AI_casual_talk_1 ai = new AI_casual_talk_1();
System.out.println("Class #" + ai.getFileId() + " topic: " + ai.getTopic());
// Output: Class #1 topic: casual_talk
```

### Example 45 — Full chatbot session
```java
String KEY = "API-KEY-AVKtyhhjkuaaweruubhh";
String greeting = new AI_greetings_6().getResponse(KEY, "namaste");
String chat = new AI_casual_talk_1().getResponse(KEY, "kaise ho");
String bye = new AI_farewell_5().getResponse(KEY, "bye");
textview1.setText(greeting + "\n" + chat + "\n" + bye);
```

### Example 46 — Token reset (new instance)
```java
AI_casual_talk_1 ai = new AI_casual_talk_1();
ai.getResponse(API_KEY, "test");
int before = ai.getTokensUsed();
ai = new AI_casual_talk_1();
int after = ai.getTokensUsed(); // Returns: 0
```

### Example 47 — Remaining tokens
```java
AI_casual_talk_1 ai = new AI_casual_talk_1();
ai.getResponse(API_KEY, "test");
int remaining = ai.getTotalTokens() - ai.getTokensUsed();
textview1.setText("Remaining: " + remaining);
```

### Example 48 — Verify key with getApiKey()
```java
AI_casual_talk_1 ai = new AI_casual_talk_1();
if (ai.getApiKey().equals("API-KEY-AVKtyhhjkuaaweruubhh")) {
    textview1.setText("Verified");
} else {
    textview1.setText("Mismatch");
}
```

### Example 49 — All formats display
```java
AI_casual_talk_1 ai = new AI_casual_talk_1();
String display = "QUESTION:\n" + ai.getQuestion(API_KEY) + "\n\n"
    + "ANSWER:\n" + ai.getResponse(API_KEY, "test") + "\n\n"
    + "PROMPT:\n" + ai.generatePrompt(API_KEY, "test");
textview1.setText(display);
```

### Example 50 — Complete Sketchware chat app
```java
// ===== onCreate =====
final String KEY = "API-KEY-AVKtyhhjkuaaweruubhh";
final AI_casual_talk_1 ai = new AI_casual_talk_1();
final StringBuilder chat = new StringBuilder();

// ===== button1 (Send) =====
String input = edittext1.getText().toString();
if (input.isEmpty()) return;
chat.append("You: ").append(input).append("\n");
String r;
if (input.contains("bye")) r = new AI_farewell_5().getResponse(KEY, input);
else if (input.contains("hi")) r = new AI_greetings_6().getResponse(KEY, input);
else if (input.contains("sad")) r = new AI_emotions_2().getResponse(KEY, input);
else r = ai.getResponse(KEY, input);
chat.append("AI: ").append(r).append("\n\n");
textview1.setText(chat.toString());
edittext1.setText("");

// ===== button2 (Token Info) =====
textview1.setText("Tokens: " + ai.getTokensUsed() + "/" + ai.getTotalTokens()
    + "\nQ&A: " + ai.getQACount());

// ===== button3 (Clear) =====
chat.setLength(0);
textview1.setText("");
```

---

## Sketchware Installation

1. Open Sketchware project
2. Library Manager, add JitPack: `maven { url 'https://jitpack.io' }`
3. Add dependency: `com.github.apexiotiver-gif:Simo-offline-Ai:v1.0.7`
4. In code: `import ai.offline.*;`
5. Use: `new AI_casual_talk_1().getResponse("API-KEY-AVKtyhhjkuaaweruubhh", "hello")`

---

## Key Facts

- **API Key:** `API-KEY-AVKtyhhjkuaaweruubhh` (same for all 228 classes, checked locally)
- **Base URL:** `https://offlineAi.com` (reference only, no HTTP call)
- **Prompt format:** `prompt{question:...}` / `prompt{answer:...}`
- **Token system:** Each Q&A has a token cost, tracked per instance
- **No internet, No server, No LLM** — rule-based offline AI
- **Version:** v1.0.7 (228 classes, ~32MB JAR)

## Links

- GitHub: https://github.com/apexiotiver-gif/Simo-offline-Ai
- JitPack: https://jitpack.io/#apexiotiver-gif/Simo-offline-Ai
- Dependency: `com.github.apexiotiver-gif:Simo-offline-Ai:v1.0.7`
