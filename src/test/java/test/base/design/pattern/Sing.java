package test.base.design.pattern;

import org.junit.Test;

public class Sing {

    private static Sing sing;

    private static class inner {
        private static Sing getSing() {
            if(sing == null) {
                sing = new Sing();
            }
            return sing;
        }
    }
    
    public static Sing getSing() {
        return inner.getSing();
    }
    @Test
    public void test() {
        Sing.getSing();
    }

}
