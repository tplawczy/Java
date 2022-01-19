package testy;


import java.util.Date;

class KlasaBazowa {
    Object property;

    public static String code = "code_KlasaBazowa";

    KlasaBazowa(int x) {
        property  = new String("22");
    }

    public void robCos() {
        System.out.println("Robie cos w ObiektBazowy");
    }

    public static Object getInstance() {
        return code;
    }
}

class KlasaPotomna extends KlasaBazowa {
    Object inneProperty;

    public  static String code = "code_KlasaPotomna";

    KlasaPotomna() {
        super(432);
        inneProperty = new Date();
        this.property = inneProperty;
    }

    public static Object getInstance() {
        return code;
    }
}

public class Zabawy {
    public static void main(String[] args) {
//
    ob.getInstance();
   op.getInstance();
//
//        KlasaBazowa x = ob;
//        x.getInstance();
//        x = op;
//        x.getInstance();
//
//        System.out.println(KlasaBazowa.code);
//        System.out.println(KlasaPotomna.code);

        System.out.println("KlasaBazowa.getInstance() = " + KlasaBazowa.getInstance());
        System.out.println("KlasaPotomna.getInstance() = " + KlasaPotomna.getInstance());

        KlasaBazowa ob = new KlasaBazowa(4);
        KlasaPotomna op = new KlasaPotomna();

        System.out.println("ob.getInstance() = " + ob.getInstance());
        System.out.println("op.getInstance() = " + op.getInstance());

        KlasaBazowa x = ob;
        System.out.println("x.getInstance() (gdzie x==ob) = " + x.getInstance());
        x = op;
        System.out.println("x.getInstance() (gdzie x==op) = " + x.getInstance());

    }
}