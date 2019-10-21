package test;

import com.snack.pojo.UserInfo;
import com.snack.service.UserService;
import com.snack.service.impl.UserServiceImpl;
//import org.jboss.arquillian.container.test.api.Deployment;
//import org.jboss.arquillian.junit.Arquillian;
//import org.jboss.shrinkwrap.api.ShrinkWrap;
//import org.jboss.shrinkwrap.api.asset.EmptyAsset;
//import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//
//import static org.junit.Assert.*;

//@RunWith(Arquillian.class)
public class UserServiceImplTest {
//    @Deployment
//    public static JavaArchive createDeployment() {
//        return ShrinkWrap.create(JavaArchive.class)
//                .addClass(UserServiceImpl.class)
//                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
//    }
//---自动注入不适用test测试-------------------------------------------------

    @Test
    public void selectUserOne() {
        UserService userService=new UserServiceImpl();
        UserInfo userinfo=new UserInfo();
        userinfo.setuPassword("123456");
        userinfo.setuUsername("poca");
        UserInfo userinfo1=userService.selectUserOne(userinfo);
        System.out.println("userinfo1:"+userinfo1);
    }
    @Test
    public void addUserOne() {
    }

}
