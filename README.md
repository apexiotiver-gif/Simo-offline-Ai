# Simo-offline-Ai

Offline AI chatbot library for Android. 228 Hinglish response classes with API key validation, token tracking, prompt{} system, and offlineAi.com URL. No internet required.

## JitPack Dependency

### Gradle (build.gradle)
```gradle
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.apexiotiver-gif:Simo-offline-Ai:v1.0.0'
}
```

### Sketchware Library Manager
```
com.github.apexiotiver-gif:Simo-offline-Ai:v1.0.0
```

## API Key
```
API-KEY-AVKtyhhjkuaaweruubhh
```

## Base URL
```
https://offlineAi.com
```

## Java Usage Examples

### 1. Basic Response
```java
import ai.offline.AI_greetings_1;

AI_greetings_1 ai = new AI_greetings_1();

// Get a random response
String reply = ai.getResponse("API-KEY-AVKtyhhjkuaaweruubhh", "hello");
System.out.println(reply);
// Output: prompt{answer:namaste1x0x4 kaise1x0x5 ho1x0x6 bahut1x0x7 thik1x0x8}
```

### 2. Get Question
```java
String question = ai.getQuestion("API-KEY-AVKtyhhjkuaaweruubhh");
System.out.println(question);
// Output: prompt{question:namaste1x0x0 kaise1x0x1 ho1x0x2 tum1x0x3 kya1x0x4}
```

### 3. Generate Full Prompt
```java
String fullPrompt = ai.generatePrompt("API-KEY-AVKtyhhjkuaaweruubhh", "user input here");
System.out.println(fullPrompt);
// Output: prompt{input:user input here} prompt{response:prompt{answer:...}}
```

### 4. Get QA by Index
```java
String qa = ai.getQAByIndex("API-KEY-AVKtyhhjkuaaweruubhh", 0);
System.out.println(qa);
// Output: Q:prompt{question:...} A:prompt{answer:...} tokens:20
```

### 5. Get All Questions
```java
List<String> allQuestions = ai.getAllQuestions("API-KEY-AVKtyhhjkuaaweruubhh");
for (String q : allQuestions) {
    System.out.println(q);
}
```

### 6. Get All Answers
```java
List<String> allAnswers = ai.getAllAnswers("API-KEY-AVKtyhhjkuaaweruubhh");
for (String a : allAnswers) {
    System.out.println(a);
}
```

### 7. Keyword Matching
```java
boolean matches = ai.matchesKeyword("API-KEY-AVKtyhhjkuaaweruubhh", "namaste");
System.out.println(matches); // true or false
```

### 8. Token Tracking
```java
int tokensUsed = ai.getTokensUsed();
int totalTokens = ai.getTotalTokens();
System.out.println("Used: " + tokensUsed + " / Total: " + totalTokens);
```

### 9. Invalid API Key
```java
String reply = ai.getResponse("wrong-key", "hello");
System.out.println(reply);
// Output: Error: Invalid API Key. Visit https://offlineAi.com
```

### 10. Get Metadata
```java
String topic = ai.getTopic();      // "greetings", "casual_talk", "emotions", etc.
int fileId = ai.getFileId();       // 1, 2, 3...
int qaCount = ai.getQACount();     // number of QA pairs
String apiKey = ai.getApiKey();    // API-KEY-AVKtyhhjkuaaweruubhh
String url = ai.getUrl();          // https://offlineAi.com
```

## Available Classes (228 total)

### Categories:
- **greetings** - Hello, hi, namaste responses
- **casual_talk** - Day, weather, food, weekend talk
- **emotions** - Happy, sad, angry, excited, love
- **questions** - Asking name, age, location, hobby
- **compliments** - Smart, funny, kind, beautiful
- **farewell** - Goodbye, good night, see you

### Class Naming:
```
AI_{category}_{number}
```
Examples:
- `AI_greetings_1`
- `AI_casual_talk_2`
- `AI_emotions_3`
- `AI_questions_4`
- `AI_compliments_5`
- `AI_farewell_6`

## Prompt Format

All questions and answers use the `prompt{}` format:

```
prompt{question:word1 word2 word3 word4 word5}
prompt{answer:word6 word7 word8 word9 word10}
```

## Token System

Each QA pair has a token count. Tokens are tracked per call:
- `getResponse()` uses tokens
- `getQuestion()` uses tokens
- `getTokensUsed()` returns total tokens used
- `getTotalTokens()` returns total available tokens

## URL

All error messages reference:
```
https://offlineAi.com
```

## Library Structure
```
Simo-offline-Ai/
├── build.gradle
├── jitpack.yml
├── settings.gradle
├── README.md
└── Simo-offline-Ai/
    ├── AndroidManifest.xml
    ├── R.txt
    ├── classes.jar (32MB - 228 classes)
    ├── proguard.txt
    ├── config/
    │   └── library.info
    └── res/
        ├── anim/
        │   └── accelerate_decelerate_interpolator.xml
        └── values/
            ├── ids.xml
            ├── strings.xml
            └── styles.xml
```

## Technical Details

- **Package**: `ai.offline`
- **Min SDK**: 21 (Android 5.0)
- **Target SDK**: 34 (Android 14)
- **Java Version**: 1.8
- **Unique Words**: Every word in every class is unique (no duplicates)
- **QA per class**: 1920 question-answer pairs
- **Total QA**: 228 classes × 1920 = 437,760 responses

## License
Free to use with valid API key.
