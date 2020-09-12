
class Solution {
    public String fractionAddition(String expression) {
        List<Node> nodes = parse(expression);
        Node result = calc(nodes);
        StringBuilder builder = new StringBuilder();
        if(result.sign < 0){
            builder.append("-");
        }
        builder.append(result.numerator);
        builder.append("/");
        builder.append(result.denominator);
        return builder.toString();
    }

    private Node calc(List<Node> nodes){
        int common = 1;
        for(int i=0; i<nodes.size(); i++){
            Node current = nodes.get(i);
            common *= current.denominator;
        }
        int numerator = 0;
        for(int i=0; i<nodes.size(); i++){
            Node current = nodes.get(i);
            numerator += (int)(current.sign * current.numerator * (common / current.denominator));
        }
        Node result = new Node();
        result.sign = numerator >= 0?1:-1;
        numerator = Math.abs(numerator);
        int g = gcd(common, numerator);
        result.numerator = numerator / g;
        result.denominator = common / g;
        return result;
    }

    private int gcd(int a, int b){
        if(a < b){
            int tmp = a;
            a = b;
            b = tmp;
        }
        if(b == 0){
            return a > 0?a:1;
        }
        while(a % b > 0){
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return b;
    }

    private List<Node> parse(String expression){
        List<Node> nodes = new ArrayList<>();
        Node node = new Node();
        nodes.add(node);
        StringBuilder builder = new StringBuilder();
        int i=0;
        if(expression.charAt(0) != '-'){
            node.sign = 1;
        }
        else {
            node.sign = -1;
            i=1;
        }
        for(; i<expression.length(); i++){
            char c = expression.charAt(i);
            if(c=='+' || c=='-'){
                node.denominator = Integer.valueOf(builder.toString());
                node = new Node();
                nodes.add(node);
                node.sign = c=='+'?1:-1;
                builder = new StringBuilder();
            }
            else if(c=='/') {
                node.numerator = Integer.valueOf(builder.toString());
                builder = new StringBuilder();
            }
            else {
                builder.append(c);
            }
        }
        node.denominator = Integer.valueOf(builder.toString());
        return nodes;
    }
}

class Node {
    public Node(){}
    int sign;
    int numerator;
    int denominator;
}