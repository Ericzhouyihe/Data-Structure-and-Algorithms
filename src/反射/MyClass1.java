package 反射;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/10/15 14:14
 * @description
 */
public class MyClass1 {
    private String message;
    private int number;
    
    public MyClass1() {
    }
    
    public MyClass1(String message, int number) {
        this.message = message;
        this.number = number;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public int getNumber() {
        return number;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
    
    // 假设有一个方法用于展示对象的状态
    public void display() {
        System.out.println("Message: " + message + ", Number: " + number);
    }
}
