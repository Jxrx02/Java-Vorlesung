package AA_Klausuren.Jahr2020;

import java.util.LinkedList;
import java.util.List;

public class CoronaWarnClient {

    private List<Token> tokens = new LinkedList<>(); //Tokens in der Nähe
    private List<Token> changingTokens = new LinkedList<>();

    private Token curToken;

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public void setChangingTokens(List<Token> changingTokens) {
        this.changingTokens = changingTokens;
    }

    public void setCurToken(Token curToken) {
        this.curToken = curToken;
        tokens.add(curToken);
    }

    Token getCurrentToken(){
        return curToken;
    }

    public List<Token> getAllTokens() {
        return changingTokens;
    }

    public List<Token> getAllSeenTokens() {
        return tokens;
    }

    public void tokenReceived(Token token) {
    }

    public void clearTokens(){
        tokens.clear();
        changingTokens.clear();
    }
}
