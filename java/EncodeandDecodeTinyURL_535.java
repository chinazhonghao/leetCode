public class Codec {

    String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    Map<Integer, Tuple> map = new HashMap<>();
    int count = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        count++;
        String hash = generateHash(count);
        map.put(count, new Tuple(hash, longUrl));
        return hash;
    }

    private String generateHash(int count) {
        StringBuilder sb = new StringBuilder();
        while(count > 0) {
            int remainder = count % 62;
            sb.append(alphabet.charAt(remainder));
            count = count / 62;
        }
        if(count > 0) sb.append(alphabet.charAt(count));
        return sb.reverse().toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int hash = generateHash(shortUrl);
        return map.get(hash).longUrl;
    }

    private int generateHash(String shortUrl) {
        int result = 0;
        for(int i = 0; i < shortUrl.length(); i++) {
            result = result * 62 + alphabet.indexOf(shortUrl.charAt(i));
        }
        return result;
    }
}

class Tuple {
    String longUrl;
    String shortUrl;

    public Tuple(String shortUrl, String longUrl) {
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));