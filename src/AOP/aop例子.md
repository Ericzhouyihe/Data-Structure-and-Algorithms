```java
// 没有使用AOP的代码
public class UserService {
    public void addUser(){
        // 业务逻辑
        Logger.log("User add"); // 重复的日志代码
    }
    
    public void updateUser(){
        // 业务逻辑
        Logger.log("User update"); // 重复的日志代码
    }
}

// 使用aop的代码
@Aspect
public class LoggingAspect{
    @Before("execution(* com.example.Userservice.*(..))")
    public void logBefore(){
        Logger.log("user added");
    }
    @AfterReturning("execution(* com.example.Userservice.*(..))")
    public void logAfterReturning(){
        Logger.log("After user operation");
    }
}

public class UserService{
    public void addUser(){
        // 业务逻辑
    }
}
```