package com.imooc;

import com.imooc.enums.OrderStatusEnum;
import com.imooc.utils.EnumUtil;
import org.junit.Test;
import org.springframework.cglib.core.EmitUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class Topic1 {

    @Test
    public void enumTest() {
        OrderStatusEnum byCode = EnumUtil.getByCode(1, OrderStatusEnum.class);
        System.out.println(byCode);
    }

    @Test
    public void test() {
        List<Integer> list = Arrays.asList(2, 3, 4);
    }

    public static void main(String[] args) throws Exception {
        Topic1 topic1 = new Topic1();
        topic1.getInfOrganization();
    }

    public void getInfOrganization() throws Exception {
        //1.注册数据库驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取数据库连接
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jt_db",
                "root", "root");
        //3.获取传输器
        Statement stat = conn.createStatement();
        //4.利用传输器发送SQL到数据库执行,
        //	返回执行结果
        String sql = "select * from account";
        ResultSet rs = stat.executeQuery(sql);
        //5.处理执行结果
        while(rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double money = rs.getDouble("money");
            System.out.println(
                    id+":"+name+":"+money);
        }
        //6.释放资源
        rs.close();
        stat.close();
        conn.close();
    }
}
