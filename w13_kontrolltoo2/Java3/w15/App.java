package w15;

public class App {
    

    public static void main(String[] args) {

        // java w15.App
        // javac ./w15/App.java ./w15/Line.java ./w15/HomogenousLine.java ./w15/LineSolver.java ./w15/Repository.java

        Repository repo = new Repository();

        LineSolver[] lines = repo.getLines();
        if (lines.length == 2) {
            System.out.println(lines[0].solve(2));
            System.out.println(lines[1].solve(2));
        } else {
            System.out.println("Broken");
        }
    }
}
