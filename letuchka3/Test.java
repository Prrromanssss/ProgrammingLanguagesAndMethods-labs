package letuchka3;

public class Test {
    public static void main(String[] args) {
        String input = "[base] Name = \"Вася\" Age = 18 Position = \"студент\" [aux] Description = \"двоечник\"";
        SyntaxAnalyzer parser = new SyntaxAnalyzer();
        parser.parseInput(input);
    }
}
