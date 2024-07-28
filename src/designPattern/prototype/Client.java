package designPattern.prototype;

public class Client {
    public static void main(String[] args) {
        StudentRegistry studentRegistry = new StudentRegistry();
        fillRegistry(studentRegistry);

        Student suraj = studentRegistry.get("june24LLD").clone();

        suraj.setAge(26);
        suraj.setName("suraj");
        suraj.setPsp(87.0);

        System.out.println("Below are details of Suraj " + suraj.getName() + " " +
                suraj.getBatch() + " " + suraj.getAvgBatchPsp());




    }
    public static void fillRegistry(StudentRegistry studentRegistry){
        Student june24LLDPrototype = new Student();
        june24LLDPrototype.setBatch("june24LLD");
        june24LLDPrototype.setAvgBatchPsp(80.0);
        studentRegistry.register("june24LLD", june24LLDPrototype);



    }
}
