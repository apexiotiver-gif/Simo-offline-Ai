# Simo-offline-Ai

Offline AI chatbot library for Android. 228 Java classes with Hinglish Q&A responses. No internet required — all responses are bundled in the JAR.

## JitPack Dependency

### Step 1: Add JitPack repository

In your `build.gradle` (project-level or settings.gradle):

```gradle
repositories {
    google()
    mavenCentral()
    maven { url 'https://jitpack.io' }
}
```

### Step 2: Add dependency

In your app-level `build.gradle`:

```gradle
dependencies {
    implementation 'com.github.apexiotiver-gif:Simo-offline-Ai:v1.0.7'
}
```

## Library Details

- **Package:** `ai.offline`
- **Classes:** 228 AI classes
- **JAR size:** ~32MB
- **API Key:** `API-KEY-AVKtyhhjkuaaweruubhh`
- **Base URL:** `https://offlineAi.com`
- **Prompt format:** `prompt{question:...}` / `prompt{answer:...}`

## Available Classes

All classes are in package `ai.offline`. Categories:

| Category | Example Class Names |
|---|---|
| Casual Talk | `AI_casual_talk_1`, `AI_casual_talk_7`, `AI_casual_talk_13` ... |
| Emotions | `AI_emotions_2`, `AI_emotions_8`, `AI_emotions_14` ... |
| Questions | `AI_questions_3`, `AI_questions_9`, `AI_questions_15` ... |
| Compliments | `AI_compliments_4`, `AI_compliments_10`, `AI_compliments_16` ... |
| Farewell | `AI_farewell_5`, `AI_farewell_11` ... |
| Greetings | `AI_greetings_6`, `AI_greetings_12` ... |

Total: 228 classes. Each class contains 5+ Q&A pairs with token tracking.

## Usage

### Import

```java
import ai.offline.*;
```

### Basic Example — Get AI Response

```java
// Create object
AI_casual_talk_1 ai = new AI_casual_talk_1();

// API key
String key = "API-KEY-AVKtyhhjkuaaweruubhh";

// Get response (returns answer)
String answer = ai.getResponse(key, "hello");
// Output: prompt{answer:word1_0c word1_0d}

// Get random question
String question = ai.getQuestion(key);
// Output: prompt{question:word1_0a word1_0b}

// Generate full prompt
String prompt = ai.generatePrompt(key, "kaise ho");
// Output: prompt{input:kaise ho} prompt{response:prompt{answer:...}}
```

### API Validation

```java
AI_casual_talk_1 ai = new AI_casual_talk_1();

// Validate API key
boolean valid = ai.validateApiKey("API-KEY-AVKtyhhjkuaaweruubhh");
// Returns true if correct, false if wrong

// If wrong key is passed, methods return error:
String response = ai.getResponse("wrong-key", "hello");
// Output: "Error: Invalid API Key. Visit https://offlineAi.com"
```

### Token Tracking

```java
AI_emotions_2 ai = new AI_emotions_2();
String key = "API-KEY-AVKtyhhjkuaaweruubhh";

// Each response consumes tokens
ai.getResponse(key, "test1");
ai.getResponse(key, "test2");

// Check tokens used
int used = ai.getTokensUsed();
System.out.println("Tokens used: " + used);

// Check total available tokens
int total = ai.getTotalTokens();
System.out.println("Total tokens: " + total);

// Check Q&A count
int count = ai.getQACount();
System.out.println("Q&A pairs: " + count);
```

### Get Library Info

```java
AI_casual_talk_1 ai = new AI_casual_talk_1();

String url = ai.getUrl();       // https://offlineAi.com
String key = ai.getApiKey();     // API-KEY-AVKtyhhjkuaaweruubhh
String topic = ai.getTopic();   // casual_talk
```

### Complete Sketchware Example

```java
// In Sketchware onCreate event:
final AI_casual_talk_1 ai = new AI_casual_talk_1();
final String API_KEY = "API-KEY-AVKtyhhjkuaaweruubhh";

// button1 onClick:
String userInput = edittext1.getText().toString();
String response = ai.getResponse(API_KEY, userInput);
textview1.setText(response);

// button2 onClick (token info):
int tokens = ai.getTokensUsed();
int total = ai.getTotalTokens();
textview1.setText("Used: " + tokens + " / " + total);
```

### Using Multiple Classes

```java
String key = "API-KEY-AVKtyhhjkuaaweruubhh";

AI_casual_talk_1 casual = new AI_casual_talk_1();
AI_emotions_2 emotions = new AI_emotions_2();
AI_greetings_6 greetings = new AI_greetings_6();
AI_compliments_4 compliments = new AI_compliments_4();
AI_farewell_5 farewell = new AI_farewell_5();

// Pick based on user input
String response;
if (userInput.contains("bye")) {
    response = farewell.getResponse(key, userInput);
} else if (userInput.contains("hi") || userInput.contains("hello")) {
    response = greetings.getResponse(key, userInput);
} else {
    response = casual.getResponse(key, userInput);
}
```

## All Methods

| Method | Parameters | Returns | Description |
|---|---|---|---|
| `getResponse(key, prompt)` | String, String | String | Get AI answer for prompt |
| `getQuestion(key)` | String | String | Get random question |
| `generatePrompt(key, input)` | String, String | String | Full prompt{input:...} prompt{response:...} |
| `validateApiKey(key)` | String | boolean | Check if API key is valid |
| `getApiKey()` | none | String | Returns API key |
| `getUrl()` | none | String | Returns https://offlineAi.com |
| `getTopic()` | none | String | Returns category name |
| `getQACount()` | none | int | Number of Q&A pairs |
| `getTokensUsed()` | none | int | Tokens consumed so far |
| `getTotalTokens()` | none | int | Total tokens available |

## Installation for Sketchware

1. Open Sketchware project
2. Go to Library Manager
3. Add JitPack repository: `maven { url 'https://jitpack.io' }`
4. Add dependency: `com.github.apexiotiver-gif:Simo-offline-Ai:v1.0.7`
5. Import in code: `import ai.offline.*;`

## Author

**apexiotiver-gif**

GitHub: https://github.com/apexiotiver-gif/Simo-offline-Ai  
JitPack: https://jitpack.io/#apexiotiver-gif/Simo-offline-Ai
