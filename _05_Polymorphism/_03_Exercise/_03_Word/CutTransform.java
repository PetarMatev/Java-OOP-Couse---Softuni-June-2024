package Java_OOP_June_2024._05_Polymorphism._03_Exercise._03_Word;

public class CutTransform implements TextTransform {

    private StringBuilder lastCut = new StringBuilder();

    public StringBuilder getLastCut() {
        return lastCut;
    }

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        this.lastCut = new StringBuilder();
        this.lastCut.append(text.substring(startIndex, endIndex));
        text.delete(startIndex, endIndex);
    }
}
