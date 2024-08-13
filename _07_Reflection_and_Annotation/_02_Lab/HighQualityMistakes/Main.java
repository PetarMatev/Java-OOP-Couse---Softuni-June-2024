//package Java_OOP_June_2024._07_Reflection_and_Annotation._02_Lab.HighQualityMistakes;
//
//import java.io.Serializable;
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//import java.lang.reflect.Modifier;
//import java.util.Arrays;
//import java.util.Comparator;
//
//public class Main {
//    public static void main(String[] args) {
//
//        Arrays.stream(reflection.getDeclaredFields())
//                .sorted(Comparator.comparing(Field::getName))
//                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
//                .forEach(f -> System.out.println(f.getName() + " must be private!"));
//
//
//        Arrays.stream(reflection.getDeclaredMethods())
//                .filter(m -> !m.getName().equals("toString"))
//                .sorted(Comparator.comparing(Method::getName))
//                .filter(Main::filterByType)
//                .forEach(m -> System.out.println(formatPrint(m)));
//
//    }
//
//    private static String formatPrint(Method m) {
//        String postfix = m.getName().startsWith("get") ? "public!" : "private";
//        return m.getName() + " have to be " + postfix;
//    }
//
//    private static boolean filterByType(Method method) {
//        return method.getName().startsWith("get") && !Modifier.isPublic(method.getModifiers())
//                || method.getName().startsWith("set") && !Modifier.isPrivate(method.getModifiers());
//    }
//
//    public static class hellos {
//        public static void main(String[] args) {
//            Class<Reflection> reflection = Reflection.class;
//
//            Arrays.stream(reflection.getDeclaredFields())
//                    .sorted(Comparator.comparing(Field::getName))
//                    .filter(f -> !Modifier.isPrivate(f.getModifiers()))
//                    .forEach(f -> System.out.println(f.getName() + " must be private!"));
//
//
//            Arrays.stream(reflection.getDeclaredMethods())
//                    .filter(m -> !m.getName().equals("toString"))
//                    .sorted(Comparator.comparing(Method::getName))
//                    .filter(Main::filterByType)
//                    .forEach(m -> System.out.println(formatPrint(m)));
//
//        }
//
//        private static String formatPrint(Method m) {
//            String postfix = m.getName().startsWith("get") ? "public!" : "private!";
//            return m.getName() + " have to be " + postfix;
//        }
//
//        private static boolean filterByType(Method method) {
//            return method.getName().startsWith("get") && !Modifier.isPublic(method.getModifiers())
//                    || method.getName().startsWith("set") && !Modifier.isPrivate(method.getModifiers());
//        }
//    }
//
//    public static class Reflection implements Serializable {
//
//        private static final String nickName = "Pinguin";
//        public String name;
//        protected String webAddress;
//        String email;
//        private int zip;
//
//        public Reflection() {
//            this.setName("Java");
//            this.setWebAddress("oracle.com");
//            this.setEmail("mail@oracle.com");
//            this.setZip(1407);
//        }
//
//        private Reflection(String name, String webAddress, String email) {
//            this.setName(name);
//            this.setWebAddress(webAddress);
//            this.setEmail(email);
//            this.setZip(2300);
//        }
//
//        protected Reflection(String name, String webAddress, String email, int zip) {
//            this.setName(name);
//            this.setWebAddress(webAddress);
//            this.setEmail(email);
//            this.setZip(2300);
//        }
//
//        public final String getName() {
//            return name;
//        }
//
//        private void setName(String name) {
//            this.name = name;
//        }
//
//        protected String getWebAddress() {
//            return webAddress;
//        }
//
//        private void setWebAddress(String webAddress) {
//            this.webAddress = webAddress;
//        }
//
//        public String getEmail() {
//            return email;
//        }
//
//        public void setEmail(String email) {
//            this.email = email;
//        }
//
//        protected final int getZip() {
//            return zip;
//        }
//
//        private void setZip(int zip) {
//            this.zip = zip;
//        }
//
//        public String toString() {
//            String result = "Name: " + getName() + "\n";
//            result += "WebAddress: " + getWebAddress() + "\n";
//            result += "email: " + getEmail() + "\n";
//            result += "zip: " + getZip() + "\n";
//            return result;
//        }
//    }
//}
