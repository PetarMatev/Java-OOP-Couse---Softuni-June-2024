package Java_OOP_June_2024._05_Polymorphism._03_Exercise._03_Word;

public class PasteTransform implements TextTransform {
    // Composition
    private final CutTransform cutTransform;

    public PasteTransform(CutTransform cutTransform) {
        this.cutTransform = cutTransform;
    }

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        text.replace(startIndex, endIndex, this.cutTransform.getLastCut().toString());
    }
}
