public class Main {
    public static void main(String[] args) throws InterruptedException {
        TuermeVonHanoi turmeVonHanoi = new TuermeVonHanoi(6);
        turmeVonHanoi.hanoi(65, 'A','C','B');
    }
}
