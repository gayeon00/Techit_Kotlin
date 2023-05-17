public class JavaMain {
    public static int JavaA1 = 100;

    public static void javaMethod1() {
        System.out.println("javaMethod1");
    }

    public static void main(String[] args) {
        //kotlin에서 정의한 companion 멤버 사용
        System.out.println("kotlinA3 : "+TestClass1.Companion.getKotlinA3());
        TestClass1.Companion.kotlinMethod3();
    }
}
